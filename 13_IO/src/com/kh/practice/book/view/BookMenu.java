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
		System.out.println("1. ���� �߰� ����");
		System.out.println("2. ���� ���� ���");
		System.out.println("9. ���α׷� ������");
		System.out.println("��ȣ �Է� : ");
		int inputNum = Integer.parseInt(sc.nextLine());
		
		switch(inputNum) {
			case 1 :
				fileSave();
				break;
			case 2 :
				fileRead();
				break;
			case 9 :
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default :
				System.out.println("�� �� �Է��ϼ̽��ϴ� �ٽ� �Է��� �ּ���.");
			
		}
		
	}
	
	public void fileSave() {
		
		System.out.println("������ : ");
		String title = sc.nextLine();
		System.out.println("���ڸ� : ");
		String author = sc.nextLine();
		System.out.println("���� ���� : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("���� ��¥(yyyy-mm-dd) : ");
		String[] date = sc.nextLine().split("-");
		
		int[] dateNew = new int[3];
		dateNew[0] = Integer.parseInt(date[0]);
		dateNew[1] = Integer.parseInt(date[1]);
		dateNew[2] = Integer.parseInt(date[2]);
		
		Calendar theDay = Calendar.getInstance();
		theDay.set(Calendar.YEAR, dateNew[0]);
		theDay.set(Calendar.MONTH, dateNew[0]);
		theDay.set(Calendar.DATE, dateNew[0]);
		
		System.out.println("������ : ");
		double discount = Double.parseDouble(sc.nextLine());
		
		 
	}
	
	

}
