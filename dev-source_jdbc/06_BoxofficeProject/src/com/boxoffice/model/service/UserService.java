package com.boxoffice.model.service;


import static com.boxoffice.common.JDBCTemplate.commit;
import static com.boxoffice.common.JDBCTemplate.openConnection;
import static com.boxoffice.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.boxoffice.model.dao.UserDao;
import com.boxoffice.model.vo.User;

public class UserService {
	private UserDao userDao = new UserDao();
	private Connection conn = null;
	
	public UserService() {
		conn = openConnection();
	}

	public User selectOne(int uNo) {
		return userDao.selectOne(conn, uNo);
	}
	
	public User selectByID(String id) {
		return userDao.selectByID(conn, id);
	}
	
	public int insert(User user) {
		int result = userDao.insert(conn, user);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}


}
