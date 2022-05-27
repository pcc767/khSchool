package member.model.service;

// static import : static 메소드를 자기 메소드처럼 활용할수 있는 문법.
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import member.model.dao.MemberDao;
import member.model.vo.Member;


// MemberService2 Connection pool Ver.
public class MemberService2 {
	/**
	 * Service의 역할
	 * 1. 다중 DAO를 관리하여 필요한 데이터의 입출력을 DAO간 결합하여 서비스를 제공함
	 *    ex) Join문, 다중쿼리, 다중 트랜잭션 관리
	 * 
	 * 2. DB 상태, 접속 관리
	 *   - 생성, Connection 관리, 종료
	 */
	
	private MemberDao memberDao = new MemberDao();
	
	private List<Connection> connList = null; // connection pool
	private final static int CONNECTION_MAX_SIZE = 5;	// 속도 유지 (직렬보다 병렬로 사용)
	private static int conIndex = 0;

	
	public MemberService2() {
		init();
	}
	
	private void init() {	//초기화 함수
		allClose();
		connList = new ArrayList<Connection>();
		for (int i = 0; i < CONNECTION_MAX_SIZE; i++) {
			connList.add(openConnection());
		}
		conIndex = 0;
		
	}
	
	private void allClose() {
		if(connList != null) {
			for(Connection conn : connList) {
				close(conn);
			}
		}
	}

	public Connection getConnection() {
		if(conIndex >= CONNECTION_MAX_SIZE) {
			conIndex = 0;
		}
		return connList.get(conIndex);
	}
	
	@Override
	// 객체가 소멸될때 불러오는 메소드
	protected void finalize() throws Throwable {
		allClose();
	}
	
	// Connection 관리 코드부 끝-
	//	-----------------------------------------------------------------------------------------------
	

	public List<Member> selectAll() {
		Connection conn = getConnection();
		return memberDao.selectAll(conn);
	}

	public Member selectOne(String memberId) {
		return memberDao.selectOne(getConnection(), memberId);
	}

	public List<Member> selectByName(String memberName) {
		return memberDao.selectByName(getConnection(), memberName);
	}


	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = memberDao.insertMember(conn, member);
		
		if(result > 0) {		// insert 성공!
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = memberDao.updateMember(conn, member);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = memberDao.deleteMember(conn, memberId);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}


}
