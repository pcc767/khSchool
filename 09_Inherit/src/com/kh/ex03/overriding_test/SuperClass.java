package com.kh.ex03.overriding_test;

public class SuperClass {
	// ���� ������ ���� Override �ǽ�

	private void privateMethod() {
		System.out.println("privateMethod");
	}

	public void publicMethod() {
		System.out.println("publicMethod");
	}

	protected void protectedMethod() {
		System.out.println("protectedMethod");
	}

	public final void finalMethod() {
		System.out.println("finalMethod");
	}

	void defaultMethod() {
		System.out.println("defaultMethod");
	}

}
