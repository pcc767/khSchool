package com.teamtest.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

	public List<Legacy> selectByLegacyName(Connection conn, String name) {
		List<Legacy> list = new ArrayList<Legacy>();
		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_name_kor LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int count = 1;
				String legacy_name_kor = rs.getString(count++);
				String legacy_category_name = rs.getString(count++);
				String legacy_area = rs.getString(count++);
				
				Legacy legacy = new Legacy(legacy_name_kor, legacy_category_name, legacy_area);
				list.add(legacy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<Legacy> selectByCategoryName(Connection conn, String name) {
		List<Legacy> list = new ArrayList<Legacy>();
		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_category_name LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int count = 1;
				String legacy_name_kor = rs.getString(count++);
				String legacy_category_name = rs.getString(count++);
				String legacy_area = rs.getString(count++);
				
				Legacy legacy = new Legacy(legacy_name_kor, legacy_category_name, legacy_area);
				list.add(legacy);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<Legacy> selectByArea(Connection conn, String area) {
		List<Legacy> list = new ArrayList<Legacy>();
		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_area LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ area +"%");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int count = 1;
				String legacy_name_kor = rs.getString(count++);
				String legacy_category_name = rs.getString(count++);
				String legacy_area = rs.getString(count++);
				
				Legacy legacy = new Legacy(legacy_name_kor, legacy_category_name, legacy_area);
				list.add(legacy);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<Legacy> selectByEra(Connection conn, String era) {
		List<Legacy> list = new ArrayList<Legacy>();
		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_era LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ era +"%");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int count = 1;
				String legacy_name_kor = rs.getString(count++);
				String legacy_category_name = rs.getString(count++);
				String legacy_area = rs.getString(count++);
				
				Legacy legacy = new Legacy(legacy_name_kor, legacy_category_name, legacy_area);
				list.add(legacy);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public Legacy selectOne(Connection conn, String legency_no) {
		return null;
	}
	
	// Detail-----------------------------------------------------------------

	public List<Legacy> selectByLegacyNameDetail(Connection conn, String name) {
		List<Legacy> list = new ArrayList<>();

		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_name_kor LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				int count = 1;
				String legacy_no = rs.getString(count++);          
				String legacy_design_no = rs.getString(count++);    
				String legacy_trans_no = rs.getString(count++);
				String legacy_category_name = rs.getString(count++);
				String legacy_name_kor = rs.getString(count++); 
				String legacy_name_chi = rs.getString(count++);     
				String legacy_area = rs.getString(count++);         
				String legacy_address = rs.getString(count++);      
				String legacy_admin = rs.getString(count++);        
				String legacy_type = rs.getString(count++);         
				String legacy_type2 = rs.getString(count++);        
				String legacy_type3 = rs.getString(count++);        
				String legacy_type4 = rs.getString(count++);       
				String legacy_quantity = rs.getString(count++);
				String legacy_era = rs.getString(count++);
				String legacy_owner = rs.getString(count++);
				String legacy_content = rs.getString(count++);
				Date legacy_enrolldate = rs.getDate(count++);
				String legacy_longitude = rs.getString(count++);   
				String legacy_latitude = rs.getString(count++);     
				
				Legacy legacy = new Legacy(legacy_no, legacy_design_no, legacy_trans_no, legacy_category_name, 
						legacy_name_kor, legacy_name_chi, legacy_area, legacy_address, legacy_admin, legacy_type, 
						legacy_type2, legacy_type3, legacy_type4, legacy_quantity, legacy_era, legacy_owner, 
						legacy_content, legacy_enrolldate, legacy_longitude, legacy_latitude);
			
				list.add(legacy);
			}
			
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<Legacy> selectByCategoryNameDetail(Connection conn, String name) {
		List<Legacy> list = new ArrayList<>();

		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_category_name LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				int count = 1;
				String legacy_no = rs.getString(count++);          
				String legacy_design_no = rs.getString(count++);    
				String legacy_trans_no = rs.getString(count++);
				String legacy_category_name = rs.getString(count++);
				String legacy_name_kor = rs.getString(count++); 
				String legacy_name_chi = rs.getString(count++);     
				String legacy_area = rs.getString(count++);         
				String legacy_address = rs.getString(count++);      
				String legacy_admin = rs.getString(count++);        
				String legacy_type = rs.getString(count++);         
				String legacy_type2 = rs.getString(count++);        
				String legacy_type3 = rs.getString(count++);        
				String legacy_type4 = rs.getString(count++);       
				String legacy_quantity = rs.getString(count++);
				String legacy_era = rs.getString(count++);
				String legacy_owner = rs.getString(count++);
				String legacy_content = rs.getString(count++);
				Date legacy_enrolldate = rs.getDate(count++);
				String legacy_longitude = rs.getString(count++);   
				String legacy_latitude = rs.getString(count++);     
				
				Legacy legacy = new Legacy(legacy_no, legacy_design_no, legacy_trans_no, legacy_category_name, 
						legacy_name_kor, legacy_name_chi, legacy_area, legacy_address, legacy_admin, legacy_type, 
						legacy_type2, legacy_type3, legacy_type4, legacy_quantity, legacy_era, legacy_owner, 
						legacy_content, legacy_enrolldate, legacy_longitude, legacy_latitude);
			
				list.add(legacy);
			}
			
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Legacy> selectByAreaDetail(Connection conn, String area) {
		List<Legacy> list = new ArrayList<>();

		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_area LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + area + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				int count = 1;
				String legacy_no = rs.getString(count++);          
				String legacy_design_no = rs.getString(count++);    
				String legacy_trans_no = rs.getString(count++);
				String legacy_category_name = rs.getString(count++);
				String legacy_name_kor = rs.getString(count++); 
				String legacy_name_chi = rs.getString(count++);     
				String legacy_area = rs.getString(count++);         
				String legacy_address = rs.getString(count++);      
				String legacy_admin = rs.getString(count++);        
				String legacy_type = rs.getString(count++);         
				String legacy_type2 = rs.getString(count++);        
				String legacy_type3 = rs.getString(count++);        
				String legacy_type4 = rs.getString(count++);       
				String legacy_quantity = rs.getString(count++);
				String legacy_era = rs.getString(count++);
				String legacy_owner = rs.getString(count++);
				String legacy_content = rs.getString(count++);
				Date legacy_enrolldate = rs.getDate(count++);
				String legacy_longitude = rs.getString(count++);   
				String legacy_latitude = rs.getString(count++);     
				
				Legacy legacy = new Legacy(legacy_no, legacy_design_no, legacy_trans_no, legacy_category_name, 
						legacy_name_kor, legacy_name_chi, legacy_area, legacy_address, legacy_admin, legacy_type, 
						legacy_type2, legacy_type3, legacy_type4, legacy_quantity, legacy_era, legacy_owner, 
						legacy_content, legacy_enrolldate, legacy_longitude, legacy_latitude);
			
				list.add(legacy);
			}
			
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Legacy> selectByEraDetail(Connection conn, String era) {
		List<Legacy> list = new ArrayList<>();

		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_era LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + era + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				int count = 1;
				String legacy_no = rs.getString(count++);          
				String legacy_design_no = rs.getString(count++);    
				String legacy_trans_no = rs.getString(count++);
				String legacy_category_name = rs.getString(count++);
				String legacy_name_kor = rs.getString(count++); 
				String legacy_name_chi = rs.getString(count++);     
				String legacy_area = rs.getString(count++);         
				String legacy_address = rs.getString(count++);      
				String legacy_admin = rs.getString(count++);        
				String legacy_type = rs.getString(count++);         
				String legacy_type2 = rs.getString(count++);        
				String legacy_type3 = rs.getString(count++);        
				String legacy_type4 = rs.getString(count++);       
				String legacy_quantity = rs.getString(count++);
				String legacy_era = rs.getString(count++);
				String legacy_owner = rs.getString(count++);
				String legacy_content = rs.getString(count++);
				Date legacy_enrolldate = rs.getDate(count++);
				String legacy_longitude = rs.getString(count++);   
				String legacy_latitude = rs.getString(count++);     
				
				Legacy legacy = new Legacy(legacy_no, legacy_design_no, legacy_trans_no, legacy_category_name, 
						legacy_name_kor, legacy_name_chi, legacy_area, legacy_address, legacy_admin, legacy_type, 
						legacy_type2, legacy_type3, legacy_type4, legacy_quantity, legacy_era, legacy_owner, 
						legacy_content, legacy_enrolldate, legacy_longitude, legacy_latitude);
			
				list.add(legacy);
			}
			
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
