package com.kh.ex01.single_operator;

public class SingleOperator {
	//���� ������
	public static void main(String[] args) {
		// 1. not(!) ������ = ���� Toggle��
		boolean isTrue = true;
		
		System.out.println(isTrue);
		System.out.println(!isTrue);
		System.out.println(!!isTrue);
		
		isTrue = !isTrue;
		System.out.println(isTrue);
		System.out.println("-------------------------------");
		
		// 2. ���� ������ ++, --
		// ��������������, �������������� -> �߿�
		
		int a= 10;
		System.out.println("a++");
		System.out.println(a++);
		System.out.println(a);

		System.out.println("++a");
		System.out.println(++a);
		System.out.println(a);
		
		
		System.out.println("a--");
		System.out.println(a--);
		System.out.println(a);

		System.out.println("--a");
		System.out.println(--a);
		System.out.println(a);
		
		
		
		
	}

}
