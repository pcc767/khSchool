package com.teamtest.service;

import static com.teamtest.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import com.teamtest.model.dao.PalaceDao;
import com.teamtest.model.vo.Palace;

public class PFacilityService {
	
	private PalaceDao dao = new PalaceDao();
	private Connection conn = null;

	public PFacilityService() {
		conn = openConnection();
	}

	public Connection getConnection() {
		return conn;
	}

//	-----------------------------------------------------------------------------

	public List<Palace> selectByPNo(int palace_no) {
		return dao.selectByPNo(getConnection(), palace_no);
	}

	public Palace selectOne(String palaceName) {
		return dao.selectOne(getConnection(), palaceName);
	}

	
	public int insert(Palace palace){
		int result = dao.insert(conn, palace);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}

}
