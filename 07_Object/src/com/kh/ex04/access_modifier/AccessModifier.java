package com.kh.ex04.access_modifier;

// 접근 제한자
public class AccessModifier {
	public int 		publicValue;		//어디서든 사용 가능
	protected int 	protectedValue;		//상속시 부모자식간 사용가능
	int				defaultValue;		//접근제한자 생략시 default
	private	int		privateValue;		//자기 자신만 사용할 수 있는 접근제한자
	
	public void myMethod() {
		publicValue = 1;
		protectedValue = 2;
		defaultValue = 3;
		privateValue = 4;
	}
	
	
	
}
