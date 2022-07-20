package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.UserVO;

public class UserDao {

	public UserVO selectByID(Connection con, String userId) {
		try {
			String sql = "SELECT * FROM TBL_USER WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, userId);
			
			ResultSet rs = pstmt.executeQuery(); 
			UserVO user = new UserVO();
			if (rs.next()) {
				int uNo 	= 		rs.getInt(1);
				userId 			 = 	rs.getString(2);
				String userPw = rs.getString(3);
				String userName 	= rs.getString(4);
				
				user = new UserVO(uNo, userId, userPw, userName);
			}
			
			pstmt.close();
			rs.close();
			return user;
		} catch (Exception e) {
		}
		return null;
	}
}