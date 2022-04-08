package com.kh.ex06.ternary_operator;

public class TernaryOperator {
	
	// 삼항 연산자 + if문
	public static void main(String[] args) {
		int a = 100;
		int b = 50;
		int c = 30;
		
		//삼항연산자
		//문법 : (조건) ? (참일때 실행되는 문장) : (거짓일때 실행되는 문장);
		String result = a>b ? "a가 b보다 큽니다." : "a가 b보다 작습니다.";
		System.out.println(result);
		
		// 중첩사용 -> 추천하지 않는다.!! -> 현업에서 중첩 사용하지 않는다.
		result = a>b ? (b>c ? "a가 b보다 크고 b는 c보다 큼" : "a가 b보다 크고 b는 c보다 작음") 
						: (b>c ? "a가 b보다 작고 b는 c보다 큼" : "a가 b보다 작고 b는 c보다 작음" );
		System.out.println(result);		
		
		// if문 - 실제로는 3항 연산자보다 많이 사용됨.
		// if(조건식) {조건식이 참일때 실행되는 구간}
		// else {조건식이 거짓일때 실행되는 구간}
		if(a>b)
			result = "a가 b보다 큽니다.";
		else
			result = "a가 b보다 작습니다.";
		
		System.out.println(result);
		
//		if(a>b) {
//			if(b>c) {
//				result = "a가 b보다 크고 b는 c보다 큼";
//			}else {
//				result = "a가 b보다 크고 b는 c보다 작음";
//			}
//		}else {
//			if(b>c) {
//				result = "a가 b보다 작고 b는 c보다 큼";
//			}else {
//				result = "a가 b보다 작고 b는 c보다 작음";
//			}
//		}
		
		
		if(a>b) {
			if(b>c)
				result = " a가 b보다 크고 b는 c보다 큼";
			else
				 result = "a가 b보다 크고 b는 c보다 작음";
		} else {
			if(b>c)
				result = " a가 b보다 작고 b는 c보다 큼";
			else
				 result = "a가 b보다 작고 b는 c보다 작음";
				 }
		System.out.println(result);
		
		
		
		
		
	}

}
