package com.kh.ex04.logical_operator;

public class LogicalOperator {
	//논리 연산자
	//괄호는 습관적으로 사용해도 문제 없음!!!!!!!
	
	public static void main(String[] args) {
		boolean x = true;
		boolean y = false;
		boolean z = true;
		
		System.out.println(x && y);		// AND 연산 - 둘다 참일때만 참.
		System.out.println(x || y);		// OR 연산 - 둘중에 하나라도 참이면 참.
		System.out.println(x && y && z);		// 3항 AND 연산 가능
		System.out.println(x || y || z);		// 3항 OR 연산 가능
		
		System.out.println(x || y && z);		// 3항 복합 연산 가능 (연산 우선순위 && > ||)
		System.out.println((x || y) && z);		// 3한 연산시 ()로 우선순위 선택.
		System.out.println("---------------------------------");
		
		// 비교 연산자
		int a = 100;
		int b = 50;
		System.out.println(a>b);
		System.out.println(a<b);
		System.out.println(a>=100);
		System.out.println(a<=100);
		System.out.println("----------------------------------");
		
		// 비교 연산자 응용
		int c= 70;
		//c 는 a보다 작고, b보다 큰가
//		System.out.println(c<a>b);  // 논리 연사자(true, false)와 숫자의 비교는 안된다.
		System.out.println(c < a && c > b);		// 이런식으로 사용!!!!

		// 연습문제.
		// a는 50보다 크고, 150보다 작은가
		System.out.println(a>50 && a<150 );
		// b는 20이상, 100미만인가?
		System.out.println(b>=20 && b<100);
		
		
		
		
		
		
		
	}

}
