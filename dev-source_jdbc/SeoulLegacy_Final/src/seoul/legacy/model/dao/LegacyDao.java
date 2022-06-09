package seoul.legacy.model.dao;

import static seoul.legacy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import seoul.legacy.model.vo.Legacy;

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
			pstmt.setInt(count++, legacy.getLegacy_no());
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
			pstmt.setString(count++, legacy.getLegacy_enrolldate());
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
	
	

	public List<Legacy> selectByLegacyName(Connection conn, String name) {
		List<Legacy> list = new ArrayList<>();

		try {
			String sql = "SELECT * FROM tbl_legacy WHERE legacy_name_kor LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				int count = 1;
				int legacy_no = rs.getInt(count++);          
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
				String legacy_enrolldate = rs.getString(count++);
				String legacy_longitude = rs.getString(count++);   
				String legacy_latitude = rs.getString(count++);     
				
				Legacy info = new Legacy(legacy_no, legacy_design_no, legacy_trans_no, legacy_category_name,
						legacy_name_kor, legacy_name_chi, legacy_area, legacy_address,
						legacy_admin, legacy_type, legacy_type2, legacy_type3, legacy_type4,
						legacy_quantity, legacy_era, legacy_owner, legacy_content,
						legacy_enrolldate, legacy_longitude, legacy_latitude);
				list.add(info);
			}
			
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public List<Legacy> selectByCategory(Connection conn, String category) {
		List<Legacy> list = new ArrayList<Legacy>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM TBL_LEGACY WHERE LEGACY_CATEGORY_NAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int count = 1;
				
				int legacy_no = rs.getInt(count++);           
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
				String legacy_enrolldate = rs.getString(count++);     
				String legacy_longitude = rs.getString(count++);    
				String legacy_latitude = rs.getString(count++);     
				
				Legacy info = new Legacy(legacy_no, legacy_design_no, legacy_trans_no, legacy_category_name,
						legacy_name_kor, legacy_name_chi, legacy_area, legacy_address,
						legacy_admin, legacy_type, legacy_type2, legacy_type3, legacy_type4,
						legacy_quantity, legacy_era, legacy_owner, legacy_content,
						legacy_enrolldate, legacy_longitude, legacy_latitude);
				list.add(info);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			close(conn);
			close(rs);
		}
		return list;
	}
	
	
	
	public List<Legacy> selectByLegacyArea(Connection conn, String area) {
		List<Legacy> temp = new ArrayList<Legacy>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			String sql = "select * from tbl_legacy where legacy_area = ?";
			String sql = "SELECT * FROM TBL_LEGACY WHERE LEGACY_AREA LIKE ?";

			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, area);
			pstmt.setString(1, "%" + area + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				
				int legacy_no = rs.getInt(count++);           
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
				String legacy_enrolldate = rs.getString(count++);     
				String legacy_longitude = rs.getString(count++);    
				String legacy_latitude = rs.getString(count++);     
				
				temp.add(new Legacy(legacy_no, legacy_design_no, legacy_trans_no, legacy_category_name,
						legacy_name_kor, legacy_name_chi, legacy_area, legacy_address,
						legacy_admin, legacy_type, legacy_type2, legacy_type3, legacy_type4,
						legacy_quantity, legacy_era, legacy_owner, legacy_content,
						legacy_enrolldate, legacy_longitude, legacy_latitude));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
//		return null;
		return temp;
	}
	
	
	
	public List<Legacy> selectByEra(Connection conn, String era) {
		List<Legacy> list = new ArrayList<>();

		try {
			String sql = "SELECT * FROM TBL_LEGACY WHERE LEGACY_ERA LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + era + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				int count = 1;
				int legacy_no = rs.getInt(count++);          
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
				String legacy_enrolldate = rs.getString(count++);
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


	
	public List<Legacy> selectTopTen(Connection conn) {
		List<Legacy> temp = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from "
					+ "(SELECT l.legacy_no, l.legacy_design_no, l.legacy_trans_no, l.legacy_category_name, l.legacy_name_kor, "
					+ "l.legacy_name_chi, l.legacy_area, l.legacy_address, l.legacy_admin, l.legacy_type, l.legacy_type2, l.legacy_type3, l.legacy_type4, " 
					+ "l.legacy_quantity, l.legacy_era, l.legacy_owner, l.legacy_content, l.legacy_enrolldate, l.legacy_longitude, l.legacy_latitude, "
					+ "nvl(cz.zzim_count,0), rank() over(order by nvl(cz.zzim_count,0) desc) rank " 
					+ "FROM (SELECT legacy_no, COUNT(*) zzim_count FROM tbl_zzim GROUP BY legacy_no) cz "
					+ "RIGHT JOIN tbl_legacy l ON l.legacy_no = cz.legacy_no) where rank <=10";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int legacyNo = rs.getInt(count++);
				String legacyDNo = rs.getString(count++);
				String legacyTNo = rs.getString(count++);
				String legacyCName = rs.getString(count++);
				String legacyNKor = rs.getString(count++);
				String legacyNChi = rs.getString(count++);
				String legacyArea = rs.getString(count++);
				String legacyAddress = rs.getString(count++);
				String legacyAdmin = rs.getString(count++);
				String legacyType = rs.getString(count++);
				String legacyType2 = rs.getString(count++);
				String legacyType3 = rs.getString(count++);
				String legacyType4 = rs.getString(count++);
				String legacyQuantity = rs.getString(count++);
				String legacyEra = rs.getString(count++);
				String legacyOwner = rs.getString(count++);
				String legacyContent = rs.getString(count++);
				String legacyEnrolldate = rs.getString(count++);
				String legacyLongitude = rs.getString(count++);
				String legacyLatitude = rs.getString(count++);

				temp.add(new Legacy(legacyNo, legacyDNo, legacyTNo, legacyCName, legacyNKor, legacyNChi, legacyArea,
						legacyAddress, legacyAdmin, legacyType, legacyType2, legacyType3, legacyType4, legacyQuantity,
						legacyEra, legacyOwner, legacyContent, legacyEnrolldate, legacyLongitude, legacyLatitude));
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
}
