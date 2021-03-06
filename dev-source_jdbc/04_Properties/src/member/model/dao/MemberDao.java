package member.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDao {
	private Properties prop = null;
	
	public MemberDao() {
		prop = new Properties();
		try {
			FileReader fr = new FileReader("resources/member-query.properties");
			prop.load(fr);
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> selectAll(Connection conn) {
		List<Member> list = new ArrayList<Member>();
		try {
//			String sql = "SELECT * FROM MEMBER ORDER BY ENROLL_DATE DESC";
			String sql = prop.getProperty("selectAll");

			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
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

	public Member selectOne(Connection conn, String memberId) {
		Member m = null;
		try {
//			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
			String sql = prop.getProperty("selectOne");

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			ResultSet rs = pstmt.executeQuery();
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
	
	public List<Member> selectByName(Connection conn, String name) {
		List<Member> list = new ArrayList<Member>();
		try {
//			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE ?"; // ??????,?????? keyword ??????
			String sql = prop.getProperty("selectByName");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// like ?????? ???, '%?????????%'?????? ????????? ??????, ????????? ???????????? ????????? ?????? ??????!
			pstmt.setString(1, "%"+name+"%");

			ResultSet rs = pstmt.executeQuery();
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

	public int insertMember(Connection conn, Member member) {
		try {
//			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			String sql = prop.getProperty("insert");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getHobby());
//			pstmt.setString(10, member.getEnrollDate()); // ????????? sysdate??? ???????????? ?????? ??????
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int updateMember(Connection conn, Member member) {
		try {
//			String sql = "UPDATE MEMBER SET PASSWORD = ?, EMAIL = ?, PHONE = ?, "
//									+ "ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
			String sql = prop.getProperty("updateMember");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
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

	public int deleteMember(Connection conn, String memberId) {
		try {
//			String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
			String sql = prop.getProperty("delete");
			PreparedStatement pstmt = conn.prepareStatement(sql); 
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
