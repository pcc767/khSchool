package seoul.legacy.controller;

import seoul.legacy.model.service.UserService;
import seoul.legacy.model.vo.User;

public class UserController {

	// 1. 로그인
	// 2. 로그아웃
	// 3. 개인 정보 조회 - toString으로 대체
	// 4. 로그인 상태 설정

	// 1. User service 호출

	private UserService us = new UserService();

	private static User loginUser = null; // 로그인 유저 객체로 저장

	// 1. 로그인
	public boolean login(String id, String pw) {
		User user = us.selectById(id); // user 테이블 안에 id 검색(dao → service)
		if (user == null) { // id가 없는 경우에 null을 반환한다 (dao 확인)
			return false; // login 실패
		}

		if (user.getUserPw().equals(pw)) {// pw 검사
			loginUser = user;
			return true; // pw가 db 안에 pw랑 같으면 로그인 성공
		}
		return false; // 뭔가 모종의 이유로 오류나면 실패
	}

	// 2. 로그아웃
	public static void logOut() {
		loginUser = null; // loginUser를 null로 바꿔줘서 로그인 user data를 없도록 만들어줌
	}

//	4. 로그인 상태 설정
	public static User getLoginUser() {
		return loginUser;// 로그인 유저 data를 객체로 반환해줌
	}

	public boolean addUser(User user) { // 회원 가입
		return us.insert(user) > 0 ? true : false;
	}

	public boolean checkId(String id) { // 중복 검사
		User user = us.selectById(id);
		return user == null ? true : false;
	}

	// ---=== 끝 ===---
}
