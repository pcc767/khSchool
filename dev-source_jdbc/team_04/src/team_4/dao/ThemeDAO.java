package dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vo.ThemeVO;

public class ThemeDAO {
	private String query;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<ThemeVO> selectAll(Connection con) {
		
		List<ThemeVO> list = new ArrayList<>();
		
		try {
			query = "SELECT * FROM TBL_THEME";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int count = 1;
				int ucSeq = rs.getInt(count++);
				String mainTitle = rs.getString(count++);
				String gugunNm = rs.getString(count++);
				String cate2Nm = rs.getString(count++);
				String lat = rs.getString(count++);
				String lng = rs.getString(count++);
				String place = rs.getString(count++);
				String title = rs.getString(count++);
				String subTitle = rs.getString(count++);
				String mainPlace = rs.getString(count++);
				String addr1 = rs.getString(count++);
				String addr2 = rs.getString(count++);
				String cntctTel = rs.getString(count++);
				String usageDay = rs.getString(count++);
				String hldyInfo = rs.getString(count++);
				String usageDayWeekAndTime = rs.getString(count++);
				String usageAmount = rs.getString(count++);
				String middleSizeRm1 = rs.getString(count++);
				String homepageUrl = rs.getString(count++);
				String trfcInfo = rs.getString(count++);
				String mainImgNormal = rs.getString(count++);
				String mainImgThumb = rs.getString(count++);
				
				ThemeVO info = new ThemeVO(ucSeq, mainTitle, gugunNm, cate2Nm, lat, lng, place, title, subTitle, mainPlace, addr1, 
						addr2, cntctTel, usageDay, hldyInfo, usageDayWeekAndTime, usageAmount, middleSizeRm1, homepageUrl, trfcInfo, mainImgNormal, mainImgThumb);
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
	
	public List<ThemeVO> searchByCategory(Connection con, String category) {
		
		List<ThemeVO> list = new ArrayList<>();
		
		try {
			query = "SELECT * FROM TBL_THEME WHERE THEME_CATE LIKE ?"; 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + category + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int count = 1;
				int ucSeq = rs.getInt(count++);
				String mainTitle = rs.getString(count++);
				String gugunNm = rs.getString(count++);
				String cate2Nm = rs.getString(count++);
				String lat = rs.getString(count++);
				String lng = rs.getString(count++);
				String place = rs.getString(count++);
				String title = rs.getString(count++);
				String subTitle = rs.getString(count++);
				String mainPlace = rs.getString(count++);
				String addr1 = rs.getString(count++);
				String addr2 = rs.getString(count++);
				String cntctTel = rs.getString(count++);
				String usageDay = rs.getString(count++);
				String hldyInfo = rs.getString(count++);
				String usageDayWeekAndTime = rs.getString(count++);
				String usageAmount = rs.getString(count++);
				String middleSizeRm1 = rs.getString(count++);
				String homepageUrl = rs.getString(count++);
				String trfcInfo = rs.getString(count++);
				String mainImgNormal = rs.getString(count++);
				String mainImgThumb = rs.getString(count++);
				
				ThemeVO info = new ThemeVO(ucSeq, mainTitle, gugunNm, cate2Nm, lat, lng, place, title, subTitle, mainPlace, addr1, 
						addr2, cntctTel, usageDay, hldyInfo, usageDayWeekAndTime, usageAmount, middleSizeRm1, homepageUrl, trfcInfo, mainImgNormal, mainImgThumb);
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
	
	public List<ThemeVO> searchByKeyword(Connection con, String keyword) {
		
		List<ThemeVO> list = new ArrayList<>();
		
		try {
			query = "SELECT * FROM TBL_THEME WHERE THEME_MAIN_TITLE LIKE ?"; 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int count = 1;
				int ucSeq = rs.getInt(count++);
				String mainTitle = rs.getString(count++);
				String gugunNm = rs.getString(count++);
				String cate2Nm = rs.getString(count++);
				String lat = rs.getString(count++);
				String lng = rs.getString(count++);
				String place = rs.getString(count++);
				String title = rs.getString(count++);
				String subTitle = rs.getString(count++);
				String mainPlace = rs.getString(count++);
				String addr1 = rs.getString(count++);
				String addr2 = rs.getString(count++);
				String cntctTel = rs.getString(count++);
				String usageDay = rs.getString(count++);
				String hldyInfo = rs.getString(count++);
				String usageDayWeekAndTime = rs.getString(count++);
				String usageAmount = rs.getString(count++);
				String middleSizeRm1 = rs.getString(count++);
				String homepageUrl = rs.getString(count++);
				String trfcInfo = rs.getString(count++);
				String mainImgNormal = rs.getString(count++);
				String mainImgThumb = rs.getString(count++);
				
				ThemeVO info = new ThemeVO(ucSeq, mainTitle, gugunNm, cate2Nm, lat, lng, place, title, subTitle, mainPlace, addr1, 
						addr2, cntctTel, usageDay, hldyInfo, usageDayWeekAndTime, usageAmount, middleSizeRm1, homepageUrl, trfcInfo, mainImgNormal, mainImgThumb);
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
	
	public List<ThemeVO> searchByGugun(Connection con, String gugun) {
		
		List<ThemeVO> list = new ArrayList<>();
		
		try {
			query = "SELECT * FROM TBL_THEME WHERE THEME_GUGUN LIKE ?"; 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + gugun + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int count = 1;
				int ucSeq = rs.getInt(count++);
				String mainTitle = rs.getString(count++);
				String gugunNm = rs.getString(count++);
				String cate2Nm = rs.getString(count++);
				String lat = rs.getString(count++);
				String lng = rs.getString(count++);
				String place = rs.getString(count++);
				String title = rs.getString(count++);
				String subTitle = rs.getString(count++);
				String mainPlace = rs.getString(count++);
				String addr1 = rs.getString(count++);
				String addr2 = rs.getString(count++);
				String cntctTel = rs.getString(count++);
				String usageDay = rs.getString(count++);
				String hldyInfo = rs.getString(count++);
				String usageDayWeekAndTime = rs.getString(count++);
				String usageAmount = rs.getString(count++);
				String middleSizeRm1 = rs.getString(count++);
				String homepageUrl = rs.getString(count++);
				String trfcInfo = rs.getString(count++);
				String mainImgNormal = rs.getString(count++);
				String mainImgThumb = rs.getString(count++);
				
				ThemeVO info = new ThemeVO(ucSeq, mainTitle, gugunNm, cate2Nm, lat, lng, place, title, subTitle, mainPlace, addr1, 
						addr2, cntctTel, usageDay, hldyInfo, usageDayWeekAndTime, usageAmount, middleSizeRm1, homepageUrl, trfcInfo, mainImgNormal, mainImgThumb);
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
	
	public int insert(Connection con, ThemeVO theme) {
		
		try {
			query = "INSERT INTO TBL_THEME VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			int count = 1;
			pstmt.setInt(count++, theme.getUcSeq());
			pstmt.setString(count++, theme.getMainTitle());
			pstmt.setString(count++, theme.getGugunNm());
			pstmt.setString(count++, theme.getCate2Nm());
			pstmt.setString(count++, theme.getLat());
			pstmt.setString(count++, theme.getLng());
			pstmt.setString(count++, theme.getPlace());
			pstmt.setString(count++, theme.getTitle());
			pstmt.setString(count++, theme.getSubTitle());
			pstmt.setString(count++, theme.getMainPlace());
			pstmt.setString(count++, theme.getAddr1());
			pstmt.setString(count++, theme.getAddr2());
			pstmt.setString(count++, theme.getCntctTel());
			pstmt.setString(count++, theme.getUsageDay());
			pstmt.setString(count++, theme.getHldyInfo());
			pstmt.setString(count++, theme.getUsageDayWeekAndTime());
			pstmt.setString(count++, theme.getUsageAmount());
			pstmt.setString(count++, theme.getMiddleSizeRm1());
			pstmt.setString(count++, theme.getHomepageUrl());
			pstmt.setString(count++, theme.getTrfcInfo());
			pstmt.setString(count++, theme.getMainImgNormal());
			pstmt.setString(count++, theme.getMainImgThumb());
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
		}
		return -1;
	}
}
