package dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import vo.WalkReviewVO;
import vo.WalkVO;

public class WalkReviewDAO {
	private String query;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insert(Connection con, WalkReviewVO walkReview) {
		try {
			String sql = "INSERT INTO TBL_WALK_REVIEW VALUES(SEQ_WALK.NEXTVAL, SYSDATE, ?, ?, ?, ?)";
					
			pstmt = con.prepareStatement(sql); 

			pstmt.setString(1, walkReview.getwRevTitle());
			pstmt.setString(2, walkReview.getwRevContent());
			pstmt.setInt(3, walkReview.getuNum());
			pstmt.setInt(4, walkReview.getwNum());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int update(Connection con, int wRevNum, WalkReviewVO walkReview) {
		try {
			String sql = "UPDATE TBL_WALK_REVIEW SET WALK_REV_REPORTING_DATE = SYSDATE, WALK_REV_TITLE = ?, WALK_REV_CONTENT = ? WHERE WALK_REV_NUM = ?";
			pstmt = con.prepareStatement(sql); 

			pstmt.setString(1, walkReview.getwRevTitle());
			pstmt.setString(2, walkReview.getwRevContent());
			pstmt.setInt(3, wRevNum);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(Connection con, int rNo) {
		try {
			String sql = "DELETE FROM TBL_WALK_REVIEW WHERE WALK_REV_NUM = ?";
			pstmt = con.prepareStatement(sql); 
			
			pstmt.setInt(1, rNo);
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<WalkReviewVO> selectAll(Connection con) {

		List<WalkReviewVO> list = new ArrayList<>();

		try {
			query = "SELECT R.WALK_REV_NUM, U.USER_NUM, W.WALK_MAIN_TITLE, R.WALK_REV_TITLE, R.WALK_REV_CONTENT, R.WALK_REV_REPORTING_DATE \r\n"
					+ "FROM TBL_WALK_REVIEW R\r\n"
					+ "JOIN TBL_WALK W ON R.WALK_NUM = W.WALK_NUM\r\n"
					+ "JOIN TBL_USER U ON R.USER_NUM = U.USER_NUM"; 
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				int wRevNum = rs.getInt("WALK_REV_NUM");
				int uNum = rs.getInt("USER_NUM");
				String wRevTitle = rs.getString("WALK_REV_TITLE");
				String wRevContent = rs.getString("WALK_REV_CONTENT");
				Date wRevCreateDate = new Date(rs.getTimestamp("WALK_REV_REPORTING_DATE").getTime());
				WalkVO walkInfo = new WalkVO();
				walkInfo.setMainTitle(rs.getString("WALK_MAIN_TITLE"));

				WalkReviewVO rev = new WalkReviewVO(wRevNum, uNum, walkInfo, wRevTitle, wRevContent, wRevCreateDate);
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

	public List<WalkReviewVO> searchByUserNumber(Connection con, int uNum) {

		List<WalkReviewVO> list = new ArrayList<>();

		try {
			query = "SELECT R.WALK_REV_NUM, U.USER_NUM, W.WALK_MAIN_TITLE, R.WALK_REV_TITLE, R.WALK_REV_CONTENT, R.WALK_REV_REPORTING_DATE \r\n"
					+ "FROM TBL_WALK_REVIEW R\r\n"
					+ "JOIN TBL_WALK W ON R.WALK_NUM = W.WALK_NUM\r\n"
					+ "JOIN TBL_USER U ON R.USER_NUM = U.USER_NUM\r\n"
					+ "WHERE R.USER_NUM = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, uNum);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				int wRevNum = rs.getInt("WALK_REV_NUM");
				String wRevTitle = rs.getString("WALK_REV_TITLE");
				String wRevContent = rs.getString("WALK_REV_CONTENT");
				Date wRevCreateDate = new Date(rs.getTimestamp("WALK_REV_REPORTING_DATE").getTime());
				WalkVO walkInfo = new WalkVO();
				walkInfo.setMainTitle(rs.getString("WALK_MAIN_TITLE"));

				WalkReviewVO rev = new WalkReviewVO(wRevNum, uNum, walkInfo, wRevTitle, wRevContent, wRevCreateDate);
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

	public List<WalkReviewVO> searchByTitle(Connection con, String title) {

		List<WalkReviewVO> list = new ArrayList<>();

		try {
			query = "SELECT R.WALK_REV_NUM, U.USER_NUM, W.WALK_MAIN_TITLE, R.WALK_REV_TITLE, R.WALK_REV_CONTENT, R.WALK_REV_REPORTING_DATE \r\n"
					+ "FROM TBL_WALK_REVIEW R\r\n"
					+ "JOIN TBL_WALK W ON R.WALK_NUM = W.WALK_NUM\r\n"
					+ "JOIN TBL_USER U ON R.USER_NUM = U.USER_NUM\r\n"
					+ "WHERE W.WALK_MAIN_TITLE LIKE ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + title + "%");
			rs = pstmt.executeQuery();
			while(rs.next() == true) {
				int wRevNum = rs.getInt("WALK_REV_NUM");
				int uNum = rs.getInt("USER_NUM");
				String wRevTitle = rs.getString("WALK_REV_TITLE");
				String wRevContent = rs.getString("WALK_REV_CONTENT");
				Date wRevCreateDate = new Date(rs.getTimestamp("WALK_REV_REPORTING_DATE").getTime());
				WalkVO walkInfo = new WalkVO();
				walkInfo.setMainTitle(rs.getString("WALK_MAIN_TITLE"));

				WalkReviewVO rev = new WalkReviewVO(wRevNum, uNum, walkInfo, wRevTitle, wRevContent, wRevCreateDate);
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

	public List<WalkReviewVO> searchByKeyword(Connection con, String keyword) {
		
		List<WalkReviewVO> list = new ArrayList<>();

		try {
			query = "SELECT R.WALK_REV_NUM, U.USER_NUM, W.WALK_MAIN_TITLE, R.WALK_REV_TITLE, R.WALK_REV_CONTENT, R.WALK_REV_REPORTING_DATE \r\n"
					+ "FROM TBL_WALK_REVIEW R\r\n"
					+ "JOIN TBL_WALK W ON R.WALK_NUM = W.WALK_NUM\r\n"
					+ "JOIN TBL_USER U ON R.USER_NUM = U.USER_NUM\r\n"
					+ "WHERE R.WALK_REV_CONTENT LIKE ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				int wRevNum = rs.getInt("WALK_REV_NUM");
				int uNum = rs.getInt("USER_NUM");
				String wRevTitle = rs.getString("WALK_REV_TITLE");
				String wRevContent = rs.getString("WALK_REV_CONTENT");
				Date wRevCreateDate = new Date(rs.getTimestamp("WALK_REV_REPORTING_DATE").getTime());
				WalkVO walkInfo = new WalkVO();
				walkInfo.setMainTitle(rs.getString("WALK_MAIN_TITLE"));

				WalkReviewVO rev = new WalkReviewVO(wRevNum, uNum, walkInfo, wRevTitle, wRevContent, wRevCreateDate);
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

}
