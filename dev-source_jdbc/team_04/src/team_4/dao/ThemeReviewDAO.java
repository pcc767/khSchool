package dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import vo.ThemeReviewVO;
import vo.ThemeVO;

public class ThemeReviewDAO {
	private String query;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<ThemeReviewVO> selectAll(Connection con) {

		List<ThemeReviewVO> list = new ArrayList<>();

		try {
			query = "SELECT R.THEME_REV_NUM, U.USER_NUM, T.THEME_MAIN_TITLE, R.THEME_REV_TITLE, R.THEME_REV_CONTENT, R.THEME_REV_REPORTING_DATE \r\n"
					+ "FROM TBL_THEME_REVIEW R\r\n"
					+ "JOIN TBL_THEME T ON R.THEME_NUM = T.THEME_NUM\r\n"
					+ "JOIN TBL_USER U ON R.USER_NUM = U.USER_NUM"; 
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int tRevNum = rs.getInt("THEME_REV_NUM");
				int uNum = rs.getInt("USER_NUM");
				String tRevTitle = rs.getString("THEME_REV_TITLE");
				String tRevContent = rs.getString("THEME_REV_CONTENT");
				Date tRevCreateDate = new Date(rs.getTimestamp("THEME_REV_REPORTING_DATE").getTime());
				ThemeVO themeInfo = new ThemeVO();
				themeInfo.setMainTitle(rs.getString("THEME_MAIN_TITLE"));
				
				ThemeReviewVO rev = new ThemeReviewVO(tRevNum, uNum, themeInfo, tRevTitle, tRevContent, tRevCreateDate);
				list.add(rev);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public List<ThemeReviewVO> searchByUserNumber(Connection con, int uNum) {

		List<ThemeReviewVO> list = new ArrayList<>();

		try {
			query = "SELECT R.THEME_REV_NUM, U.USER_NUM, T.THEME_MAIN_TITLE, R.THEME_REV_TITLE, R.THEME_REV_CONTENT, R.THEME_REV_REPORTING_DATE \r\n"
					+ "FROM TBL_THEME_REVIEW R\r\n"
					+ "JOIN TBL_THEME T ON R.THEME_NUM = T.THEME_NUM\r\n"
					+ "JOIN TBL_USER U ON R.USER_NUM = U.USER_NUM\r\n"
					+ "WHERE R.USER_NUM = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, uNum);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int tRevNum = rs.getInt("THEME_REV_NUM");
				String tRevTitle = rs.getString("THEME_REV_TITLE");
				String tRevContent = rs.getString("THEME_REV_CONTENT");
				Date tRevCreateDate = new Date(rs.getTimestamp("THEME_REV_REPORTING_DATE").getTime());
				ThemeVO themeInfo = new ThemeVO();
				themeInfo.setMainTitle(rs.getString("THEME_MAIN_TITLE"));
				ThemeReviewVO rev = new ThemeReviewVO(tRevNum, uNum, themeInfo, tRevTitle, tRevContent, tRevCreateDate);
				list.add(rev);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public List<ThemeReviewVO> searchByKeyword(Connection con, String keyword) {

		List<ThemeReviewVO> list = new ArrayList<>();

		try {
			query = "SELECT R.THEME_REV_NUM, U.USER_NUM, T.THEME_MAIN_TITLE, R.THEME_REV_TITLE, R.THEME_REV_CONTENT, R.THEME_REV_REPORTING_DATE \r\n"
					+ "FROM TBL_THEME_REVIEW R\r\n"
					+ "JOIN TBL_THEME T ON R.THEME_NUM = T.THEME_NUM\r\n"
					+ "JOIN TBL_USER U ON R.USER_NUM = U.USER_NUM\r\n"
					+ "WHERE R.THEME_REV_CONTENT LIKE ?"; 
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int uNum = rs.getInt("USER_NUM");
				int tRevNum = rs.getInt("THEME_REV_NUM");
				String tRevTitle = rs.getString("THEME_REV_TITLE");
				String tRevContent = rs.getString("THEME_REV_CONTENT");
				Date tRevCreateDate = new Date(rs.getTimestamp("THEME_REV_REPORTING_DATE").getTime());
				ThemeVO themeInfo = new ThemeVO();
				themeInfo.setMainTitle(rs.getString("THEME_MAIN_TITLE"));
				ThemeReviewVO rev = new ThemeReviewVO(tRevNum, uNum, themeInfo, tRevTitle, tRevContent, tRevCreateDate);
				list.add(rev);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	public List<ThemeReviewVO> searchByTitle(Connection con, String title) {
		List<ThemeReviewVO> list = new ArrayList<>();

		try {
			query = "SELECT R.THEME_REV_NUM, U.USER_NUM, T.THEME_MAIN_TITLE, R.THEME_REV_TITLE, R.THEME_REV_CONTENT, R.THEME_REV_REPORTING_DATE \r\n"
					+ "FROM TBL_THEME_REVIEW R\r\n"
					+ "JOIN TBL_THEME T ON R.THEME_NUM = T.THEME_NUM\r\n"
					+ "JOIN TBL_USER U ON R.USER_NUM = U.USER_NUM\r\n"
					+ "WHERE T.THEME_MAIN_TITLE LIKE ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + title + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				int tRevNum = rs.getInt("THEME_REV_NUM");
				int uNum = rs.getInt("USER_NUM");
				String tRevTitle = rs.getString("THEME_REV_TITLE");
				String tRevContent = rs.getString("THEME_REV_CONTENT");
				Date tRevCreateDate = new Date(rs.getTimestamp("THEME_REV_REPORTING_DATE").getTime());
				ThemeVO themeInfo = new ThemeVO();
				themeInfo.setMainTitle(rs.getString("THEME_MAIN_TITLE"));
				
				ThemeReviewVO rev = new ThemeReviewVO(tRevNum, uNum, themeInfo, tRevTitle, tRevContent, tRevCreateDate);
				list.add(rev);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public int insert(Connection con, ThemeReviewVO rev) {

		try {
			query = "INSERT INTO TBL_THEME_REVIEW VALUES(SEQ_THEME.NEXTVAL, SYSDATE, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, rev.gettRevTitle());
			pstmt.setString(2, rev.gettRevContent());
			pstmt.setInt(3, rev.getuNum());
			pstmt.setInt(4, rev.gettNum());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(Connection con, int tRevNum) {
		try {
			query = "DELETE FROM TBL_THEME_REVIEW WHERE THEME_REV_NUM = ?";
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, tRevNum);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int update(Connection con, int tRevNum, ThemeReviewVO themeReview) {
		try {
			String sql = "UPDATE TBL_THEME_REVIEW SET THEME_REV_REPORTING_DATE = SYSDATE, THEME_REV_TITLE = ?, THEME_REV_CONTENT = ? WHERE THEME_REV_NUM = ?";
			PreparedStatement pstmt = con.prepareStatement(sql); 

			pstmt.setString(1, themeReview.gettRevTitle());
			pstmt.setString(2, themeReview.gettRevContent());
			pstmt.setInt(3, tRevNum);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
