package com.kh.practice.chap01_poly.view;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import com.kh.practice.chap01_poly.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryMenu {
	
	public static Scanner sc = new Scanner(System.in);
	LibraryController lc = new LibraryController();
	
	
	public void mainMenu() {
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		lc.insertMember(new Member(name,age,gender));
		
		System.out.println("1. 마이 페이지 : ");
		System.out.println("2. 도서 전체 조회 : ");
		System.out.println("3. 도서 검색 : ");
		System.out.println("4. 도서 대여하기 : ");
		System.out.println("9. 프로그램 종료하기 ");
		System.out.print("번호 선택 :  ");
		int inputNum = Integer.parseInt(sc.nextLine());
		
		switch(inputNum) {
			case 1 : 
				System.out.println(lc.myInfo());
				break;
			case 2 :
				selectAll();
				break;
			case 3 :
				searchBook();
				break;
			case 4 :
				rentBook();
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("번호를 잘 못 입력하셨습니다 다시 입력해 주세요.");
		}
		
	}
	
	public void selectAll() {
		
		Book[] bList = lc.selectAll();
		
		for(int i=0; i<bList.length; i++) {
			System.out.println("i번 도서 "+bList[i]);
		}
		
	}
	
	public void searchBook() {
		System.out.println("검색할  제목  키워드 : ");
		String keyword = sc.nextLine();
		
		Book[] searchBook = lc.searchBook(keyword);
		
		for(int i=0; i<searchBook.length; i++) {
			System.out.println(searchBook[i]);
		}		
	}
	
	public void rentBook() {
		selectAll();
		System.out.println("대여할 도서 번호 : ");
		int inputNum = Integer.parseInt(sc.nextLine());
		
		lc.rentBook(inputNum);
		switch(inputNum) {
			case 0 :
				System.out.println("성공적으로 대여 되었습니다.");
				break;
			case 1 :
				System.out.println("나이 제한으로 대여가 불가합니다.");
				break;
			case 2 : 
				System.out.println("성공적으로 대여되었습니다.요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
				break;	
		}
	}
	

}
