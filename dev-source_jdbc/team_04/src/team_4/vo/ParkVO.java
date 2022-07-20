package vo;

public class ParkVO {
	private int    mgntNum;
	private String pkNam;  
	private String addr;   
	private String pkCnt;  
	private String tponNum;
	private String tenMin; 
	private String ftDay;  
	private String ftMon;  
	private String svcSrtTe;
	private String svcEndTe;
	private String satSrtTe;
	private String satEndTe;
	private String hldSrtTe;
	private String hldEndTe;
	
	public ParkVO(int mgntNum, String pkNam, String addr, String pkCnt, String tponNum, String tenMin, String ftDay,
			String ftMon, String svcSrtTe, String svcEndTe, String satSrtTe, String satEndTe, String hldSrtTe,
			String hldEndTe) {
		super();
		this.mgntNum = mgntNum;
		this.pkNam = pkNam;
		this.addr = addr;
		this.pkCnt = pkCnt;
		this.tponNum = tponNum;
		this.tenMin = tenMin;
		this.ftDay = ftDay;
		this.ftMon = ftMon;
		this.svcSrtTe = svcSrtTe;
		this.svcEndTe = svcEndTe;
		this.satSrtTe = satSrtTe;
		this.satEndTe = satEndTe;
		this.hldSrtTe = hldSrtTe;
		this.hldEndTe = hldEndTe;
	}

	@Override
	public String toString() {
		return "Park [mgntNum=" + mgntNum + ", pkNam=" + pkNam + ", addr=" + addr + ", pkCnt=" + pkCnt + ", tponNum="
				+ tponNum + ", tenMin=" + tenMin + ", ftDay=" + ftDay + ", ftMon=" + ftMon + ", svcSrtTe=" + svcSrtTe
				+ ", svcEndTe=" + svcEndTe + ", satSrtTe=" + satSrtTe + ", satEndTe=" + satEndTe + ", hldSrtTe="
				+ hldSrtTe + ", hldEndTe=" + hldEndTe + "]";
	}
	
	public String toStringForConsole() {
		return "no:" + mgntNum + ", 주차장명:" + pkNam + ", 주소:" + addr	+ ", 주차구획수:" + pkCnt
				+ ", 전화번호:" + tponNum + ", 주차기본요금:" + tenMin ;
			
	}

	public int getMgntNum() {
		return mgntNum;
	}

	public void setMgntNum(int mgntNum) {
		this.mgntNum = mgntNum;
	}

	public String getPkNam() {
		return pkNam;
	}

	public void setPkNam(String pkNam) {
		this.pkNam = pkNam;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPkCnt() {
		return pkCnt;
	}

	public void setPkCnt(String pkCnt) {
		this.pkCnt = pkCnt;
	}

	public String getTponNum() {
		return tponNum;
	}

	public void setTponNum(String tponNum) {
		this.tponNum = tponNum;
	}

	public String getTenMin() {
		return tenMin;
	}

	public void setTenMin(String tenMin) {
		this.tenMin = tenMin;
	}

	public String getFtDay() {
		return ftDay;
	}

	public void setFtDay(String ftDay) {
		this.ftDay = ftDay;
	}

	public String getFtMon() {
		return ftMon;
	}

	public void setFtMon(String ftMon) {
		this.ftMon = ftMon;
	}

	public String getSvcSrtTe() {
		return svcSrtTe;
	}

	public void setSvcSrtTe(String svcSrtTe) {
		this.svcSrtTe = svcSrtTe;
	}

	public String getSvcEndTe() {
		return svcEndTe;
	}

	public void setSvcEndTe(String svcEndTe) {
		this.svcEndTe = svcEndTe;
	}

	public String getSatSrtTe() {
		return satSrtTe;
	}

	public void setSatSrtTe(String satSrtTe) {
		this.satSrtTe = satSrtTe;
	}

	public String getSatEndTe() {
		return satEndTe;
	}

	public void setSatEndTe(String satEndTe) {
		this.satEndTe = satEndTe;
	}

	public String getHldSrtTe() {
		return hldSrtTe;
	}

	public void setHldSrtTe(String hldSrtTe) {
		this.hldSrtTe = hldSrtTe;
	}

	public String getHldEndTe() {
		return hldEndTe;
	}

	public void setHldEndTe(String hldEndTe) {
		this.hldEndTe = hldEndTe;
	}
	
	
}
