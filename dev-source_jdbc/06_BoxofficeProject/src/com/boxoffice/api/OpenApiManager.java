package com.boxoffice.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.boxoffice.model.vo.Boxoffice;

public class OpenApiManager {
	public static String key = "be34f20d99e875855b6997ecb0c02f27";
	public static String WEEKLY_BOXOFFICE_XML_URL  = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml";
	public static String WEEKLY_BOXOFFICE_JSON_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";

	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
		public static List<Boxoffice>  callWeeklyBoxOfficeListByXML(Date searchDate) {
			String dateStr = sdf.format(searchDate);
			List<Boxoffice> list = new ArrayList<>();
			
			StringBuffer urlBuffer = new StringBuffer();
			urlBuffer.append(WEEKLY_BOXOFFICE_XML_URL);
			urlBuffer.append("?" + "key=" + key); // 첫 번째만 물음표로 설정
			urlBuffer.append("&" + "targetDt=" + dateStr);
			urlBuffer.append("&" + "weekGb=" + "0");
			
			System.out.println(urlBuffer);
			
			try {
				URL url = new URL(urlBuffer.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/xml");
				int code = conn.getResponseCode(); // 실제 호출하는 부
				System.out.println("ResponseCode : " + code);
				
				if(code < 200 || code > 300) {
					System.out.println("페이지가 잘못되었습니다.");
					return null;
				}
				
				// 3. 페이지 Parsing(해석)
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				 
				Document doc = db.parse(conn.getInputStream()); // xml 부를 파싱하여 객체화
				
				doc.getDocumentElement().normalize();
				
				System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
				System.out.println("======================================================");

				String boxofficeType  =  doc.getElementsByTagName("boxofficeType").item(0).getTextContent();
				String showRange = doc.getElementsByTagName("showRange").item(0).getTextContent();
				String yearWeekTime = doc.getElementsByTagName("yearWeekTime").item(0).getTextContent();
				
				NodeList nList = doc.getElementsByTagName("weeklyBoxOffice");
				for(int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					System.out.println("\nCurrent Element : " + node.getNodeName());
					if(node.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) node;
						System.out.println("rank 	: "  + eElement.getElementsByTagName("rank").item(0).getTextContent());
						System.out.println("movieNm : "  + eElement.getElementsByTagName("movieNm").item(0).getTextContent());
						System.out.println("openDt  : "  + eElement.getElementsByTagName("openDt").item(0).getTextContent());
						System.out.println("audiAcc : "  + eElement.getElementsByTagName("audiAcc").item(0).getTextContent());
						
						int rnum 			       = Integer.parseInt(eElement.getElementsByTagName("rnum").item(0).getTextContent());
						int rank 				   = Integer.parseInt(eElement.getElementsByTagName("rank").item(0).getTextContent());
						int rankInten 			   = Integer.parseInt(eElement.getElementsByTagName("rankInten").item(0).getTextContent());
						String rankOldAndNew       = eElement.getElementsByTagName("rankOldAndNew").item(0).getTextContent();
						String moviecd 			   = eElement.getElementsByTagName("movieCd").item(0).getTextContent();
						String movienm 			   = eElement.getElementsByTagName("movieNm").item(0).getTextContent();
						Date opendt 			   = sdf.parse(eElement.getElementsByTagName("openDt").item(0).getTextContent());
						long salesamt 			   = Long.parseLong(eElement.getElementsByTagName("salesAmt").item(0).getTextContent());
						double salesshare 		   = Double.parseDouble(eElement.getElementsByTagName("salesShare").item(0).getTextContent());
						long salesinten 		   = Long.parseLong(eElement.getElementsByTagName("salesInten").item(0).getTextContent());
						double saleschange 		   = Double.parseDouble(eElement.getElementsByTagName("salesChange").item(0).getTextContent());
						long salesacc 		       = Long.parseLong(eElement.getElementsByTagName("salesAcc").item(0).getTextContent());
						long audicnt 			   = Long.parseLong(eElement.getElementsByTagName("audiCnt").item(0).getTextContent());
						long audiinten		       = Long.parseLong(eElement.getElementsByTagName("audiInten").item(0).getTextContent());
						double audichange 	       = Double.parseDouble(eElement.getElementsByTagName("audiChange").item(0).getTextContent());
						long audiacc 		       = Long.parseLong(eElement.getElementsByTagName("audiAcc").item(0).getTextContent());
						long scrncnt 		       = Long.parseLong(eElement.getElementsByTagName("scrnCnt").item(0).getTextContent());
						long showcnt 		       = Long.parseLong(eElement.getElementsByTagName("showCnt").item(0).getTextContent());
					
						java.sql.Date opendt2 = new java.sql.Date(opendt.getTime());
						Boxoffice box = new Boxoffice(0, rnum, rank, rankInten, rankOldAndNew, moviecd, movienm, opendt2, salesamt, salesshare, salesinten, saleschange, salesacc, audicnt, audiinten, audichange, audiacc, scrncnt, showcnt, boxofficeType, showRange, yearWeekTime); 
						list.add(box);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}
