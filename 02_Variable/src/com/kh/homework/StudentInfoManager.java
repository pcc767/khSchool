package com.kh.homework;

import java.util.Scanner;

public class StudentInfoManager {
	
	// �л����� ���� ���α׷��Դϴ�.
	// �л��� �̸�, ����, �ּ�, �г�, ����(�Ҽ��� ���� ����) �Է� �޾��ּ���.
	// ��� ������ �Է¹����� ����ϴ� ����� ����� �ּ���.
	// ������ ���� �Է��Ҽ� �ִ� Interface�� �ۼ����ּ���.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��Ͻÿ� : ");
		String name = sc.nextLine();
		
		System.out.print("���̸� �Է��Ͻÿ� : ");
		int age = Integer.parseInt(sc.nextLine());
		
		
		
		System.out.print("�ּҸ� �Է��Ͻÿ� : ");
		String add = sc.nextLine();

		System.out.print("�г��� �Է��Ͻÿ�(ex : x): ");
		int grade = Integer.parseInt(sc.nextLine());
		
		System.out.print("������ �Է��Ͻÿ� : ");
		double grade2 = Double.parseDouble(sc.nextLine());
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(add);
		System.out.println(grade);
		System.out.println(grade2);

		
		
		
		
		
		
	}

}
