package seoul.legacy.api;

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

import seoul.legacy.model.vo.Facility;

// 객체 facility로
// 데이타 프린트 삭제 후 object.tostring으로 출력

public class PalaceApiManager {

	public static String PALACE_LIST_URL = "http://www.heritage.go.kr/heri/gungDetail/gogungListOpenApi.do";
	public static String PALACE_DETAIL_URL = "http://www.heritage.go.kr/heri/gungDetail/gogungDetailOpenApi.do";

	public static List<Facility> callPalaceByXML() {

		List<Facility> list = new ArrayList<Facility>();

		int p_facility_no;
		int palace_no;
		int p_facility_detail_no;

		try {
			StringBuffer urlBufferList = new StringBuffer(PALACE_LIST_URL);

			URL urlList = new URL(urlBufferList.toString());
			HttpURLConnection connList = (HttpURLConnection) urlList.openConnection();
			connList.setRequestMethod("GET");
			connList.setRequestProperty("Accept", "application/xml");
			int codeList = connList.getResponseCode();
			if (codeList < 200 || codeList >= 300) {
				System.out.println("문제있음(http상태코드확인)");
				return null;
			}

			DocumentBuilderFactory dbfList = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbList = dbfList.newDocumentBuilder();
			Document docList = dbList.parse(connList.getInputStream());
			docList.normalizeDocument();

			NodeList palaceList = docList.getElementsByTagName("list");
			for (int i = 0; i < palaceList.getLength(); i++) {

				Node nodeList = palaceList.item(i);
				if (nodeList.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementList = (Element) nodeList;

					p_facility_no = Integer
							.parseInt(eElementList.getElementsByTagName("serial_number").item(0).getTextContent());
					palace_no = Integer
							.parseInt(eElementList.getElementsByTagName("gung_number").item(0).getTextContent());
					p_facility_detail_no = Integer
							.parseInt(eElementList.getElementsByTagName("detail_code").item(0).getTextContent());

					StringBuffer urlBufferDetail = new StringBuffer(PALACE_DETAIL_URL);
					urlBufferDetail.append("?" + "serial_number=" + p_facility_no);
					urlBufferDetail.append("&" + "gung_number=" + palace_no);
					urlBufferDetail.append("&" + "detail_code=" + p_facility_detail_no);

					URL urlDetail = new URL(urlBufferDetail.toString());
					HttpURLConnection connDetail = (HttpURLConnection) urlDetail.openConnection();
					connDetail.setRequestMethod("GET");
					connDetail.setRequestProperty("Accept", "application/xml");
					int codeDetail = connDetail.getResponseCode();
					if (codeDetail < 200 || codeDetail >= 300) {
						System.out.println("문제있음(http상태코드확인)");
						return null;
					}

					DocumentBuilderFactory dbfDetail = DocumentBuilderFactory.newInstance();
					DocumentBuilder dbDetail = dbfDetail.newDocumentBuilder();
					Document docDetail = dbDetail.parse(connDetail.getInputStream());
					docDetail.normalizeDocument();

					String p_facility_name_kor = docDetail.getElementsByTagName("contents_kor").item(0).getTextContent()
							.strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String p_facility_name_eng = docDetail.getElementsByTagName("contents_eng").item(0).getTextContent()
							.strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String p_facility_name_jpa = docDetail.getElementsByTagName("contents_jpa").item(0).getTextContent()
							.strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String p_facility_name_chi = docDetail.getElementsByTagName("contents_chi").item(0).getTextContent()
							.strip().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String p_facility_content = docDetail.getElementsByTagName("explanation_kor").item(0)
							.getTextContent().strip()
							.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String p_facility_content_eng = docDetail.getElementsByTagName("explanation_eng").item(0)
							.getTextContent().strip()
							.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String p_facility_content_jpa = docDetail.getElementsByTagName("explanation_jpa").item(0)
							.getTextContent().strip()
							.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
					String p_facility_content_chi = docDetail.getElementsByTagName("explanation_chi").item(0)
							.getTextContent().strip()
							.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");

					Facility palace = new Facility(p_facility_no, p_facility_detail_no, palace_no, p_facility_name_kor,
							p_facility_name_eng, p_facility_name_jpa, p_facility_name_chi, p_facility_content,
							p_facility_content_eng, p_facility_content_jpa, p_facility_content_chi);
					list.add(palace);
					System.out.println(palace.toString());
				}
			}
			connList.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public static void main(String[] args) { // <<<< for test
		callPalaceByXML();
	}

}
