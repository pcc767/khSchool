package com.oneTeam.view;

import java.util.Scanner;

public class menu {
	
	public static Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		System.out.println("========== Legacy Project Main ===========");
		System.out.println("1. 문화재 검색");
		System.out.println("2. 궁궐 검색");
		System.out.println("3. 서울시 문호재 Top-100");
		System.out.println("4. 로그인");
		System.out.println("5. 종료");
		System.out.println("번호 선택 : ");
		int choNum = Integer.parseInt(sc.nextLine());
		
		while(true){
			switch(choNum) {
				case 1 :
					LegacyNameSearch();
					break;
				case 2 :
					PalaceNameSearch();
					break;
				case 3 :
				case 4 :
					login();
					break;
				case 5 :
				default :
			}
		}

	}
	
	public void login() {
		while(true) {
			System.out.println("================== 로그인 =====================");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
//			boolean result = userController.login(id, pw);
			if(result) {
				System.out.println("로그인에 성공하였습니다!");
				break;
			}else {
				System.out.println("로그인에 실패하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void loginMenu() {
		System.out.println("========== Legacy Project Main ===========");
		System.out.println("1. 문화재 검색");
		System.out.println("2. 궁궐 검색");
		System.out.println("3. 서울시 문호재 Top-100");
		System.out.println("4. 개인 정보");
		System.out.println("5. 로그아웃");
		System.out.println("6. 종료");
		System.out.println("번호 선택 : ");
		int choNum = Integer.parseInt(sc.nextLine());
		
		while(true){
			switch(choNum) {
				case 1 :
				case 2 :
				case 3 :
				case 4 :
				case 5 :
				case 6 :
				default :
			}
		}
		
	}
	
	
	public void LegacySearch() {
		System.out.println("========== Legacy Project Main ===========");
		System.out.println("1. 이름 검색");
		System.out.println("2. 간편 검색");
		System.out.println("3. 뒤로 가기");
		int choNum = Integer.parseInt(sc.nextLine());
		
		while(true){
			switch(choNum) {
				case 1 :
					searchName();
					break;
				case 2 :
					simpleSearch();
					break;
				case 3 :	
					back();
					break;
				default :
					System.out.println("잘 못된 번호를 선택하였습니다. 다시 선택하여 주세요.");
			}
		}
	}

	private void searchName() {
		System.out.println("========== 이름 검색 ===========");
		System.out.println("키워드를 입력해 주세요");
		System.out.println("키워드를 : ");
		String keyWord = sc.nextLine();
		
		
	}
	

}
