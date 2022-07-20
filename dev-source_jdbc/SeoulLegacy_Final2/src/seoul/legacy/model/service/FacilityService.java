package seoul.legacy.model.service;

import static seoul.legacy.common.JDBCTemplate.commit;
import static seoul.legacy.common.JDBCTemplate.openConnection;
import static seoul.legacy.common.JDBCTemplate.rollback;

import java.sql.Connection;

import seoul.legacy.model.dao.FacilityDao;
import seoul.legacy.model.vo.Facility;

public class FacilityService {
	
	private FacilityDao dao = new FacilityDao();
	private Connection conn = null;
	
	public FacilityService() {
		conn = openConnection();
	}
	
	public int insert(Facility facility) {
		int result = dao.insert(conn, facility);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	

}
