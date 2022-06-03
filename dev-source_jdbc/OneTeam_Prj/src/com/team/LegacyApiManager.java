package com.teamtest.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.teamtest.model.vo.Legacy;

public class LegacyApiManager {
	
	public static String LEGACY_LIST_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do";
	public static String LEGACY_DETAIL_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do";
	
	public static String locationCodeSeoul = "11";
	public static String totalCnt;
	
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	
	public static List<Legacy> callLegacyByXML(){
		
		List<Legacy> list = new ArrayList<Legacy>();
		
		
		String ccbaKdcd;
		String ccbaAsno;
		
		
		try {
			StringBuffer urlBuffer = new StringBuffer(LEGACY_LIST_URL);
			urlBuffer.append("?" + "ccbaCtcd=" + locationCodeSeoul);
			System.out.println(urlBuffer);			//<<<< for test
						
			URL url = new URL(urlBuffer.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			int code = conn.getResponseCode();
			System.out.println(code);				//<<<< for test
			if (code < 200 || code >= 300) {
				System.out.println("문제있음(http상태코드확인)");
//				return null;
			}
						
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(conn.getInputStream());
			doc.normalizeDocument();
			
			totalCnt = doc.getElementsByTagName("totalCnt").item(0).getTextContent();		//<<<<
			System.out.println("totalCntTest : " + totalCnt); 
			
//			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		try {
			NodeList legacyList = null;
			NodeList legacyDetail = null;
						
			StringBuffer urlBufferList = new StringBuffer(LEGACY_LIST_URL);
			urlBufferList.append("?" + "ccbaCtcd=" + locationCodeSeoul);
			urlBufferList.append("&" + "pageUnit=" + totalCnt);
			System.out.println(urlBufferList);			//<<<< for test
			
			URL urlList = new URL(urlBufferList.toString());
			HttpURLConnection conn = (HttpURLConnection) urlList.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			int codeList = conn.getResponseCode();
			System.out.println(codeList);				//<<<< for test
			if (codeList < 200 || codeList >= 300) {
				System.out.println("문제있음(http상태코드확인)");
//				return null;
			}
			
			DocumentBuilderFactory dbfList = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbList = dbfList.newDocumentBuilder();
			Document docList = dbList.parse(conn.getInputStream());
			docList.normalizeDocument();
			
			System.out.println("totalCnt : " + docList.getElementsByTagName("totalCnt").item(0).getTextContent()); 	//<<<< !!!!
			
			legacyList = docList.getElementsByTagName("item");
			int count = 1;		//<<<< for test
			for (int i = 0; i < legacyList.getLength(); i++) {
								
				Node nodeList = legacyList.item(i);
				System.out.println("\n=======================================\n");
				if (nodeList.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementList = (Element)nodeList;
					
					System.out.println("testno : " + count++);		//<<<< for test
					ccbaKdcd = eElementList.getElementsByTagName("ccbaKdcd").item(0).getTextContent();		//<<<<
					ccbaAsno = eElementList.getElementsByTagName("ccbaAsno").item(0).getTextContent();		//<<<<
					
					String no = eElementList.getElementsByTagName("no").item(0).getTextContent();              
//					String ccbaAsno = eElementList.getElementsByTagName("ccbaAsno").item(0).getTextContent();        
					String ccbaCpno = eElementList.getElementsByTagName("ccbaCpno").item(0).getTextContent();        
					String ccmaName = eElementList.getElementsByTagName("ccmaName").item(0).getTextContent();        
					String ccbaMnm1 = eElementList.getElementsByTagName("ccbaMnm1").item(0).getTextContent();        
					String ccbaMnm2 = eElementList.getElementsByTagName("ccbaMnm2").item(0).getTextContent();        
					String ccsiName = eElementList.getElementsByTagName("ccsiName").item(0).getTextContent();        
					String ccbaAdmin = eElementList.getElementsByTagName("ccbaAdmin").item(0).getTextContent();       
					String longitude = eElementList.getElementsByTagName("longitude").item(0).getTextContent();       
					String latitude = eElementList.getElementsByTagName("latitude").item(0).getTextContent();
					
					System.out.println("no : " + no);	
					System.out.println("ccbaAsno : " + ccbaAsno); 
					System.out.println("ccbaCpno : " + ccbaCpno);					
					System.out.println("ccmaName : " + ccmaName);					
					System.out.println("ccbaMnm1 : " + ccbaMnm1);					
					System.out.println("ccbaMnm2 : " + ccbaMnm2);					
					System.out.println("ccsiName : " + ccsiName);					
					System.out.println("ccbaAdmin : " + ccbaAdmin);					
					System.out.println("longitude : " + longitude);					
					System.out.println("latitude : " + latitude);		
					
					
					
					System.out.println("- - - - - - - - - - - - - - - - - - -");
					
					StringBuffer urlBufferDetail = new StringBuffer(LEGACY_DETAIL_URL);
					urlBufferDetail.append("?" + "ccbaCtcd=" + locationCodeSeoul);
					urlBufferDetail.append("&" + "ccbaKdcd=" + ccbaKdcd);		////<<<<#####
					urlBufferDetail.append("&" + "ccbaAsno=" + ccbaAsno);		////<<<<#####
					System.out.println(urlBufferDetail);						//<<<< for test
					
					URL urlDetail = new URL(urlBufferDetail.toString());
					HttpURLConnection connect = (HttpURLConnection) urlDetail.openConnection();
					connect.setRequestMethod("GET");
					connect.setRequestProperty("Accept", "application/xml");
					int codeDetail = connect.getResponseCode();
					System.out.println(codeDetail);				//<<<< for test
					if(codeDetail < 200 || codeDetail >= 300) {
						System.out.println("문제있음(http상태코드확인)");
//						return null;
					}
					
					DocumentBuilderFactory dbfDetail = DocumentBuilderFactory.newInstance();
					DocumentBuilder dbDetail = dbfDetail.newDocumentBuilder();
					Document docDetail = dbDetail.parse(connect.getInputStream());
					docDetail.normalizeDocument();
					
					legacyDetail = docDetail.getElementsByTagName("item");
						
					Node nodeDetail = legacyDetail.item(0);
					System.out.println();
					if (nodeDetail.getNodeType() == Node.ELEMENT_NODE) {
						Element eElementDetail = (Element)nodeDetail;
						
						String ccbaLcad = eElementDetail.getElementsByTagName("ccbaLcad").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");        
						String gcodeName = eElementDetail.getElementsByTagName("gcodeName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");     
						String bcodeName = eElementDetail.getElementsByTagName("bcodeName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");       
						String mcodeName = eElementDetail.getElementsByTagName("mcodeName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");      
						String scodeName = eElementDetail.getElementsByTagName("scodeName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");      
						String ccbaQuan = eElementDetail.getElementsByTagName("ccbaQuan").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");       
						String ccceName = eElementDetail.getElementsByTagName("ccceName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");      
						String ccbaPoss = eElementDetail.getElementsByTagName("ccbaPoss").item(0).getTextContent().trim().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");       
						String content = eElementDetail.getElementsByTagName("content").item(0).getTextContent().strip().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");        
						java.util.Date ccbaAsdtJava = sdf.parse(eElementDetail.getElementsByTagName("ccbaAsdt").item(0).getTextContent()); 
						java.sql.Date ccbaAsdt = new java.sql.Date(ccbaAsdtJava.getTime());
						
						System.out.println("ccbaLcad : " + ccbaLcad);
						System.out.println("gcodeName : " + gcodeName);
						System.out.println("bcodeName : " + bcodeName);
						System.out.println("mcodeName : " + mcodeName);
						System.out.println("scodeName : " + scodeName);
						System.out.println("ccbaQuan : " + ccbaQuan);
						System.out.println("ccceName : " + ccceName);
						System.out.println("ccbaPoss : " + ccbaPoss);
						System.out.println("content : " + content);
						System.out.println("ccbaAsdt : " + ccbaAsdt);
						
						Legacy legacy = new Legacy(no, ccbaAsno, ccbaCpno, ccmaName, ccbaMnm1, ccbaMnm2, ccsiName, ccbaLcad, ccbaAdmin, gcodeName, bcodeName, mcodeName, scodeName, ccbaQuan, ccceName, ccbaPoss, content, ccbaAsdt, longitude, latitude);
						list.add(legacy);
					}
				}
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("\n[test]\n");			//<<<< for test
//		System.out.println(list.size());
//		System.out.println(list.get(0));
		return list;
	}
	
//	public static void main(String[] args) {		//<<<< for test
//		callLegacyByXML();
//	}

}
