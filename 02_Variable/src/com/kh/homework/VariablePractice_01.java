package com.kh.homework;

import java.util.Scanner;

public class VariablePractice_01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		String gen = null;
		int age = 0;
		int tall = 0;
		
		System.out.println("�̸��� �Է��ϼ���.");
		name = sc.nextLine();
		
		System.out.println("������ �Է��ϼ���.");
		gen = sc.nextLine();
		
		System.out.println("���̸� �Է��ϼ���.");
		age = Integer.parseInt(sc.nextLine());
		
		System.out.println("Ű�� �Է��ϼ���.");
		tall = Integer.parseInt(sc.nextLine());
		
		System.out.println();
		System.out.println("Ű "+tall+"cm�� "+age+"��"+" "+gen+" "+name+"�� �ݰ����ϴ�.");
		
		
		
	}

}
