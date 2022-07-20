package seoul.legacy.model.vo;

import java.util.Date;

public class Zzim {
	// 1. userId로 검색
	// 2. legacyNo로 검색
	private String userId;
	private int legacyNo;
	private Date zzimDate;
	private String legacyName;

	public Zzim() {
		super();
	}

	public Zzim(String userId, int legacyNo, Date zzimDate, String legacyName) {
		super();
		this.userId = userId;
		this.legacyNo = legacyNo;
		this.zzimDate = zzimDate;
		this.legacyName = legacyName;
	}

	// insert 시 활용
	public Zzim(String userId, int legacyNo) {
		super();
		this.userId = userId;
		this.legacyNo = legacyNo;
	}

	// 1. id 검색 출력
	@Override
	public String toString() {
		return "문화재명 : " + legacyName + " 찜한 일자 : " + zzimDate;
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

	public Date getZzimDate() {
		return zzimDate;
	}

	public void setZzimDate(Date zzimDate) {
		this.zzimDate = zzimDate;
	}

	public String getLegacyName() {
		return legacyName;
	}

	public void setLegacyName(String legacyName) {
		this.legacyName = legacyName;
	}

}
