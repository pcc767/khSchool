package com.kh.ex02.test_inherit;

public class ChildClass extends SuperClass{
	private int privateValue = 105;		// �ۿ��� ���� �Ұ�
	protected int protectedValue = 110;
	public int publicValue = 120;
	
	
	public ChildClass() {
		super();	// �θ��� ������ ȣ��, �����ص� �ڵ����� ���������ش�.
					// ���� ���� : �ι��� Ŭ���� ���� -> �ڽ��� Ŭ������ ����.
		System.out.println("ChildClass�� �������Դϴ�.");
		
		int publicValue = 300;
	
		// ������ ��� ���� ���
		System.out.println("My privateValue : "+this.privateValue);
		System.out.println("My protectedValue : "+this.protectedValue);
		System.out.println("My publicValue : "+this.publicValue);
		System.out.println("Local publicValue : "+publicValue);
		
		// �θ��� ������� ���
		System.out.println("My privateValue : "+super.getPrivateValue());
		System.out.println("My protectedValue : "+super.protectedValue);
		System.out.println("My publicValue : "+super.publicValue);
		
	}
	
	@Override
	public void publicMethod() {
		System.out.println("ChidClass�� publicMethod�Դϴ�.");
		super.publicMethod();	// ������ �θ��� �޼ҵ带 ȣ���ϴ� ���, ��� �ȴ�.!!
	}
	
	

}
