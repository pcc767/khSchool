package com.kh.ex01.conditional;

public class IfStatement1 {
	// if문
	// if(조건식1) {
	//      (조건식 1이 참일대 실행되는 문장)
	// } else if(조건식2) {
	//      (조건식 2가 참일때 실행되는 문장)
	// }
	// else {
	// (모든 조건이 해당되지 않을때 실행되는 문장)
	// }
	
	// 조합 1 : if
	// 조합 2 : if - else
	// 조합 3 : if - else if - else
	// 조합 4 : if - else if
	
	public static void main(String[] args) {
		int a = 7;
		
		//기본적인 if문 스타일
		if(a % 2 == 0) {
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("홀수 입니다.");
		}
		
		// c언어 스타일(old 스타일)  -> 추천 X
		if(a % 2 == 0) 
		{
			System.out.println("짝수 입니다.");
		} 
		else 
		{
			System.out.println("홀수 입니다.");
		}
		
		
		// 중괄호 없이도 if문을 사용 가능 -> if문이나 else문 아래 한줄만 실행  -> 추천 X
		if(a % 2 == 0)		
			System.out.println("짝수 입니다.");		
		else 		
			System.out.println("홀수 입니다.");	
			
		
		
	}
	
}
