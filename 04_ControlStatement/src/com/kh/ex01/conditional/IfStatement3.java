package com.kh.ex01.conditional;

import java.util.Scanner;

public class IfStatement3 {
	
	// �ڵ� ��
	// ���ܸ� ���� if + return�� ������ �ϰ�, �������� ��Ȳ�� ���� �Ʒ��� ó���ϴ� ������� ����
	// ���� : �ڵ� ���⵵�� �پ���.
	
	public static void main(String[] args) {
		// �α��� ���
		// ID�� �Է� �ް� 3���� �̸��̸� "ID�� ª���ϴ�." -> ����
		// PW�� �Է� �ް� 8���� �̸��̸� ����, PW�� ID�� ���� �Ǿ� ������ ����.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� �Է����ּ��� : ");
		String id = sc.nextLine();
		
		if(id.length()<3) {
			System.out.println("���̵� ª���ϴ�.");
			return; // main method�� ������ Ű����
		}
		
		System.out.println("�н����带 �Է����ּ��� : ");
		String pw = sc.nextLine();
		
//		if(pw.length()<8) {
//			System.out.println("�н����尡 ª���ϴ�.");
//			return;
//		}
//		
//		if(pw.contains(id) == true) {
//			System.out.println("�н����忡 ���̵� ���ԵǾ� �ֽ��ϴ�.");
//			return;
//		}
		
		// �� �ּ� �ΰ��� �ѹ��� ó���Ҽ� �ִ�.
		if(pw.length()<8 || pw.contains(id) == true) {
			System.out.println("�н����尡 ª�ų�, �н����忡 ���̵� ���ԵǾ� �ֽ��ϴ�.");
			return;
		}
		//�α��� ����
		System.out.println(" - �α��ο� �����Ͽ����ϴ�. ���̵� : "+id);
		

	
			
	}
	
	
	
	
	
}
