package com.kh.ex02.arithmeticOperator;

public class ArithmeticOperator {
	// 산술 연산자 + - / * %
	// Arithmetic 외워둬~
	
	public static void main(String[] args) {
		
		int a = 100;
		int b = 2;
		int c = 0;
		
		System.out.println("사칙연산");
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a/3);  //int라서 3
		System.out.println(a/3.0);  // 소수점 표현방법 1
		System.out.println(a/(double)3);  // 소수점 표현방법 2
		
		// by zero error
//		System.out.println(a/0); // java.lang.ArithmeticException 발생
		
		System.out.println("모듈러 연산(%)");
		c = 10%3;  // 나머지 연산 = 1
		System.out.println(c);
		c=10%2; // 짝수인지 확일할때
		c=9%3; // 배수인지 확인
		
		// if문으로 짝수 필터링
		c=8;
		if(c % 2 == 0) {
			System.out.println(c+" 는 짝수 입니다");
		} else {
			System.out.println(c+" 는 홀수 입니다.");
		}
		
		
		// 정수 + 실수 사용할때 주의점.
		// : 사칙연산시 type의 크기가 큰쪽으로 자동형변환 된다.
		// double>float>long>int>short>byte
		
		float pi = 3.14f; // long보다 크다
		double x = 1.2345678912;
		int i =10;
		
		System.out.println(pi+i);
		System.out.println(pi+x);
		System.out.println(pi+(float)x);
		
		

		
		
		
		
		
	}
}
