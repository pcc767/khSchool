package com.Legacy.model.service;


import static com.LegacySearch.common.JDBCTemplate.commit;
import static com.LegacySearch.common.JDBCTemplate.openConnection;
import static com.LegacySearch.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

//import com.boxoffice.model.dao.BoxOfficeDao;
//import com.boxoffice.model.vo.Boxoffice;

import model.vo.Heritage;

public class HeritageService {
//	private BoxOfficeDao dao = new BoxOfficeDao();
	private Connection conn = null;
	
	public HeritageService() {
		conn = openConnection();
	}

	public List<Heritage> selectByLegacyName(String regency_name_kor) {
		return dao.selectByLegacyName(conn, regency_name_kor);
	}
	
	public List<Heritage> selectByCategoryName(String regency_category_name) {
		return dao.selectByLegacyName(conn, regency_category_name);
	}
	
	public List<Heritage> selectByArea(String regency_area) {
		return dao.selectByLegacyName(conn, regency_area);
	}
	
	public List<Heritage> selectByEra(String regency_era) {
		return dao.selectByLegacyName(conn, regency_era);
	}
	
	public Heritage selectOne(String regency_no) {
		return dao.selectOne(conn, regency_no);
	}

}
