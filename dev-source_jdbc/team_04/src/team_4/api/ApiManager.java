package api;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vo.ParkVO;
import vo.ThemeVO;
import vo.WalkVO;

public class ApiManager {
	
	public List<ParkVO> parkApi() {
		String addr;
		
		List<ParkVO> list = new ArrayList<>();
		try {
			int page = 1;
			while(true) {
				String url = "http://apis.data.go.kr/6260000/BusanPblcPrkngInfoService/getPblcPrkngInfo?"
	        			+ "serviceKey=1n4THo6i88dAniTj3VQPQLc%2BKj8AhB%2BjrA2WmJxMjKlcpkoi%2BsxoUiHXhe%2Fhrp8NY9BQOoPu1Vdj8UuQH4g2Dg%3D%3D&"
	        			+ "numOfRows=50&pageNo="+page; 
	        	
	        	DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// 'item' 태그 안에 있는 모든 태그들 가져옴.
				NodeList nList = doc.getElementsByTagName("item");
				
				for(int i = 0; i < nList.getLength(); i++){
					Node nNode = nList.item(i);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						Element eElement = (Element) nNode;
						int mgntNum = Integer.parseInt(getTagValue("mgntNum", eElement));
						String pkNam = getTagValue("pkNam", eElement);
						if (getTagValue("doroAddr", eElement).equals("-")) {
							addr = getTagValue("jibunAddr", eElement);
						} else {
							addr = getTagValue("doroAddr", eElement);
						}
						if (addr.length() <= 4) {
							addr = addr + " " + pkNam;
						}
						String tponNum = getTagValue("tponNum", eElement);
						String pkCnt = getTagValue("pkCnt", eElement);
						String tenMin = getTagValue("tenMin", eElement);
						String ftDay = getTagValue("ftDay", eElement);
						String ftMon = getTagValue("ftMon", eElement);
						String svcSrtTe = getTagValue("svcSrtTe", eElement);
						String svcEndTe = getTagValue("svcEndTe", eElement);
						String satSrtTe = getTagValue("satSrtTe", eElement);
						String satEndTe = getTagValue("satEndTe", eElement);
						String hldSrtTe = getTagValue("hldSrtTe", eElement);
						String hldEndTe = getTagValue("hldEndTe", eElement);
						
						ParkVO park = new ParkVO(mgntNum, pkNam, addr, pkCnt, tponNum, tenMin, ftDay, ftMon, svcSrtTe, svcEndTe, satSrtTe, satEndTe, hldSrtTe, hldEndTe);
						list.add(park);
						}
					}	
					page++;
					if (page > 12) { 
						System.out.println("파싱 성공!!");
						break;
					}
				}
		} catch (Exception e) {
			System.out.println("데이터가 잘못되었습니다.");
			e.printStackTrace();
		}
		
		return list;
	}	
	
