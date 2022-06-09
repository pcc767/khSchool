package seoul.legacy.model.dao;

import static seoul.legacy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import seoul.legacy.model.vo.Zzim;

public class ZzimDAO {

	// 1. zzim id로 조회
	public List<Zzim> selectById(Connection conn, String id) {
		List<Zzim> temp = new ArrayList<Zzim>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select z.user_id, z.legacy_no, z.zzim_date, l.legacy_name_kor "
					+ "from tbl_zzim z, tbl_legacy l where l.legacy_no = z.legacy_no and z.user_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("user_id");
				int legacyNo = rs.getInt("legacy_no");
				Date zzimDate = rs.getDate("zzim_date");
				String legacyName = rs.getString("legacy_name_kor");

				temp.add(new Zzim(userId, legacyNo, zzimDate, legacyName));
			}
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return null;
	}

	public int countZzim(Connection conn, int lNo) {
		int count = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select legacy_no, count(*) from tbl_zzim where legacy_no = ? group by legacy_no";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt("count(*)");
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}
	

	// 2. zzim 추가
	public int insert(Connection conn, Zzim zzim) {
		try {
			String sql = "insert into tbl_zzim (user_id, legacy_no) values (?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zzim.getUserId());
			pstmt.setInt(2, zzim.getLegacyNo());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
		}
		return -1;
	}

	// 3. zzim 삭세
	public int delete(Connection conn, Zzim zzim) {
		try {
			String sql = "delete from tbl_review where user_id = ? and legacy_no = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zzim.getUserId());
			pstmt.setInt(2, zzim.getLegacyNo());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
