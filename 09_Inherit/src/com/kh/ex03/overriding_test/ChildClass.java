package com.kh.ex03.overriding_test;

public class ChildClass extends SuperClass{
	// ���� �����ں��� ��� �ǽ�
	// ��� : private, final ��� �Ұ�!

	@Override
	public void publicMethod() {
		
		super.publicMethod();
	}

	@Override
	protected void protectedMethod() {
		
		super.protectedMethod();
	}
	
//	@Override
//	public void protectedMethod() {		// �θ��� �޼ҵ庸�� ���������� ������ �а� ���� ����
//		
//		super.protectedMethod();
//	}

	@Override
	void defaultMethod() {
		
		super.defaultMethod();
	}
	
	


}
