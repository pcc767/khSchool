package seoul.legacy.model.dao;

import static seoul.legacy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import seoul.legacy.model.vo.Facility;

public class FacilityDAO {

	public Facility selectOnebyfNo(Connection conn, int fNo) {
		Facility temp = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			String sql = "select p_facility_no, palace_no, p_facility_detail_no, "
					+ "p_facility_name_kor, p_facility_name_eng, p_facility_name_jpa, p_facility_name_chi, "
					+ "p_facility_content, p_facility_content_eng, p_facility_content_jpa, p_facility_content_chi "
					+ "from tbl_palace_facility where p_facility_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				// getInt(String str);
				int facialityNO = rs.getInt("p_facility_no");
				int detailNo = rs.getInt("p_facility_detail_no");
				int palaceNo = rs.getInt("palace_no");
				String nameKor = rs.getString("p_facility_name_kor");
				String nameEng = rs.getString("p_facility_name_eng");
				String nameJpa = rs.getString("p_facility_name_jpa");
				String nameChi = rs.getString("p_facility_name_chi");
				String contentKor = rs.getString("p_facility_content");
				String contentEng = rs.getString("p_facility_content_eng");
				String contentJpa = rs.getString("p_facility_content_jpa");
				String contentChi = rs.getString("p_facility_content_chi");

				temp = new Facility(facialityNO, detailNo, palaceNo, nameKor, nameEng, nameJpa, nameChi, contentKor,
						contentEng, contentJpa, contentChi);
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

	public List<Facility> selectAll(Connection conn, int pNo) {
		List<Facility> temp = new ArrayList<>();

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			String sql = "select " + "p_facility_no, p_facility_detail_no, palace_no, "
					+ "p_facility_name_kor, p_facility_name_eng, p_facility_name_jpa, p_facility_name_chi, "
					+ "p_facility_content, p_facility_content_eng, p_facility_content_jpa, p_facility_content_chi "
					+ "from tbl_palace_facility " + "where palace_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				int facialityNO = rs.getInt("p_facility_no");
				int detailNo = rs.getInt("p_facility_detail_no");
				int palaceNo = rs.getInt("palace_no");
				String nameKor = rs.getString("p_facility_name_kor");
				String nameEng = rs.getString("p_facility_name_eng");
				String nameJpa = rs.getString("p_facility_name_jpa");
				String nameChi = rs.getString("p_facility_name_chi");
				String contentKor = rs.getString("p_facility_content");
				String contenteng = rs.getString("p_facility_content_eng");
				String contentjpa = rs.getString("p_facility_content_jpa");
				String contentchi = rs.getString("p_facility_content_chi");

				temp.add(new Facility(facialityNO, detailNo, palaceNo, nameKor, nameEng, nameJpa, nameChi, contentKor,
						contenteng, contentjpa, contentchi));
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

	public int insert(Connection conn, Facility Facility) {

		try {
			String sql = "insert into tbl_palace_facility (p_facility_no, palace_no, p_facility_detail_no, "
					+ "p_facility_name_kor, p_facility_name_eng, p_facility_name_jpa, "
					+ "p_facility_name_chi, p_facility_content, p_facility_content_eng, p_facility_content_jpa, p_facility_content_chi) "
					+ "values (?,?,?, ?,?,?,?, ?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int count = 1;
			pstmt.setInt(count++, Facility.getFacialityNO());
			pstmt.setInt(count++, Facility.getPalace_no());
			pstmt.setInt(count++, Facility.getP_faciality_detail_no());
			pstmt.setString(count++, Facility.getP_facility_name_kor());
			pstmt.setString(count++, Facility.getP_facility_name_eng());
			pstmt.setString(count++, Facility.getP_facility_name_jpa());
			pstmt.setString(count++, Facility.getP_facility_name_chi());
			pstmt.setString(count++, Facility.getP_facility_content());
			pstmt.setString(count++, Facility.getP_facility_content_eng());
			pstmt.setString(count++, Facility.getP_facility_content_jpa());
			pstmt.setString(count++, Facility.getP_facility_content_chi());

			int result = pstmt.executeUpdate();

			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
