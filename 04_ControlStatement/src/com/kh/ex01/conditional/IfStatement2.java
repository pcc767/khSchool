package com.kh.ex01.conditional;

import java.util.Scanner;

public class IfStatement2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���ڸ� �Է��ϼ��� : ");
		int value = sc.nextInt();
		
		//��� , 0 , �������� �Ǻ�
		
		if(value >= 1) {
			System.out.println("��� �Դϴ�.");
		} else if (value == 0) {
			System.out.println("0�Դϴ�.");
		} else {
			System.out.println("�����Դϴ�.");
		}
		
		// 100, 1000, 1000���� �۰ų� , 10000���� ū �� ����
		if(value < 100) {
			System.out.println("100���� �۽��ϴ�.");
		} else if (value < 1000) {
			System.out.println("1000���� �۽��ϴ�.");
		} else if (value < 10000) {
			System.out.println("10000���� �۽��ϴ�.");
		} else{
			System.out.println("10000���� Ů�ϴ�.");
		}
		
		// ���ǽ��� ����� ��� ���� ������ ū ���� ���ǽ� ó��.(ū������ �� ��� �������� ���ǹ��� ���õ��� ����)
		// ū ������ �� ��� &&������ ���  -> ����õ.
//		if(value > 10000) {
//			System.out.println("10000���� Ů�ϴ�.");
//		} else if (value <= 10000 && value > 1000) {
//			System.out.println("10000���� �۽��ϴ�.");
//		} else if (value <= 1000 && value > 100 ) {
//			System.out.println("1000���� �۽��ϴ�.");
//		} else {
//			System.out.println("100���� �۽��ϴ�.");
//		}
		

		
		// ��� : ������ �����Ѹ� ����ϰ� ©�� �ְ�, ���� �߸��Ǹ� ���ǹ��� ����������.
			
		
		
		
		
	}

}
