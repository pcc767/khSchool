package seoul.legacy.model.service;

import static seoul.legacy.common.JDBCTemplate.commit;
import static seoul.legacy.common.JDBCTemplate.openConnection;
import static seoul.legacy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import seoul.legacy.model.dao.ZzimDao;
import seoul.legacy.model.vo.User;
import seoul.legacy.model.vo.Zzim;

public class ZzimService {

	private Connection conn = null;
	private ZzimDao dao = new ZzimDao();

	public ZzimService() {
		conn = openConnection();
	}

	public List<Zzim> selectById(String id) {
		return dao.selectById(conn, id);
	}

	public int insert(Zzim zzim) {
		int result = dao.insert(conn, zzim);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int delete(Zzim zzim) {
		int result = dao.delete(conn, zzim);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public int zzimcount(int legacy_no) {
		return dao.zzimcount(conn, legacy_no);
	}

	
}
