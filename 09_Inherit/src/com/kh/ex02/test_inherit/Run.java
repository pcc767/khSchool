package com.kh.ex02.test_inherit;

public class Run {
	
	public static void main(String[] args) {
		System.out.println("SuperClass ����");
		new SuperClass();
		System.out.println("SuperClass ���� ��");
		
		System.out.println("ChildClass ����");
		new ChildClass().publicMethod();		
		System.out.println("ChildClass ���� ��");
		
	}

}
