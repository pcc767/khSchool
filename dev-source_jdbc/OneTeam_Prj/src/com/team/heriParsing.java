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

public class heriParsing {

	public static String HERI_SEARCH_XML_URL = "http://www.heritage.go.kr/heri/gungDetail/gogungListOpenApi.do";

//		gung_number int 궁 번호

	public static String HERI_DETAIL_XML_URL = "http://www.heritage.go.kr/heri/gungDetail/gogungDetailOpenApi.do";

//		serial_number	int	순번(필수)
//		gung_number	int	궁 번호(필수)
//		detail_code	int	세부코드(필수)

	public static int gung_number;
	public static int serial_number;
	public static int detail_code;

	private static void parsingXml() {

		for (gung_number = 1; gung_number < 6; gung_number++) {
			try {

				NodeList heritageList = null;
				NodeList heritageListD = null;

				StringBuilder urlBuilder = new StringBuilder(HERI_SEARCH_XML_URL);
				urlBuilder.append("?" + "gung_number=" + gung_number);
				System.out.println(urlBuilder);
				System.out.println("\n");

				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/xml");
				int code = conn.getResponseCode();
//						System.out.println("ResponseCode : " + code);
				if (code < 200 || code >= 300) {
					System.out.println("문제있음");
					return;
				}

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(conn.getInputStream());
				doc.normalizeDocument();
				heritageList = doc.getElementsByTagName("list");

				for (int i = 0; i < heritageList.getLength(); i++) {

					Node node = heritageList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) node;
						serial_number = Integer
								.parseInt(eElement.getElementsByTagName("serial_number").item(0).getTextContent());
						detail_code = Integer
								.parseInt(eElement.getElementsByTagName("detail_code").item(0).getTextContent());

						System.out.println(
								"궁 번호 : " + eElement.getElementsByTagName("gung_number").item(0).getTextContent());

						// System.out.println( "궁 이름 : " +
						// eElement.getElementsByTagName("gung_name").item(0).getTextContent());

						System.out.println(
								"세부번호 : " + eElement.getElementsByTagName("detail_code").item(0).getTextContent());

						System.out.println(
								"시리얼 넘버 : " + eElement.getElementsByTagName("serial_number").item(0).getTextContent());

						StringBuilder urlB = new StringBuilder(HERI_DETAIL_XML_URL);
						urlB.append("?" + "gung_number=" + gung_number);
						urlB.append("&" + "serial_number=" + serial_number);
						urlB.append("&" + "detail_code=" + detail_code);
						System.out.print(urlB);

						URL urlD = new URL(urlB.toString());
						HttpURLConnection connect = (HttpURLConnection) urlD.openConnection();
						connect.setRequestMethod("GET");
						connect.setRequestProperty("Accept", "application/xml");
						int codeD = connect.getResponseCode();
//								System.out.println("ResponseCode : " + code);
						if (codeD < 200 || codeD >= 300) {
							System.out.println("문제있음");
							return;
						}

						DocumentBuilderFactory dbfD = DocumentBuilderFactory.newInstance();
						DocumentBuilder dbD = dbfD.newDocumentBuilder();
						Document docD = dbD.parse(connect.getInputStream());
						docD.normalizeDocument();

						heritageListD = docD.getElementsByTagName("result");

						Node nodeD = heritageListD.item(0);
						System.out.println();

						if (nodeD.getNodeType() == Node.ELEMENT_NODE) {
							// 상세 목록에서 프린트
							Element eElementD = (Element) nodeD;
							System.out.println("문화재명(국문) : "
									+ eElementD.getElementsByTagName("contents_kor").item(0).getTextContent());
							System.out.println("문화재명(영문) : "
									+ eElementD.getElementsByTagName("contents_eng").item(0).getTextContent());
							System.out.println("문화재명(일문) : "
									+ eElementD.getElementsByTagName("contents_jpa").item(0).getTextContent());
							System.out.println("문화재명(중문) : "
									+ eElementD.getElementsByTagName("contents_chi").item(0).getTextContent());
							System.out.println("문화재 한글설명 : "
									+ eElementD.getElementsByTagName("explanation_kor").item(0).getTextContent().strip()
											.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
							System.out.println("문화재 영문설명 : "
									+ eElementD.getElementsByTagName("explanation_eng").item(0).getTextContent().strip()
											.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
							System.out.println("문화재 일문설명 : "
									+ eElementD.getElementsByTagName("explanation_jpa").item(0).getTextContent().strip()
											.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
							System.out.println("문화재 중문설명 : "
									+ eElementD.getElementsByTagName("explanation_chi").item(0).getTextContent().strip()
											.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));

							System.out.println("\n");

						}

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		parsingXml();
		System.out.println("========================================================");

	}

}
