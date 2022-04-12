package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.model.MemberController;

public class MemberMenu {
	
	private static Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("�ִ� ��� ������ ȸ�� ���� 10���Դϴ�.");
		System.out.println("���� ��ϵ� ȸ�� ����"+mc.existMemberNum()+"���Դϴ�.");
		if(mc.existMemberNum() != 10) {
			System.out.println("1. �� ȸ�� ���");
			System.out.println("2. ȸ�� �˻�");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. ��� ���");
			System.out.println("9. ������");
			System.out.println("�Է��� �޴� : ");
			int inputNum = Integer.parseInt(sc.nextLine());
			
			switch(inputNum) {
				
			case 1 :
				insertMember();
				break;
			case 2 :
				searchMember();
				break;
			case 3 :
				updateMember();
				break;
			case 4 :
				deleteMember();
				break;
			case5 :
				printAll();
				break;
			case9 :
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default :
				System.out.println("��ȣ�� �� �� �ԷµǾ����ϴ�.");	
				
			}	
			
		}
		
		if(mc.existMemberNum() == 10) {			
			System.out.println("2. ȸ�� �˻�");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. ��� ���");
			System.out.println("9. ������");
			System.out.println("�Է��� �޴� : ");
			int inputNum = Integer.parseInt(sc.nextLine());
			
			switch(inputNum) {			
		
			case 2 :
				searchMember();
				break;
			case 3 :
				updateMember();
				break;
			case 4 :
				deleteMember();
				break;
			case5 :
				printAll();
				break;
			case9 :
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default :
				System.out.println("��ȣ�� �� �� �ԷµǾ����ϴ�.");	
				
			}	
			
		}
	}

	public void insertMember() {
		
		
	}

}
