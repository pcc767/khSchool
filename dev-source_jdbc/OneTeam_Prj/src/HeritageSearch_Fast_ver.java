import model.vo.Heritage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HeritageSearch_Fast_ver {

    public static String HERITAGE_SIMPLE_SEARCH = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do";
    public static String HERITAGE_DETAIL_SEARCH = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do";

    static List<Heritage> listHeader = null;
    
    public static void main(String[] args) {
        listHeader = callHeritageListByXML();
        System.out.println("========================================================");
        for(Heritage item : listHeader) {
        	new Thread(new Runnable() {
        		@Override
        		public void run() {
        			HeritageDetailListByXML(item, listHeader);
        		}
        	}).start();
        	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }

    private static List<Heritage> callHeritageListByXML() {

        List<Heritage> list = new ArrayList<>();                        // header data 담을 List객체 생성.
        list = Collections.synchronizedList(list);

        int pageNum = 1;                                                // 키값(pageIndex) 인덱스로 사용 할 int 변수
        try {
            while (true) {
                StringBuilder urlBuilder = new StringBuilder(HERITAGE_SIMPLE_SEARCH);
//                urlBuilder.append("?" + "totalCnt=" + 2122); // 첫 번째만 물음표로 설정
                urlBuilder.append("?" + "ccbaCtcd=" + 11);
                urlBuilder.append("&" + "pageUnit=" + 1000);
                urlBuilder.append("&" + "pageIndex=" + pageNum);        // int변수 사용.
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

                // 페이지 Parsing
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                /*
                * DocumentBuilder.parse
                * 지정된 InputStream의 내용을 XML 문서로 구문 분석하고 "새 DOM 문서 개체"를 반환합니다.
                * InputStream이 null인 경우 예외가 발생.
                 */

                Document doc = db.parse(conn.getInputStream());     //  xml부를 파싱하여 객체화
                doc.normalizeDocument();

                // 방법 1
//                Element root = doc.getDocumentElement();
//                System.out.println(root.getNodeName());
                // 방법 2
                System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
                System.out.println("========================================================");

//            System.out.println("item : " + doc.getElementsByTagName("item").item(0).getTextContent());

                NodeList heritageList = doc.getElementsByTagName("item");
                for (int i = 0; i < heritageList.getLength(); i++) {
                    Node node = heritageList.item(i);           // item, get과 비슷하다 생각.
                    System.out.println("\nCurrent Element : " + node.getNodeName());
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) node;
                        System.out.println("regency_sn : " + eElement.getElementsByTagName("sn").item(0).getTextContent());
                        System.out.println("regency_no : " + eElement.getElementsByTagName("ccbaKdcd").item(0).getTextContent());
                        System.out.println("regency_design_no : " + eElement.getElementsByTagName("ccbaAsno").item(0).getTextContent());
                        System.out.println("regency_trans_no : " + eElement.getElementsByTagName("ccbaCpno").item(0).getTextContent());
                        System.out.println("regency_name_kor : " + eElement.getElementsByTagName("ccbaMnm1").item(0).getTextContent());
                        System.out.println("regency_name_chi : " + eElement.getElementsByTagName("ccbaMnm2").item(0).getTextContent());
                        System.out.println("regency_category_name : " + eElement.getElementsByTagName("ccmaName").item(0).getTextContent());
                        System.out.println("regency_area : " + eElement.getElementsByTagName("ccsiName").item(0).getTextContent());
                        System.out.println("regency_area_no : " + eElement.getElementsByTagName("ccbaCtcd").item(0).getTextContent());      //추가
                        System.out.println("regency_admin : " + eElement.getElementsByTagName("ccbaAdmin").item(0).getTextContent());

//                        int regency_sn = Integer.parseInt(eElement.getElementsByTagName("sn").item(0).getTextContent());
                        String regency_no = eElement.getElementsByTagName("ccbaKdcd").item(0).getTextContent();
                        String regency_design_no = eElement.getElementsByTagName("ccbaAsno").item(0).getTextContent();
                        String regency_trans_no = eElement.getElementsByTagName("ccbaCpno").item(0).getTextContent();
                        String regency_name_kor = eElement.getElementsByTagName("ccbaMnm1").item(0).getTextContent();
                        String regency_name_chi = eElement.getElementsByTagName("ccbaMnm2").item(0).getTextContent();
                        String regency_category_name = eElement.getElementsByTagName("ccmaName").item(0).getTextContent();
                        String regency_area = eElement.getElementsByTagName("ccsiName").item(0).getTextContent();
                        String regency_area_no = eElement.getElementsByTagName("ccbaCtcd").item(0).getTextContent();
                        String regency_admin = eElement.getElementsByTagName("ccbaAdmin").item(0).getTextContent();

                        Heritage heri = new Heritage(regency_no, regency_design_no, regency_trans_no, regency_name_kor,
                                regency_name_chi, regency_category_name, regency_area, regency_area_no, regency_admin);

                        list.add(heri);
                    }
                }

                pageNum += 1;
                if (pageNum >= 4) {
                    break;
                }

                conn.disconnect();
            }           // while end
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



    private static void HeritageDetailListByXML(Heritage heritage, List<Heritage> listHeader) {
        try {
                StringBuilder url_detail = new StringBuilder(HERITAGE_DETAIL_SEARCH);
                url_detail.append("?" + "ccbaKdcd="+ heritage.getRegency_no());
                url_detail.append("&" + "ccbaAsno=" + heritage.getRegency_design_no());
                url_detail.append("&" + "ccbaCtcd=" + heritage.getRegency_area_no());
                System.out.println(url_detail);

                URL url = new URL(url_detail.toString());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/xml");
                int code = conn.getResponseCode();
                System.out.println("ResponseCode : " + code);

                if (code < 200 || code >= 300) {
                    System.out.println("페이지가 잘 못 되었습니다.");
                    return;
                }

                // 페이지 Parsing
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                Document doc = db.parse(conn.getInputStream());     //  xml부를 파싱하여 객체화
                doc.normalizeDocument();

                System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
                System.out.println("========================================================");

//            System.out.println("item : " + doc.getElementsByTagName("item").item(0).getTextContent());

                NodeList heritageList = doc.getElementsByTagName("item");
                for (int i = 0; i < heritageList.getLength(); i++) {            
                    Node node = heritageList.item(i);
                    System.out.println("\nCurrent Element : " + node.getNodeName());
                    Element eElement = (Element) node;
                    if (node.getNodeType() == Node.ELEMENT_NODE) {                    	
                        System.out.println("regency_name_kor : " + eElement.getElementsByTagName("ccbaMnm1").item(0).getTextContent());
                        System.out.println("regency_address : " + eElement.getElementsByTagName("ccbaLcad").item(0).getTextContent().strip());
                        System.out.println("regency_type : " + eElement.getElementsByTagName("gcodeName").item(0).getTextContent());
                        System.out.println("regency_type2 : " + eElement.getElementsByTagName("bcodeName").item(0).getTextContent());
                        System.out.println("regency_type3 : " + eElement.getElementsByTagName("mcodeName").item(0).getTextContent());
                        System.out.println("regency_type4 : " + eElement.getElementsByTagName("scodeName").item(0).getTextContent());
                        System.out.println("regency_quantity : " + eElement.getElementsByTagName("ccbaQuan").item(0).getTextContent());
                        System.out.println("regency_era : " + eElement.getElementsByTagName("ccceName").item(0).getTextContent());
                        System.out.println("regency_owner : " + eElement.getElementsByTagName("ccbaPoss").item(0).getTextContent().strip());
                        System.out.println("regency_content : " + eElement.getElementsByTagName("content").item(0).getTextContent().strip());
                        System.out.println("regency_enrolldate : " + eElement.getElementsByTagName("ccbaAsdt").item(0).getTextContent());
//                      <result>----------------------------------------------------------------------------------------
                        System.out.println("regency_longitude : " + doc.getElementsByTagName("longitude").item(0).getTextContent());
                        System.out.println("regency_latitude : " + doc.getElementsByTagName("latitude").item(0).getTextContent());
//                      </result>---------------------------------------------------------------------------------------

                        // setter로 저장
                        listHeader.get(i).setRegency_address(eElement.getElementsByTagName("ccbaLcad").item(0).getTextContent());
                        listHeader.get(i).setRegency_type(eElement.getElementsByTagName("gcodeName").item(0).getTextContent());
                        listHeader.get(i).setRegency_type2(eElement.getElementsByTagName("bcodeName").item(0).getTextContent());
                        listHeader.get(i).setRegency_type3(eElement.getElementsByTagName("mcodeName").item(0).getTextContent());
                        listHeader.get(i).setRegency_type4(eElement.getElementsByTagName("scodeName").item(0).getTextContent());
                        listHeader.get(i).setRegency_quantity(eElement.getElementsByTagName("ccbaQuan").item(0).getTextContent());
                        listHeader.get(i).setRegency_era(eElement.getElementsByTagName("ccceName").item(0).getTextContent());
                        listHeader.get(i).setRegency_owner(eElement.getElementsByTagName("ccbaPoss").item(0).getTextContent());
                        listHeader.get(i).setRegency_content(eElement.getElementsByTagName("content").item(0).getTextContent());
                        listHeader.get(i).setRegency_enrolldate(eElement.getElementsByTagName("ccbaAsdt").item(0).getTextContent());
//                      <result>----------------------------------------------------------------------------------------
                        listHeader.get(i).setRegency_longitude(doc.getElementsByTagName("longitude").item(0).getTextContent());
                        listHeader.get(i).setRegency_latitude(doc.getElementsByTagName("latitude").item(0).getTextContent());
//                      <result>----------------------------------------------------------------------------------------

					}
				}
				conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}



