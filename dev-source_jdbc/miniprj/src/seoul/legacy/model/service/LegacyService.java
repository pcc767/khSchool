package seoul.legacy.model.service;

import java.sql.Connection;
import java.util.List;
import static seoul.legacy.common.JDBCTemplate.*;
import seoul.legacy.model.dao.LegacyDAO;
import seoul.legacy.model.vo.Legacy;

public class LegacyService {

	private Connection conn = null;
	private LegacyDAO dao = new LegacyDAO();

	public LegacyService() {
		conn = openConnection();
	}

	public int insert(Legacy legacy) {
		int result = dao.insert(conn, legacy);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public List<Legacy> selectByLegacyArea(String area) {
		return dao.selectByLegacyArea(conn, area);
	}

	public List<Legacy> selectByCategory(String category) {
		return dao.selectByCategory(conn, category);
	}

	public List<Legacy> topTen() {
		return dao.selectTopTen(conn);
	}

	public List<Legacy> selectByEra(String legency_era) {
		return dao.selectByEra(conn, legency_era);
	}
	
	public List<Legacy> selectByName(String name){
		return dao.selectByLegacyName(conn, name);
	}

	public Legacy selectOneByNo(int no) {
		return dao.selectOneByNo(conn, no);
	}
}
