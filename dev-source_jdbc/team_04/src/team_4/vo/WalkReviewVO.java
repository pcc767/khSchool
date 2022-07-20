package vo;

import java.util.Date;

import common.Util;

public class WalkReviewVO {
	private int wRevNum;
	private int uNum;
	private int wNum;
	private String wRevTitle;
	private String wRevContent;
	private Date wRevCreateDate;
	private WalkVO walkInfo;
	
	public WalkReviewVO() {
		super();
	}

	public WalkReviewVO(int wRevNum, int uNum, WalkVO walkInfo, String wRevTitle, String wRevContent, Date wRevCreateDate) {
		super();
		this.wRevNum = wRevNum;
		this.uNum = uNum;
		this.walkInfo = walkInfo;
		this.wRevTitle = wRevTitle;
		this.wRevContent = wRevContent;
		this.wRevCreateDate = wRevCreateDate;
	}
	
	public WalkReviewVO(int wRevNum, int uNum, int wNum, String wRevTitle, String wRevContent) {
		super();
		this.wRevNum = wRevNum;
		this.uNum = uNum;
		this.wNum = wNum;
		this.wRevTitle = wRevTitle;
		this.wRevContent = wRevContent;
	}

	public WalkReviewVO(String wRevTitle, String wRevContent) {
		super();
		this.wRevTitle = wRevTitle;
		this.wRevContent = wRevContent;
	}

	@Override
	public String toString() {
		return "WalkReviewVO [wRevNum=" + wRevNum + ", uNum=" + uNum + ", wNum=" + wNum + ", wRevTitle=" + wRevTitle
				+ ", wRevContent=" + wRevContent + ", wRevCreateDate=" + wRevCreateDate + "]";
	}
	
	public String toStringForConsole() {
		return "리뷰번호:" + wRevNum + " 유저번호:" + uNum + " 여행제목:" + walkInfo.getMainTitle() +" 제목:" + wRevTitle + " 내용: "+ wRevContent + "  작성일:" + Util.getDateFormat(wRevCreateDate);
	}

	public int getwRevNum() {
		return wRevNum;
	}

	public void setwRevNum(int wRevNum) {
		this.wRevNum = wRevNum;
	}

	public int getuNum() {
		return uNum;
	}

	public void setuNum(int uNum) {
		this.uNum = uNum;
	}

	public int getwNum() {
		return wNum;
	}

	public void setwNum(int wNum) {
		this.wNum = wNum;
	}

	public String getwRevTitle() {
		return wRevTitle;
	}

	public void setwRevTitle(String wRevTitle) {
		this.wRevTitle = wRevTitle;
	}

	public String getwRevContent() {
		return wRevContent;
	}

	public void setwRevContent(String wRevContent) {
		this.wRevContent = wRevContent;
	}

	public Date getwRevCreateDate() {
		return wRevCreateDate;
	}

	public void setwRevCreateDate(Date wRevCreateDate) {
		this.wRevCreateDate = wRevCreateDate;
	}
}
