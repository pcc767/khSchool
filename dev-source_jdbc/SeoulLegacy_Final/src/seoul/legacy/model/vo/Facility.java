package seoul.legacy.model.vo;

public class Facility {
	
	private int p_facility_no;
	private int palace_no;
	private int p_facility_detail_no;
	private String p_facility_name_kor;
	private String p_facility_name_eng;
	private String p_facility_name_jpa;
	private String p_facility_name_chi;
	private String p_facility_content;
	private String p_facility_content_eng;
	private String p_facility_content_jpa;
	private String p_facility_content_chi;
	
	public Facility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facility(int p_facility_no, int palace_no, int p_facility_detail_no, String p_facility_name_kor,
			String p_facility_name_eng, String p_facility_name_jpa, String p_facility_name_chi,
			String p_facility_content, String p_facility_content_eng, String p_facility_content_jpa,
			String p_facility_content_chi) {
		super();
		this.p_facility_no = p_facility_no;
		this.palace_no = palace_no;
		this.p_facility_detail_no = p_facility_detail_no;
		this.p_facility_name_kor = p_facility_name_kor;
		this.p_facility_name_eng = p_facility_name_eng;
		this.p_facility_name_jpa = p_facility_name_jpa;
		this.p_facility_name_chi = p_facility_name_chi;
		this.p_facility_content = p_facility_content;
		this.p_facility_content_eng = p_facility_content_eng;
		this.p_facility_content_jpa = p_facility_content_jpa;
		this.p_facility_content_chi = p_facility_content_chi;
	}

	public int getP_facility_no() {
		return p_facility_no;
	}

	public void setP_facility_no(int p_facility_no) {
		this.p_facility_no = p_facility_no;
	}

	public int getPalace_no() {
		return palace_no;
	}

	public void setPalace_no(int palace_no) {
		this.palace_no = palace_no;
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

	public String getP_facility_content() {
		return p_facility_content;
	}

	public void setP_facility_content(String p_facility_content) {
		this.p_facility_content = p_facility_content;
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

	@Override
	public String toString() {
		return "Palace [p_facility_no=" + p_facility_no + ", palace_no=" + palace_no + ", p_facility_detail_no="
				+ p_facility_detail_no + ", p_facility_name_kor=" + p_facility_name_kor + ", p_facility_name_eng="
				+ p_facility_name_eng + ", p_facility_name_jpa=" + p_facility_name_jpa + ", p_facility_name_chi="
				+ p_facility_name_chi + ", p_facility_content=" + p_facility_content + ", p_facility_content_eng="
				+ p_facility_content_eng + ", p_facility_content_jpa=" + p_facility_content_jpa
				+ ", p_facility_content_chi=" + p_facility_content_chi + "]";
	}
	
	

}
