package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {
	// 공통부 코드를 작성
	// 1. JDBC 관련 드라이버 로드 
	// 2. connection 생성
	// 3. 객체들 close
	
	public static String driverClass;
	public static String url;
	public static String user;
	public static String password;

	static {
		try {
			Properties prop = new Properties(); // 컬랙션 중 하나! = MAP : Key, Value
			FileReader fr = new FileReader("resources/data-source.properties");
			prop.load(fr);
			fr.close();
			
			driverClass = prop.getProperty("driverClass");
			Class.forName(driverClass);
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection openConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); // 자동커밋 해제 설정
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	public static void close(Connection conn) {
		try {
			if(conn != null && conn.isClosed() == false) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null && pstmt.isClosed() == false) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null && rs.isClosed() == false) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
