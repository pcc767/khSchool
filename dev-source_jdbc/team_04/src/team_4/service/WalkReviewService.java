package service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.connect;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import dao.WalkReviewDAO;
import vo.WalkReviewVO;

public class WalkReviewService {

	private WalkReviewDAO dao = new WalkReviewDAO();
	private Connection con = connect();
	
	public List<WalkReviewVO> selectAll() { 
		return dao.selectAll(con);
	}
	
	public List<WalkReviewVO> searchByUserNumber(int uNum) { 
		return dao.searchByUserNumber(con, uNum);
	}
	
	public List<WalkReviewVO> searchByTitle(String title) { 
		return dao.searchByTitle(con, title);
	}
	
	public List<WalkReviewVO> searchByKeyword(String keyword) {
		return dao.searchByKeyword(con, keyword);
	}
	
	public int insert(WalkReviewVO review) {
		int result = dao.insert(con, review);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}

	public int delete(int rNo) {
		int result = dao.delete(con, rNo);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}
	
	public int update(int wRevNum, WalkReviewVO walkReview) {
		int result = dao.update(con, wRevNum, walkReview);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}
}