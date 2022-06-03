package com.boxoffice.controller;


import com.boxoffice.model.service.UserService;
import com.boxoffice.model.vo.User;


public class UserController {
	private UserService userService = new UserService();
	private static User loginUser = null;
	
	public boolean login(String id, String pw) {
		User user = userService.selectByID(id);
		if(user == null) {
			return false;
		}
		
		if(user.getPassword().equals(pw) == true) {
			loginUser = user;
			return true;
		}else {
			return false;
		}
	}

	public static void logout() {
		loginUser = null;
	}
	
	public static User getLoginUser() {
		return loginUser;
	}
	
}
