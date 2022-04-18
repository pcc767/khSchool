package com.kh.ex01.string_basic;

public class StringConstruct {

	public static void main(String[] args) {
		
		// String 사용 Tip
		// 1. String의 저장소는 Heap과 String constant pool 두가지가 있다.
		// 2. String constant pool을 사용하는 것이 메모리 관리측면에서 유리하다.
		// 3. String은 new 생성하지 않는다. // Heap을 생으로 사용하지 않는다.

		
		//String Pool Test
		String str1 = "Test String";
		String str2 = new String("Test String");
		String str3 = str2.toString();
		String str4 = str2.intern();
		
		System.out.println(str1.hashCode()); // 객체를 유일하게 식별하기 위한 대표값
		System.out.println(str2.hashCode()); // 1/42억
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		
		// equals는 hashCode기반으로 비교가 된다.
		System.out.println("-------equals--------");
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str4));
		System.out.println("---------------------");

		// ==는 메모자의 주소값으로 비교한다.
		System.out.println("------- ==(비교) ------");
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);
		System.out.println("---------------------");
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		// 문자열 초기화 방법(강사 추천 문법)
		String temp = ""; //공백으로 초기화
		temp += "123"+","+"홍길동";
		System.out.println(temp);

		
		
		
		
	}

}
