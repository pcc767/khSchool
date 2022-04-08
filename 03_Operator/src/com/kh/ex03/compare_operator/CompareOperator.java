package com.kh.ex03.compare_operator;

public class CompareOperator {
	
	// �� ������
	public static void main(String[] args) {
		int a = 100;
		int b = 200;
		
		System.out.println(a == b);  // ������
		System.out.println(a != b);  // �ٸ���		
		System.out.println("---------------------------");
		
		// ���ڿ� �� .. ���� : �ſ� �����. immutable
		System.out.println("���ڿ� ��");
		String str1 = "������";
		String str2 = "������";
		String str3 = new String("������");
		
		System.out.println(str1 == str2);  //true
		System.out.println(str1 == str3);  //false
		
		// String �񱳽ÿ��� �׻� ����. "==" ���� �ȵǰ� 
		// ���ڿ� �񱳴� "equals" �޼ҵ� ���
		System.out.println(str1.equals(str2));  // true
		System.out.println(str1.equals(str3));  // true
		
		
		// ���ڿ� �����ϴ��� Ȯ���ϴ� �Լ� = contains
		str3 = new String("����");
		System.out.println(str1.contains(str2));  // "������"���� "������" Ȯ��
		System.out.println(str1.contains(str3));  // "������"���� "����" Ȯ��
	}

}
