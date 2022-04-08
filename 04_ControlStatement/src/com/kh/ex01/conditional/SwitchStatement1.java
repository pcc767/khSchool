package com.kh.ex01.conditional;

public class SwitchStatement1 {
	public static void main(String[] args) {
		// 점수 1등급~4등급 (최하, 모든 최저점수 포함)
		// 100~81 1등급, 80~70 2등급....
		
		double score = 90.7;
		int grade = (int)(score/20);
		
		// switch(이곳에 사용 가능한 type : int, chat, String) // double(실수)은 안됨
		switch(grade) {
			case 5 : 
			case 4 : 
				System.out.println("1등급 입니다.");
				break;
			case 3 : 
				System.out.println("2등급 입니다.");
				break;
			case 2 : 
				System.out.println("3등급 입니다.");
				break;
			case 1 : 
				System.out.println("4등급 입니다.");
				break;
			default : 
				System.out.println("예외값입니다.");
			
		
		}
	}

}
