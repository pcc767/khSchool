package com.kh.ex02.user_exception;

public class UseException {
	
	public static void main(String[] args) {
		String userID = "test";
		String userPW = "1234";
		
		String inputID = "test123";
		String inputPW = "1234";
		
		try {
			if(userID.equals(inputID) == false) {
				throw new LoginException("아이디가 맞지 않습니다.");
				// throw를 만나면 return과 같은 효과 발생
			}
			if(userPW.equals(inputPW) == false) {
				throw new LoginException("비밀번호가 맞지 않습니다.");
			}
			System.out.println("로그인 성공");
			
		} catch (LoginException e) {
			System.out.println("로그인 예외처리부");
			e.printStackTrace();
		} finally {
			// 주요 자원을 정리하는 곳.
			inputID = null;
			inputPW = null;
			System.out.println("자원이 정리되었습니다.");
		}
		
		
	}

}
