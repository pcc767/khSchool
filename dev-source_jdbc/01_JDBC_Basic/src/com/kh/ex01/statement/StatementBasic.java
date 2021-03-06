package com.kh.ex01.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementBasic {
	// close 메모리 고갈될수 있고 (메모리 릭(leak)), close 안 할시 컴퓨터 다운됨.(무조건 사용)
	// executeQuery, executeUpdate 차이점
	// executeQuery  : result set을 만드는 sql문에서 사용하며, 주로 select문을 수행할때 사용됩니다.
	// executeUpdate : insert나 update와 같은 ddl이나 dml을 실행할때 사용됩니다.
//						반환값이 int이며, 실행된 쿼리 갯수만큼 반환.
	
	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;		// 출력을 위한 객체
	
	public static String driverClass = "oracle.jdbc.OracleDriver";
	public static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static String user = "student";
	public static String password = "student";
	
	public static void main(String[] args) {
		try {
			// 1. 클래스 드라이버 등록(최초 1회만 등록하고, 요새는 안해도 되지만 명시적으로 작성함)
			Class.forName(driverClass);				// - DriverManager 클래스 생성.
			System.out.println("1. 드아이버 등록 성공");
			
			// 2. Connection 객체 생성(url(ip + port + name), id, password)
			// 	 - DB와 연결하는 객체.
			//	 - DriverManager 클래스는 JDBC 드라이버를 통하여 Connection을 만드는 역활.
			//	 - DriverManager는 Class.forName() 메소드를 통해서 생성됨.
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2. 데이터 베이스 접속 및 로그인 성공!");
			
			// 3. 자동 커밋여부 설정 : true(기본값), false(옵션) -> 사용자가 트랜젝션 제어 필요!
			conn.setAutoCommit(false);
			
			// 4. conn 객체를 통해 SQL을 DB로 요청할 수 있는 Statement 객체를 생성.
//				-Statement (java.sql.Statement)는 Connection으로 연결한 객체에게,
//				 Query 작업을 실행하기 위한 객체
			stmt = conn.createStatement();
			System.out.println("3. Statement 생성 성공!");
			
			// 사용자 쿼시 시작부!
			select();
			
			insert();			
			select();
			
			update();			
			select();
			
			delete();			
			select();
			
			
			
			
			// 5. COMMIT 처리 수행
//			conn.commit();
			conn.rollback();		// 실패시 롤백
			
			
			
			
	
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();		//예외 발생시 롤백 처리!
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			// 6. 생성된 객체 close
			// -> 생성된 객체의 역순으로 close 수행!
			try {
				if(rs != null && rs.isClosed() == false) {
					rs.close();
				}
				if(stmt != null && stmt.isClosed() == false) {
					stmt.close();
				}
				if(conn != null && conn.isClosed() == false) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
	
			}
			
			
		}
	}


	private static void select() throws SQLException {
		System.out.println("\n SELECT문 시작");
		
		String sql = "SELECT * FROM MEMBER";	// 문자열 뒤 세미클론 주의! , 실무에서는 *보다 명식적으로 추려올 컬럼 이름 명시.
		rs = stmt.executeQuery(sql);			// 실제로 db 쿼리를 요청하는 문장
		
		while (rs.next()) {
			// 모든 데이터는 문자열로 가져올수 있다.
			// -> 필요시 변환이 필요하다.
			
			StringBuffer sb = new StringBuffer();
//			sb.append(rs.getString(1)+", ");			// index로 가져올수 있다 -> 컬럼의 생성순
			sb.append(rs.getString("MEMBER_ID")+", ");	
			sb.append(rs.getString("PASSWORD")+", ");
			sb.append(rs.getString("MEMBER_NAME")+", ");
			sb.append(rs.getString("GENDER")+", ");
			sb.append(rs.getInt("AGE")+", ");
			sb.append(rs.getString("EMAIL")+", ");
			sb.append(rs.getString("PHONE")+", ");
			sb.append(rs.getString("ADDRESS")+", ");
			sb.append(rs.getString("HOBBY")+", ");
			sb.append(rs.getDate("ENROLL_DATE")+", ");	// java.sql.Date
			System.out.println(sb.toString());
		}

		
		rs.close();
		System.out.println("SELECT문 종료\n");
	}

	private static void insert() throws SQLException {
		System.out.println("\ninsert문 시작");
		
		String sql = "INSERT INTO MEMBER "
				+ " VALUES('user2','pass1234','홍길동','M', 31, 'hong333@kh.org', "
				+ " '01017778888','서울시 강남구 팔달동 77','영화,축구',SYSDATE)";
		int result = stmt.executeUpdate(sql);
		
		System.out.println(result > 0 ? "업데이트 성공" : "업데이트 실패");
		
		System.out.println("insert문 종료\n");
	}
	
	private static void update() throws SQLException {
		System.out.println("\nupdate문 시작");
		
		String sql = "UPDATE MEMBER SET member_name = '최길동' WHERE member_id = 'user2'";

		int result = stmt.executeUpdate(sql);
		
		System.out.println(result > 0 ? "업데이트 성공" : "업데이트 실패");
		
		System.out.println("update문 종료\n");
	}
	
	private static void delete() throws SQLException {
		System.out.println("\ndelete문 시작");
		
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = 'user2'";

		int result = stmt.executeUpdate(sql);
		
		System.out.println(result > 0 ? "업데이트 성공" : "업데이트 실패");
		
		System.out.println("delete문 종료\n");
	}
	
	
	
	
	
	
}
