package com.kh.ex03.overriding_test;

public class ChildClass extends SuperClass{
	// 접근 제한자별로 상속 실습
	// 결론 : private, final 상속 불가!

	@Override
	public void publicMethod() {
		
		super.publicMethod();
	}

	@Override
	protected void protectedMethod() {
		
		super.protectedMethod();
	}
	
//	@Override
//	public void protectedMethod() {		// 부모의 메소드보다 접근제한자 범위를 넓게 설정 가능
//		
//		super.protectedMethod();
//	}

	@Override
	void defaultMethod() {
		
		super.defaultMethod();
	}
	
	


}
