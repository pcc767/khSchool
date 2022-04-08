package com.kh.ex04.access_modifier;

public class TestAccessModifier {
	public static void main(String[] args) {
		//AccessModifier 와 같은 페키지에서 멤버 변수 접근 테스트!
		
		AccessModifier test = new AccessModifier();
		
		test.publicValue = 1;		// public ok
		test.protectedValue = 2;	// protected ok
		test.defaultValue = 3;		// default ok
//		test.privateValue = 4;		// fail! -> The field AccessModifier.privateValue is not visible
		
	}
	
}
