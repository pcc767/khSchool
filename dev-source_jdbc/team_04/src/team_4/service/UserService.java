package service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import dao.UserDao;
import vo.UserVO;

public class UserService {
	private UserDao userDao = new UserDao();
	private Connection con = connect();
	
	public UserVO selectByID(String id) {
		return userDao.selectByID(con, id);
	}
}
