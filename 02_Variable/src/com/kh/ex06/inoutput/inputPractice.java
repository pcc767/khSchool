package com.kh.ex06.inoutput;

import java.util.Scanner;

public class inputPractice {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ���ڿ� �Է¹ޱ�
		System.out.println("���ڿ��� �Է� �ٶ��ϴ�.");
		String str = sc.nextLine();
		System.out.println(str);
		
//		// ���� �Է¹ޱ�
//		System.out.println("���ڸ� �Է� �ٶ��ϴ�.");
//		int value = sc.nextInt();
//		System.out.println(value);
//		
//		// �Ǽ� �Է¹ޱ�
//		System.out.println("�Ǽ��� �Է� �ٶ��ϴ�.");
//		double value2 = sc.nextDouble();
//		System.out.println(value2);

		// ���� �Է¹ޱ�
		System.out.println("���ڸ� �Է� �ٶ��ϴ�.");
		str = sc.nextLine();
		int value3 = Integer.parseInt(str); // parseInt : ���ڿ��� ���ڷ� ��ȯ�ϴ� �Լ�
		System.out.println(value3);
		
		// �Ǽ� �Է¹ޱ�
		System.out.println("�Ǽ��� �Է� �ٶ��ϴ�.");
		str = sc.nextLine();
		double value4 = Double.parseDouble(str); // parseDouble : ���ڿ��� �Ǽ��� ��ȯ�ϴ� �Լ�
		System.out.println(value4);
		
	}

}
