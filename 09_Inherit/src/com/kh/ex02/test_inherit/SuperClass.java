package com.kh.ex02.test_inherit;


// 부모(조상) 클래스
public class SuperClass {
	private int privateValue = 5;		// 밖에서 생성 불가	
	protected int protectedValue = 10;
	public int publicValue = 20;
	
	public SuperClass() {				// Construct
		System.out.println("SuperClass의 생성자 입니다.");
	}
	
	public void publicMethod() {
		System.out.println("SuperClass의 publicMethod 입니다.");
	}

	public int getPrivateValue() {
		return privateValue;
	}

	public void setPrivateValue(int privateValue) {
		this.privateValue = privateValue;
	}
	
	
	

	
}
