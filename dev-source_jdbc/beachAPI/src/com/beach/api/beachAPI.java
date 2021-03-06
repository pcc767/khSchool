package com.beach.api;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.beach.model.vo.Beach;

public class beachAPI {

//    public static final String KEY = "orCD5outbUakEqSxWPAu4C3NHBeT2DtV5DHSQbUBCr4Wx74vx2MumvtD23yU8ImOKwK8KWIjpiG5ubsei4j9dA%3D%3D";
    public static final String KEY = "GFYaIRR7h%2B5VzBC0UOr0Dfa1JlCCgM%2Fe6P4cE7yER1%2Bi%2FOSIf8sUDicnuExyGImszns9Bo%2FqfcQR1eXlSiu6jA%3D%3D";
    public static final String BEACH_KEYWORD_LIST_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword";
    public static final String BEACH_DETAIL_LIST_URL = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon";

//    http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?ServiceKey=orCD5outbUakEqSxWPAu4C3NHBeT2DtV5DHSQbUBCr4Wx74vx2MumvtD23yU8ImOKwK8KWIjpiG5ubsei4j9dA%3D%3D&MobileApp=AppTest&MobileOS=ETC&numOfRows=500&cat1=A01&cat2=A0101&cat3=A01011200&keyword=

    public static List<Beach> callBeachKeywordByXML(){

        List<Beach> list = new ArrayList<>();
        List<Beach> bList = new ArrayList<>();
        String place = "해수욕장";
        String nurl = null;
        try {
        	nurl = URLEncoder.encode(place, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append(BEACH_KEYWORD_LIST_URL);
        urlBuffer.append("?" + "ServiceKey="+KEY);
        urlBuffer.append("&" + "MobileApp=AppTest");
        urlBuffer.append("&" + "MobileOS=ETC");
        urlBuffer.append("&" + "numOfRows=500");
        urlBuffer.append("&" + "cat1=A01");
        urlBuffer.append("&" + "cat2=A0101");
        urlBuffer.append("&" + "cat3=A01011200");
        urlBuffer.append("&" + "keyword="+nurl);

        System.out.println(urlBuffer);
        
        
        try {
            URL url = new URL(urlBuffer.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            int code = conn.getResponseCode();
            System.out.println("Response code: " + code);

            if(code < 200 || code > 300){
                System.out.println("페이지가 잘 못되었습니다.");
                return null;
            }

            //페이지 해석
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(conn.getInputStream());
            doc.normalizeDocument();

            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
            System.out.println("========================================================");

            //태그 선택이 안되는것 같음.--------------------------------------------------------
            NodeList beachList = doc.getElementsByTagName("item");
            System.out.println("파실할 리스트 수 : "+ beachList.getLength());

            for(int i=0; i<beachList.getLength();i++){
                Node node = beachList.item(i);
                System.out.println("\nCurrent Element : " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) node;
                    
                    System.out.println(getStrData(eElement, "title"));
                    System.out.println(getStrData(eElement, "addr1"));
                    System.out.println(getStrData(eElement, "addr2"));
                    System.out.println(getIntData(eElement, "areacode"));
                    System.out.println(getStrData(eElement, "contentid"));
                    System.out.println(getStrData(eElement, "contenttypeid"));
                    
                    String title = getStrData(eElement, "title");
                    String addr1 = getStrData(eElement, "addr1");
                    String addr2 = getStrData(eElement, "addr2");
                    int areacode = getIntData(eElement, "areacode");
                    String contentid = getStrData(eElement, "contentid");
                    String contenttypeid = getStrData(eElement, "contenttypeid");
                    String mapx = getStrData(eElement, "mapx");
                    String mapy = getStrData(eElement, "mapy");
                    String mlevel = getStrData(eElement, "mlevel");
                    
                    Beach beach = new Beach(title, addr1, addr2, areacode, contentid, contenttypeid, mapx, mapy, mlevel);
                    list.add(beach);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
//        BEACH_KEYWORD_LIST_URL--------------------------------------------------------------------------------------------------
        
        String place1 = "해변";
        String enUrl = null;
        try {
        	enUrl = URLEncoder.encode(place1, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        StringBuffer urlBuffer1 = new StringBuffer();
        urlBuffer1.append(BEACH_KEYWORD_LIST_URL);
        urlBuffer1.append("?" + "ServiceKey="+KEY);
        urlBuffer1.append("&" + "MobileApp=AppTest");
        urlBuffer1.append("&" + "MobileOS=ETC");
        urlBuffer1.append("&" + "numOfRows=500");
        urlBuffer1.append("&" + "cat1=A01");
        urlBuffer1.append("&" + "cat2=A0101");
        urlBuffer1.append("&" + "cat3=A01011200");
        urlBuffer1.append("&" + "keyword="+enUrl);

        System.out.println(urlBuffer1);
        
        
        try {
            URL url = new URL(urlBuffer1.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            int code = conn.getResponseCode();
            System.out.println("Response code: " + code);

            if(code < 200 || code > 300){
                System.out.println("페이지가 잘 못되었습니다.");
                return null;
            }

            //페이지 해석
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(conn.getInputStream());
            doc.normalizeDocument();

            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
            System.out.println("========================================================");

            //태그 선택이 안되는것 같음.--------------------------------------------------------
            NodeList beachList = doc.getElementsByTagName("item");
            System.out.println("파실할 리스트 수 : "+ beachList.getLength());

            for(int i=0; i<beachList.getLength();i++){
                Node node = beachList.item(i);
                System.out.println("\nCurrent Element : " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) node;
                    
                    System.out.println(getStrData(eElement, "title"));
                    System.out.println(getStrData(eElement, "addr1"));
                    System.out.println(getStrData(eElement, "addr2"));
                    System.out.println(getIntData(eElement, "areacode"));
                    System.out.println(getStrData(eElement, "contentid"));
                    System.out.println(getStrData(eElement, "contenttypeid"));
                    
                    String title = getStrData(eElement, "title");
                    String addr1 = getStrData(eElement, "addr1");
                    String addr2 = getStrData(eElement, "addr2");
                    int areacode = getIntData(eElement, "areacode");
                    String contentid = getStrData(eElement, "contentid");
                    String contenttypeid = getStrData(eElement, "contenttypeid");
                    String mapx = getStrData(eElement, "mapx");
                    String mapy = getStrData(eElement, "mapy");
                    String mlevel = getStrData(eElement, "mlevel");
                    
                    Beach beach = new Beach(title, addr1, addr2, areacode, contentid, contenttypeid, mapx, mapy, mlevel);
                    list.add(beach);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
//      =======================================================================================================================
//      BEACH_DETAIL_LIST_URL--------------------------------------------------------------------------------------------------
//      =======================================================================================================================
        
		for (int j = 0; j < list.size(); j++) {
			StringBuffer urlBuffer2 = new StringBuffer();
			urlBuffer2.append(BEACH_DETAIL_LIST_URL);
			urlBuffer2.append("?" + "ServiceKey=" + KEY);
			urlBuffer2.append("&" + "MobileApp=AppTest");
			urlBuffer2.append("&" + "MobileOS=ETC");
			urlBuffer2.append("&" + "contentId=" + list.get(j).getContentid());

			System.out.println(urlBuffer2);

			try {
				URL url = new URL(urlBuffer2.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/xml");
				int code = conn.getResponseCode();
				System.out.println("Response code: " + code);

				if (code < 200 || code > 300) {
					System.out.println("페이지가 잘 못되었습니다.");
					return null;
				}

				// 페이지 해석
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(conn.getInputStream());
				doc.normalizeDocument();

				System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
				System.out.println("========================================================");

				NodeList beachList = doc.getElementsByTagName("item");
				System.out.println("파싱할 리스트 수 : " + beachList.getLength());

				for (int i = 0; i < beachList.getLength(); i++) {
					Node node = beachList.item(i);
					System.out.println("\nCurrent Element : " + node.getNodeName());
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) node;

						System.out.println(getStrData(eElement, "title"));
						System.out.println(getStrData(eElement, "homepage"));
						System.out.println(getStrData(eElement, "firstimage"));
						System.out.println(getStrData(eElement, "overview"));
						System.out.println(getStrData(eElement, "addr1"));
						
						int resultCode = getIntData(eElement, "resultCode");
						String resultMsg = getStrData(eElement, "resultMsg");
						int numOfRows = getIntData(eElement, "numOfRows");
						int pageNo = getIntData(eElement, "pageNo");
						int totalCount = getIntData(eElement, "totalCount");
						String contentid = getStrData(eElement, "contentid");
						String contenttypeid = getStrData(eElement, "contenttypeid");
						int booktour = getIntData(eElement, "booktour");
						String createdtime = getStrData(eElement, "createdtime");
						String homepage = getStrData(eElement, "homepage");
						String modifiedtime = getStrData(eElement, "modifiedtime");
						String tel = getStrData(eElement, "tel");
						String telname = getStrData(eElement, "telname");
						String firstimage = getStrData(eElement, "firstimage");
						String firstimage2 = getStrData(eElement, "firstimage2");
						int areacode = getIntData(eElement, "areacode");
						int sigungucode = getIntData(eElement, "sigungucode");
						String cat1 = getStrData(eElement, "cat1");
						String cat2 = getStrData(eElement, "cat2");
						String cat3 = getStrData(eElement, "cat3");
						String addr1 = getStrData(eElement, "addr1");
						String addr2 = getStrData(eElement, "addr2");
						String zipcode = getStrData(eElement, "zipcode");
						String mapx = getStrData(eElement, "mapx");
						String mapy = getStrData(eElement, "mapy");
						String mlevel = getStrData(eElement, "mlevel");
						String overview = getStrData(eElement, "overview");
						String title = getStrData(eElement, "title");
						
						Beach beach = new Beach(resultCode, resultMsg, numOfRows, pageNo, totalCount, contentid, contenttypeid, booktour, 
								createdtime, homepage, modifiedtime, tel, telname, firstimage, firstimage2, areacode, sigungucode, 
								cat1, cat2, cat3, addr1, addr2, zipcode, mapx, mapy, mlevel, overview, title);
						
						
						bList.add(beach);
						
						
					}
				}	// 안쪽 for문 close

			} catch (Exception e) {
				e.printStackTrace();
			}
		} // for문 close
//      --------------------------------------------------------------------------------------------------

        Set<Beach> set = new HashSet<>(bList);		// 중복제거
        bList = new ArrayList<>(set);
        
        return bList;
        
    }
    
    
    
    
//  --------------------------------------------------------------------------------------------------

    private static String getStrData(Element eElement, String tagName){
        try {
            return eElement.getElementsByTagName(tagName).item(0).getTextContent();
        } catch (Exception e) {
        	e.printStackTrace();
            return "-";
        }
    }
    
    private static int getIntData(Element eElement, String tagName){
		try {
			return Integer.parseInt(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	private static long getLogData(Element eElement, String tagName){
		try {
			return Long.parseLong(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0;
		}
	}
	
	private static double getDoubleData(Element eElement, String tagName){
		try {
			return Double.parseDouble(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0.0;
		}
	}
	
//  --------------------------------------------------------------------------------------------------



    public static void main(String[] args) {
        callBeachKeywordByXML();

    }

}


//
//System.out.println(getStrData(eElement, "contentid"));
//System.out.println(getStrData(eElement, "contenttypeid"));
//System.out.println(getStrData(eElement, "overview"));
//System.out.println(getStrData(eElement, "addr1"));
//System.out.println(getStrData(eElement, "title"));
//System.out.println(getStrData(eElement, "homepage"));
//System.out.println(getStrData(eElement, "firstimage"));
//System.out.println(getStrData(eElement, "firstimage2"));


