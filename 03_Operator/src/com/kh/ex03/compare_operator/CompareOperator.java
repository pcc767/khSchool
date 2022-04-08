package com.kh.ex03.compare_operator;

public class CompareOperator {
	
	// 비교 연산자
	public static void main(String[] args) {
		int a = 100;
		int b = 200;
		
		System.out.println(a == b);  // 같은지
		System.out.println(a != b);  // 다른지		
		System.out.println("---------------------------");
		
		// 문자열 비교 .. 주의 : 매우 어려움. immutable
		System.out.println("문자열 비교");
		String str1 = "가나다";
		String str2 = "가나다";
		String str3 = new String("가나다");
		
		System.out.println(str1 == str2);  //true
		System.out.println(str1 == str3);  //false
		
		// String 비교시에는 항상 주의. "==" 쓰면 안되고 
		// 문자열 비교는 "equals" 메소드 사용
		System.out.println(str1.equals(str2));  // true
		System.out.println(str1.equals(str3));  // true
		
		
		// 문자열 포함하는지 확인하는 함수 = contains
		str3 = new String("가나");
		System.out.println(str1.contains(str2));  // "가나다"에서 "가나다" 확인
		System.out.println(str1.contains(str3));  // "가나다"에서 "가나" 확인
	}

}
