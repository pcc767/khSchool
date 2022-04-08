package com.kh.ex02.reference;

public class ReferenceVariable {
	
	// ������(Reference Type)
	// ���� ���� ���� �ʰ�, �ּҸ� ����ġ�� �ּ� ���� ���� ����
	// ��ü�� �����ҽ� ��ü�� heap�� ������ �Ǵµ�, �� Heap�� �ִ� ��ü�� �����ϱ� ���Ͽ� ����� ��.
	// �а� ��� : indirect / �����̶�� ǥ������ ���
	// �������� �ּҰ��� �����ϴ� �������� ���� �޸��� �ּ� ũ�⸦ ���µ�, OS - 32bit / 64bit
	
	// ������=Class �� Ư¡(�⺻���� �ٸ�)
	// 1. �⺻���� ������ �ڹ��� ��� ������ �������̴�.
	// 2. �������� Ÿ���� �빮�ڷ� �����Ѵ�. (����ڰ� ���� ������(class)�� ���� �����ϳ� �� ����)
	// 3. �������� null�� �ʱ�ȭ �����ϴ�.
	// 4. �������� ��κ� new�� ���� �����ϰ� heap�� ����ȴ�.
	//    -> ���� new�� ���� ���� ���� Ŭ������ �ִ�.
	// 5. ��� �������� Object�� ����Ѵ�. ( Object�� ��� Ŭ������ �θ��̴�.)
	
	public static void main(String[] args) {
		String str1 = null;
		String str2 = "�ȳ��ϼ���~~!!"; // ���ڿ��� Ư���ϰ� new�� �Ƚᵵ ��������.
		String str3 = new String("�ȳ��ϼ���~~!!");
		
		Integer intval1 = null;
		Integer intval2 = 31;
		Integer intval3 = new Integer(31);  // deprecated = ���� ���� �������� ����.
		
		Object obj = new Object();
		System.out.println(obj.hashCode());
		System.out.println(intval2.hashCode());
		System.out.println(str2.hashCode());
		
		
	}
}
