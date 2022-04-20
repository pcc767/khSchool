package com.kh.ex02.user_exception;


// 사용자 예외, 로그인이 실패한 경우 발생하는 예외를 정의
public class LoginException extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	private String cause;
	
	public LoginException(String cause) {
		this.cause = cause;		
	}
	
	@Override
	public void printStackTrace() {
		System.out.println("로그인에 실해하였습니다.");
		System.out.println("원인 : "+ cause);		
		super.printStackTrace();
	}
	
	

}
