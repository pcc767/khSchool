package com.kh.ex04.access_modifier2;

import com.kh.ex04.access_modifier.AccessModifier;

//상속된 클래스
public class ExtendsTestAccessModifier extends AccessModifier{
	
	public void testMethod() {
		publicValue = 1;		// public ok
		protectedValue = 2;	// protected ok -> 상속 전용 접근자
//		defaultValue = 3;		// default 안된다. -> 외부 패키지 접근 불가
//		privateValue = 4;		// fail!
	}
	

}
