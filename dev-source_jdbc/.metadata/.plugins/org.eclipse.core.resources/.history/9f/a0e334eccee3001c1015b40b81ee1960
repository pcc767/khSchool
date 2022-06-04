package com.teamtest.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teamtest.common.JDBCTemplate;
import com.teamtest.model.vo.Legacy;

public class LegacyDao {
	
	public int insert(Connection conn, Legacy legacy) {
		try {
			String sql = "INSERT INTO "	// 공백주의
					+ "TBL_LEGACY(LEGACY_NO, LEGACY_DESIGN_NO, LEGACY_TRANS_NO, LEGACY_CATEGORY_NAME, LEGACY_NAME_KOR, LEGACY_NAME_CHI, "
					+ "			LEGACY_AREA, LEGACY_ADDRESS, LEGACY_ADMIN, LEGACY_TYPE, LEGACY_TYPE2, LEGACY_TYPE3, "
					+ "			LEGACY_TYPE4, LEGACY_QUANTITY, LEGACY_ERA, LEGACY_OWNER, LEGACY_CONTENT, LEGACY_ENROLLDATE, "
					+ "			LEGACY_LONGITUDE, LEGACY_LATITUDE) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "		?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int count = 1;
			pstmt.setString(count++, legacy.getLegacy_no());
			pstmt.setString(count++, legacy.getLegacy_design_no());
			pstmt.setString(count++, legacy.getLegacy_trans_no());
			pstmt.setString(count++, legacy.getLegacy_category_name());
			pstmt.setString(count++, legacy.getLegacy_name_kor());
			pstmt.setString(count++, legacy.getLegacy_name_chi());
			pstmt.setString(count++, legacy.getLegacy_area());
			pstmt.setString(count++, legacy.getLegacy_address());
			pstmt.setString(count++, legacy.getLegacy_admin());
			pstmt.setString(count++, legacy.getLegacy_type());
			pstmt.setString(count++, legacy.getLegacy_type2());
			pstmt.setString(count++, legacy.getLegacy_type3());
			pstmt.setString(count++, legacy.getLegacy_type4());
			pstmt.setString(count++, legacy.getLegacy_quantity());
			pstmt.setString(count++, legacy.getLegacy_era());
			pstmt.setString(count++, legacy.getLegacy_owner());
			pstmt.setString(count++, legacy.getLegacy_content());
			pstmt.setDate(count++, (java.sql.Date) legacy.getLegacy_enrolldate());
			pstmt.setString(count++, legacy.getLegacy_longitude());
			pstmt.setString(count++, legacy.getLegacy_latitude());
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void main(String[] args) throws SQLException {	//<<<< for test
		Connection conn = JDBCTemplate.openConnection();
		Legacy legacy = new Legacy("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", null, "19", "20");
		int result = new LegacyDao().insert(conn, legacy);
		conn.commit();
		System.out.println(result);	
		
	}

}
