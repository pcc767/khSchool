package com.kh.ex05.method_test;

public class TestMethod {
	public static void main(String[] args) {
		MyObject test = new MyObject();
		
		// static method 사용법 : class명칭.메소드 이름
		MyObject.staicMethod();	// ststic일때는 이텔릭체로 변함, 이게 표준적인 문법
		test.staicMethod(); 	// 생성된 객체를 통해 접근가능하나 권장하지 않음.
		
		// 하나의 인자만 적용법
		test.singleParameter("싱글 파라메터 시험~");
		
		// 여러 인자 적용
		test.multipleParameter(3, 5, "test");
		
		//리턴값 받는 메소드
		int value = test.returnValue(10, 20);
		System.out.println(value);
		
		
		
		
	}

}


class MyObject{
	
	// static 메소드 : 외부에서 클래스의 생성없이 이름으로 접근 가능한 메소드. (중요!!!)	
	public static void staicMethod() {
		System.out.println("Call static method!!!!");
	}
	
	//1개의 인자 받는 메소드(Parameter : 인자)
	public void singleParameter(String str) {
		System.out.println(str);
	}
	
	// 2개의 이상의 인자를 받을때
	protected void multipleParameter(int a, int b, String str) {
		System.out.println(a +b);
		System.out.println(str);		
	}
	
	//반환 값이 있는 메소드
	int returnValue(int a, int b) {
		return a+b;
	}
	
	
}