package seoul.legacy.model.service;

import static seoul.legacy.common.JDBCTemplate.commit;
import static seoul.legacy.common.JDBCTemplate.openConnection;
import static seoul.legacy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import seoul.legacy.model.dao.PalaceDAO;
import seoul.legacy.model.vo.Palace;

public class PalaceService {

	private Connection conn = null;
	private PalaceDAO dao = new PalaceDAO();
	
	
	
	public PalaceService() {
		conn = openConnection();
		
	}
	
	public List<Palace> selectAll() {
		return dao.selectAll(conn);
		
	}
	
	public int insert (Palace palace) {
		int result = dao.insert(conn, palace);
		if (result > 0) {
			commit(conn);	
		}else {
			rollback(conn);
		}
		return result;
	}
	
}
