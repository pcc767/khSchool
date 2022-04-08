package com.kh.ex07.overloading;

public class Overloading {
	//메소드 오버로딩이란?
	// - 같은 메소드(함수)명이면서 다른 타입의 인자를 받아들이고 같은 기능을 동작하게끔 설계할때 사용
	
	/*메소드 오버라이딩 규칙
		  1. 메소드의 이름이 같아야한다.
	  	  2. 매개변수의 갯수가 다르거나
		  3. 매개변수의 Type(종류)가 다르거나
		  4. 매개변수의 Type 순서가 다르거나
		  5. 반환형은 무관하다. (return 을 하든 안하든 된다.)
		  6. 변수명은 무관하다. (Type으로만 판단함!)
	  */
	
	void myMethod(int arg) {
		System.out.println(arg);
	}
	
	int myMethod(int arg1, int arg2) {
		System.out.println(arg1+arg2);
		return arg1+arg2;
	}
	 
	int myMethod(String arg) {
		System.out.println(arg);
		return arg.length();
	}

	
	
	public static void main(String[] args) {
		//대표적인 오버로딩 함수 :
		System.out.println(12);
		System.out.println(3.14);
		System.out.println('a');
		System.out.println("hello");
		
		
		Overloading test = new Overloading();
		test.myMethod(12);
		test.myMethod("hello!!!");
		test.myMethod(12,14);
		
		
		
	}
	
	

}
