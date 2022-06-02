package com.boxoffice.model.vo;

import java.util.Date;

import com.boxoffice.common.Util;

public class Favorite {
	private int bNo;
	private int uNo;
	private Date createDate; // CREATE_DATE
	private String userId;
	private String movieNm;

	public Favorite() {
		super();
	}
	
	public Favorite(int bNo, int uNo) {
		super();
		this.bNo = bNo;
		this.uNo = uNo;
	}

	public Favorite(int bNo, int uNo, Date createDate, String userId, String movieNm) {
		super();
		this.bNo = bNo;
		this.uNo = uNo;
		this.createDate = createDate;
		this.userId = userId;
		this.movieNm = movieNm;
	}

	@Override
	public String toString() {
		return "Favorite [bNo=" + bNo + ", uNo=" + uNo + ", createDate=" + Util.getDateFormat(createDate)  + ", userId=" + userId
				+ ", movieNm=" + movieNm + "]";
	}
	
	public String toStringForConsole() {
		return 	"제목 : " + movieNm + ", 생성일 : " + Util.getDateFormat(createDate)  + ", id=" + userId;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

}