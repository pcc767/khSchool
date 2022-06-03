package miniproject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class chaParsing {
	// 문화재 검색 목록
	public static String CHA_SEARCH_XML_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do";
	// 상세 목록
	public static String CHA_DETAIL_XML_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do";

	public static String ccbaAsno;
	public static String ccbaKdcd;
	public static String ccbaCtcd = "11";

	public static String totalCnt;

	private static void parsingXml() {

		try {
			NodeList legacyList = null;
			NodeList legacyListD = null;

			StringBuilder urlBuilder = new StringBuilder(CHA_SEARCH_XML_URL);
			urlBuilder.append("?" + "ccbaCtcd=" + ccbaCtcd);
			urlBuilder.append("&" + "pageUnit=" + "2122");
			System.out.println(urlBuilder);

			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			int code = conn.getResponseCode();
			if (code < 200 || code >= 300) {
				System.out.println("문제있음");
				return;
			}

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(conn.getInputStream());
			doc.normalizeDocument();
			legacyList = doc.getElementsByTagName("item");

			totalCnt = doc.getElementsByTagName("totalCnt").item(0).getTextContent();
			System.out.println("totalCntTest : " + totalCnt + "\n");

			for (int i = 0; i < legacyList.getLength(); i++) {
				Node node = legacyList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					// 기본 목록에서 프린트
					Element eElement = (Element) node;
					ccbaKdcd = eElement.getElementsByTagName("ccbaKdcd").item(0).getTextContent();
					ccbaAsno = eElement.getElementsByTagName("ccbaAsno").item(0).getTextContent();
					// no int
					System.out.println("고유 번호 : " +eElement.getElementsByTagName("no").item(0).getTextContent());
					System.out.println("종목코드 : " + eElement.getElementsByTagName("ccbaKdcd").item(0).getTextContent());

					System.out.println("지정번호 : " + eElement.getElementsByTagName("ccbaAsno").item(0).getTextContent());

					System.out.println("문화재 명 : " + eElement.getElementsByTagName("ccbaMnm1").item(0).getTextContent());
					System.out.println(
							"문화재명(한자) : " + eElement.getElementsByTagName("ccbaMnm2").item(0).getTextContent());

					System.out.println("시군구명 : " + eElement.getElementsByTagName("ccsiName").item(0).getTextContent());

					System.out.println("관리자 : " + eElement.getElementsByTagName("ccbaAdmin").item(0).getTextContent());

					StringBuilder urlB = new StringBuilder(CHA_DETAIL_XML_URL);
					urlB.append("?" + "ccbaCtcd=" + ccbaCtcd);
					urlB.append("&" + "ccbaKdcd=" + ccbaKdcd);
					urlB.append("&" + "ccbaAsno=" + ccbaAsno);
					System.out.println(urlB);

					URL urlD = new URL(urlB.toString());
					HttpURLConnection connect = (HttpURLConnection) urlD.openConnection();
					connect.setRequestMethod("GET");
					connect.setRequestProperty("Accept", "application/xml");
					int codeD = connect.getResponseCode();

					if (codeD < 200 || codeD >= 300) {
						System.out.println("문제있음");
						return;
					}

					DocumentBuilderFactory dbfD = DocumentBuilderFactory.newInstance();
					DocumentBuilder dbD = dbfD.newDocumentBuilder();
					Document docD = dbD.parse(connect.getInputStream());
					docD.normalizeDocument();

					legacyListD = docD.getElementsByTagName("item");

					Node nodeD = legacyListD.item(0);
					System.out.println();

					if (nodeD.getNodeType() == Node.ELEMENT_NODE) {
						// 상세 목록에서 프린트
						Element eElementD = (Element) nodeD;
						//date ccbaAsdt
						
						System.out.println(
								"분류 : " + eElementD.getElementsByTagName("gcodeName").item(0).getTextContent());
						System.out.println(
								"분류2 : " + eElementD.getElementsByTagName("bcodeName").item(0).getTextContent());
						System.out.println(
								"분류3 : " + eElementD.getElementsByTagName("mcodeName").item(0).getTextContent());
						System.out.println(
								"분류4 : " + eElementD.getElementsByTagName("scodeName").item(0).getTextContent());
						System.out
								.println("수량 : " + eElementD.getElementsByTagName("ccbaQuan").item(0).getTextContent());
						System.out
								.println("시대 : " + eElementD.getElementsByTagName("ccceName").item(0).getTextContent());
						System.out.println(
								"소유자 : " + eElementD.getElementsByTagName("ccbaPoss").item(0).getTextContent().strip());
						System.out
								.println("주소 : " + eElementD.getElementsByTagName("ccbaLcad").item(0).getTextContent().strip());
						System.out.println("지정일 : " + eElementD.getElementsByTagName("ccbaAsdt").item(0).getTextContent().strip());
						System.out
								.println("설명 : " + eElementD.getElementsByTagName("content").item(0).getTextContent());
						System.out.println("경도 : " + docD.getElementsByTagName("longitude").item(0).getTextContent());
						System.out.println("위도 : " + docD.getElementsByTagName("latitude").item(0).getTextContent());
						System.out.println();
						System.out.println();

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		parsingXml();
		System.out.println("========================================================");

	}

}
