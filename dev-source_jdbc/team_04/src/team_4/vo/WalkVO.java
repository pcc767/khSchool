package vo;

public class WalkVO {
	private int	   ucSeq;
	private String mainTitle;
	private String cate2Nm;
	private String lat;
	private String lng;
	private String place;
	private String title;
	private String subTitle;
	private String trfcInfo;
	private String middleSizeRm1;
	private String mainImgNormal;
	private String mainImgThumb;

	public WalkVO() {
		super();
	}

	public WalkVO(int ucSeq, String mainTitle, String cate2Nm, String lat, String lng, String place, String title,
			String subTitle, String trfcInfo, String middleSizeRm1, String mainImgNormal, String mainImgThumb) {
		super();
		this.ucSeq = ucSeq;
		this.mainTitle = mainTitle;
		this.cate2Nm = cate2Nm;
		this.lat = lat;
		this.lng = lng;
		this.place = place;
		this.title = title;
		this.subTitle = subTitle;
		this.trfcInfo = trfcInfo;
		this.middleSizeRm1 = middleSizeRm1;
		this.mainImgNormal = mainImgNormal;
		this.mainImgThumb = mainImgThumb;
	}

	@Override
	public String toString() {
		return "Walk [ucSeq=" + ucSeq + ", mainTitle=" + mainTitle + ", cate2Nm=" + cate2Nm + ", lat=" + lat + ", lng="
				+ lng + ", place=" + place + ", title=" + title + ", subTitle=" + subTitle + ", trfcInfo=" + trfcInfo
				+ ", middleSizeRm1=" + middleSizeRm1 + ", mainImgNormal=" + mainImgNormal + ", mainImgThumb="
				+ mainImgThumb + "]";
	}
	
	public String toStringForConsole() {
		return "no:" + ucSeq + ", 콘텐츠명:" + mainTitle + ", 구분:" + cate2Nm	+ ", 구군:" + ", 위도:" + lat + ", 경도:" + lng ;
			
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

	public String getTrfcInfo() {
		return trfcInfo;
	}

	public void setTrfcInfo(String trfcInfo) {
		this.trfcInfo = trfcInfo;
	}

	public String getMiddleSizeRm1() {
		return middleSizeRm1;
	}

	public void setMiddleSizeRm1(String middleSizeRm1) {
		this.middleSizeRm1 = middleSizeRm1;
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
