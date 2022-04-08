package com.kh.ex03.run_object;


import com.kh.ex03.object_app.Person;  // import���� ���� �ش� class�� ����ϴ� ��� => �̰� ǥ��
import com.kh.ex03.object_app.*; 		// *�� ���ϵ�ī��� �ش� ��Ű���� �ش��ϴ� ��� Ŭ������ ����Ʈ

public class Run {
	public static void main(String[] args) {
		Person person = new Person();	//��ü �����ϴ� ��
		System.out.println(person.name);	// default �����ڿ��� "�̸� ����"���� �ʱ�ȭ ��
		System.out.println(person.age);		// 0
		System.out.println(person.phoneNum);	// null
		System.out.println(person.Pid);			//	null
		System.out.println("--------------------------------------");
		
		//������� �����ϴ� ��
		person.name = "ȫ�浿";
		System.out.println(person.name);
		System.out.println("--------------------------------------");
		
		//setter, getter�� ���ؼ� �����ϴ� ��  -> �޼ҵ� ���� ����
		person.setName("�ֱ浿");
		System.out.println(person.getName());
		System.out.println("--------------------------------------");
		
		Person2 person2 = new Person2("��浿", 31, "010-0000-0000", "910290-0000000");
		System.out.println(person2.getName());		
		System.out.println(person2.toString());
//		person2.name = "�ڱ浿" // �ȵ� private�� ���Ƽ�
		person2.setPhoneNum("010-3445-5555");
		System.out.println(person2.toString());
		
		
		
		
//		Person2 person2 = null;
	}

}
