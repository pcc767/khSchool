package com.kh.ex05.typecasting;

public class TypeCasting {
	
	//종류 2가지
	// 1. 자동 형변환 : 작은 수에서 큰 수로 갈때, 아무 문제 없고, Cast를 명시하지 않아도 된다.  -> 묵시적 형변환 
	// 2. 강제 형변환 : 큰 수에서 작은 수로 갈때, 데이터 손실이 발상(큰 문제), Cast를 "반드시" 명시  -> 명시적 형변환
	// 3. Cast 문법 : (type)변수명;
	
	public static void main(String[] args) {
		byte val = 100;
		val = (byte)123; // 묵시적 형변환이 되는 상황에서 명시적으로 cast문 작성한 코드 -> 문제 발생
//		val = 4000;	// Type mismatch 발생
		val = (byte)4000;	// overflow 발생
		
		System.out.println(val);
		
		// 의도한 강제형변환 문법 1. 소수점 버리기!
		int value1 = 0;
		double value2 = 3.14;
		value1 = (int)value2;
		System.out.println(value1);
		
		// 의도한 강제형변화 문법 2 . 문자열 형변환
		char ch = 'A';
		int alpha = ch;
		System.out.println(alpha);
		System.out.println((char)alpha); // 강제형변화
		System.out.println((char)++alpha); // 강제형변화
		System.out.println((char)++alpha); // 강제형변화
		System.out.println((char)++alpha); // 강제형변화
		System.out.println((char)(alpha-'A'+'a'));
	}



}
