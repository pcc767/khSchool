package com.kh.ex03.object_app;


// ��ü��? ���� ����� �߻�ȭ�� ������ + �޼ҵ�
// person -> �� ����� ���������� �߻�ȭ���� ���� ��
public class Person {
	
	//����� - ��� ���� �����ϴ� ��
	public String name;
	public int age;
	public String phoneNum;
	public String Pid;
	
	// �����ڶ�?
	// - ��ü�� �����ɶ� ȣ��Ǵ� Ư���� �޼ҵ�
	// - �뵵 : ��ü�� ��������� �ʱ�ȭ �ϰų� �ʱ�ȭ�� �ʿ��� �޼ҵ带 ȣ���Ҷ�
	public Person() {		// ������
		name = "�̸� ����";
	}
	
	//setter - wrint only(���� ����)
	public void setName(String name) {		// ������������ �Ķ���� name
		this.name = name;					// ������� name = �������� �Ķ���� name
	}
	
	//getter - read only(�б� ����)
	public String getName() {
		return name;
	}

	
	
	
	
	
}

