package seoul.legacy.model.service;

import static seoul.legacy.common.JDBCTemplate.commit;
import static seoul.legacy.common.JDBCTemplate.openConnection;
import static seoul.legacy.common.JDBCTemplate.rollback;

import java.sql.Connection;

import seoul.legacy.model.dao.UserDAO;
import seoul.legacy.model.vo.User;

public class UserService {

	private Connection conn = null;
	private UserDAO dao = new UserDAO();

	public UserService() {
		conn = openConnection();
	}

	public User selectById(String id) {
		return dao.selectOneById(conn, id);
	}

	public int insert(User user) {
		int result = dao.insert(conn, user);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
}
