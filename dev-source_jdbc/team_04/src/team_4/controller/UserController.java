package controller;

import service.UserService;
import vo.UserVO;

public class UserController {
	private UserService userService = new UserService();
	private static UserVO loginUser = null;
	
	public boolean login(String id, String pw) {
		UserVO user = userService.selectByID(id);
		if(user.getUserPw() == null) {
			return false;
		}
		
		if(user.getUserPw().equals(pw)) {
			loginUser = user;
			return true;
		}else {
			return false;
		}
	}

	public static void logout() {
		loginUser = null;
	}
	
	public static UserVO getLoginUser() {
		return loginUser;
	}
}
