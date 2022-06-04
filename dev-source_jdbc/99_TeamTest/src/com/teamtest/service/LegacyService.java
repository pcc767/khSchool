package com.teamtest.service;

import static com.teamtest.common.JDBCTemplate.commit;
import static com.teamtest.common.JDBCTemplate.openConnection;
import static com.teamtest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.teamtest.model.dao.LegacyDao;
import com.teamtest.model.vo.Legacy;

public class LegacyService {
	private LegacyDao dao = new LegacyDao();
	private Connection conn = null;
	
	public LegacyService() {
		conn = openConnection();
	}
	
	public List<Legacy> selectByLegacyName(String legency_name_kor) {
		return dao.selectByLegacyName(conn, legency_name_kor);
	}
	
	public List<Legacy> selectByCategoryName(String legency_category_name) {
		return dao.selectByCategoryName(conn, legency_category_name);
	}
	
	public List<Legacy> selectByArea(String legency_area) {
		return dao.selectByArea(conn, legency_area);
	}
	
	public List<Legacy> selectByEra(String legency_era) {
		return dao.selectByEra(conn, legency_era);
	}
	
	public Legacy selectOne(String legency_no) {
		return dao.selectOne(conn, legency_no);
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

}
