package vo;

public class ThemeVO {
	private int    ucSeq;                 
	private String mainTitle;                
	private String cate2Nm;               
	private String gugunNm;               
	private String lat;                    
	private String lng;                   
	private String place;                  
	private String title;                  
	private String subTitle;               
	private String mainPlace;             
	private String addr1;                  
	private String addr2;                  
	private String cntctTel;              
	private String usageDay;              
	private String hldyInfo;              
	private String usageDayWeekAndTime;
	private String usageAmount;           
	private String middleSizeRm1;        
	private String homepageUrl;           
	private String trfcInfo;              
	private String mainImgNormal;        
	private String mainImgThumb;         
	                              
	public ThemeVO() {
		super();
	}

	public ThemeVO(int ucSeq, String mainTitle, String cate2Nm, String gugunNm, String lat, String lng, String place,
			String title, String subTitle, String mainPlace, String addr1, String addr2, String cntctTel,
			String usageDay, String hldyInfo, String usageDayWeekAndTime, String usageAmount, String middleSizeRm1,
			String homepageUrl, String trfcInfo, String mainImgNormal, String mainImgThumb) {
		super();
		this.ucSeq = ucSeq;
		this.mainTitle = mainTitle;
		this.cate2Nm = cate2Nm;
		this.gugunNm = gugunNm;
		this.lat = lat;
		this.lng = lng;
		this.place = place;
		this.title = title;
		this.subTitle = subTitle;
		this.mainPlace = mainPlace;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.cntctTel = cntctTel;
		this.usageDay = usageDay;
		this.hldyInfo = hldyInfo;
		this.usageDayWeekAndTime = usageDayWeekAndTime;
		this.usageAmount = usageAmount;
		this.middleSizeRm1 = middleSizeRm1;
		this.homepageUrl = homepageUrl;
		this.trfcInfo = trfcInfo;
		this.mainImgNormal = mainImgNormal;
		this.mainImgThumb = mainImgThumb;
	}

	@Override
	public String toString() {
		return "ThemeVO [ucSeq=" + ucSeq + ", mainTitle=" + mainTitle + ", cate2Nm=" + cate2Nm + ", gugunNm=" + gugunNm
				+ ", lat=" + lat + ", lng=" + lng + ", place=" + place + ", title=" + title + ", subTitle=" + subTitle
				+ ", mainPlace=" + mainPlace + ", addr1=" + addr1 + ", addr2=" + addr2 + ", cntctTel=" + cntctTel
				+ ", usageDay=" + usageDay + ", hldyInfo=" + hldyInfo + ", usageDayWeekAndTime=" + usageDayWeekAndTime
				+ ", usageAmount=" + usageAmount + ", middleSizeRm1=" + middleSizeRm1 + ", homepageUrl=" + homepageUrl
				+ ", trfcInfo=" + trfcInfo + ", mainImgNormal=" + mainImgNormal + ", mainImgThumb=" + mainImgThumb
				+ "]";
	}
	
	public String toStringForConsole() {
		return "no:" + ucSeq + ", 콘텐츠명:" + mainTitle + ", 구분:" + cate2Nm	+ ", 구군:" + gugunNm
				+ ", 위도:" + lat + ", 경도:" + lng ;
			
	}

	public int getUcSeq() {
		return ucSeq;
	}

	public void setUcSeq(int ucSeq) {
		this.ucSeq = ucSeq;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}

	public String getCate2Nm() {
		return cate2Nm;
	}

	public void setCate2Nm(String cate2Nm) {
		this.cate2Nm = cate2Nm;
	}

	public String getGugunNm() {
		return gugunNm;
	}

	public void setGugunNm(String gugunNm) {
		this.gugunNm = gugunNm;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getMainPlace() {
		return mainPlace;
	}

	public void setMainPlace(String mainPlace) {
		this.mainPlace = mainPlace;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getCntctTel() {
		return cntctTel;
	}

	public void setCntctTel(String cntctTel) {
		this.cntctTel = cntctTel;
	}

	public String getUsageDay() {
		return usageDay;
	}

	public void setUsageDay(String usageDay) {
		this.usageDay = usageDay;
	}

	public String getHldyInfo() {
		return hldyInfo;
	}

	public void setHldyInfo(String hldyInfo) {
		this.hldyInfo = hldyInfo;
	}

	public String getUsageDayWeekAndTime() {
		return usageDayWeekAndTime;
	}

	public void setUsageDayWeekAndTime(String usageDayWeekAndTime) {
		this.usageDayWeekAndTime = usageDayWeekAndTime;
	}

	public String getUsageAmount() {
		return usageAmount;
	}

	public void setUsageAmount(String usageAmount) {
		this.usageAmount = usageAmount;
	}

	public String getMiddleSizeRm1() {
		return middleSizeRm1;
	}

	public void setMiddleSizeRm1(String middleSizeRm1) {
		this.middleSizeRm1 = middleSizeRm1;
	}

	public String getHomepageUrl() {
		return homepageUrl;
	}

	public void setHomepageUrl(String homepageUrl) {
		this.homepageUrl = homepageUrl;
	}

	public String getTrfcInfo() {
		return trfcInfo;
	}

	public void setTrfcInfo(String trfcInfo) {
		this.trfcInfo = trfcInfo;
	}

	public String getMainImgNormal() {
		return mainImgNormal;
	}

	public void setMainImgNormal(String mainImgNormal) {
		this.mainImgNormal = mainImgNormal;
	}

	public String getMainImgThumb() {
		return mainImgThumb;
	}

	public void setMainImgThumb(String mainImgThumb) {
		this.mainImgThumb = mainImgThumb;
	}
}
