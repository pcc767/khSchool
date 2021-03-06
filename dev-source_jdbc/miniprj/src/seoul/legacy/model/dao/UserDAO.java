package seoul.legacy.model.dao;

import static seoul.legacy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import seoul.legacy.model.vo.User;


public class UserDAO {

	public User selectOneById(Connection conn, String id) {

		User temp = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select user_id, user_pw, user_name, user_email, user_phone from tbl_user where user_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String userId = rs.getString("user_id");
				String userPw = rs.getString("user_pw");
				String userName = rs.getString("user_name");
				String userEmail = rs.getString("user_email");
				String userPhone = rs.getString("user_phone");

				temp = new User(userId, userPw, userName, userEmail, userPhone);
			}
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
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
}
