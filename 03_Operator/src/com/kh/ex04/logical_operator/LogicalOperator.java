package com.kh.ex04.logical_operator;

public class LogicalOperator {
	//�� ������
	//��ȣ�� ���������� ����ص� ���� ����!!!!!!!
	
	public static void main(String[] args) {
		boolean x = true;
		boolean y = false;
		boolean z = true;
		
		System.out.println(x && y);		// AND ���� - �Ѵ� ���϶��� ��.
		System.out.println(x || y);		// OR ���� - ���߿� �ϳ��� ���̸� ��.
		System.out.println(x && y && z);		// 3�� AND ���� ����
		System.out.println(x || y || z);		// 3�� OR ���� ����
		
		System.out.println(x || y && z);		// 3�� ���� ���� ���� (���� �켱���� && > ||)
		System.out.println((x || y) && z);		// 3�� ����� ()�� �켱���� ����.
		System.out.println("---------------------------------");
		
		// �� ������
		int a = 100;
		int b = 50;
		System.out.println(a>b);
		System.out.println(a<b);
		System.out.println(a>=100);
		System.out.println(a<=100);
		System.out.println("----------------------------------");
		
		// �� ������ ����
		int c= 70;
		//c �� a���� �۰�, b���� ū��
//		System.out.println(c<a>b);  // �� ������(true, false)�� ������ �񱳴� �ȵȴ�.
		System.out.println(c < a && c > b);		// �̷������� ���!!!!

		// ��������.
		// a�� 50���� ũ��, 150���� ������
		System.out.println(a>50 && a<150 );
		// b�� 20�̻�, 100�̸��ΰ�?
		System.out.println(b>=20 && b<100);
		
		
		
		
		
		
		
	}

}
