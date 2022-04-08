package com.kh.ex01.basic_object;

public class BasicObject {
	
	//Object��?
	// - ��� class�� ����(�θ�)�� Ŭ����
	// - ��� ��ü�� Type�� ��ü�Ҽ� �ִ� Type
	// - Class = ��ü = ���������� Type
	
	public static void main(String[] args) {
		// Type ������ = (��ü�� �����ϴ� ���� = new)
		Object object = new Object();
		System.out.println(object.toString());
		
		//Type ������ = (��ü������)
		String str = new String("Test");
		Object object2 = str;
		
		System.out.println(str.length());
		//System.out.println(object2.lenght());	//�ȵȴ� object���� ������ �ʴ� �޼ҵ� ȣ��
		System.out.println(((String)object2).length());
		
		System.out.println(object.toString());		//Object�� �ִ� toString�� ȣ��
		System.out.println(str.toString());			// String�� �ִ� toString�� ȣ��
		
	}
}