public List<ThemeVO> themeApi() {
		
		List<ThemeVO> list = new ArrayList<>();
		try {
			int page = 1;
			while (true) {
				String url = "http://apis.data.go.kr/6260000/RecommendedService/getRecommendedKr?"
						+ "serviceKey=FTKvf97d%2BwaYn2%2BxgA%2F0es0m8euqT4dmzeRe5rpsoncctCkGOMl3d%2Fw2s1sK2aZa6xB485OOCmPYOtqUJ8jBiA%3D%3D"
						+ "&numOfRows=50&pageNo="+ page;

				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);

				// 'item' 태그 안에 있는 모든 태그들 가져옴.
				NodeList nList = doc.getElementsByTagName("item");

				for (int i = 0; i < nList.getLength(); i++) {
					Node nNode = nList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						int ucSeq = Integer.parseInt(getTagValue("UC_SEQ", eElement));
						String mainTitle = getTagValue("MAIN_TITLE", eElement);
						String cate2Nm = getTagValue("CATE2_NM", eElement);
						String gugunNm = getTagValue("GUGUN_NM", eElement);
						String lat = getTagValue("LAT", eElement);
						String lng = getTagValue("LNG", eElement);
						String place = getTagValue("PLACE", eElement);
						String title = getTagValue("TITLE", eElement);
						String subtitle = getTagValue("SUBTITLE", eElement);
						String mainPlace = getTagValue("MAIN_PLACE", eElement);
						String addr1 = getTagValue("ADDR1", eElement);
						String addr2 = getTagValue("ADDR2", eElement);
						String cntctTel = getTagValue("CNTCT_TEL", eElement);
						String usageDay = getTagValue("USAGE_DAY", eElement);
						String hldyInfo = getTagValue("HLDY_INFO", eElement);
						String usageDayWeekAndTime = getTagValue("USAGE_DAY_WEEK_AND_TIME", eElement);
						String usageAmount = getTagValue("USAGE_AMOUNT", eElement);
						String middleSizeRm1 = getTagValue("MIDDLE_SIZE_RM1", eElement);
						String homepageUrl = getTagValue("HOMEPAGE_URL", eElement);
						String trfcInfo = getTagValue("TRFC_INFO", eElement);
						String mainImgNormal = getTagValue("MAIN_IMG_NORMAL", eElement);
						String mainImgThumb = getTagValue("MAIN_IMG_THUMB", eElement);
						
						ThemeVO theme = new ThemeVO(ucSeq, mainTitle, cate2Nm, gugunNm, lat, lng, place, title, 
												    subtitle, mainPlace, addr1, addr2, cntctTel, usageDay, hldyInfo, usageDayWeekAndTime, 
												    usageAmount, middleSizeRm1, homepageUrl, trfcInfo, mainImgNormal, mainImgThumb);
						
						list.add(theme);
					}
				}
				page++;
				if (page > 3) { 
					System.out.println("파싱 성공!!");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("데이터가 잘못되었습니다.");
			e.printStackTrace();
		}

		return list;
	}
	
	
	public List<WalkVO> walkApi() {
		
		List<WalkVO> list = new ArrayList<>();
		try {
			int page = 1;
			while (true) {
				String url = "http://apis.data.go.kr/6260000/WalkingService/getWalkingKr?"
						+ "serviceKey=1n4THo6i88dAniTj3VQPQLc%2BKj8AhB%2BjrA2WmJxMjKlcpkoi%2BsxoUiHXhe%2Fhrp8NY9BQOoPu1Vdj8UuQH4g2Dg%3D%3D&"
						+ "numOfRows=50&pageNo=" + page;

				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);

				// 'item' 태그 안에 있는 모든 태그들 가져옴.
				NodeList nList = doc.getElementsByTagName("item");

				for (int i = 0; i < nList.getLength(); i++) {
					Node nNode = nList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						int ucSeq = Integer.parseInt(getTagValue("UC_SEQ", eElement));
						String mainTitle = getTagValue("MAIN_TITLE", eElement);
						String cate2Nm = getTagValue("CATE2_NM", eElement);
						String lat = getTagValue("LAT", eElement);
						String lng = getTagValue("LNG", eElement);
						String place = getTagValue("PLACE", eElement);
						String title = getTagValue("TITLE", eElement);
						String subtitle = getTagValue("SUBTITLE", eElement);
						String trfcInfo = getTagValue("TRFC_INFO", eElement);
						String middleSizeRm1 = getTagValue("MIDDLE_SIZE_RM1", eElement);
						String mainImgNormal = getTagValue("MAIN_IMG_NORMAL", eElement);
						String mainImgThumb = getTagValue("MAIN_IMG_THUMB", eElement);
						
						
						WalkVO walk = new WalkVO(ucSeq, mainTitle, cate2Nm, lat, lng, place, 
								title, subtitle, trfcInfo, middleSizeRm1, mainImgNormal, mainImgThumb);
						list.add(walk);
					}
				}
				System.out.println("파싱 성공!!");
				break;
			}
		} catch (Exception e) {
			System.out.println("데이터가 잘못되었습니다.");
			e.printStackTrace();
		}
		
		return list;
	}
	
	private static String getTagValue(String tag, Element e) {
	    NodeList nlList = e.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
}
