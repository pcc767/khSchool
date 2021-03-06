import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BoxOfficeOpenApi {
	public static String key = "be34f20d99e875855b6997ecb0c02f27";

	public static String WEEKLY_BOXOFFICE_XML_URL  = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml";
	public static String WEEKLY_BOXOFFICE_JSON_URL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";

	public static void main(String[] args) {
		callWeeklyBoxOfficeListByXML();
		System.out.println("========================================================");
		callWeeklyBoxOfficeListByJSON();
	}
	
	
	// https://www.delftstack.com/ko/howto/java/java-read-xml/
	public static void callWeeklyBoxOfficeListByXML() {
		try {
			// 1. URL을 가공하는 코드 시작
			StringBuilder urlBuilder = new StringBuilder(WEEKLY_BOXOFFICE_XML_URL); /*URL*/
			// 국문 키워드 섞인 경우는 아래와같이 encode 필수!
//			GET방식의 파라미터 셋팅법
//			urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "=" + URLEncoder.encode(key, "UTF-8")); /*Service Key*/
//			urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode("20220520", "UTF-8")); /*페이지번호*/
//			urlBuilder.append("&" + URLEncoder.encode("weekGb","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과 수*/

			// 숫자/영문일때는 간단하게 가능!
			urlBuilder.append("?" + "key=" + key); // 첫 번째만 물음표로 설정
			urlBuilder.append("&" + "targetDt=" + "20220521");
			urlBuilder.append("&" + "weekGb=" + "1");

			System.out.println(urlBuilder);
			// 1. URL을 가공하는 코드 끝
			
			// 2. URL을 HTTP 객체를 통해 요청하는 코드 시작!
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

//			setRequestMethod 이부분의 코드는 API 마다 요청하는 방식이 다름으로 권장방식을 따라줘야함!
//			conn.setRequestProperty("Content-type", "application/json");
			conn.setRequestProperty("Accept", "application/xml");
			
			int code = conn.getResponseCode(); // 실제 page를 요청하는 부분
			System.out.println("ResponseCode : " + code );
			if(code < 200 || code >= 300) {
//				 HTTP/1.0 200 OK
//				 HTTP/1.0 401 Unauthorized
				System.out.println("페이지가 잘못되었습니다.");
				return;
			}
			// 2. URL을 HTTP 객체를 통해 요청하는 코드 끝!
			
			
			// 3. XML 파싱부 시작!
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(conn.getInputStream()); // xml부를 가져와 파싱할 준비 완료!
			doc.normalizeDocument(); // xml을 표준으로 다시 정리해주는 기능 -> 해도되고 안해도 될수도 있으나.
			// 셋팅부 끝!
			// getElementsByTagName : 태그를 통해 node를 가져올수 있는 메소드
			
			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			System.out.println("===========================================================");
			// ※ 파싱할때의 주의점 - 값의 대소문자가 구별됨! 반드시 맞게 사용할것
			System.out.println("boxofficeType : " + doc.getElementsByTagName("boxofficeType").item(0).getTextContent());
			System.out.println("showRange : " + doc.getElementsByTagName("showRange").item(0).getTextContent());
			System.out.println("yearWeekTime : " + doc.getElementsByTagName("yearWeekTime").item(0).getTextContent());
			// Root 정보 해석 끝!
			
			NodeList boxofficeList = doc.getElementsByTagName("weeklyBoxOffice");
			for(int i = 0; i < boxofficeList.getLength(); i++) {
				Node node = boxofficeList.item(i);
				System.out.println("\nCurrent Elemnet : " + node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)node;
					System.out.println("rank : " + eElement.getElementsByTagName("rank").item(0).getTextContent());
					System.out.println("movieNm : " + eElement.getElementsByTagName("movieNm").item(0).getTextContent());
					System.out.println("openDt : " + eElement.getElementsByTagName("openDt").item(0).getTextContent());
					System.out.println("audiAcc : " + eElement.getElementsByTagName("audiAcc").item(0).getTextContent());
				}
			}
			// 3. XML 파싱부 종료!
			
			// 4. Close
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public  static void callWeeklyBoxOfficeListByJSON() {
		 
		 try {
				// 1. URL을 가공하는 코드 시작
				StringBuilder urlBuilder = new StringBuilder(WEEKLY_BOXOFFICE_JSON_URL); /*URL*/
				// 국문 키워드 섞인 경우는 아래와같이 encode 필수!
//				GET방식의 파라미터 셋팅법
//				urlBuilder.append("?" + URLEncoder.encode("key","UTF-8") + "=" + URLEncoder.encode(key, "UTF-8")); /*Service Key*/
//				urlBuilder.append("&" + URLEncoder.encode("targetDt","UTF-8") + "=" + URLEncoder.encode("20220520", "UTF-8")); /*페이지번호*/
//				urlBuilder.append("&" + URLEncoder.encode("weekGb","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과 수*/

				// 숫자/영문일때는 간단하게 가능!
				urlBuilder.append("?" + "key=" + key); // 첫 번째만 물음표로 설정
				urlBuilder.append("&" + "targetDt=" + "20220521");
				urlBuilder.append("&" + "weekGb=" + "1");

				System.out.println(urlBuilder);
				// 1. URL을 가공하는 코드 끝
				
				// 2. URL을 HTTP 객체를 통해 요청하는 코드 시작!
				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");

//				setRequestMethod 이부분의 코드는 API 마다 요청하는 방식이 다름으로 권장방식을 따라줘야함!
//				conn.setRequestProperty("Content-type", "application/json");
				conn.setRequestProperty("Accept", "application/json");
				
				int code = conn.getResponseCode(); // 실제 page를 요청하는 부분
				System.out.println("ResponseCode : " + code );
				if(code < 200 || code >= 300) {
//					 HTTP/1.0 200 OK
//					 HTTP/1.0 401 Unauthorized
					System.out.println("페이지가 잘못되었습니다.");
					return;
				}
				// 2. URL을 HTTP 객체를 통해 요청하는 코드 끝!
				
				// 3. JSON 파싱부 시작!
				InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				JSONParser jsonParser = new JSONParser(); 
				JSONObject rootObj = (JSONObject) jsonParser.parse(br);
				JSONObject childObj = (JSONObject) rootObj.get("boxOfficeResult");
				
				System.out.println("Root 부");
				System.out.println("boxofficeType : " + childObj.get("boxofficeType"));
				System.out.println("showRange : " + childObj.get("showRange"));
				System.out.println("yearWeekTime : " + childObj.get("yearWeekTime"));
				System.out.println("===========================================================");
				
				JSONArray officeArray = (JSONArray) childObj.get("weeklyBoxOfficeList");
				for(int i = 0; i<officeArray.size(); i++) {
					JSONObject obj = (JSONObject) officeArray.get(i);
					System.out.println("rank : " + obj.get("rank"));
					System.out.println("movieNm : " + obj.get("movieNm"));
					System.out.println("openDt : " + obj.get("openDt"));
					System.out.println("audiAcc : " + obj.get("audiAcc") + "\n");
				}

				
				
				// 3. JSON 파싱부 종료!
				
				// 4. Close
				conn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
