package com.teamtest.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.teamtest.model.vo.Palace;

public class PalaceApiManager {
	
	public static String PALACE_LIST_URL = "http://www.heritage.go.kr/heri/gungDetail/gogungListOpenApi.do";
	public static String PALACE_DETAIL_URL = "http://www.heritage.go.kr/heri/gungDetail/gogungDetailOpenApi.do";

	public static List<Palace> callPalaceByXML() {
		
		List<Palace> list = new ArrayList<Palace>();
		
		int serial_number;
		int gung_number;
		int detail_code;
		
		try {
			StringBuffer urlBufferList = new StringBuffer(PALACE_LIST_URL);
			System.out.println(urlBufferList);			//<<<< for test
			
			URL urlList = new URL(urlBufferList.toString());
			HttpURLConnection connList = (HttpURLConnection) urlList.openConnection();
			connList.setRequestMethod("GET");
			connList.setRequestProperty("Accept", "application/xml");
			int codeList = connList.getResponseCode();
			System.out.println(codeList);		//<<<< for test
			if (codeList < 200 || codeList >= 300) {
				System.out.println("문제있음(http상태코드확인)");
				return null;
			}
			
			DocumentBuilderFactory dbfList = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbList = dbfList.newDocumentBuilder();
			Document docList = dbList.parse(connList.getInputStream());
			docList.normalizeDocument();
			
			NodeList palaceList = docList.getElementsByTagName("list");
			int count = 1; 		//<<<< for test
			for (int i = 0; i < palaceList.getLength(); i++) {
				
				Node nodeList = palaceList.item(i);
				System.out.println("\n=======================================\n");
				if (nodeList.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementList = (Element) nodeList;
					
					System.out.println("testno : " + count++);		//<<<< for test
					
					serial_number = Integer.parseInt(eElementList.getElementsByTagName("serial_number").item(0).getTextContent());
					gung_number = Integer.parseInt(eElementList.getElementsByTagName("gung_number").item(0).getTextContent());
					detail_code = Integer.parseInt(eElementList.getElementsByTagName("detail_code").item(0).getTextContent());
					
					System.out.println("serial_number : " + serial_number);
					System.out.println("gung_number : " + gung_number);
					System.out.println("detail_code : " + detail_code);
					
					
					System.out.println("- - - - - - - - - - - - - - - - - - -");
					
					StringBuffer urlBufferDetail = new StringBuffer(PALACE_DETAIL_URL);
					urlBufferDetail.append("?" + "serial_number=" + serial_number);
					urlBufferDetail.append("&" + "gung_number=" + gung_number);
					urlBufferDetail.append("&" + "detail_code=" + detail_code);
					System.out.println(urlBufferDetail);			//<<<< for test
					
					URL urlDetail = new URL(urlBufferDetail.toString());
					HttpURLConnection connDetail = (HttpURLConnection) urlDetail.openConnection();
					connDetail.setRequestMethod("GET");
					connDetail.setRequestProperty("Accept", "application/xml");
					int codeDetail = connDetail.getResponseCode();
					System.out.println(codeDetail);		//<<<< for test
					if (codeDetail < 200 || codeDetail >= 300) {
						System.out.println("문제있음(http상태코드확인)");
						return null;
					}
					
					DocumentBuilderFactory dbfDetail = DocumentBuilderFactory.newInstance();
					DocumentBuilder dbDetail = dbfDetail.newDocumentBuilder();
					Document docDetail = dbDetail.parse(connDetail.getInputStream());
					docDetail.normalizeDocument();
					
					System.out.println();
					String contents_kor = docDetail.getElementsByTagName("contents_kor").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String contents_eng = docDetail.getElementsByTagName("contents_eng").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String contents_jpa = docDetail.getElementsByTagName("contents_jpa").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String contents_chi = docDetail.getElementsByTagName("contents_chi").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String explanation_kor = docDetail.getElementsByTagName("explanation_kor").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String explanation_eng = docDetail.getElementsByTagName("explanation_eng").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String explanation_jpa = docDetail.getElementsByTagName("explanation_jpa").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String explanation_chi = docDetail.getElementsByTagName("explanation_chi").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					
					System.out.println("contents_kor : " + contents_kor);
					System.out.println("contents_eng : " + contents_eng);
					System.out.println("contents_jpa : " + contents_jpa);
					System.out.println("contents_chi : " + contents_chi);
					System.out.println("explanation_kor : " + explanation_kor);
					System.out.println("explanation_eng : " + explanation_eng);
					System.out.println("explanation_jpa : " + explanation_jpa);
					System.out.println("explanation_chi : " + explanation_chi);
					
					Palace palace = new Palace(serial_number, gung_number, detail_code, contents_kor, contents_eng, contents_jpa, contents_chi, explanation_kor, explanation_eng, explanation_jpa, explanation_chi);
					list.add(palace);
				}
			}
			connList.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public static void main(String[] args) {		//<<<< for test
		callPalaceByXML();
	}
	
}
