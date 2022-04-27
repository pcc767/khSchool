package com.kh.pratice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.pratice.list.library.controller.BookController;
import com.kh.pratice.list.library.model.vo.Book;

public class BookMenu {
	
	BookController bc = new BookController();
	public static Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("== Welcome KH Librery ==");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int inputNum = Integer.parseInt(sc.nextLine());
			
			switch(inputNum) {
				case 1 :
					insertBook();
					break;
				case 2 :
					selectList();
					break;
				case 3 :
					searchBook();
					break;
				case 4 :
					deleteBook();
					break;
				case 5 :
					ascBook();
					break;
				case 9 :
					System.out.println("프로그램을 종료합니다");
					return;
				default :
					System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요.");	
			
			}
		}
		
	}

	private void ascBook() {
		if(bc.ascBook()==1) {
			System.out.println("정렬에 성공하였습니다.");
		} else {
			System.out.println("정렬에 실패하였습니다.");
		}
		
		
	}

	private void deleteBook() {
		System.out.println("== 도서 삭제 ==");
		System.out.print("삭제할 도서명 : ");
		String title = sc.nextLine();
		System.out.print("삭제할 저자명 : ");
		String author = sc.nextLine();
		
		Book remove = bc.delectBook(title, author);
		
		if(remove.equals(remove)) {
			System.out.println("성공적으로 삭제 되었습니다.");
		} 
		
		if(!remove.equals(remove)){
			System.out.println("삭제할 도서를 찾지 못했습니다.");
		}
		

	}

	private void searchBook() {
		System.out.print("검색할 도서명 : ");
		String keyword = sc.nextLine();
		
		ArrayList<Book> searchList = new ArrayList<>(bc.searchBook(keyword));
		if(searchList.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		}
		if(!searchList.isEmpty()) {
			for(int i=0; i<searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}
		
	}

	private void selectList() {
		ArrayList<Book> list = new ArrayList<>(bc.selectList());
		
		if(list.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다.");
		}
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
	}

	private void insertBook() {
		String category = "";
		System.out.println("== 새 도서 추가 ==");
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		System.out.print("저자명 : ");
		String author = sc.nextLine();
		System.out.print("장르 (1.인문 / 2.자연과학 / 3.의료 / 4.기타) : ");
		int category_ = Integer.parseInt(sc.nextLine());
		
		switch(category_) {
			case 1 : 
				category = "인문";
				break;
			case 2 : 
				category = "자연과학";
				break;
			case 3 : 
				category = "의료";
				break;
			case 4 : 
				category = "기타";
				break;
			default : 
				System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요.");
		}
		
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		bc.insertBook(new Book(title, author, category, price));
		
	}

}
