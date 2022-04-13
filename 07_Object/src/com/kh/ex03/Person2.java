package com.kh.ex03.object_app;

public class Person2 {
	// Person�� ����� �� ���� -> ǥ��
	// ValueObject : VO�� �а�, �����͸� �ִ� ��ü�� ǥ����, ��� ���� + getter, setter + ��Ÿ(toString)
	// ValueObject�� ��ü������ ��������� private���� ���� ���� �Ѵ�.
	// ���� : �ܺο��� ���� ������ �������� �ʰ�, getter/setter�� ����� ����.
	
	private String name;
	private int age;
	private String phoneNum;
	private String pId;
	
	// ���� ���� ������.
	public Person2() {
		name = "�̸� ����";		
	}
	
	// ���� �ִ� ������ ����� ��
	// 1. ��������, ���ú����� �̸��� ����ġ -> �������� ������� ����.
//	public Person2(String _name, int _age, String _phoneNum, String _pId) {
//		// ��ü�� �����ҋ� ��������� �ʱⰪ�� �޾� �Է��ϴ� ������
//		name = _name;
//		age = _age;
//		phoneNum = _phoneNum;
//		pId = _pId;
//
//	}
	
	//���� �ִ� ������ ����� �� -> �������� ��õ
	public Person2(String name, int age, String phoneNum, String pId) {
		// ��ü�� �����ҋ� ��������� �ʱⰪ�� �޾� �Է��ϴ� ������
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.pId = pId;
		
	}
	
	// getter - �̸��� read only�� ���
	public String getName() {
		return name;
	}
	
	// setter - ��ȭ��ȣ - Write only�� ���� �����ϰԲ�
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String toString() {
		String result = "";
		result = result +  "�̸� : "+name+"\n";
		result = result +  "���� : "+age+"\n";		
		result += "��ȭ��ȣ : "+phoneNum+"\n";
		result += "�ֹι�ȣ : "+pId+"\n";
		return result;
	}
	
	
	
}