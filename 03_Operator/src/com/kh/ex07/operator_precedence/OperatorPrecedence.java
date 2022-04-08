package com.kh.ex07.operator_precedence;

public class OperatorPrecedence {
	//연산자 우선순위
	public static void main(String[] args) {
		// 1. 사직연산 우선순위
		System.out.println(1+2*3);
		
		// 2. 단항연산자 우선순위
		int a = 10;
		System.out.println(++a * 10);
		
		// 3. 산술 논리 복합될때
		System.out.println(3+4>5);
		System.out.println(3+4==5);
		System.out.println((3+4)==5);  // 괄호를 통해 우선순위를 명시적으로 사용!!	
		
		// 결론 : 복잡해지면 괄호 사용!!!!!
	}
}
