package seoul.legacy.model.service;

import static seoul.legacy.common.JDBCTemplate.commit;
import static seoul.legacy.common.JDBCTemplate.openConnection;
import static seoul.legacy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import seoul.legacy.model.dao.ReviewDAO;
import seoul.legacy.model.vo.Review;
public class ReviewService {

	private Connection conn = null;
	private ReviewDAO dao = new ReviewDAO();

	public ReviewService() {
		conn = openConnection();
	}
	
	public List<Review> selectAll() {
		return dao.selectAll(conn);
	}

	public List<Review> selectByLegacyNo(int lNo) {
		return dao.selectByLegacyNo(conn, lNo);
	}

	public List<Review> selectByUserId(String id) {
		return dao.selectByUserId(conn, id);
	}

	public int insert(Review review) {
		int result = dao.insert(conn, review);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int delete(Review review) {
		int result = dao.delete(conn, review);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
}
