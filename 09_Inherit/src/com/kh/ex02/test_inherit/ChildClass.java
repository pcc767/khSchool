package com.kh.ex02.test_inherit;

public class ChildClass extends SuperClass{
	private int privateValue = 105;		// 밖에서 생성 불가
	protected int protectedValue = 110;
	public int publicValue = 120;
	
	
	public ChildClass() {
		super();	// 부모의 생성자 호출, 생략해도 자동으로 생성시켜준다.
					// 생성 순서 : 부무의 클래스 생성 -> 자식의 클래스가 생성.
		System.out.println("ChildClass의 생성자입니다.");
		
		int publicValue = 300;
	
		// 본인의 멤버 변수 출력
		System.out.println("My privateValue : "+this.privateValue);
		System.out.println("My protectedValue : "+this.protectedValue);
		System.out.println("My publicValue : "+this.publicValue);
		System.out.println("Local publicValue : "+publicValue);
		
		// 부모의 멤버변수 출력
		System.out.println("My privateValue : "+super.getPrivateValue());
		System.out.println("My protectedValue : "+super.protectedValue);
		System.out.println("My publicValue : "+super.publicValue);
		
	}
	
	@Override
	public void publicMethod() {
		System.out.println("ChidClass의 publicMethod입니다.");
		super.publicMethod();	// 강제로 부모의 메소드를 호출하는 방법, 없어도 된다.!!
	}
	
	

}
