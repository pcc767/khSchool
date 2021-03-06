package seoul.legacy.model.service;

import static seoul.legacy.common.JDBCTemplate.commit;
import static seoul.legacy.common.JDBCTemplate.openConnection;
import static seoul.legacy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import seoul.legacy.model.dao.LegacyDao;
import seoul.legacy.model.vo.Legacy;

public class LegacyService {
	private LegacyDao dao = new LegacyDao();
	private Connection conn = null;
	
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
	
	
	public List<Legacy> selectByLegacyName(String legency_name_kor) {
		return dao.selectByLegacyName(conn, legency_name_kor);
	}
	
	public List<Legacy> selectByCategory(String category) {
		return dao.selectByCategory(conn, category);
	}
	
	public List<Legacy> selectByLegacyArea(String area){
		return dao.selectByLegacyArea(conn, area);
	}

	public List<Legacy> selectByEra(String legency_era) {
		return dao.selectByEra(conn, legency_era);
	}

	// 추가 - 0606 / 구기혁
	public List<Legacy> topTen() {
		return dao.selectTopTen(conn);
	}

}
