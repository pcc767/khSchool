package com.kh.pratice.list.library.controller;

import java.util.ArrayList;
import java.util.Comparator;

import com.kh.pratice.list.library.model.vo.Book;

public class BookController {
	
	ArrayList<Book> list = new ArrayList<>();
	
	public BookController() {
		
		list.add(new Book("�ڹ��� ����", "���ü�", "��Ÿ", 20000));
		list.add(new Book("���� ���� �˰�", "������", "��Ÿ", 15000));
		list.add(new Book("��ȭ�� ���", "������", "�ι�", 17500));
		list.add(new Book("�� ������", "�ڽſ�", "�Ƿ�", 20000));		
	}
	
	public void insertBook(Book book) {
		list.add(book);
	}
	
	public ArrayList<Book> selectList() {
		return list;
	}
	
	public ArrayList<Book> searchBook(String ketword) {
		ArrayList<Book> searchList = new ArrayList<Book>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().contains(ketword)) {
				searchList.add(list.get(i));
			}
		}
		return searchList;		
	}
	
	public Book delectBook(String title, String author) {
		Book removeBook = null;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				if(list.get(i).getAuthor().equals(author)) {
					return removeBook = list.remove(i);
				}
			}
		}
		return removeBook;
	}
	
	public int ascBook() {
		list.sort(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {				
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		return 1;
		
	}

	
	
	
}
