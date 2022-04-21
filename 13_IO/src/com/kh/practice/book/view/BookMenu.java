package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;



public class BookMenu {

	public static Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();
	Book[] bArr;
	
	public BookMenu() {
		bc.makeFile();
		bArr = bc.fileRead();
	}
	
	public void mainMenu() {
		System.out.println("1. 도서 추가 저장");
		System.out.println("2. 저장 도서 출력");
		System.out.println("9. 프로그램 끝내기");
		System.out.println("번호 입력 : ");
		int inputNum = Integer.parseInt(sc.nextLine());
		
		switch(inputNum) {
			case 1 :
				fileSave();
				break;
			case 2 :
				fileRead();
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘 못 입력하셨습니다 다시 입려해 주세요.");
			
		}
		
	}
	
	public void fileSave() {
		
		System.out.println("도서명 : ");
		String title = sc.nextLine();
		System.out.println("저자명 : ");
		String author = sc.nextLine();
		System.out.println("도서 가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("출판 날짜(yyyy-mm-dd) : ");
		String[] date = sc.nextLine().split("-");
		
		int[] dateNew = new int[3];
		dateNew[0] = Integer.parseInt(date[0]);
		dateNew[1] = Integer.parseInt(date[1]);
		dateNew[2] = Integer.parseInt(date[2]);
		
		Calendar theDay = Calendar.getInstance();
		theDay.set(Calendar.YEAR, dateNew[0]);
		theDay.set(Calendar.MONTH, dateNew[0]);
		theDay.set(Calendar.DATE, dateNew[0]);
		
		System.out.println("할인율 : ");
		double discount = Double.parseDouble(sc.nextLine());
		
		 
	}
	
	

}
