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
			System.out.println("1. �� ���� �߰�");
			System.out.println("2. ���� ��ü ��ȸ");
			System.out.println("3. ���� �˻� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� �� �������� ����");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
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
					System.out.println("���α׷��� �����մϴ�");
					return;
				default :
					System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���.");	
			
			}
		}
		
	}

	private void ascBook() {
		if(bc.ascBook()==1) {
			System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		} else {
			System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		}
		
		
	}

	private void deleteBook() {
		System.out.println("== ���� ���� ==");
		System.out.print("������ ������ : ");
		String title = sc.nextLine();
		System.out.print("������ ���ڸ� : ");
		String author = sc.nextLine();
		
		Book remove = bc.delectBook(title, author);
		
		if(remove.equals(remove)) {
			System.out.println("���������� ���� �Ǿ����ϴ�.");
		} 
		
		if(!remove.equals(remove)){
			System.out.println("������ ������ ã�� ���߽��ϴ�.");
		}
		

	}

	private void searchBook() {
		System.out.print("�˻��� ������ : ");
		String keyword = sc.nextLine();
		
		ArrayList<Book> searchList = new ArrayList<>(bc.searchBook(keyword));
		if(searchList.isEmpty()) {
			System.out.println("�˻������ �����ϴ�.");
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
			System.out.println("�����ϴ� ������ �����ϴ�.");
		}
		if(!list.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		
	}

	private void insertBook() {
		String category = "";
		System.out.println("== �� ���� �߰� ==");
		System.out.print("������ : ");
		String title = sc.nextLine();
		System.out.print("���ڸ� : ");
		String author = sc.nextLine();
		System.out.print("�帣 (1.�ι� / 2.�ڿ����� / 3.�Ƿ� / 4.��Ÿ) : ");
		int category_ = Integer.parseInt(sc.nextLine());
		
		switch(category_) {
			case 1 : 
				category = "�ι�";
				break;
			case 2 : 
				category = "�ڿ�����";
				break;
			case 3 : 
				category = "�Ƿ�";
				break;
			case 4 : 
				category = "��Ÿ";
				break;
			default : 
				System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���.");
		}
		
		System.out.print("���� : ");
		int price = Integer.parseInt(sc.nextLine());
		
		bc.insertBook(new Book(title, author, category, price));
		
	}

}
