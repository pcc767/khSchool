package member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

public class MemberDao {
//	--------------------------------------------------------------------------------------------------------------
	public final static String driverClass = "oracle.jdbc.OracleDriver";
	public final static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static String user = "student";
	public final static String password = "student";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDao() {
		try {
//			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null && rs.isClosed() == false) {
				rs.close();
			}
			if(pstmt != null && pstmt.isClosed() == false) {
				pstmt.close();
			}
			if(conn != null && conn.isClosed() == false) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	--------------------------------------------------------------------------------------------------------------

	public List<Member> selectAll() {
		List<Member> list = new ArrayList<Member>();
		try {
			String sql = "SELECT * FROM MEMBER ORDER BY ENROLL_DATE DESC";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;
				String memberId = rs.getString(count++);
				String password = rs.getString(count++);
				String memberName = rs.getString(count++);
				String gender = rs.getString(count++);
				int age = rs.getInt(count++);
				String email = rs.getString(count++);
				String phone = rs.getString(count++);
				String address = rs.getString(count++);
				String hobby = rs.getString(count++);
				java.sql.Date enrollDate = rs.getDate(count++);
				Member m = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
				list.add(m);
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Member selectOne(String memberId) {
		Member m = null;
		try {
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;
				String memberId2 = rs.getString(count++);
				String password = rs.getString(count++);
				String memberName = rs.getString(count++);
				String gender = rs.getString(count++);
				int age = rs.getInt(count++);
				String email = rs.getString(count++);
				String phone = rs.getString(count++);
				String address = rs.getString(count++);
				String hobby = rs.getString(count++);
				java.sql.Date enrollDate = rs.getDate(count++);
				m = new Member(memberId2, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public List<Member> selectByName(String name) {
		List<Member> list = new ArrayList<Member>();
		try {
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE ?"; // 제목,문장 keyword 검색
			pstmt = conn.prepareStatement(sql);
			// like 쓰는 법, '%홍길동%'으로 만드는 방법, 키워드 검색할때 이렇게 쓰면 된다!
			pstmt.setString(1, "%"+name+"%");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int count = 1;
				String memberId = rs.getString(count++);
				String password = rs.getString(count++);
				String memberName = rs.getString(count++);
				String gender = rs.getString(count++);
				int age = rs.getInt(count++);
				String email = rs.getString(count++);
				String phone = rs.getString(count++);
				String address = rs.getString(count++);
				String hobby = rs.getString(count++);
				java.sql.Date enrollDate = rs.getDate(count++);
				Member m = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
				list.add(m);
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insertMember(Member member) {
		try {
			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getHobby());
//			pstmt.setString(10, member.getEnrollDate()); // 날짜는 sysdate로 입력하는 것을 권장
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int updateMember(Member member) {
		try {
			String sql = "UPDATE MEMBER SET PASSWORD = ?, EMAIL = ?, PHONE = ?, "
									+ "ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getHobby());
			pstmt.setString(6, member.getMemberId());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int deleteMember(String memberId) {
		try {
			String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, memberId);
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
