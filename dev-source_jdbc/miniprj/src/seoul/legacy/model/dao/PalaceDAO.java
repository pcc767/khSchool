package seoul.legacy.model.dao;

import static seoul.legacy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import seoul.legacy.model.vo.Palace;

public class PalaceDAO {

	public List<Palace> selectAll(Connection conn) {
		List<Palace> temp = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select p.palace_no, p.legacy_no , l.legacy_name_kor, l.legacy_content "
					+ "from tbl_palace p, tbl_legacy l where p.legacy_no = l.legacy_no";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int palaceNo = rs.getInt("palace_no");
				int legacyNo = rs.getInt("legacy_no");
				String legacyName = rs.getString("legacy_name_kor");
				String legacyContant = rs.getString("legacy_content");

				temp.add(new Palace(palaceNo, legacyNo, legacyName, legacyContant));
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

	public int insert(Connection conn, Palace palace) {

		try {
			String sql = "insert into tbl_palace (palace_no, legacy_no) values (?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, palace.getPalaceNo());
			pstmt.setInt(2, palace.getLegacyNo());

			int result = pstmt.executeUpdate();

			pstmt.close();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
