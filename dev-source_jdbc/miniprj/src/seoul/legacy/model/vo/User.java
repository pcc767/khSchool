package seoul.legacy.model.vo;

public class User {

	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userPhone;

	public User() {
		super();
	}

	public User(String userId, String userPw, String userName, String userEmail, String userPhone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}

	public User(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		return "아이디 : " + userId + "\n이름 : " + userName + "\nE-Mail : " + userEmail + "\n전화번호 : " + userPhone;
	} // 유저 데이타 조회

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
