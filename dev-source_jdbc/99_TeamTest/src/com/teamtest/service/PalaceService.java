package com.teamtest.service;

import static com.teamtest.common.JDBCTemplate.commit;
import static com.teamtest.common.JDBCTemplate.openConnection;
import static com.teamtest.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.teamtest.model.dao.PalaceDao;
import com.teamtest.model.vo.Palace;

public class PalaceService {
	
	private PalaceDao dao = new PalaceDao();
	private Connection conn = null;
	
	public PalaceService() {
		conn = openConnection();
	}

	public Connection getConnection() {
		return conn;
	}

//	-----------------------------------------------------------------------------

	public List<Palace> selectAll() {
		Connection conn = getConnection();
		return dao.selectAll(conn);
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
