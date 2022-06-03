package com.teamtest.service;

import static com.teamtest.common.JDBCTemplate.commit;
import static com.teamtest.common.JDBCTemplate.openConnection;
import static com.teamtest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.teamtest.model.dao.LegacyDao;
import com.teamtest.model.vo.Legacy;

import model.vo.Heritage;

public class LegacyService {
	private LegacyDao dao = new LegacyDao();
	private Connection conn = null;
	
	public LegacyService() {
		conn = openConnection();
	}
	
	public List<Legacy> selectByLegacyName(String regency_name_kor) {
		return dao.selectByLegacyName(conn, regency_name_kor);
	}
	
	public List<Legacy> selectByCategoryName(String regency_category_name) {
		return dao.selectByLegacyName(conn, regency_category_name);
	}
	
	public List<Legacy> selectByArea(String regency_area) {
		return dao.selectByLegacyName(conn, regency_area);
	}
	
	public List<Legacy> selectByEra(String regency_era) {
		return dao.selectByLegacyName(conn, regency_era);
	}
	
	public Legacy selectOne(String regency_no) {
		return dao.selectOne(conn, regency_no);
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
