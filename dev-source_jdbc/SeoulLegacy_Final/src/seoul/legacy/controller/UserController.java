package seoul.legacy.controller;

import seoul.legacy.model.service.UserService;
import seoul.legacy.model.vo.User;

public class UserController {
	
	static {
		User loginUser = null;
	}
	
	private UserService us = new UserService();
	private static User loginUser = null;
	
	public boolean login(String id, String pw) {
		User user = us.selectById(id);
		if(user == null) {
			return false;
		}
		
		if(user.getUserId().equals(id) && user.getUserPw().equals(pw)) {
			loginUser = user;
			return true;
		}else {
			return false;
		}
	}
	
	public void logout() {
		loginUser = null;
	}
	
	public User selectById(String userId) {
		return us.selectById(userId);
	}

	public static User getLoginUser() {
		return loginUser;
	}

	public int insertUser(User user) {
		return us.insert(user);
	}

	

}
