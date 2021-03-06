package com.kh.ex02.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementBasic {
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public static String driverClass = "oracle.jdbc.OracleDriver";
	public static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static String user = "student";
	public static String password = "student";
	
	public static void main(String[] args) {
		try {
			// 1. 클래스 드라이버 등록 (최초 1회만 해야하고, 요새는 안해도 되지만 명시적으로 둠)
			Class.forName(driverClass);
			System.out.println("1. 드라이버 등록 성공");
			
			// 2. Connection 객체 생성 (url=ip+port+이름, id, password)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2. DB 접속 및 로그인 성공!");
			
			// 3. 자동 커밋여부 설정 : true(기본값), false(옵션) ->  사용자가 트랜잭션 제어 필요!
			conn.setAutoCommit(false);
			
			
			// 사용자 쿼리 작성부!
			select();
			
			System.out.println("selectONE 호출!!");
			Member member = selectOne("user77");
			System.out.println(member +" \n");
			

			member = new Member(
					"test12", "1234", "홍길동", "M", 32, 
					"test@gmail.com", "01012345678", 
					"서울시 강남구 역삼로", 
					"축구", null);
			
			insert(member);
			select();
			
			update("김길동", member.getMemberId());
			select();
			
			delete(member.getMemberId());
			select();
			
			// 5. commit 처리 수행
//			conn.commit();
			conn.rollback(); // 실패시 롤백
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 예외 발생시 롤백처리!
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			// 6. 생성된 객체 Close
			//  -> 생성된 객체의 역순으로 Close 수행!
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
	}

	private static Member selectOne(String id) throws SQLException {
		// 반만 완성된 쿼리를 준비한다. -> ?를 향후 다른 TEXT로 교체될 부분
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? ORDER BY ? DESC";
		pstmt = conn.prepareStatement(sql); // 쿼리를 준비상태로 셋팅하는 문장, 실행X
		
		// ※ 주의 pstmt의 index의 시작은 1부터 시작한다! 만약 0부터 시작하면 에러 발생! 
		pstmt.setString(1, id); // '?' 첫번째 자리에 'id'로 대처하는 문장
		pstmt.setString(2, "ENROLL_DATE"); // '?' 두번째 자리에 'ENROLL_DATE'로 대처하는 문장!
	
//		rs = pstmt.executeQuery(sql); // 이렇게 쓰면 절대 안된다!!! -> sql 초기화된다.
		rs = pstmt.executeQuery();
		Member m = null;
		if(rs.next()) { // rs는 반드시 1회 실행 이후 결과값을 가져올수 있다!
			// *로 가져올 경우 TABLE의 선언 순으로 컬럼이 배치된다.
			int count = 1;
			String memberId 			= rs.getString(count++); // index는 1부터 시작!
			String password             = rs.getString(count++);
			String memberName           = rs.getString(count++);
			String gender               = rs.getString(count++);
			int age                     = rs.getInt(count++);
			String email                = rs.getString(count++);
			String phone                = rs.getString(count++);
			String address              = rs.getString(count++);
			String hobby                = rs.getString(count++);
			java.sql.Date enrollDate    = rs.getDate(count++);
			m = new Member(memberId, password, memberName, gender, age, email, phone, address, hobby, enrollDate);
		}
		pstmt.close();
		rs.close();
		return m;
	}

	private static void select() throws SQLException {
		System.out.println("\nSELECT문 시작!!");

		String sql = "SELECT * FROM MEMBER"; // 문자열 뒤 세미클론 주의!
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(); // 실제 DB로 쿼리를 요청하는 문장
		
		while (rs.next()) {
			// 모든 데이터는 문자열로 가져올수 있다!
			// -> 필요시 변환이 필요하다.
			StringBuffer sb = new StringBuffer();
			sb.append(rs.getString(1)+", "); // index로 가져올수 있다. -> 컬럼의 생성 순!
//			sb.append(rs.getString("MEMBER_ID")+", ");
			sb.append(rs.getString("PASSWORD")+", ");
			sb.append(rs.getString("MEMBER_NAME")+", ");
			sb.append(rs.getString("GENDER")+", ");
			sb.append(rs.getInt("AGE")+", "); // 숫자로 받을때
			sb.append(rs.getString("EMAIL")+", ");
			sb.append(rs.getString("PHONE")+", ");
			sb.append(rs.getString("ADDRESS")+", ");
			sb.append(rs.getString("HOBBY")+", ");
			sb.append(rs.getDate("ENROLL_DATE")+", "); // java.sql.Date
			System.out.println(sb.toString());
		}
		rs.close();
		pstmt.close();
		System.out.println("SELECT문 종료\n");
	}

	private static void insert(Member member) throws SQLException {
		System.out.println("\nInsert문 시작!!");
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		pstmt = conn.prepareStatement(sql);
		
		System.out.println(member);
		// ※ 주의 insert문은 Type이 맞지 않은 경우 Error가 발생!
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getPassword());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, member.getGender());
		pstmt.setInt(5, member.getAge());
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getPhone());
		pstmt.setString(8, member.getAddress());
		pstmt.setString(9, member.getHobby());
//		pstmt.setString(10, member.getEnrollDate()); // 날짜는 sysdate로 입력하는 것을 권장
		
		int result = pstmt.executeUpdate();
		System.out.println(result > 0 ? "업데이트 성공" : "업데이트 실패!");
		System.out.println("Insert문 종료\n");
		
		
	}
	
	
	private static void update(String newName, String mId) throws SQLException {
		System.out.println("\nUpdate문 시작!!");
		String sql = "UPDATE MEMBER SET member_name = ? WHERE member_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newName);
		pstmt.setString(2, mId);
		
		int result = pstmt.executeUpdate();
		
		System.out.println(result > 0 ? "업데이트 성공" : "업데이트 실패!");
		System.out.println("Update문 종료\n");
	}
	
	
	private static void delete(String mId) throws SQLException {
		System.out.println("\ndelete문 시작!!");
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mId);
		int result = pstmt.executeUpdate();
		
		System.out.println(result > 0 ? "업데이트 성공" : "업데이트 실패!");
		System.out.println("delete문 종료\n");
	}
	
}

