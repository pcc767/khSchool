package com.kh.ex01.conditional;

import java.util.Scanner;

public class SwitchStatement2 {
	//�������� �Է¹ޱ�  -> ABCDEF
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������� �Է��ϼ��� : ");
		char grade = sc.nextLine().charAt(0);  // �տ� �ѱ��� ��������!
		
		switch(grade) {
		case 'A' :
		case 'a' :
			System.out.println("A���� �Դϴ�.");
			break;
		case 'B' :
		case 'b' :
			System.out.println("B���� �Դϴ�.");
			break;
		case 'C' :
		case 'c' :
			System.out.println("C���� �Դϴ�.");
			break;
		case 'D' :
		case 'd' :
			System.out.println("D���� �Դϴ�.");
			break;
		default :
			System.out.println("F���� �Դϴ�.");
			break;
			
			
		}
		
	}


}
