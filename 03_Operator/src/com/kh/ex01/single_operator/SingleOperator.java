package com.kh.ex01.single_operator;

public class SingleOperator {
	//단항 연산자
	public static void main(String[] args) {
		// 1. not(!) 연산자 = 논리값 Toggle용
		boolean isTrue = true;
		
		System.out.println(isTrue);
		System.out.println(!isTrue);
		System.out.println(!!isTrue);
		
		isTrue = !isTrue;
		System.out.println(isTrue);
		System.out.println("-------------------------------");
		
		// 2. 증감 연산자 ++, --
		// 전위증감연산자, 후위증감연산자 -> 중요
		
		int a= 10;
		System.out.println("a++");
		System.out.println(a++);
		System.out.println(a);

		System.out.println("++a");
		System.out.println(++a);
		System.out.println(a);
		
		
		System.out.println("a--");
		System.out.println(a--);
		System.out.println(a);

		System.out.println("--a");
		System.out.println(--a);
		System.out.println(a);
		
		
		
		
	}

}
