package com.kh.ex04.access_modifier2;

import com.kh.ex04.access_modifier.AccessModifier;

public class TestAccessModifier2 {
	public static void main(String[] args) {
		//AccessModifier 와 같은 페키지에서 멤버 변수 접근 테스트!
		
		AccessModifier test = new AccessModifier();
		
		test.publicValue = 1;		// public ok -> 어디서든 접근 가능
//		test.protectedValue = 2;	// protected NG
//		test.defaultValue = 3;		// default NG
//		test.privateValue = 4;		// fail!
	}

}
