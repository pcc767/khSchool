package com.kh.ex03.overriding_test2;

import com.kh.ex03.overriding_test.SuperClass;

public class OtherChildClass extends SuperClass {
	// �ܺ� Ŭ���� ��� �׽�Ʈ
	
	// ��� : private, final, default ��� �Ұ�

	
	// �� public ��õ ��
	@Override
	public void publicMethod() {
		// TODO Auto-generated method stub
		super.publicMethod();
	}

	//����
	@Override
	protected void protectedMethod() {
		// TODO Auto-generated method stub
		super.protectedMethod();
	}

	
	
	
}
