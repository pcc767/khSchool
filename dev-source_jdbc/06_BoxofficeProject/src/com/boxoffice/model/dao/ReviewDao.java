package com.boxoffice.model.dao;


import static com.boxoffice.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.boxoffice.common.JDBCTemplate;
import com.boxoffice.model.vo.Boxoffice;
import com.boxoffice.model.vo.Review;
import com.boxoffice.model.vo.User;

public class ReviewDao {

	public List<Review> selectAll(Connection conn) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		try {
			String sql = "SELECT R.RNO, R.BNO, R.UNO, R.TITLE, R.SCORE, R.CREATE_DATE, U.ID, B.MOVIENM "
					+ "FROM REVIEW_BOXOFFICE R, USERS U, WEEKLY_BOXOFFICE B "
					+ "WHERE R.BNO = B.BNO AND R.UNO = U.UNO ORDER BY R.RNO";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int rNo  = rs.getInt("RNO");
				int bNo  = rs.getInt("BNO");
				int uNo  = rs.getInt("UNO");
				String title  = rs.getString("TITLE");
				int score  = rs.getInt("SCORE");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				User user = new User();
				user.setId(rs.getString("ID"));
				Boxoffice movieInfo = new Boxoffice();
				movieInfo.setMovienm(rs.getString("MOVIENM"));
				Review r = new Review(rNo, bNo, uNo, title, null, score, createDate, user, movieInfo);
				list.add(r);
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	public List<Review> selectByUNo(Connection conn, int uNo) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		try {
			String sql = "SELECT R.RNO, R.BNO, R.UNO, R.TITLE, R.CONTENT, R.SCORE, R.CREATE_DATE, U.ID, B.MOVIENM "
					+ "FROM REVIEW_BOXOFFICE R, USERS U, WEEKLY_BOXOFFICE B "
					+ "WHERE R.BNO = B.BNO AND R.UNO = U.UNO AND R.UNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			rs = pstmt.executeQuery();
			
			while (rs.next() == true) {
				int rNo  = rs.getInt("RNO");
				int bNo  = rs.getInt("BNO");
				 uNo  = rs.getInt("UNO");
				String title  = rs.getString("TITLE");
				String content  = rs.getString("CONTENT");
				int score  = rs.getInt("SCORE");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				User user = new User();
				user.setId(rs.getString("CREATE_DATE"));
				Boxoffice movieInfo = new Boxoffice();
				movieInfo.setMovienm(rs.getString("MOVIENM"));
				Review r = new Review(rNo, bNo, uNo, title, content, score, createDate, user, movieInfo);
				list.add(r);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	public List<Review> selectByBNo(Connection conn, int bNo) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		try {
			String sql = "SELECT R.RNO, R.BNO, R.UNO, R.TITLE, R.CONTENT, R.SCORE, R.CREATE_DATE, U.ID, B.MOVIENM "
					+ "FROM REVIEW_BOXOFFICE R, USERS U, WEEKLY_BOXOFFICE B "
					+ "WHERE R.BNO = B.BNO AND R.UNO = U.UNO AND R.BNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();
			
			while (rs.next() == true) {
				int rNo  = rs.getInt("RNO");
			    bNo 	 = rs.getInt("BNO");
				int uNo  = rs.getInt("UNO");
				String title  = rs.getString("TITLE");
				String content  = rs.getString("CONTENT");
				int score  = rs.getInt("SCORE");
				Date createDate  = new Date(rs.getTimestamp("CREATE_DATE").getTime());
				User user = new User();
				user.setId(rs.getString("ID"));
				Boxoffice movieInfo = new Boxoffice();
				movieInfo.setMovienm(rs.getString("MOVIENM"));
				Review r = new Review(rNo, bNo, uNo, title, content, score, createDate, user, movieInfo);
				list.add(r);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
	
	public Review selectOneDetail(Connection conn, int rNo) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		try {
			String sql = "SELECT B.*, U.*, R.*  "  
					+ "FROM REVIEW_BOXOFFICE R, USERS U, WEEKLY_BOXOFFICE B "
					+ "WHERE R.BNO = B.BNO AND R.UNO = U.UNO AND R.RNO = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNo);
			rs = pstmt.executeQuery();
			
			if (rs.next() == true) {
				int count = 1;
				int bNo 					= rs.getInt(count++);
				int rnum                    = rs.getInt(count++);
				int rank                    = rs.getInt(count++);
				int rankInten               = rs.getInt(count++);
				String rankOldandnew        = rs.getString(count++);
				String moviecd              = rs.getString(count++);
				String movienm              = rs.getString(count++);
				Date opendt                 = rs.getDate(count++);
				long salesamt                = rs.getLong(count++);
				double salesshare            = rs.getDouble(count++);
				long salesinten              = rs.getLong(count++);
				double saleschange           = rs.getDouble(count++);
				long salesacc                = rs.getLong(count++);
				long audicnt                 = rs.getLong(count++);
				long audiinten               = rs.getLong(count++);
				double audichange            = rs.getDouble(count++);
				long audiacc                 = rs.getLong(count++);
				long scrncnt                 = rs.getLong(count++);
				long showcnt                 = rs.getLong(count++);
				String boxofficeType        = rs.getString(count++);
				String showrange            = rs.getString(count++);
				String yearweektime         = rs.getString(count++);
				Boxoffice movieInfo = new Boxoffice(bNo, rnum, rank, rankInten, rankOldandnew, moviecd, movienm, opendt, salesamt, salesshare, salesinten, saleschange, salesacc, audicnt, audiinten, audichange, audiacc, scrncnt, showcnt, boxofficeType, showrange, yearweektime);
				
				int uNo = 		rs.getInt(count++);
				String id = 	rs.getString(count++);
				String password = rs.getString(count++);
				String name 	= rs.getString(count++);
				User user = new User(uNo, id, password, name);
				
				int rNo2  = rs.getInt(count++);
				int bNo2  = rs.getInt(count++);
				int uNo2  = rs.getInt(count++);
				String title  = rs.getString(count++);
				String content  = rs.getString(count++);
				int score  = rs.getInt(count++);
				Date createDate  = new Date(rs.getTimestamp(count++).getTime());
				review = new Review(rNo2, bNo2, uNo2, title, content, score, createDate, user, movieInfo);
			}
			
			return review;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public int insert(Connection conn, Review review) {
		try {
			String sql = "INSERT INTO REVIEW_BOXOFFICE(RNO, BNO, UNO, TITLE, CONTENT, SCORE) "
					+ "VALUES(SEQ_REVIEW_NO.NEXTVAL, ?, ?, ?, ?, ?)";
					
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, review.getbNo());
			pstmt.setInt(2, review.getuNo());
			pstmt.setString(3, review.getTitle());
			pstmt.setString(4, review.getContent());
			pstmt.setInt(5, review.getScore());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int delete(Connection conn, int rNo) {
		try {
			String sql = "DELETE FROM REVIEW_BOXOFFICE WHERE RNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			
			pstmt.setInt(1, rNo);
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		Connection conn = JDBCTemplate.openConnection();
		
		Review r = new Review(1, 1, "????????????", "?????? ??????", 5);
		int result = new ReviewDao().insert(conn, r);
		System.out.println(result);

		
		List<Review> list = new ReviewDao().selectAll(conn);
		
		 result = new ReviewDao().delete(conn, list.get(0).getrNo());
		System.out.println(result);
		
		
		list = new ReviewDao().selectAll(conn);
		for(Review info : list) {
			System.out.println(info.toString());
		}
		System.out.println();
		
		
		
		Review review = new ReviewDao().selectOneDetail(conn, 2);
		System.out.println(review);
		
		list = new ReviewDao().selectByUNo(conn, 1);
		for(Review info : list) {
			System.out.println(info.toString());
		}
		System.out.println();
	}
	
	
}
