package seoul.legacy.model.service;

import static seoul.legacy.common.JDBCTemplate.commit;
import static seoul.legacy.common.JDBCTemplate.openConnection;
import static seoul.legacy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import seoul.legacy.model.dao.FacilityDAO;
import seoul.legacy.model.vo.Facility;

public class FacilityService {

	private Connection conn = null;
	private FacilityDAO dao = new FacilityDAO();

	public FacilityService() {
		conn = openConnection();

	}

	public List<Facility> selectByPalaceNO(int pNo) {
		return dao.selectAll(conn, pNo);

	}

	public Facility selectOneByFacilityNO(int FacilityNo) {
		return dao.selectOnebyfNo(conn, FacilityNo);

	}

	public int insert(Facility Facility) {
		int result = dao.insert(conn, Facility);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}
