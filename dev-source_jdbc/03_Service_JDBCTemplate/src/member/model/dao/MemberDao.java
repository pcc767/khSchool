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
	/**
	
	DAO 설계 지침
	1. 기본적으로 관련 Table과 1:1 매핑하는게 일반 설계
	   단, 종속관계인 경우 1:2 매핑도 가능(join)
	   
	2. Table 간의 정보 결합이 필요한 경우 (Join문 작성할때) 가이드
	   1) Join문을 주 데이터가 많은 Dao를 지정하여 설계 // 마이바티스 구조
	     ex) Member + job이 될때는 Member가 주 데이터 임으로 MemberDAO에 구현
	   
	   2) 별도의 Dao를 생성하여 결합문(Join)만 설계하는 기법 // 하이버네티스 JPA
	     ex) MemberJobDao
	     
	   3) Join문을 활용하지 않고 DAO 별로 SELECT를 여러번 하는 방법 ★★★★★
	     ex) MemberDao.select() -> jobDao.select()
	     대프로젝트용 꼼수. -> 시간이 없거나.
	       -> 최적화는 나중에....
	       
	 3. 쿼리 외의 부가기능은 서비스나 JDBC Template로 이관 
	
	■ 프로젝트용 꼼수 -> 나중에 안되고 급할때 사용.
	   1) 제약조건을 모두 해제한다.
	   2) 기본적인 쿼리문구만 사용하여 구현한다. -> join문 금지.
	   
	*/

//	--------------------------------------------------------------------------------------------------------------
	
	
	
	
//	--------------------------------------------------------------------------------------------------------------

	public List<Member> selectAll(Connection conn) {
		List<Member> list = new ArrayList<Member>();
		try {
			String sql = "SELECT * FROM MEMBER ORDER BY ENROLL_DATE DESC";
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
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
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
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE ?"; // 제목,문장 keyword 검색
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// like 쓰는 법, '%홍길동%'으로 만드는 방법, 키워드 검색할때 이렇게 쓰면 된다!
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
			String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
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
//			pstmt.setString(10, member.getEnrollDate()); // 날짜는 sysdate로 입력하는 것을 권장
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int updateMember(Connection conn, Member member) {
		try {
			String sql = "UPDATE MEMBER SET PASSWORD = ?, EMAIL = ?, PHONE = ?, "
									+ "ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
			
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
			String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
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
