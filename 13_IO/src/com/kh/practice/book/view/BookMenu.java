package com.kh.practice.book.view;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;


public class BookMenu {

	public static Scanner sc = new Scanner(System.in);
    BookController bc = new BookController();
    Book[] bArr;

    public BookMenu(){
        bc.makeFile();
        bArr = bc.fileRead();
    }

    public void mainMenu(){
        System.out.println("1. ���� �߰� ����");
        System.out.println("2. ���� ���� ���");
        System.out.println("9. ���α׷� ������");
        System.out.print("�޴� ��ȣ : ");
        int inputNum = Integer.parseInt(sc.nextLine());

        switch (inputNum){
            case 1 :
                fileSave();
                break;
            case 2 :
                fileRead();
                break;
            case 9 :
                System.out.println("���α׷��� ����Ǿ����ϴ�.");
                return;
            default :
                System.out.println("�� �� �Է��ϼ̽��ϴ� .�ٽ� �Է��� �ּ���.");
        }

    }

	public void fileSave() {
		try {

			System.out.print("������ : ");
			String title = sc.nextLine();
			System.out.print("���ڸ� : ");
			String author = sc.nextLine();
			System.out.print("���� ���� : ");
			int price = Integer.parseInt(sc.nextLine());
			System.out.print("���� ��¥(yyyy-mm-dd) : ");
			String dateStr = sc.nextLine();

			// yyyy-MM-dd �����ϴ� ��
			// 1.��û���״�� split ���
			String[] array = dateStr.split("-");
			int year = Integer.parseInt(array[0]);
			int month = Integer.parseInt(array[1]) - 1;
			int date = Integer.parseInt(array[2]);
			Calendar cal = new GregorianCalendar();
			cal.set(year, month, date);

			// 2 .Simple Date Format ���
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(sdf.parse(dateStr));

//            String[] date = sc.nextLine().split("-");
//
//            int[] arrDate = new int[]{
//                    Integer.parseInt(date[0]),
//                    Integer.parseInt(date[1]),
//                    Integer.parseInt(date[2]),
//            };
//
//            Calendar date1 = Calendar.getInstance();
//            date1.set(Calendar.YEAR,arrDate[0]);
//            date1.set(Calendar.MONTH, arrDate[1]);
//            date1.set(Calendar.DATE, arrDate[1]);

			System.out.print("������ : ");
			double discount = Double.parseDouble(sc.nextLine());

			Book book = new Book(title, author, price, cal2, discount);
			bArr = Arrays.copyOf(bArr, bArr.length + 1);
			bArr[bArr.length - 1] = book;

			bc.fileSave(bArr);

//            for(int i=0; i< bArr.length; i++){
//                if(bArr[i]==null){
//                    bArr[i] = new Book(title,author,price,date1,discount);
//                }

		} catch (Exception e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		}

	}


    private void fileRead() {

        Book[] book = bc.fileRead();
        System.out.println(Arrays.toString(book));

    }
	
	

}
