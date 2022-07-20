package service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import dao.ParkDAO;
import vo.ParkVO;

public class ParkService {
	
	private ParkDAO dao = new ParkDAO();
	private Connection con = connect();
	
	public List<ParkVO> selectAll() {
		return dao.selectAll(con);
	}
	
	public List<ParkVO> searchByPkName(String parkName) {
		return dao.searchByPkName(con, parkName);
	}
	
	public List<ParkVO> searchByPkAdd(String parkAdd) {
		return dao.searchByPkAdd(con, parkAdd);
	}
	
	public int insert(ParkVO park) {
		int result = dao.insert(con, park);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}
}
