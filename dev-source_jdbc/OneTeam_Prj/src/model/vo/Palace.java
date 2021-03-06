package model.vo;

public class Palace {

    // Header_data
    private int facility_no;                // serial_number 순번(키값)
    private int castle_no;                  // gung_number 궁 번호
    private int p_facility_detail_no;       // int detail_code 세부코드
    private String p_facility_name_kor;	            // String	궁 이름
    private String p_facility_contents_kor;         // String	문화재 한글설명
    private String imgUrl;	                // String	이미지 경로

//    필수 파라미터 -- 완성 후 삭제.
//    serial_number	int	순번(필수)
//    gung_number	int	궁 번호(필수)
//    detail_code	int	세부코드(필수)

    // Detail_data
    private String p_facility_name_eng;        	// String	문화재 영문명
    private String p_facility_name_jpa;	        // String	문화재 일문명
    private String p_facility_name_chi;	            // String	문화재 중문명
//    private String explanation_kor;	        // String	문화재 한글설명            // Header_data 중복
    private String p_facility_content_eng;	        // String	문화재 영문설명
    private String p_facility_content_jpa;	        // String	문화재 일문설명
    private String p_facility_content_chi;	        // String	문화재 중문설명
//    private String imgUrl;	                // String	문화재 이미지 경로          // Header_data 중복
    private String image;	                // String	문화재 상세 이미지 경로
    private String moving;	                // String	동영상 경로

    public Palace() {
    }

    public Palace(int facility_no, int castle_no, int p_facility_detail_no, String p_facility_name_kor,
			String p_facility_contents_kor) {
		super();
		this.facility_no = facility_no;
		this.castle_no = castle_no;
		this.p_facility_detail_no = p_facility_detail_no;
		this.p_facility_name_kor = p_facility_name_kor;
		this.p_facility_contents_kor = p_facility_contents_kor;
	}

	public int getFacility_no() {
		return facility_no;
	}

	public void setFacility_no(int facility_no) {
		this.facility_no = facility_no;
	}

	public int getCastle_no() {
		return castle_no;
	}

	public void setCastle_no(int castle_no) {
		this.castle_no = castle_no;
	}

	public int getP_facility_detail_no() {
		return p_facility_detail_no;
	}

	public void setP_facility_detail_no(int p_facility_detail_no) {
		this.p_facility_detail_no = p_facility_detail_no;
	}

	public String getP_facility_name_kor() {
		return p_facility_name_kor;
	}

	public void setP_facility_name_kor(String p_facility_name_kor) {
		this.p_facility_name_kor = p_facility_name_kor;
	}

	public String getP_facility_contents_kor() {
		return p_facility_contents_kor;
	}

	public void setP_facility_contents_kor(String p_facility_contents_kor) {
		this.p_facility_contents_kor = p_facility_contents_kor;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getP_facility_name_eng() {
		return p_facility_name_eng;
	}

	public void setP_facility_name_eng(String p_facility_name_eng) {
		this.p_facility_name_eng = p_facility_name_eng;
	}

	public String getP_facility_name_jpa() {
		return p_facility_name_jpa;
	}

	public void setP_facility_name_jpa(String p_facility_name_jpa) {
		this.p_facility_name_jpa = p_facility_name_jpa;
	}

	public String getP_facility_name_chi() {
		return p_facility_name_chi;
	}

	public void setP_facility_name_chi(String p_facility_name_chi) {
		this.p_facility_name_chi = p_facility_name_chi;
	}

	public String getP_facility_content_eng() {
		return p_facility_content_eng;
	}

	public void setP_facility_content_eng(String p_facility_content_eng) {
		this.p_facility_content_eng = p_facility_content_eng;
	}

	public String getP_facility_content_jpa() {
		return p_facility_content_jpa;
	}

	public void setP_facility_content_jpa(String p_facility_content_jpa) {
		this.p_facility_content_jpa = p_facility_content_jpa;
	}

	public String getP_facility_content_chi() {
		return p_facility_content_chi;
	}

	public void setP_facility_content_chi(String p_facility_content_chi) {
		this.p_facility_content_chi = p_facility_content_chi;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMoving() {
		return moving;
	}

	public void setMoving(String moving) {
		this.moving = moving;
	}

	@Override
	public String toString() {
		return "Palace [facility_no=" + facility_no + ", castle_no=" + castle_no + ", p_facility_detail_no="
				+ p_facility_detail_no + ", p_facility_name_kor=" + p_facility_name_kor + ", p_facility_contents_kor="
				+ p_facility_contents_kor + ", imgUrl=" + imgUrl + ", p_facility_name_eng=" + p_facility_name_eng
				+ ", p_facility_name_jpa=" + p_facility_name_jpa + ", p_facility_name_chi=" + p_facility_name_chi
				+ ", p_facility_content_eng=" + p_facility_content_eng + ", p_facility_content_jpa="
				+ p_facility_content_jpa + ", p_facility_content_chi=" + p_facility_content_chi + ", image=" + image
				+ ", moving=" + moving + "]";
	}


	
}
