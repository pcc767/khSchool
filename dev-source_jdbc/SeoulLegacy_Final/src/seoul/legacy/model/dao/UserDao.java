package seoul.legacy.model.dao;

import static seoul.legacy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import seoul.legacy.common.JDBCTemplate;
import seoul.legacy.model.vo.User;


public class UserDao {

	public User selectOneById(Connection conn, String id) {

		try {
			String sql = "select user_id, user_pw, user_name, user_email, user_phone from tbl_user where user_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			rs.next();
			String userId = rs.getString(1);
			String userPw = rs.getString(2);
			String userName = rs.getString(3);
			String userEmail = rs.getString(4);
			String userPhone = rs.getString(5);

			User infoUser = new User(userId, userPw, userName, userEmail, userPhone);
			
			close(pstmt);
			close(rs);
			return infoUser;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insert(Connection conn, User user) {

		try {
			String sql = "insert into tbl_user (user_id, user_pw, user_name, user_email, user_phone) values(?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserPhone());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Connection conn = JDBCTemplate.openConnection();
		User user = new UserDao().selectOneById(conn, "test1");
		System.out.println(user);
	}
	

}
