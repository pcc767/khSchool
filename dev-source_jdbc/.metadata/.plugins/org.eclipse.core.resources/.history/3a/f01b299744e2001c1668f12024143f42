//import model.vo.Heritage;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class HeritageDetailListByXML_ {
//    public static String HERITAGE_DETAIL_SEARCH = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do";
//    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//
////    public static void main(String[] args) {
////        callHeritageDetailListByXML();
////        System.out.println("========================================================");
////    }
//
//    private static List<Heritage> HeritageDetailListByXML(List<Heritage> listHeader) {
//
//        int hNum = 1;
//        while (true) {
//            try {
//                StringBuilder url_detail = new StringBuilder(HERITAGE_DETAIL_SEARCH);
//
////            for (int i = 0; i < listDetail.size(); i++) {
//                url_detail.append("?" + "ccbaKdcd="+  url_detail.get(hNum).getRegency_no());
//                url_detail.append("&" + "ccbaAsno=" + url_detail.get(hNum).getRegency_design_no());
//                url_detail.append("&" + "ccbaCtcd=" + url_detail.get(hNum).getRegency_area_no());
////            }
//                System.out.println(url_detail);
//
//                URL url = new URL(url_detail.toString());
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setRequestMethod("GET");
//                conn.setRequestProperty("Accept", "application/xml");
//                int code = conn.getResponseCode();
//                System.out.println("ResponseCode : " + code);
//
//                if (code < 200 || code >= 300) {
//                    System.out.println("페이지가 잘 못 되었습니다.");
//                    return null;
//                }
//
//                // 페이지 Parsing
//                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//                DocumentBuilder db = dbf.newDocumentBuilder();
//
//                Document doc = db.parse(conn.getInputStream());     //  xml부를 파싱하여 객체화
//                doc.normalizeDocument();
//
//                System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
//                System.out.println("========================================================");
//
////            System.out.println("item : " + doc.getElementsByTagName("item").item(0).getTextContent());
//
//                NodeList heritageList = doc.getElementsByTagName("item");
//                for (int i = 0; i < heritageList.getLength(); i++) {
//                    Node node = heritageList.item(i);
//                    System.out.println("\nCurrent Element : " + node.getNodeName());
//                    if (node.getNodeType() == Node.ELEMENT_NODE) {
//                        Element eElement = (Element) node;
//
//                        System.out.println("regency_address : " + eElement.getElementsByTagName("ccbaLcad").item(0).getTextContent());
//                        System.out.println("regency_type : " + eElement.getElementsByTagName("gcodeName").item(0).getTextContent());
//                        System.out.println("regency_type2 : " + eElement.getElementsByTagName("bcodeName").item(0).getTextContent());
//                        System.out.println("regency_type3 : " + eElement.getElementsByTagName("mcodeName").item(0).getTextContent());
//                        System.out.println("regency_type4 : " + eElement.getElementsByTagName("scodeName").item(0).getTextContent());
//                        System.out.println("regency_quantity : " + eElement.getElementsByTagName("ccbaQuan").item(0).getTextContent());
//                        System.out.println("regency_era : " + eElement.getElementsByTagName("ccceName").item(0).getTextContent());
//                        System.out.println("regency_owner : " + eElement.getElementsByTagName("ccbaPoss").item(0).getTextContent());
//                        System.out.println("regency_content : " + eElement.getElementsByTagName("content").item(0).getTextContent());
//                        System.out.println("regency_enrolldate : " + eElement.getElementsByTagName("ccmaName").item(0).getTextContent());
//                        System.out.println("regency_longitude : " + eElement.getElementsByTagName("longitude").item(0).getTextContent());
//                        System.out.println("regency_latitude : " + eElement.getElementsByTagName("latitude").item(0).getTextContent());
////
//
//                        String regency_address = eElement.getElementsByTagName("ccbaLcad").item(0).getTextContent();
//                        String regency_type = eElement.getElementsByTagName("gcodeName").item(0).getTextContent();
//                        String regency_type2 = eElement.getElementsByTagName("bcodeName").item(0).getTextContent();
//                        String regency_type3 = eElement.getElementsByTagName("mcodeName").item(0).getTextContent();
//                        String regency_type4 = eElement.getElementsByTagName("scodeName").item(0).getTextContent();
//                        String regency_quantity = eElement.getElementsByTagName("ccbaQuan").item(0).getTextContent();
//                        String regency_era = eElement.getElementsByTagName("ccceName").item(0).getTextContent();
//                        String regency_owner = eElement.getElementsByTagName("ccbaPoss").item(0).getTextContent();
//                        String regency_content = eElement.getElementsByTagName("content").item(0).getTextContent();
//                        Date regency_enrolldate = sdf.parse(eElement.getElementsByTagName("ccmaName").item(0).getTextContent());
//                        String regency_longitude = eElement.getElementsByTagName("longitude").item(0).getTextContent();
//                        String regency_latitude = eElement.getElementsByTagName("latitude").item(0).getTextContent();
//
//                        java.sql.Date eDate = new java.sql.Date(regency_enrolldate.getTime());        // regency_enrolldate  type 변경
//
//                        // 상세 검색시
//                        Heritage heriDetail = new Heritage(regency_address, regency_type, regency_type2, regency_type3, regency_type4,
//                                regency_quantity, regency_era, regency_owner, regency_content, eDate, regency_longitude, regency_latitude);
//
////                    Heritage heriDetail = new Heritage(regency_sn, regency_no, regency_design_no, regency_trans_no, regency_name_kor,
////                            regency_name_chi, regency_category_name, regency_area, regency_area_no, regency_admin, regency_address,
////                            regency_type, regency_type2, regency_type3, regency_type4, regency_quantity, regency_era, regency_owner,
////                            regency_content, eDate, regency_longitude, regency_latitude);
//
//                        listDetail.add(heriDetail);
//                    }
//                }
//
//                hNum += 1;
//                if (hNum >= 16501) {
//                    break;
//                }
//
//                conn.disconnect();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }       // while end
//        return listDetail;
//    }
//
//
//}
//
//
//
