package service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;


import dao.ThemeReviewDAO;
import vo.ThemeReviewVO;

public class ThemeReviewService {
	
	private ThemeReviewDAO dao = new ThemeReviewDAO();
	private Connection con = connect();
	
	public List<ThemeReviewVO> selectAll() { 
		return dao.selectAll(con);
	}
	
	public List<ThemeReviewVO> searchByUserNumber(int uNum) {
		return dao.searchByUserNumber(con, uNum);
	}

	public List<ThemeReviewVO> searchByKeyword(String keyword) { 
		return dao.searchByKeyword(con, keyword);
	}
	
	public List<ThemeReviewVO> searchByTitle(String title) {
		return dao.searchByTitle(con, title);
	}
	
	public int insert(ThemeReviewVO review) {
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
	
	public int update(int tRevNum, ThemeReviewVO themeReview) {
		int result = dao.update(con, tRevNum, themeReview);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		return result;
	}
}