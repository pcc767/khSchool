package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	MemberController mc = new MemberController();
	public static Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.println("���� ��ϵ� ȸ������ "+mc.existMemberNum()+"�� �Դϴ�.");
		
		System.out.println("1. �� ȸ�� ���");
		System.out.println("2. ȸ�� �˻�");
		System.out.println("3. ȸ�� ���� ����");
		System.out.println("4. ȸ�� ����");
		System.out.println("5. ��� ���");
		System.out.println("9. ������");
		System.out.println("�޴� ��ȣ : ");
		int inputNum = Integer.parseInt(sc.nextLine());
		
		switch(inputNum) {
		case 1:
			insertMember();
			break;
		case 2:
			searchMember();
			break;
		case 3:
			updateMember();
			break;
		case 4 : 
			deleteMember();
			break;
		case 5 :
			printAll();
			break;
		case 9 :
			System.out.println("���α׷� ����.");
			return;
		default :
			System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���");
			break;
		}		
	}
	
	public void insertMenber() {
		System.out.println("�� ȸ���� ����մϴ�.");
		String id = null;
		while(true) {
			System.out.println("���̵� : ");
			id = sc.nextLine();
			if (mc.checkId(id) == false) {
				System.out.println("������ ���̵��Դϴ�.");				
				break;
			}
			else
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է��� �ּ���.");
		}		
		System.out.println("�̸� : ");
		String name = sc.nextLine();
		System.out.println("��й�ȣ : ");
		String password = sc.nextLine();
		System.out.println("�̸��� : ");
		String email = sc.nextLine();
		char gender;
		while(true) {
			System.out.println("���� : ");
			gender = sc.nextLine().toUpperCase().charAt(0);
			if(gender	)
			
		}
			
		System.out.println("���� : ");
		int age = Integer.parseInt(sc.nextLine());
	}
	
	
}
