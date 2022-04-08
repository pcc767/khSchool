package com.kh.ex01.basic_object;

public class BasicObject {
	
	//Object란?
	// - 모든 class의 조상(부모)인 클래스
	// - 모든 객체의 Type을 대체할수 있는 Type
	// - Class = 객체 = 변수에서의 Type
	
	public static void main(String[] args) {
		// Type 변수명 = (객체를 생성하는 문장 = new)
		Object object = new Object();
		System.out.println(object.toString());
		
		//Type 변수명 = (객체생성문)
		String str = new String("Test");
		Object object2 = str;
		
		System.out.println(str.length());
		//System.out.println(object2.lenght());	//안된다 object에서 가지지 않는 메소드 호출
		System.out.println(((String)object2).length());
		
		System.out.println(object.toString());		//Object에 있는 toString을 호출
		System.out.println(str.toString());			// String에 있는 toString을 호출
		
	}
}
