package seoul.legacy.model.vo;

public class Palace {

// 	palaceNo(궁번호) , Legacyno(문화재번호) , legacyName(문화재이름) , legacycontent(설명)

	private int palaceNo;
	private int legacyNo;
	private String legacyName;
	private String legacyContent;

	public Palace() {
		super();
	}

	public Palace(int palaceNo, int legacyNo, String legacyName, String legacyContent) {
		super();
		this.palaceNo = palaceNo;
		this.legacyNo = legacyNo;
		this.legacyName = legacyName;
		this.legacyContent = legacyContent;
	}

	public Palace(int palaceNo, int legacyNo) {
		super();
		this.palaceNo = palaceNo;
		this.legacyNo = legacyNo;
	}

	@Override
	public String toString() {
		return "궁궐 이름 : " + legacyName + "\n설명 : " + legacyContent;
	}

	public int getPalaceNo() {
		return palaceNo;
	}

	public void setPalaceNo(int palaceNo) {
		this.palaceNo = palaceNo;
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

	public String getLegacyContent() {
		return legacyContent;
	}

	public void setLegacyContent(String legacyContent) {
		this.legacyContent = legacyContent;
	}

}