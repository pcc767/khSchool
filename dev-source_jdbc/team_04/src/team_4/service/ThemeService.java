package service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.connect;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import dao.ThemeDAO;
import vo.ThemeVO;

public class ThemeService {

	private ThemeDAO dao = new ThemeDAO();
	private Connection con = connect();
	
	public List<ThemeVO> selectAll() {
		return dao.selectAll(con);
	}
	
	public List<ThemeVO> searchByCategory(String category) {
		return dao.searchByCategory(con, category);
	}
	
	public List<ThemeVO> searchByKeyword(String keyword) {
		return dao.searchByKeyword(con, keyword);
	}
	
	public List<ThemeVO> searchByGugun(String gugun) {
		return dao.searchByGugun(con, gugun);
	}
	
	public int insert(ThemeVO theme) {
		int result = dao.insert(con, theme);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}
}
