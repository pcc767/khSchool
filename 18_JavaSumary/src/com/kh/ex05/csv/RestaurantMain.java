package com.kh.ex05.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//전라남도 메뉴정보
//https://www.data.go.kr/data/15076624/fileData.do

//전라남도 식당 정보
//https://www.data.go.kr/data/15076621/fileData.do

//1. 식당과 모든 메뉴를 탐색할수 있는 기능 - 
//2. 식당을 찾으면 메뉴까지 보여주는 기능  - 
//3. 메뉴의 키워드를 조회하면 식당 정보가 같이 나올수 있는 기능 - 

public class RestaurantMain {
	private List<LineInfo> restaurantList = new ArrayList<>();
	private List<LineInfo> menuList = new ArrayList<>();
	
	// 식당ID - 메뉴 리스트
	private Map<String, List<LineInfo>> restaurantIDToMenuListMap 
									= new HashMap<String, List<LineInfo>>();
	
	// 식당ID - 식당 Line 정보
	private Map<String, LineInfo> restaurantIDToLineInfoMap 
											= new HashMap<String, LineInfo>();
	
	
	public static void main(String[] args) {
		RestaurantMain main = new RestaurantMain();
		main.fileReadForRestaurant("전라남도_식당정보_20201229.csv");
		main.fileReadForMenu("전라남도_메뉴정보_20210120.csv");
		
	}

	private void fileReadForMenu(String path) {
		menuList = makeCSVList(path, "UTF-8");
		//식당ID:857880, 식당명:고흥막회집,
		for(LineInfo info : menuList) {
//			if(info.getData("식당ID").equals("857880")) {
				System.out.println(info);
//			}
		}
	}


	private void fileReadForRestaurant(String path) {
		restaurantList = makeCSVList(path, "EUC-KR");
		//식당ID:857880, 식당명:고흥막회집,
		for(LineInfo info : restaurantList) {
//			if(info.getData("식당명").equals("고흥막회집")) {
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
	
	// 식당ID,식당명,업종(메뉴)정보,테이크아웃여부,예약가능여부,선결제(pre-pay)여부,식당대표전화번호,도로명주소,지번주소,정규휴업일,식당면적,식당위도,식당경도,대표메뉴,어워드_글로벌,어워드_로컬,트립어드바이저 인기도,씨트립 인기도,네이버 인기도,레드테이블 평가,온라인화진행여부,다국어메뉴판제공여부,다국어지원언어,다국어메뉴판 주소,수용태세지수,좌석수_입석,좌석수_좌식,와이파이여부,장애인편의시설여부,주차가능유무,식당근처랜드마크정보,랜드마크위도,랜드마크경도,식당홈페이지,등록일시
	public List<String> csvLineToList(String csvLine) {
		try {
			String delemeter = ",";
			if (csvLine.contains(",\"") == true) {
				//"주재료 : 갈비살 / 조리법 : 고기 / 소스 : 양념,숙성 / 옵션 : 이베리코"
				csvLine = filter(csvLine);
			}
			List<String> list = new ArrayList<String>();
			String[] array = csvLine.split(delemeter);
			for(String str : array) {
				str = str.replace("\"", "").strip().replace("_", ",");
				if (str.contains("메뉴ID")) {
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
		//"주재료 : 갈비살 / 조리법 : 고기 / 소스 : 양념_숙성 / 옵션 : 이베리코", "주재료 : 갈비살 / 조리법 : 고기 / 소스 : 양념,숙성 / 옵션 : 이베리코"
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

//메뉴ID	식당ID	메뉴명	메뉴가격	메뉴태그정보	등록일시
//1		858991	짜장면	6000	주재료 : 돼지고기,야채,면,밀가루 / 조리법 : 볶음 / 소스 : 춘장	2020-10-26 16:45

//메뉴ID	식당ID	메뉴명			메뉴가격	메뉴태그정보	등록일시
//2		858991	간짜장(2인이상)	7000	주재료 : 밀가루 / 조리법 : 짜장면 / 소스 : 짜장소스	2020-10-26 16:45

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






