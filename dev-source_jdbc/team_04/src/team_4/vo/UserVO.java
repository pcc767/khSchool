package vo;

public class UserVO {
	private int userNum;
	private String userId;
	private String userPw;
	private String userName;
	
	public UserVO() {
		super();
	}

	public UserVO(int userNum, String userId, String userPw, String userName) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}

	public String toString() {
		return "안녕하세요. " + userName + "회원님, 환영합니다.";
	}


	public int getUserNum() {
		return userNum;
	}


	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
}
