package vo;

import java.util.Date;

import common.Util;

public class ThemeReviewVO {
	private int tRevNum; 		
	private int uNum; 			
	private int tNum; 			
	private String tRevTitle; 	
	private String tRevContent; 	
	private Date tRevCreateDate;
	private UserVO user;
	private ThemeVO themeInfo;
	
	public ThemeReviewVO() {
		super();
	}

	public ThemeReviewVO(int tRevNum, int uNum, ThemeVO themeInfo, String tRevTitle, String tRevContent, Date tRevCreateDate) {
		super();
		this.tRevNum = tRevNum;
		this.uNum = uNum;
		this.themeInfo = themeInfo;
		this.tRevTitle = tRevTitle;
		this.tRevContent = tRevContent;
		this.tRevCreateDate = tRevCreateDate;
	}
	
	public ThemeReviewVO(int tRevNum, int uNum, int tNum, String tRevTitle, String tRevContent) {
		super();
		this.tRevNum = tRevNum;
		this.uNum = uNum;
		this.tNum = tNum;
		this.tRevTitle = tRevTitle;
		this.tRevContent = tRevContent;
	}
	
	public ThemeReviewVO(String tRevTitle, String tRevContent) {
		super();
		this.tRevTitle = tRevTitle;
		this.tRevContent = tRevContent;
	}

	@Override
	public String toString() {
		return "ThemeReviewVO [tRevNum=" + tRevNum + ", uNum=" + uNum + ", tNum=" + tNum + ", tRevTitle=" + tRevTitle
				+ ", tRevContent=" + tRevContent + ", tRevCreateDate=" + tRevCreateDate + "]";
	}
	
	public String toStringForConsole() {
		return "리뷰번호:" + tRevNum + " 유저번호:" + uNum + " 여행제목:" + themeInfo.getMainTitle() +" 제목:" + tRevTitle + " 내용: "+ tRevContent + "  작성일:" + Util.getDateFormat(tRevCreateDate);
	}
	
	public String toStringDetail() {
		return "No : " + tRevNum 
				+ "\n제목 : " + tRevTitle 
				+ "\n테마여행 : " + themeInfo.getTitle()
				+ "\n내용 : " + tRevContent  
				+ "\n작성일 : " + Util.getDateFormat(tRevCreateDate)
				+ "\n작성자 : " + user.getUserId() 
				+ "\n";
	}

	public int gettRevNum() {
		return tRevNum;
	}

	public void settRevNum(int tRevNum) {
		this.tRevNum = tRevNum;
	}

	public int getuNum() {
		return uNum;
	}

	public void setuNum(int uNum) {
		this.uNum = uNum;
	}

	public int gettNum() {
		return tNum;
	}

	public void settNum(int tNum) {
		this.tNum = tNum;
	}

	public String gettRevTitle() {
		return tRevTitle;
	}

	public void settRevTitle(String tRevTitle) {
		this.tRevTitle = tRevTitle;
	}

	public String gettRevContent() {
		return tRevContent;
	}

	public void settRevContent(String tRevContent) {
		this.tRevContent = tRevContent;
	}

	public Date gettRevCreateDate() {
		return tRevCreateDate;
	}

	public void settRevCreateDate(Date tRevCreateDate) {
		this.tRevCreateDate = tRevCreateDate;
	}
}
