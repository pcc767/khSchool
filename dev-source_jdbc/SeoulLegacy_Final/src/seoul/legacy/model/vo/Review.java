package seoul.legacy.model.vo;

import java.util.Date;

public class Review {
	// 1. 유저 검색
	// 2. 문화재 검색
	private int reviewNo;
	private String reviewContent;
	private String userId;
	private int legacyNo;
	private String legacyName;
	private Date reviewDate;

	public Review() {
		super();
	}

	public Review(String reviewContent, String userId, int legacyNo) {
		super();
		this.reviewContent = reviewContent;
		this.userId = userId;
		this.legacyNo = legacyNo;
	}

	public Review(int reviewNo, String reviewContent, String userId, int legacyNo, String legacyName, Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.userId = userId;
		this.legacyNo = legacyNo;
		this.legacyName = legacyName;
		this.reviewDate = reviewDate;
	}

	// 문화재로 검색 시
	public String legacyToString() {
		return "아이디 : " + userId + "작성 일자 : " + reviewDate + "\n내용 : " + reviewContent;
	}

	// 아이디로 검색 시
	public String idToString() {
		return "문화재명 : " + legacyName + "작성 일자 : " + reviewDate + "\n내용 : " + reviewContent;
	}	

	
	//추가 - 0606 / 구기혁
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", userId=" + userId
				+ ", legacyNo=" + legacyNo + ", legacyName=" + legacyName + ", reviewDate=" + reviewDate + "]";
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getLegacyNo() {
		return legacyNo;
	}

	public void setLegacyNo(int legacyNo) {
		this.legacyNo = legacyNo;
	}

	public String getLegacyName() {
		return legacyName;
	}

	public void setLegacyName(String legacyName) {
		this.legacyName = legacyName;
	}

}
