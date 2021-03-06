package seoul.legacy.model.dao;

import static seoul.legacy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import seoul.legacy.model.vo.Review;
public class ReviewDAO {
	
	//추가 - 0606 / 구기혁
	public List<Review> selectAll(Connection conn){
		List<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT R.review_no, R.review_content, R.user_id, R.legacy_no, L.legacy_name, R.review_date "
					+ "FROM tbl_review R, tbl_user U, tbl_legacy L "
					+ "WHERE r.legacy_no = l.legacy_no "
					+ "AND r.user_id = u.user_id "
					+ "AND r.legacy_no = l.legacy_name_kor";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reviewNo = rs.getInt("r.review_no");
				String reviewContent = rs.getString("r.review_content");
				String userId = rs.getString("r.user_id");
				int legacyNo = rs.getInt("r.legacy_no");
				String legacyName = rs.getString("l.legacy_name");
				Date reviewDate = rs.getDate("r.review_date");
				
				list.add(new Review(reviewNo, reviewContent, userId, legacyNo, legacyName, reviewDate));
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

	// 1. 문화재로 리뷰 검색
	public List<Review> selectByLegacyNo(Connection conn, int lNo) {

		List<Review> temp = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select r.review_no, r.review_content, r.user_id, r.legacy_no, l.legacy_name_kor, "
					+ "r.review_date from tbl_review r, tbl_legacy l "
					+ "where r.legacy_no = l.legacy_no and r.legacy_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int reviewNo = rs.getInt("review_no");
				String reviewContent = rs.getString("review_content");
				String userId = rs.getString("user_id");
				int legacyNo = rs.getInt("legacy_no");
				String legacyName = rs.getString("legacy_name");
				Date reviewDate = rs.getDate("review_date");

				temp.add(new Review(reviewNo, reviewContent, userId, legacyNo, legacyName, reviewDate));
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

	// 2. 유저 아이디로 검색
	public List<Review> selectByUserId(Connection conn, String id) {

		List<Review> temp = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select r.review_no, r.review_content, r.user_id, r.legacy_no, l.legacy_name_kor, "
					+ "r.review_date from tbl_review r, tbl_legacy l "
					+ "where r.legacy_no = l.legacy_no and r.user_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int reviewNo = rs.getInt("review_no");
				String reviewContent = rs.getString("review_content");
				String userId = rs.getString("user_id");
				int legacyNo = rs.getInt("legacy_no");
				String legacyName = rs.getString("legacy_name_kor");
				Date reviewDate = rs.getDate("review_date");

				temp.add(new Review(reviewNo, reviewContent, userId, legacyNo, legacyName, reviewDate));
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

	// 3. 리뷰 작성
	public int insert(Connection conn, Review review) {

		try {
			String sql = "insert into tbl_review(review_no, review_content, user_id, legacy_no) "
					+ "values (seq_review_no.nextval, ?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int count = 1;
			pstmt.setString(count++, review.getReviewContent());
			pstmt.setString(count++, review.getUserId());
			pstmt.setInt(count++, review.getLegacyNo());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 4. 리뷰 삭제
	public int delete(Connection conn, Review review) {
		try {
			String sql = "delete from tbl_review where review_no = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, review.getReviewNo());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
