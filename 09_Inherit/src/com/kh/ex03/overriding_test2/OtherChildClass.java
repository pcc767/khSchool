package com.kh.ex03.overriding_test2;

import com.kh.ex03.overriding_test.SuperClass;

public class OtherChildClass extends SuperClass {
	// 외부 클래스 상속 테스트
	
	// 결과 : private, final, default 상속 불가

	
	// ★ public 추천 ★
	@Override
	public void publicMethod() {
		// TODO Auto-generated method stub
		super.publicMethod();
	}

	//비추
	@Override
	protected void protectedMethod() {
		// TODO Auto-generated method stub
		super.protectedMethod();
	}

	
	
	
}
