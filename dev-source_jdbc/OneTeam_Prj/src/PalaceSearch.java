
import model.vo.Palace;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PalaceSearch {

    public static String PALACE_SIMPLE_SEARCH = "http://www.heritage.go.kr/heri/gungDetail/gogungListOpenApi.do";
    public static String PALACE_DETAIL_SEARCH = "http://www.heritage.go.kr/heri/gungDetail/gogungDetailOpenApi.do";

    public static void main(String[] args) {
        List<Palace> listHeader = new ArrayList<>();
        listHeader = callPalaceListByXML();
        System.out.println("========================================================");
        PalaceDetailListByXML(listHeader);
        
        
    }

    private static List<Palace> callPalaceListByXML() {
    	
        List<Palace> list = new ArrayList<>();                        // header data 담을 List객체 생성.
        int palaceNum = 1;                                            // 키값(pageIndex) 인덱스로 사용 할 int 변수
        try {
            while (true) {
                StringBuilder urlBuilder = new StringBuilder(PALACE_SIMPLE_SEARCH);
                urlBuilder.append("?" + "gung_number=" + palaceNum); // 첫 번째만 물음표로 설정
                System.out.println(urlBuilder);

                /*
                * HttpURLConnection은 http통신을 수행할 객체.
                * URL 객체로 connection 생성.
                * 응답받은 결과를 InputStream 으로 받아서 버퍼에 순차적으로 담는다.
                 */
                URL url = new URL(urlBuilder.toString());                               // 파라미터로 들어온 url을 사용해
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();      // Connection 실시.
//              http 요청에 필요한 타입 정의----------------------------------------------
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/xml");
//              /--------------------------------------------------------------------
                int code = conn.getResponseCode();
                System.out.println("ResponseCode : " + code);

                if (code < 200 || code >= 300) {
                    System.out.println("페이지가 잘 못 되었습니다.");
                    return null;
                }

                // Get Document Builder
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                /*
                * DocumentBuilder.parse
                * 지정된 InputStream의 내용을 XML 문서로 구문 분석하고 "새 DOM 문서 개체"를 반환합니다.
                * InputStream이 null인 경우 예외가 발생.
                 */

                // Document builder
                Document doc = db.parse(conn.getInputStream());     //  xml부를 파싱하여 객체화
                doc.getDocumentElement().normalize();               //  doc.getDocumentElement().normalize(), doc.normalizeDocument() 차이?
//                doc.normalizeDocument();

                // 방법 1
//                Element root = doc.getDocumentElement();
//                System.out.println(root.getNodeName());
                // 방법 2
                System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
                System.out.println("========================================================");

//            System.out.println("item : " + doc.getElementsByTagName("item").item(0).getTextContent());

                // Get all list
                NodeList heritageList = doc.getElementsByTagName("list");
                for (int i = 0; i < heritageList.getLength(); i++) {
                    Node node = heritageList.item(i);           // item, get과 비슷하다 생각.
                    System.out.println("\nCurrent Element : " + node.getNodeName());
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) node;
                        System.out.println("facility_no : " + eElement.getElementsByTagName("serial_number").item(0).getTextContent());
                        System.out.println("castle_no : " + eElement.getElementsByTagName("gung_number").item(0).getTextContent());
                        System.out.println("p_facility_detail_no : " + eElement.getElementsByTagName("detail_code").item(0).getTextContent());
                        System.out.println("p_facility_name_kor : " + eElement.getElementsByTagName("contents_kor").item(0).getTextContent());
                        System.out.println("p_facility_contents_kor : " + eElement.getElementsByTagName("explanation_kor").item(0).getTextContent());
//                        System.out.println("p_facility_imgUrl : " + eElement.getElementsByTagName("imgUrl").item(0).getTextContent());

                        int facility_no = Integer.parseInt(eElement.getElementsByTagName("serial_number").item(0).getTextContent());
                        int castle_no = Integer.parseInt(eElement.getElementsByTagName("gung_number").item(0).getTextContent());
                        int p_facility_detail_no = Integer.parseInt(eElement.getElementsByTagName("detail_code").item(0).getTextContent());
                        String p_facility_name_kor = eElement.getElementsByTagName("contents_kor").item(0).getTextContent();
                        String p_facility_contents_kor = eElement.getElementsByTagName("explanation_kor").item(0).getTextContent();  

                        Palace pla = new Palace(facility_no, castle_no, p_facility_detail_no, p_facility_name_kor, p_facility_contents_kor);
                        
                        list.add(pla);
                    }
                }

                palaceNum += 1;
                if (palaceNum > 6) {
                    break;
                }

                conn.disconnect();                
            }           // while end
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



    private static List<Palace> PalaceDetailListByXML(List<Palace> listHeader) {

        int palaceNum = 0;

        while (true) {
            try {

                StringBuilder url_detail = new StringBuilder(PALACE_DETAIL_SEARCH);

                //    serial_number	int	순번(필수)
                //    gung_number	int	궁 번호(필수)
                //    detail_code	int	세부코드(필수)

                url_detail.append("?" + "serial_number=" + listHeader.get(palaceNum).getFacility_no());
                url_detail.append("&" + "gung_number=" + listHeader.get(palaceNum).getCastle_no());
                url_detail.append("&" + "detail_code=" + listHeader.get(palaceNum).getP_facility_detail_no());

                System.out.println(url_detail);

                URL url = new URL(url_detail.toString());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/xml");
                int code = conn.getResponseCode();
                System.out.println("ResponseCode : " + code);

                if (code < 200 || code >= 300) {
                    System.out.println("페이지가 잘 못 되었습니다.");
                    return null;
                }

                // 페이지 Parsing
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                Document doc = db.parse(conn.getInputStream());     //  xml부를 파싱하여 객체화
                doc.normalizeDocument();

                System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
                System.out.println("========================================================");

//            System.out.println("item : " + doc.getElementsByTagName("item").item(0).getTextContent());

                NodeList heritageList = doc.getElementsByTagName("result");
                for (int i = 0; i < heritageList.getLength(); i++) {
                    Node node = heritageList.item(i);
                    System.out.println("\nCurrent Element : " + node.getNodeName());
                    Element eElement = (Element) node;
                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        // console print
                        System.out.println("facility_no : " + eElement.getElementsByTagName("serial_number").item(0).getTextContent());
                        System.out.println("castle_no : " + eElement.getElementsByTagName("gung_number").item(0).getTextContent());
                        System.out.println("p_facility_detail_no : " + eElement.getElementsByTagName("detail_code").item(0).getTextContent());
                        System.out.println("p_facility_name_eng : " + eElement.getElementsByTagName("contents_eng").item(0).getTextContent());
                        System.out.println("p_facility_name_jpa : " + eElement.getElementsByTagName("contents_jpa").item(0).getTextContent());
                        System.out.println("p_facility_name_chi : " + eElement.getElementsByTagName("contents_chi").item(0).getTextContent());
                        System.out.println("p_facility_content_eng : " + eElement.getElementsByTagName("explanation_eng").item(0).getTextContent().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
                        System.out.println("p_facility_content_jpa : " + eElement.getElementsByTagName("explanation_jpa").item(0).getTextContent().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
                        System.out.println("p_facility_content_chi : " + eElement.getElementsByTagName("explanation_chi").item(0).getTextContent().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));

                        // input setter
                        listHeader.get(i).setP_facility_name_eng(eElement.getElementsByTagName("contents_eng").item(0).getTextContent());
                        listHeader.get(i).setP_facility_name_jpa(eElement.getElementsByTagName("contents_jpa").item(0).getTextContent());
                        listHeader.get(i).setP_facility_name_chi(eElement.getElementsByTagName("contents_chi").item(0).getTextContent());
                        listHeader.get(i).setP_facility_content_eng(eElement.getElementsByTagName("explanation_eng").item(0).getTextContent());
                        listHeader.get(i).setP_facility_content_jpa(eElement.getElementsByTagName("explanation_jpa").item(0).getTextContent());
                        listHeader.get(i).setP_facility_content_chi(eElement.getElementsByTagName("explanation_chi").item(0).getTextContent());

                    }
                }

                palaceNum += 1;
                if (palaceNum >= listHeader.size()) {
                    break;
                }

                conn.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }       // while end
        return listHeader;
    }


}



