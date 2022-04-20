package com.kh.ex01.exception;

import java.io.IOException;

public class UseThrows {
	
	//throws : 예외가 발생하면 호출한 메소드에게 예외의 책임을 전가하는 키워드
	// 		   단, main에서 발생시 프로그램 종료를 의미
	
	//thorw : 예외를 만들어서 던지는 키워드.
	
	public static void method() throws IOException {
		System.out.println("TEST1");
		if(true)
			throw new IOException("TEST");
		System.out.println("TEST2"); // 예외 발생시 아래에 문장은 실행되지 않음.
	}

	
	public static void main(String[] args) throws IOException {
		method();
	}

}
