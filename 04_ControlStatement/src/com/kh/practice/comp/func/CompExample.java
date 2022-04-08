package com.kh.practice.comp.func;

import java.util.Random;
import java.util.Scanner;

public class CompExample {

	public static Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.print("정수 : ");
		int iNum = Integer.parseInt(sc.nextLine());

		if (iNum <= 0) {
			System.out.println("양수가 아닙니다.");
		}

		for (int i = 1; i <= iNum; i++) {
			if (i % 2 == 0) {
				System.out.print("수");
			} else {
				System.out.print("박");
			}
		}
	}
	

	public void practice2() {

		while (true) {
			System.out.print("정수 : ");
			int iNum = Integer.parseInt(sc.nextLine());

			if (iNum <= 0) {
				System.out.println("양수가 아닙니다.");
				continue;
			}

			for (int i = 1; i <= iNum; i++) {
				if (i % 2 == 0) {
					System.out.print("수");
				} else {
					System.out.print("박");
				}
			}
			System.out.println();
		}
	}
	

	public void practice3() {

		System.out.print("문자열 : ");
		String str = sc.nextLine();
		System.out.print("문자 : ");
		char cha = sc.next().charAt(0);

		int findNum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (cha == str.charAt(i)) {
				findNum++;
			}
		}
		System.out.printf("%s 안에 포함된 %c 개수 : %d", str, cha, findNum);

	}
	

	public void practice4() {
		loop: while (true) {
			System.out.print("문자열 : ");
			String str = sc.nextLine();

			System.out.print("문자 : ");
			char cha = sc.next().charAt(0);

			int findNum = 0;
			for (int i = 0; i < str.length(); i++) {
				if (cha == str.charAt(i)) {
					findNum++;
				}
			}

			System.out.printf("%s 안에 포함된 %c 개수 : %d\n", str, cha, findNum);
			System.out.println();

			while (true) {
				System.out.print("더 하시겠습니까? (y/n) : ");
				char chaSel = sc.next().charAt(0);
				sc.nextLine();

				if (chaSel == 'y' || chaSel == 'Y') {
					continue loop;
				} else if (chaSel == 'n' || chaSel == 'N') {
					System.out.println("종료합니다.");
					return;
				} else {
					System.out.println("잘 못된 대답니다. 다시 입력해 주세요.");
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
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요 : ");
			int ranInt = Integer.parseInt(sc.nextLine());

			if (ranInt <= 0 && ranInt > 100) {
				System.out.println("1~100 사이의 숫자를 입력해주세요");
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
			System.out.println("정답입니다~~!!");
			System.out.println(iNum + "회만에 맞추셨습니다.");
		}

	}
	

	public void practice6() {

		System.out.print("당신의 이름을 입력해주세요 : ");
		String strName = sc.nextLine();
		int iNum = 0;
		int itotal = 0;
		int iwin = 0;
		int ilost = 0;
		int idraw = 0;

		while (true) {
			int randomInt = new Random().nextInt(3);

			System.out.print("가위,바위,보 : ");
			String iGame = sc.nextLine();

			if (iGame.equals("exit")) {
				System.out.println(itotal + "전 " + iwin + "승 " + idraw + "무 " + ilost + "패");
				return;
			} else if (!iGame.equals("가위") && !iGame.equals("바위") && !iGame.equals("보")) {
				System.out.println("잘 못입력하셨습니다.");
				System.out.println();
				continue;
			}

			if (randomInt == 0) {
				System.out.println("컴퓨터 : 가위");
			} else if (randomInt == 1) {
				System.out.println("컴퓨터 : 바위");
			} else {
				System.out.println("컴퓨터 : 보");
			}

			// System.out.println(strName+" : "+iGame);

			if (iGame.equals("가위")) {
				iNum = 0;
			} else if (iGame.equals("바위")) {
				iNum = 1;
			} else {
				iNum = 2;
			}

			System.out.println(strName + " : " + iGame);

			if (randomInt < iNum) {
				System.out.println("이겼습니다.");
				iwin++;
			} else if (randomInt == 2 && iNum == 0) {
				System.out.println("이겼습니다.");
				iwin++;
			} else if (randomInt > iNum) {
				System.out.println("졌습니다.");
				ilost++;
			} else {
				System.out.println("비겼습니다.");
				idraw++;
			}
			System.out.println();
			itotal++;
		}
	}
	
	
}
