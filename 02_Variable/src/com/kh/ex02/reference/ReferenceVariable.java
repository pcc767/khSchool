package com.kh.ex02.reference;

public class ReferenceVariable {
	
	// 참조형(Reference Type)
	// 실제 값을 갖지 않고, 주소를 가르치는 주소 값을 갖는 변수
	// 객체를 생성할시 객체는 heap에 생성이 되는데, 이 Heap에 있는 객체를 접근하기 위하여 사용이 됨.
	// 학계 용어 : indirect / 간접이라는 표현으로 사용
	// 참조형의 주소값을 저장하는 공간으로 실제 메모리의 주소 크기를 갖는데, OS - 32bit / 64bit
	
	// 참조형=Class 의 특징(기본형과 다름)
	// 1. 기본형을 제외한 자바의 모든 변수는 참조형이다.
	// 2. 참조형의 타입은 대문자로 시작한다. (사용자가 만든 참조형(class)는 정의 가능하나 룰 위반)
	// 3. 잠조형은 null로 초기화 가능하다.
	// 4. 참조형은 대부분 new를 통해 생성하고 heap에 저장된다.
	//    -> 가끔 new로 생성 되지 않은 클래스도 있다.
	// 5. 모든 참조형은 Object를 상속한다. ( Object는 모든 클래스의 부모이다.)
	
	public static void main(String[] args) {
		String str1 = null;
		String str2 = "안녕하세요~~!!"; // 문자열은 특수하게 new를 안써도 생성가능.
		String str3 = new String("안녕하세요~~!!");
		
		Integer intval1 = null;
		Integer intval2 = 31;
		Integer intval3 = new Integer(31);  // deprecated = 쓰는 것을 권장하지 않음.
		
		Object obj = new Object();
		System.out.println(obj.hashCode());
		System.out.println(intval2.hashCode());
		System.out.println(str2.hashCode());
		
		
	}
}
