package com.kh.ex05.assignment_operation;

public class AssignmentOperator {
	
	// ���� ������
	public static void main(String[] args) {
		// ���� �������� ����(assign)���
		int a = 10;
		int b = 10;
		
		a = a+10;
		System.out.println(a);
		
		b += 10;		// ���� ǥ���� �������� ��ġ�ϴ�.
		System.out.println(b);
		
		b += 10;
		System.out.println(b);
		
		b =+ 10;  		// ���� + ���⿡ ���� ���� �ٸ���.
		System.out.println(b);
		
		// �� alt+shift+a : selection mode
		
		// ��Ģ����
		b += 10;
		b -= 10;
		b *= 10;
		b /= 10;
		b %= 10;
		
		// �߸��� ��Ģ���� �� ����
		b =+ 10;		// b=(+10)
		b =- 10;		// b=(-10)
		b =* 10;
		b =/ 10;
		b =% 10;
	}

}
