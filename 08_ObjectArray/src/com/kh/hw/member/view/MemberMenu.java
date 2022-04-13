package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	// Responsibility Scope : ��ü�� ���Ұ� ������ν� å������ �ϴ� ����
	
	// View�� å�� ���� (Responsibility Scope)
	// - ����ڷκ��� (G,C)UI�� �����ϰ� �Է°� �̺�Ʈ�� Controller���� �����ϰ�,
	//   ó�� ����� ����ڿ��� �����ϴ� ����
	// - View�� �Ҽ� ���� �� : UI����, ������� �Է��� �ùٸ��� Ȯ���ϴ� �� ex) ID�� ��������, PW �ڸ���..
	// - View�� �ϸ� �ȵǴ� �� : ID�� �ߺ�Ȯ��, ID/PW�� �α����� �������� Ȯ���ϴ� ��
	//                        -> Controller�� Model���� Ȯ���ؾ��ϴ� ��
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public MemberMenu() {}

	public void mainMenu() {

		while (true) {
			System.out.println("���� ��ϵ� ȸ�� ���� " + mc.existMemberNum() + "���Դϴ�.");
			System.out.print("1. �� ȸ�� ���\n2. ȸ�� �˻�\n3. ȸ�� ���� ����\n4. ȸ�� ����\n5. ��� ���\n9. ������\n�޴� ��ȣ : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
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
				case 5 :
					printAll();
					break;
				case 9 :
					System.out.println("���α׷��� �����մϴ�.");
					return;
				default :
					System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
					break;
			}
		}
	}

	public void insertMember() {
		System.out.println("�� ȸ���� ����մϴ�.");
		
		String inputId = null;
		while (true) {
			System.out.print("���̵� : ");
			inputId = sc.nextLine();

			if (mc.checkId(inputId) == false) {
				break;
			} else {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}

		System.out.print("�̸� : ");
		String inputName = sc.nextLine();

		System.out.print("��й�ȣ : ");
		String inputPassword = sc.nextLine();

		System.out.print("�̸��� : ");
		String inputEmail = sc.nextLine();

		char inputGender;
		
		while (true) {
			System.out.print("����(M/F) : ");
			inputGender = sc.nextLine().charAt(0);

			if (inputGender == 'm' || inputGender == 'M' || inputGender == 'f' || inputGender == 'F') {
				break;
			} else {
				System.out.println("������ �ٽ� �Է��ϼ���.");
			}
		}

		System.out.print("���� : ");
		int inputAge = Integer.parseInt(sc.nextLine());
		mc.insertMember(new Member(inputId, inputName, inputPassword, inputEmail, inputGender, inputAge));
	}

	public void searchMember() {

		System.out.print("1. ���̵�� �˻��ϱ�\n2. �̸����� �˻��ϱ�\n3. �̸��Ϸ� �˻��ϱ�\n9. �������� ���ư���\n�޴� ��ȣ : ");
		int menuNum = Integer.parseInt(sc.nextLine());

		switch(menuNum) {
			case 1 :
				searchId();
				break;
			case 2 :
				searchName();
				break;
			case 3:
				searchEmail();
				break;
			case 9 : 
				mainMenu();
				break;
			default :
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
		}

	}

	public void searchId() {
		System.out.print("�˻��� ���̵� : ");
		String inputId = sc.nextLine();

		Member member = mc.searchId(inputId);
		
		if (member == null) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			System.out.println("ã���� ȸ�� ��ȸ ����Դϴ�.");
			System.out.println(member.toString());
		}
	}

	public void searchName() {
		System.out.print("�˻��� �̸� : ");
		String inputName = sc.nextLine();
		Member[] array = mc.searchName(inputName);

		if (array.length == 0) {
			System.out.println("�˻� ����� �����ϴ�.");
			return;
		} 
		
		System.out.println("ã���� ȸ�� ��ȸ ����Դϴ�.");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].inform()); 
		}
	}

	public void searchEmail() {
		System.out.print("�˻��� �̸��� : ");
		String inputEmail = sc.nextLine();

		Member[] array = mc.searchEmail(inputEmail);

		if (array.length == 0) {
			System.out.println("�˻� ����� �����ϴ�.");
			return;
		} 
		
		System.out.println("ã���� ȸ�� ��ȸ ����Դϴ�.");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].inform()); 
		}
	}

	public void updateMember() {
		System.out.print("1. ��й�ȣ �����ϱ�\n2. �̸� �����ϱ�\n3. �̸��� �����ϱ�\n9. �������� ���ư���\n�޴� ���� : ");
		int menuNum = Integer.parseInt(sc.nextLine());

		if (menuNum == 1) {
			updatePassword();
		} else if (menuNum == 2) {
			updateName();
		} else if (menuNum == 3) {
			updateEmail();
		} else if (menuNum == 9) {
			System.out.println("�������� ���ư��ϴ�.");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}

	}

	public void updatePassword() {
		System.out.print("������ ȸ���� ���̵� : ");
		String inputId = sc.nextLine();
		System.out.print("������ ȸ���� ��й�ȣ : ");
		String inputPassword = sc.nextLine();

		if (mc.updatePassword(inputId, inputPassword)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}

	public void updateName() {
		System.out.print("������ ȸ���� ���̵� : ");
		String inputId = sc.nextLine();
		System.out.print("������ ȸ���� �̸� : ");
		String inputName = sc.nextLine();

		if (mc.updateName(inputId, inputName)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}

	public void updateEmail() {
		System.out.print("������ ȸ���� ���̵� : ");
		String inputId = sc.nextLine();
		System.out.print("������ ȸ���� �̸��� : ");
		String inputEmail = sc.nextLine();

		if (mc.updateEmail(inputId, inputEmail)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}

	public void deleteMember() {

		System.out.print("1. Ư�� ȸ�� �����ϱ�\n2. ��� ȸ�� �����ϱ�\n9. �������� ���ư���\n�޴� ��ȣ : ");
		int menuNum = Integer.parseInt(sc.nextLine());

		if (menuNum == 1) {
			deleteOne();
		} else if (menuNum == 2) {
			deleteAll();
		} else if (menuNum == 9) {
			System.out.println("�������� ���ư��ϴ�.");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}

	}

	public void deleteOne() {
		System.out.print("������ ȸ���� ���̵� : ");
		String inputId = sc.nextLine();

		System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) : ");
		char ch = sc.nextLine().charAt(0);

		if (ch == 'y' || ch == 'Y') {
			if (mc.delete(inputId)) {
				System.out.println("���������� �����Ǿ����ϴ�.");
			} else {
				System.out.println("�������� �ʴ� ���̵��Դϴ�.");
			}
		}
	}

	public void deleteAll() {
		System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) : ");
		char ch = sc.nextLine().charAt(0);

		if (ch == 'y' || ch == 'Y') {
			mc.delete();
			System.out.println("���������� �����Ͽ����ϴ�.");
		}
	}

	public void printAll() {
		if (mc.existMemberNum() == 0) {
			System.out.println("����� ȸ���� �����ϴ�.");
			return;
		} 
		
		Member[] array = mc.printAll();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].inform());
		}
	}
}
