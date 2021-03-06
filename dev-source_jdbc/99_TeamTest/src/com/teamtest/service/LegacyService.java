package com.teamtest.service;

import static com.teamtest.common.JDBCTemplate.*;

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
	
	public Connection getConnetion() {
		return conn;
	}
	
	@Override
	protected void finalize() throws Throwable {
		close(conn);
	}
	
	//------------------------------------------------------------------
	
	public List<Legacy> selectByLegacyName(String legency_name_kor) {
		return dao.selectByLegacyName(getConnetion(), legency_name_kor);
	}
	
	public List<Legacy> selectByCategoryName(String legency_category_name) {
		return dao.selectByCategoryName(getConnetion(), legency_category_name);
	}
	
	public List<Legacy> selectByArea(String legency_area) {
		return dao.selectByArea(getConnetion(), legency_area);
	}
	
	public List<Legacy> selectByEra(String legency_era) {
		return dao.selectByEra(getConnetion(), legency_era);
	}
	
	public Legacy selectOne(String legency_no) {
		return dao.selectOne(getConnetion(), legency_no);
	}
	
	//-Detail---------------------------------------------------------------------

	public List<Legacy> selectByLegacyNameDetail(String legency_name_kor) {
		return dao.selectByLegacyNameDetail(getConnetion(), legency_name_kor);
	}
	
	public List<Legacy> selectByCategoryNameDetail(String legency_category_name) {
		return dao.selectByCategoryNameDetail(getConnetion(), legency_category_name);
	}
	
	public List<Legacy> selectByAreaDetail(String legency_area) {
		return dao.selectByAreaDetail(getConnetion(), legency_area);
	}
	
	public List<Legacy> selectByEraDetail(String legency_era) {
		return dao.selectByEraDetail(getConnetion(), legency_era);
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
