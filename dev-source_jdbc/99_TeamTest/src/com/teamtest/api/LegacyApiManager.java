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
		String legacy_design_no;
		
		
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
					legacy_design_no = eElementList.getElementsByTagName("ccbaAsno").item(0).getTextContent();		//<<<<
					
					String legacy_no = eElementList.getElementsByTagName("no").item(0).getTextContent();              
//					String ccbaAsno = eElementList.getElementsByTagName("ccbaAsno").item(0).getTextContent();        
					String legacy_trans_no = eElementList.getElementsByTagName("ccbaCpno").item(0).getTextContent();        
					String legacy_category_name = eElementList.getElementsByTagName("ccmaName").item(0).getTextContent();        
					String legacy_name_kor = eElementList.getElementsByTagName("ccbaMnm1").item(0).getTextContent();        
					String legacy_name_chi = eElementList.getElementsByTagName("ccbaMnm2").item(0).getTextContent();        
					String legacy_area = eElementList.getElementsByTagName("ccsiName").item(0).getTextContent();        
					String legacy_admin = eElementList.getElementsByTagName("ccbaAdmin").item(0).getTextContent();       
					String legacy_longitude = eElementList.getElementsByTagName("longitude").item(0).getTextContent();       
					String legacy_latitude = eElementList.getElementsByTagName("latitude").item(0).getTextContent();
					
					System.out.println("no : " + legacy_no);	
					System.out.println("ccbaAsno : " + legacy_design_no); 
					System.out.println("ccbaCpno : " + legacy_trans_no);					
					System.out.println("ccmaName : " + legacy_category_name);					
					System.out.println("ccbaMnm1 : " + legacy_name_kor);					
					System.out.println("ccbaMnm2 : " + legacy_name_chi);					
					System.out.println("ccsiName : " + legacy_area);					
					System.out.println("ccbaAdmin : " + legacy_admin);					
					System.out.println("longitude : " + legacy_longitude);					
					System.out.println("latitude : " + legacy_latitude);		
					
					
					
					System.out.println("- - - - - - - - - - - - - - - - - - -");
					
					StringBuffer urlBufferDetail = new StringBuffer(LEGACY_DETAIL_URL);
					urlBufferDetail.append("?" + "ccbaCtcd=" + locationCodeSeoul);
					urlBufferDetail.append("&" + "ccbaKdcd=" + ccbaKdcd);		////<<<<#####
					urlBufferDetail.append("&" + "ccbaAsno=" + legacy_design_no);		////<<<<#####
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
						
						String legacy_address = eElementDetail.getElementsByTagName("ccbaLcad").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");        
						String legacy_type = eElementDetail.getElementsByTagName("gcodeName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");     
						String legacy_type2 = eElementDetail.getElementsByTagName("bcodeName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");       
						String legacy_type3 = eElementDetail.getElementsByTagName("mcodeName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");      
						String legacy_type4 = eElementDetail.getElementsByTagName("scodeName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");      
						String legacy_quantity = eElementDetail.getElementsByTagName("ccbaQuan").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");       
						String legacy_era = eElementDetail.getElementsByTagName("ccceName").item(0).getTextContent().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");      
						String legacy_owner = eElementDetail.getElementsByTagName("ccbaPoss").item(0).getTextContent().trim().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");       
						String legacy_content = eElementDetail.getElementsByTagName("content").item(0).getTextContent().strip().strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");        
						java.util.Date ccbaAsdtJava = sdf.parse(eElementDetail.getElementsByTagName("ccbaAsdt").item(0).getTextContent()); 
						java.sql.Date legacy_enrolldate = new java.sql.Date(ccbaAsdtJava.getTime());
						
						System.out.println("ccbaLcad : " + legacy_address);
						System.out.println("gcodeName : " + legacy_type);
						System.out.println("bcodeName : " + legacy_type2);
						System.out.println("mcodeName : " + legacy_type3);
						System.out.println("scodeName : " + legacy_type4);
						System.out.println("ccbaQuan : " + legacy_quantity);
						System.out.println("ccceName : " + legacy_era);
						System.out.println("ccbaPoss : " + legacy_owner);
						System.out.println("content : " + legacy_content);
						System.out.println("ccbaAsdt : " + legacy_enrolldate);
						
						Legacy legacy = new Legacy(legacy_no, legacy_design_no, legacy_trans_no, legacy_category_name, legacy_name_kor, legacy_name_chi, legacy_area, legacy_address, legacy_admin, legacy_type, legacy_type2, legacy_type3, legacy_type4, legacy_quantity, legacy_era, legacy_owner, legacy_content, legacy_enrolldate, legacy_longitude, legacy_latitude);
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
