package dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vo.ParkVO;

public class ParkDAO {
	private String query;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<ParkVO> selectAll(Connection con) {
		
		List<ParkVO> list = new ArrayList<>();

		try {
			query = "SELECT * FROM TBL_PARK";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int count = 1;
				int mgntNum = rs.getInt(count++);
				String pkNam = rs.getString(count++);
				String addr = rs.getString(count++);
				String pkCnt = rs.getString(count++);
				String tponNum = rs.getString(count++);
				String tenMin = rs.getString(count++);
				String ftDay = rs.getString(count++);
				String ftMon = rs.getString(count++);
				String svcSrtTe = rs.getString(count++);
				String svcEndTe = rs.getString(count++);
				String satSrtTe = rs.getString(count++);
				String satEndTe = rs.getString(count++);
				String hldSrtTe = rs.getString(count++);
				String hldEndTe = rs.getString(count++);

				ParkVO info = new ParkVO(mgntNum, pkNam, addr, pkCnt, tponNum, tenMin, ftDay,
						ftMon, svcSrtTe, svcEndTe, satSrtTe, satEndTe, hldSrtTe, hldEndTe);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public List<ParkVO> searchByPkName(Connection con, String parkName) { 

		List<ParkVO> list = new ArrayList<>();

		try {
			query = "SELECT * FROM TBL_PARK WHERE PARK_NAME LIKE ?"; 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + parkName + "%");
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int count = 1;
				int mgntNum = rs.getInt(count++);
				String pkNam = rs.getString(count++);
				String addr = rs.getString(count++);
				String pkCnt = rs.getString(count++);
				String tponNum = rs.getString(count++);
				String tenMin = rs.getString(count++);
				String ftDay = rs.getString(count++);
				String ftMon = rs.getString(count++);
				String svcSrtTe = rs.getString(count++);
				String svcEndTe = rs.getString(count++);
				String satSrtTe = rs.getString(count++);
				String satEndTe = rs.getString(count++);
				String hldSrtTe = rs.getString(count++);
				String hldEndTe = rs.getString(count++);

				ParkVO info = new ParkVO(mgntNum, pkNam, addr, pkCnt, tponNum, tenMin, ftDay,
						ftMon, svcSrtTe, svcEndTe, satSrtTe, satEndTe, hldSrtTe, hldEndTe);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public List<ParkVO> searchByPkAdd(Connection con, String parkAdd) {
		
		List<ParkVO> list = new ArrayList<>();
		
		try {
			query = "SELECT * FROM TBL_PARK WHERE PARK_ADD LIKE ?"; 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + parkAdd + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int count = 1;
				int mgntNum = rs.getInt(count++);
				String pkNam = rs.getString(count++);
				String addr = rs.getString(count++);
				String pkCnt = rs.getString(count++);
				String tponNum = rs.getString(count++);
				String tenMin = rs.getString(count++);
				String ftDay = rs.getString(count++);
				String ftMon = rs.getString(count++);
				String svcSrtTe = rs.getString(count++);
				String svcEndTe = rs.getString(count++);
				String satSrtTe = rs.getString(count++);
				String satEndTe = rs.getString(count++);
				String hldSrtTe = rs.getString(count++);
				String hldEndTe = rs.getString(count++);

				ParkVO info = new ParkVO(mgntNum, pkNam, addr, pkCnt, tponNum, tenMin, ftDay,
						ftMon, svcSrtTe, svcEndTe, satSrtTe, satEndTe, hldSrtTe, hldEndTe);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	public int insert(Connection con, ParkVO park) {
		
		try {
			query = "INSERT INTO TBL_PARK VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			int count = 1;
			pstmt.setInt(count++, park.getMgntNum());
			pstmt.setString(count++, park.getPkNam());
			pstmt.setString(count++, park.getAddr());
			pstmt.setString(count++, park.getPkCnt());
			pstmt.setString(count++, park.getTponNum());
			pstmt.setString(count++, park.getTenMin());
			pstmt.setString(count++, park.getFtDay());
			pstmt.setString(count++, park.getFtMon());
			pstmt.setString(count++, park.getSvcSrtTe());
			pstmt.setString(count++, park.getSvcEndTe());
			pstmt.setString(count++, park.getSatSrtTe());
			pstmt.setString(count++, park.getSatEndTe());
			pstmt.setString(count++, park.getHldSrtTe());
			pstmt.setString(count++, park.getHldEndTe());
			
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
		}
		return -1;
	}
}
