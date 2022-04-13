package com.kh.ex01.basic_inherit;

import java.util.Date;

public class BasicInherit /*extends Object*/{
	//��� Ŭ������ Object���� ��ӹ޾� ������ Ŭ�����̸�, Object ��� ������ ���� �����ϴ�.
	
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new String("�ȳ�?");
		Object obj3 = new Date();
		Object obj4 = new BasicInherit();
		
		// Class �� �̸� ���
		System.out.println(obj1.getClass().getName());	
		System.out.println(obj2.getClass().getName());	
		System.out.println(obj3.getClass().getName());	
		System.out.println(obj4.getClass().getName());	
		
		// Class�� ������ �˾ƺ��� ���
		System.out.println(obj1.getClass().getSuperclass());	// null : �θ� ����. �����̴ѱ�!!!!
		System.out.println(obj2.getClass().getSuperclass());	
		System.out.println(obj3.getClass().getSuperclass());	
		System.out.println(obj4.getClass().getSuperclass());	
	

	}

}
