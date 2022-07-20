package dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vo.WalkVO;

public class WalkDAO {
	private String query;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<WalkVO> selectAll(Connection con) {
		List<WalkVO> list = new ArrayList<>();
		
		try {
			query = "SELECT * FROM TBL_WALK";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int count = 1;
				int ucSeq = rs.getInt(count++);
				String mainTitle = rs.getString(count++);
				String cate2Nm = rs.getString(count++);
				String lat = rs.getString(count++);
				String lng = rs.getString(count++);
				String place = rs.getString(count++);
				String title = rs.getString(count++);
				String subTitle = rs.getString(count++);
				String trfcInfo = rs.getString(count++);
				String middleSizeRm1 = rs.getString(count++);
				String mainImgNormal = rs.getString(count++);
				String mainImgThumb = rs.getString(count++);
				
				WalkVO info = new WalkVO(ucSeq, mainTitle, cate2Nm, lat, lng, place, 
						title, subTitle, trfcInfo, middleSizeRm1, mainImgNormal, mainImgThumb);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public List<WalkVO> searchByCtegory(Connection con, String category) {
		
		List<WalkVO> list = new ArrayList<>();
		
		try {
			query = "SELECT * FROM TBL_WALK WHERE WALK_CATE LIKE ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + category + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int count = 1;
				int ucSeq = rs.getInt(count++);
				String mainTitle = rs.getString(count++);
				String cate2Nm = rs.getString(count++);
				String lat = rs.getString(count++);
				String lng = rs.getString(count++);
				String place = rs.getString(count++);
				String title = rs.getString(count++);
				String subTitle = rs.getString(count++);
				String trfcInfo = rs.getString(count++);
				String middleSizeRm1 = rs.getString(count++);
				String mainImgNormal = rs.getString(count++);
				String mainImgThumb = rs.getString(count++);
				
				WalkVO info = new WalkVO(ucSeq, mainTitle, cate2Nm, lat, lng, place, 
						title, subTitle, trfcInfo, middleSizeRm1, mainImgNormal, mainImgThumb);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public List<WalkVO> searchByKeyword(Connection con, String keyword) {
		
		List<WalkVO> list = new ArrayList<>();
		
		try {
			query = "SELECT * FROM TBL_WALK WHERE WALK_MAIN_TITLE LIKE ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int count = 1;
				int ucSeq = rs.getInt(count++);
				String mainTitle = rs.getString(count++);
				String cate2Nm = rs.getString(count++);
				String lat = rs.getString(count++);
				String lng = rs.getString(count++);
				String place = rs.getString(count++);
				String title = rs.getString(count++);
				String subTitle = rs.getString(count++);
				String trfcInfo = rs.getString(count++);
				String middleSizeRm1 = rs.getString(count++);
				String mainImgNormal = rs.getString(count++);
				String mainImgThumb = rs.getString(count++);
				
				WalkVO info = new WalkVO(ucSeq, mainTitle, cate2Nm, lat, lng, place, 
						title, subTitle, trfcInfo, middleSizeRm1, mainImgNormal, mainImgThumb);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public int insert(Connection con, WalkVO walk) {
		
		query = "INSERT INTO TBL_WALK VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			
			int count = 1;
			
			pstmt.setInt(count++, walk.getUcSeq());
			pstmt.setString(count++, walk.getMainTitle());
			pstmt.setString(count++, walk.getCate2Nm());
			pstmt.setString(count++, walk.getLat());
			pstmt.setString(count++, walk.getLng());
			pstmt.setString(count++, walk.getPlace());
			pstmt.setString(count++, walk.getTitle());
			pstmt.setString(count++, walk.getSubTitle());
			pstmt.setString(count++, walk.getTrfcInfo());
			pstmt.setString(count++, walk.getMiddleSizeRm1());
			pstmt.setString(count++, walk.getMainImgNormal());
			pstmt.setString(count++, walk.getMainImgThumb());
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
		}
		return -1;
	}
}
