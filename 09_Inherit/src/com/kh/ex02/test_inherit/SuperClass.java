package com.kh.ex02.test_inherit;


// �θ�(����) Ŭ����
public class SuperClass {
	private int privateValue = 5;		// �ۿ��� ���� �Ұ�	
	protected int protectedValue = 10;
	public int publicValue = 20;
	
	public SuperClass() {				// Construct
		System.out.println("SuperClass�� ������ �Դϴ�.");
	}
	
	public void publicMethod() {
		System.out.println("SuperClass�� publicMethod �Դϴ�.");
	}

	public int getPrivateValue() {
		return privateValue;
	}

	public void setPrivateValue(int privateValue) {
		this.privateValue = privateValue;
	}
	
	
	

	
}
