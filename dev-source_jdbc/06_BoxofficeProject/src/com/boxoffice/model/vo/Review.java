package com.boxoffice.model.vo;

import java.sql.Date;

public class Review {
	int rNo;
	int bNo;
	int uNo;
	String title;
	String content;
	int score;
	Date createDate; // REVIEW_BOXOFFICE
	User user;
	Boxoffice movieInfo;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int rNo, int bNo, int uNo, String title, String content, int score, Date createDate, User user,
			Boxoffice movieInfo) {
		super();
		this.rNo = rNo;
		this.bNo = bNo;
		this.uNo = uNo;
		this.title = title;
		this.content = content;
		this.score = score;
		this.createDate = createDate;
		this.user = user;
		this.movieInfo = movieInfo;
	}
	
	

	public Review(int bNo, int uNo, String title, String content, int score) {
		super();
		this.bNo = bNo;
		this.uNo = uNo;
		this.title = title;
		this.content = content;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Review [rNo=" + rNo + ", bNo=" + bNo + ", uNo=" + uNo + ", title=" + title + ", content=" + content
				+ ", score=" + score + ", createDate=" + createDate + ", user=" + user + ", movieInfo=" + movieInfo
				+ "]";
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boxoffice getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(Boxoffice movieInfo) {
		this.movieInfo = movieInfo;
	}

}