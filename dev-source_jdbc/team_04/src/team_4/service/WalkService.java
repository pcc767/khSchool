package service;

import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.connect;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import dao.WalkDAO;
import vo.WalkVO;

public class WalkService {

	private WalkDAO dao = new WalkDAO();
	private Connection con = connect();
	
	public List<WalkVO> selectAll() {
		return dao.selectAll(con);
	}
	
	public List<WalkVO> searchByCtegory(String category) {
		return dao.searchByCtegory(con, category);
	}
	
	public List<WalkVO> searchByKeyword(String keyword) {
		return dao.searchByKeyword(con, keyword);
	}
	
	public int insert(WalkVO walk) {
		int result = dao.insert(con, walk);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}
}
