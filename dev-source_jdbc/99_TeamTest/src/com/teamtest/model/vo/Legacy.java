package com.teamtest.model.vo;

import java.sql.Date;

// Legacy - LegacyApiManagerr - datasource.properties - JDBCTemplete - LegacyDao - LegacyService - LegacyController

public class Legacy {
	
	private String legacy_no;
	private String legacy_design_no;
	private String legacy_trans_no;
	private String legacy_category_name;
	private String legacy_name_kor; 
	private String legacy_name_chi; 
	private String legacy_area;
	private String legacy_address; 
	private String legacy_admin; 
	private String legacy_type; 
	private String legacy_type2; 
	private String legacy_type3; 
	private String legacy_type4; 
	private String legacy_quantity; 
	private String legacy_era; 
	private String legacy_owner; 
	private String legacy_content; 
	private Date legacy_enrolldate; 
	private String legacy_longitude; 
	private String legacy_latitude;
	
	public Legacy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Legacy(String legacy_name_kor,String legacy_category_name, String legacy_area) {
		super();
		this.legacy_name_kor = legacy_name_kor;
		this.legacy_category_name = legacy_category_name;
		this.legacy_area = legacy_area;
	}

	public Legacy(String legacy_no, String legacy_design_no, String legacy_trans_no, String legacy_category_name,
			String legacy_name_kor, String legacy_name_chi, String legacy_area, String legacy_address,
			String legacy_admin, String legacy_type, String legacy_type2, String legacy_type3, String legacy_type4,
			String legacy_quantity, String legacy_era, String legacy_owner, String legacy_content,
			Date legacy_enrolldate, String legacy_longitude, String legacy_latitude) {
		super();
		this.legacy_no = legacy_no;
		this.legacy_design_no = legacy_design_no;
		this.legacy_trans_no = legacy_trans_no;
		this.legacy_category_name = legacy_category_name;
		this.legacy_name_kor = legacy_name_kor;
		this.legacy_name_chi = legacy_name_chi;
		this.legacy_area = legacy_area;
		this.legacy_address = legacy_address;
		this.legacy_admin = legacy_admin;
		this.legacy_type = legacy_type;
		this.legacy_type2 = legacy_type2;
		this.legacy_type3 = legacy_type3;
		this.legacy_type4 = legacy_type4;
		this.legacy_quantity = legacy_quantity;
		this.legacy_era = legacy_era;
		this.legacy_owner = legacy_owner;
		this.legacy_content = legacy_content;
		this.legacy_enrolldate = legacy_enrolldate;
		this.legacy_longitude = legacy_longitude;
		this.legacy_latitude = legacy_latitude;
	}

	public String getLegacy_no() {
		return legacy_no;
	}

	public void setLegacy_no(String legacy_no) {
		this.legacy_no = legacy_no;
	}

	public String getLegacy_design_no() {
		return legacy_design_no;
	}

	public void setLegacy_design_no(String legacy_design_no) {
		this.legacy_design_no = legacy_design_no;
	}

	public String getLegacy_trans_no() {
		return legacy_trans_no;
	}

	public void setLegacy_trans_no(String legacy_trans_no) {
		this.legacy_trans_no = legacy_trans_no;
	}

	public String getLegacy_category_name() {
		return legacy_category_name;
	}

	public void setLegacy_category_name(String legacy_category_name) {
		this.legacy_category_name = legacy_category_name;
	}

	public String getLegacy_name_kor() {
		return legacy_name_kor;
	}

	public void setLegacy_name_kor(String legacy_name_kor) {
		this.legacy_name_kor = legacy_name_kor;
	}

	public String getLegacy_name_chi() {
		return legacy_name_chi;
	}

	public void setLegacy_name_chi(String legacy_name_chi) {
		this.legacy_name_chi = legacy_name_chi;
	}

	public String getLegacy_area() {
		return legacy_area;
	}

	public void setLegacy_area(String legacy_area) {
		this.legacy_area = legacy_area;
	}

	public String getLegacy_address() {
		return legacy_address;
	}

	public void setLegacy_address(String legacy_address) {
		this.legacy_address = legacy_address;
	}

	public String getLegacy_admin() {
		return legacy_admin;
	}

	public void setLegacy_admin(String legacy_admin) {
		this.legacy_admin = legacy_admin;
	}

	public String getLegacy_type() {
		return legacy_type;
	}

	public void setLegacy_type(String legacy_type) {
		this.legacy_type = legacy_type;
	}

	public String getLegacy_type2() {
		return legacy_type2;
	}

	public void setLegacy_type2(String legacy_type2) {
		this.legacy_type2 = legacy_type2;
	}

	public String getLegacy_type3() {
		return legacy_type3;
	}

	public void setLegacy_type3(String legacy_type3) {
		this.legacy_type3 = legacy_type3;
	}

	public String getLegacy_type4() {
		return legacy_type4;
	}

	public void setLegacy_type4(String legacy_type4) {
		this.legacy_type4 = legacy_type4;
	}

	public String getLegacy_quantity() {
		return legacy_quantity;
	}

	public void setLegacy_quantity(String legacy_quantity) {
		this.legacy_quantity = legacy_quantity;
	}

	public String getLegacy_era() {
		return legacy_era;
	}

	public void setLegacy_era(String legacy_era) {
		this.legacy_era = legacy_era;
	}

	public String getLegacy_owner() {
		return legacy_owner;
	}

	public void setLegacy_owner(String legacy_owner) {
		this.legacy_owner = legacy_owner;
	}

	public String getLegacy_content() {
		return legacy_content;
	}

	public void setLegacy_content(String legacy_content) {
		this.legacy_content = legacy_content;
	}

	public Date getLegacy_enrolldate() {
		return legacy_enrolldate;
	}

	public void setLegacy_enrolldate(Date legacy_enrolldate) {
		this.legacy_enrolldate = legacy_enrolldate;
	}

	public String getLegacy_longitude() {
		return legacy_longitude;
	}

	public void setLegacy_longitude(String legacy_longitude) {
		this.legacy_longitude = legacy_longitude;
	}

	public String getLegacy_latitude() {
		return legacy_latitude;
	}

	public void setLegacy_latitude(String legacy_latitude) {
		this.legacy_latitude = legacy_latitude;
	}

	
	public String detailtoString() {
		return "Legacy [legacy_no=" + legacy_no + ", legacy_design_no=" + legacy_design_no + ", legacy_trans_no="
				+ legacy_trans_no + ", legacy_category_name=" + legacy_category_name + ", legacy_name_kor="
				+ legacy_name_kor + ", legacy_name_chi=" + legacy_name_chi + ", legacy_area=" + legacy_area
				+ ", legacy_address=" + legacy_address + ", legacy_admin=" + legacy_admin + ", legacy_type="
				+ legacy_type + ", legacy_type2=" + legacy_type2 + ", legacy_type3=" + legacy_type3 + ", legacy_type4="
				+ legacy_type4 + ", legacy_quantity=" + legacy_quantity + ", legacy_era=" + legacy_era
				+ ", legacy_owner=" + legacy_owner + ", legacy_content=" + legacy_content + ", legacy_enrolldate="
				+ legacy_enrolldate + ", legacy_longitude=" + legacy_longitude + ", legacy_latitude=" + legacy_latitude
				+ "]";
	}

	@Override
	public String toString() {
		return "Legacy [legacy_name_kor=" + legacy_name_kor +", legacy_category_name=" + legacy_category_name
				+ ", legacy_area=" + legacy_area + "]";
	}
	
	
	
	
}
