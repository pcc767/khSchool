package com.kh.ex05.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//���󳲵� �޴�����
//https://www.data.go.kr/data/15076624/fileData.do

//���󳲵� �Ĵ� ����
//https://www.data.go.kr/data/15076621/fileData.do

//1. �Ĵ�� ��� �޴��� Ž���Ҽ� �ִ� ��� - 
//2. �Ĵ��� ã���� �޴����� �����ִ� ���  - 
//3. �޴��� Ű���带 ��ȸ�ϸ� �Ĵ� ������ ���� ���ü� �ִ� ��� - 

public class RestaurantMain {
	private List<LineInfo> restaurantList = new ArrayList<>();
	private List<LineInfo> menuList = new ArrayList<>();
	
	// �Ĵ�ID - �޴� ����Ʈ
	private Map<String, List<LineInfo>> restaurantIDToMenuListMap 
									= new HashMap<String, List<LineInfo>>();
	
	// �Ĵ�ID - �Ĵ� Line ����
	private Map<String, LineInfo> restaurantIDToLineInfoMap 
											= new HashMap<String, LineInfo>();
	
	
	public static void main(String[] args) {
		RestaurantMain main = new RestaurantMain();
		main.fileReadForRestaurant("���󳲵�_�Ĵ�����_20201229.csv");
		main.fileReadForMenu("���󳲵�_�޴�����_20210120.csv");
		
	}

	private void fileReadForMenu(String path) {
		menuList = makeCSVList(path, "UTF-8");
		//�Ĵ�ID:857880, �Ĵ��:���︷ȸ��,
		for(LineInfo info : menuList) {
//			if(info.getData("�Ĵ�ID").equals("857880")) {
				System.out.println(info);
//			}
		}
	}


	private void fileReadForRestaurant(String path) {
		restaurantList = makeCSVList(path, "EUC-KR");
		//�Ĵ�ID:857880, �Ĵ��:���︷ȸ��,
		for(LineInfo info : restaurantList) {
//			if(info.getData("�Ĵ��").equals("���︷ȸ��")) {
				System.out.println(info);
//			}
		}
	}
	
	private List<LineInfo> makeCSVList(String path, String charset) {
		List<LineInfo> list = new ArrayList<LineInfo>();
		
		try( FileReader fr = new FileReader(path, Charset.forName(charset));
				BufferedReader br = new BufferedReader(fr);
				) {
			String headerStr = br.readLine();
			List<String> headerList = csvLineToList(headerStr);
			
			String str = null;
			while((str = br.readLine()) != null) {
				List<String> lineList = csvLineToList(str);
				if(lineList == null) {
					continue;
				}
				LineInfo info = new LineInfo(headerList, lineList);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// �Ĵ�ID,�Ĵ��,����(�޴�)����,����ũ�ƿ�����,���డ�ɿ���,������(pre-pay)����,�Ĵ��ǥ��ȭ��ȣ,���θ��ּ�,�����ּ�,�����޾���,�Ĵ����,�Ĵ�����,�Ĵ�浵,��ǥ�޴�,�����_�۷ι�,�����_����,Ʈ���������� �α⵵,��Ʈ�� �α⵵,���̹� �α⵵,�������̺� ��,�¶���ȭ���࿩��,�ٱ���޴�����������,�ٱ����������,�ٱ���޴��� �ּ�,�����¼�����,�¼���_�Լ�,�¼���_�½�,�������̿���,��������ǽü�����,������������,�Ĵ��ó���帶ũ����,���帶ũ����,���帶ũ�浵,�Ĵ�Ȩ������,����Ͻ�
	public List<String> csvLineToList(String csvLine) {
		try {
			String delemeter = ",";
			if (csvLine.contains(",\"") == true) {
				//"����� : ����� / ������ : ��� / �ҽ� : ���,���� / �ɼ� : �̺�����"
				csvLine = filter(csvLine);
			}
			List<String> list = new ArrayList<String>();
			String[] array = csvLine.split(delemeter);
			for(String str : array) {
				str = str.replace("\"", "").strip().replace("_", ",");
				if (str.contains("�޴�ID")) {
					str = str.substring(1, str.length());
				}
				list.add(str);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String filter(String str) {
		StringBuffer sb = new StringBuffer(str);
		StringBuffer newsb = new StringBuffer();
		//"����� : ����� / ������ : ��� / �ҽ� : ���_���� / �ɼ� : �̺�����", "����� : ����� / ������ : ��� / �ҽ� : ���,���� / �ɼ� : �̺�����"
		boolean in = false;
		for(int i=0; i<sb.length(); i++) {
			char value = sb.charAt(i);
			if(value=='\"') {
				in = !in;
			}
			if(in == true) {
				if(value == ',') {
					value = '_';
				}
			}
			newsb.append(value);
		}
		return newsb.toString();
	}
	
}

//�޴�ID	�Ĵ�ID	�޴���	�޴�����	�޴��±�����	����Ͻ�
//1		858991	¥���	6000	����� : �������,��ä,��,�а��� / ������ : ���� / �ҽ� : ����	2020-10-26 16:45

//�޴�ID	�Ĵ�ID	�޴���			�޴�����	�޴��±�����	����Ͻ�
//2		858991	��¥��(2���̻�)	7000	����� : �а��� / ������ : ¥��� / �ҽ� : ¥��ҽ�	2020-10-26 16:45

class LineInfo {
	private List<String> header;
	private List<String> info;

	public LineInfo(List<String> header, List<String> info) {
		super();
		this.header = header;
		this.info = info;
	}

	public LineInfo() {
		super();
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<String> getInfo() {
		return info;
	}

	public void setInfo(List<String> info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < header.size(); i++) {
			sb.append(header.get(i) + ":"+ info.get(i)+", ");
		}
		return sb.toString();
	}
	
	public String getData(String key) {
		int index = header.indexOf(key);
		if(index != -1) {
			return info.get(index);
		}else {
			return null;
		}
	}
}






