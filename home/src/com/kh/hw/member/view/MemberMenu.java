package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	MemberController mc = new MemberController();
	public static Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.println("현재 등록된 회원수는 "+mc.existMemberNum()+"명 입니다.");
		
		System.out.println("1. 새 회원 등록");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 모두 출력");
		System.out.println("9. 끝내기");
		System.out.println("메뉴 번호 : ");
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
			System.out.println("프로그램 종료.");
			return;
		default :
			System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요");
			break;
		}		
	}
	
	public void insertMenber() {
		System.out.println("새 회원을 등록합니다.");
		String id = null;
		while(true) {
			System.out.println("아이디 : ");
			id = sc.nextLine();
			if (mc.checkId(id) == false) {
				System.out.println("가능한 아이디입니다.");				
				break;
			}
			else
				System.out.println("중복된 아이디입니다. 다시 입력해 주세요.");
		}		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("비밀번호 : ");
		String password = sc.nextLine();
		System.out.println("이메일 : ");
		String email = sc.nextLine();
		char gender;
		while(true) {
			System.out.println("성별 : ");
			gender = sc.nextLine().toUpperCase().charAt(0);
			if(gender	)
			
		}
			
		System.out.println("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
	}
	
	
}
