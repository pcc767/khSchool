package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.model.MemberController;

public class MemberMenu {
	
	private static Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("최대 등록 가능한 회원 수는 10명입니다.");
		System.out.println("현재 등록된 회원 수는"+mc.existMemberNum()+"명입니다.");
		if(mc.existMemberNum() != 10) {
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.println("입력할 메뉴 : ");
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
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("번호가 잘 못 입력되었습니다.");	
				
			}	
			
		}
		
		if(mc.existMemberNum() == 10) {			
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.println("입력할 메뉴 : ");
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
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("번호가 잘 못 입력되었습니다.");	
				
			}	
			
		}
	}

	public void insertMember() {
		
		
	}

}
