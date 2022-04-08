package com.kh.ex01.conditional;

import java.util.Scanner;

public class IfStatement3 {
	
	// 코딩 팁
	// 예외를 먼저 if + return을 필터일 하고, 정상적인 상황을 가장 아래로 처리하는 방법으로 구성
	// 장점 : 코드 복잡도가 줄어든다.
	
	public static void main(String[] args) {
		// 로그인 기능
		// ID를 입력 받고 3글자 미만이면 "ID가 짧습니다." -> 실패
		// PW를 입력 받고 8글자 미만이면 실패, PW에 ID가 포함 되어 있으면 실패.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요 : ");
		String id = sc.nextLine();
		
		if(id.length()<3) {
			System.out.println("아이디가 짧습니다.");
			return; // main method를 끝내는 키워드
		}
		
		System.out.println("패스워드를 입력해주세요 : ");
		String pw = sc.nextLine();
		
//		if(pw.length()<8) {
//			System.out.println("패스워드가 짧습니다.");
//			return;
//		}
//		
//		if(pw.contains(id) == true) {
//			System.out.println("패스워드에 아이디가 포함되어 있습니다.");
//			return;
//		}
		
		// 위 주석 두개를 한번에 처리할수 있다.
		if(pw.length()<8 || pw.contains(id) == true) {
			System.out.println("패스워드가 짧거나, 패스워드에 아이디가 포함되어 있습니다.");
			return;
		}
		//로그인 성공
		System.out.println(" - 로그인에 성공하였습니다. 아이디 : "+id);
		

	
			
	}
	
	
	
	
	
}
