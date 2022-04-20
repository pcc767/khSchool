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
		
		System.out.println("�̸� : ");
		String name = sc.nextLine();
		System.out.println("���� : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("���� : ");
		char gender = sc.nextLine().charAt(0);
		
		lc.insertMember(new Member(name,age,gender));
		
		System.out.println("1. ���� ������ : ");
		System.out.println("2. ���� ��ü ��ȸ : ");
		System.out.println("3. ���� �˻� : ");
		System.out.println("4. ���� �뿩�ϱ� : ");
		System.out.println("9. ���α׷� �����ϱ� ");
		System.out.print("��ȣ ���� :  ");
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
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default :
				System.out.println("��ȣ�� �� �� �Է��ϼ̽��ϴ� �ٽ� �Է��� �ּ���.");
		}
		
	}
	
	public void selectAll() {
		
		Book[] bList = lc.selectAll();
		
		for(int i=0; i<bList.length; i++) {
			System.out.println("i�� ���� "+bList[i]);
		}
		
	}
	
	public void searchBook() {
		System.out.println("�˻���  ����  Ű���� : ");
		String keyword = sc.nextLine();
		
		Book[] searchBook = lc.searchBook(keyword);
		
		for(int i=0; i<searchBook.length; i++) {
			System.out.println(searchBook[i]);
		}		
	}
	
	public void rentBook() {
		selectAll();
		System.out.println("�뿩�� ���� ��ȣ : ");
		int inputNum = Integer.parseInt(sc.nextLine());
		
		lc.rentBook(inputNum);
		switch(inputNum) {
			case 0 :
				System.out.println("���������� �뿩 �Ǿ����ϴ�.");
				break;
			case 1 :
				System.out.println("���� �������� �뿩�� �Ұ��մϴ�.");
				break;
			case 2 : 
				System.out.println("���������� �뿩�Ǿ����ϴ�.�丮�п� ������ �߱޵Ǿ����� �������������� Ȯ���ϼ���");
				break;	
		}
	}
	

}
