package com.kh.ex07.operator_precedence;

public class OperatorPrecedence {
	//������ �켱����
	public static void main(String[] args) {
		// 1. �������� �켱����
		System.out.println(1+2*3);
		
		// 2. ���׿����� �켱����
		int a = 10;
		System.out.println(++a * 10);
		
		// 3. ��� �� ���յɶ�
		System.out.println(3+4>5);
		System.out.println(3+4==5);
		System.out.println((3+4)==5);  // ��ȣ�� ���� �켱������ ��������� ���!!	
		
		// ��� : ���������� ��ȣ ���!!!!!
	}
}
