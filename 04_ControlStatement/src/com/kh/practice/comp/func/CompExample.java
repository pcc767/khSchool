package com.kh.practice.comp.func;

import java.util.Random;
import java.util.Scanner;

public class CompExample {

	public static Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.print("���� : ");
		int iNum = Integer.parseInt(sc.nextLine());

		if (iNum <= 0) {
			System.out.println("����� �ƴմϴ�.");
		}

		for (int i = 1; i <= iNum; i++) {
			if (i % 2 == 0) {
				System.out.print("��");
			} else {
				System.out.print("��");
			}
		}
	}
	

	public void practice2() {

		while (true) {
			System.out.print("���� : ");
			int iNum = Integer.parseInt(sc.nextLine());

			if (iNum <= 0) {
				System.out.println("����� �ƴմϴ�.");
				continue;
			}

			for (int i = 1; i <= iNum; i++) {
				if (i % 2 == 0) {
					System.out.print("��");
				} else {
					System.out.print("��");
				}
			}
			System.out.println();
		}
	}
	

	public void practice3() {

		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		System.out.print("���� : ");
		char cha = sc.next().charAt(0);

		int findNum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (cha == str.charAt(i)) {
				findNum++;
			}
		}
		System.out.printf("%s �ȿ� ���Ե� %c ���� : %d", str, cha, findNum);

	}
	

	public void practice4() {
		loop: while (true) {
			System.out.print("���ڿ� : ");
			String str = sc.nextLine();

			System.out.print("���� : ");
			char cha = sc.next().charAt(0);

			int findNum = 0;
			for (int i = 0; i < str.length(); i++) {
				if (cha == str.charAt(i)) {
					findNum++;
				}
			}

			System.out.printf("%s �ȿ� ���Ե� %c ���� : %d\n", str, cha, findNum);
			System.out.println();

			while (true) {
				System.out.print("�� �Ͻðڽ��ϱ�? (y/n) : ");
				char chaSel = sc.next().charAt(0);
				sc.nextLine();

				if (chaSel == 'y' || chaSel == 'Y') {
					continue loop;
				} else if (chaSel == 'n' || chaSel == 'N') {
					System.out.println("�����մϴ�.");
					return;
				} else {
					System.out.println("�� ���� ���ϴ�. �ٽ� �Է��� �ּ���.");
					continue;
				}
			}
		}
	}
	

	public void practice5() {

		int randomInt = new Random().nextInt(100) + 1;
		boolean isWin = false;
		int iNum = 0;

		while (true) {
			System.out.print("1~100 ������ ������ ������ ���纸���� : ");
			int ranInt = Integer.parseInt(sc.nextLine());

			if (ranInt <= 0 && ranInt > 100) {
				System.out.println("1~100 ������ ���ڸ� �Է����ּ���");
				continue;
			}

			if (ranInt == randomInt) {
				isWin = true;
				break;
			} else {
				if (randomInt > ranInt) {
					System.out.println("UP~~!!");
				} else {
					System.out.println("DOWN~~!!");
				}
			}
			iNum++;
		}

		if (isWin == true) {
			System.out.println("�����Դϴ�~~!!");
			System.out.println(iNum + "ȸ���� ���߼̽��ϴ�.");
		}

	}
	

	public void practice6() {

		System.out.print("����� �̸��� �Է����ּ��� : ");
		String strName = sc.nextLine();
		int iNum = 0;
		int itotal = 0;
		int iwin = 0;
		int ilost = 0;
		int idraw = 0;

		while (true) {
			int randomInt = new Random().nextInt(3);

			System.out.print("����,����,�� : ");
			String iGame = sc.nextLine();

			if (iGame.equals("exit")) {
				System.out.println(itotal + "�� " + iwin + "�� " + idraw + "�� " + ilost + "��");
				return;
			} else if (!iGame.equals("����") && !iGame.equals("����") && !iGame.equals("��")) {
				System.out.println("�� ���Է��ϼ̽��ϴ�.");
				System.out.println();
				continue;
			}

			if (randomInt == 0) {
				System.out.println("��ǻ�� : ����");
			} else if (randomInt == 1) {
				System.out.println("��ǻ�� : ����");
			} else {
				System.out.println("��ǻ�� : ��");
			}

			// System.out.println(strName+" : "+iGame);

			if (iGame.equals("����")) {
				iNum = 0;
			} else if (iGame.equals("����")) {
				iNum = 1;
			} else {
				iNum = 2;
			}

			System.out.println(strName + " : " + iGame);

			if (randomInt < iNum) {
				System.out.println("�̰���ϴ�.");
				iwin++;
			} else if (randomInt == 2 && iNum == 0) {
				System.out.println("�̰���ϴ�.");
				iwin++;
			} else if (randomInt > iNum) {
				System.out.println("�����ϴ�.");
				ilost++;
			} else {
				System.out.println("�����ϴ�.");
				idraw++;
			}
			System.out.println();
			itotal++;
		}
	}
	
	
}
