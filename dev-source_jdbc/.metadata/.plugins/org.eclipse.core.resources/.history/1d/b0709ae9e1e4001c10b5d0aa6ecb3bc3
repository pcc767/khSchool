package com.teamtest.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.teamtest.model.vo.Palace;

public class PalaceDao {
	
	public int insert(Connection conn, Palace palace) {
		try {
			String sql = "INSERT INTO TBL_PALACE_FACILITY(P_FACILITY_NO, PALACE_NO, P_FACILITY_DETAIL_NO, "
					   + "P_FACILITY_NAME_KOR, P_FACILITY_NAME_ENG, P_FACILITY_NAME_JPA, P_FACILITY_NAME_CHI, "
					   + "P_FACILITY_CONTENT, P_FACILITY_CONTENT_ENG, P_FACILITY_CONTENT_JPA, P_FACILITY_CONTENT_CHI) "
					   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int count = 1;
			pstmt.setInt(count++, palace.getP_facility_no());
			pstmt.setInt(count++, palace.getPalace_no());
			pstmt.setInt(count++, palace.getP_facility_detail_no());
			pstmt.setString(count++, palace.getP_facility_name_kor());
			pstmt.setString(count++, palace.getP_facility_name_eng());
			pstmt.setString(count++, palace.getP_facility_name_jpa());
			pstmt.setString(count++, palace.getP_facility_name_chi());
			pstmt.setString(count++, palace.getP_facility_content());
			pstmt.setString(count++, palace.getP_facility_content_eng());
			pstmt.setString(count++, palace.getP_facility_content_jpa());
			pstmt.setString(count++, palace.getP_facility_content_chi());
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
