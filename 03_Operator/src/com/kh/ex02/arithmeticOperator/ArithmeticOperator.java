package com.kh.ex02.arithmeticOperator;

public class ArithmeticOperator {
	// ��� ������ + - / * %
	// Arithmetic �ܿ���~
	
	public static void main(String[] args) {
		
		int a = 100;
		int b = 2;
		int c = 0;
		
		System.out.println("��Ģ����");
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a/3);  //int�� 3
		System.out.println(a/3.0);  // �Ҽ��� ǥ����� 1
		System.out.println(a/(double)3);  // �Ҽ��� ǥ����� 2
		
		// by zero error
//		System.out.println(a/0); // java.lang.ArithmeticException �߻�
		
		System.out.println("��ⷯ ����(%)");
		c = 10%3;  // ������ ���� = 1
		System.out.println(c);
		c=10%2; // ¦������ Ȯ���Ҷ�
		c=9%3; // ������� Ȯ��
		
		// if������ ¦�� ���͸�
		c=8;
		if(c % 2 == 0) {
			System.out.println(c+" �� ¦�� �Դϴ�");
		} else {
			System.out.println(c+" �� Ȧ�� �Դϴ�.");
		}
		
		
		// ���� + �Ǽ� ����Ҷ� ������.
		// : ��Ģ����� type�� ũ�Ⱑ ū������ �ڵ�����ȯ �ȴ�.
		// double>float>long>int>short>byte
		
		float pi = 3.14f; // long���� ũ��
		double x = 1.2345678912;
		int i =10;
		
		System.out.println(pi+i);
		System.out.println(pi+x);
		System.out.println(pi+(float)x);
		
		

		
		
		
		
		
	}
}
