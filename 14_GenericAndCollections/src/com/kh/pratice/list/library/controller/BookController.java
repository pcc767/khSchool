package com.kh.pratice.list.library.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.pratice.list.library.model.vo.Book;

public class BookController {

	private List<Book> list = new ArrayList<>(); 
	
	public BookController() {
		
		list.add(new Book("�ڹ��� ����", "���ü�","��Ÿ", 20000));
		list.add(new Book("���� ���� �˰���", "������","��Ÿ", 15000));
		list.add(new Book("��ȭ�� ���", "������", "�ι�", 17500));
		list.add(new Book("�� ������", "�ڽſ�", "�Ƿ�", 21000));
		
	}
	
	public void insertBook(Book bk) {
		list.add(bk);
	}
	
	public ArrayList<Book> selectList() {
		return (ArrayList<Book>) list;
	}
	
	public ArrayList<Book> searchBook(String keyword) {
		ArrayList<Book> searchList = new ArrayList<Book>();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().contains(keyword)){
				searchList.add(list.get(i));
			}
		}
		return searchList;
	}
	
	public boolean deleteBook(String title, String author){
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().contains(title)) {
				if(list.get(i).getAuthor().contains(author)) {
					list.remove(list.get(i));
					return true;				
				}
			}
		}
		return false;
	}
	
	public int ascBook() {
		list.sort(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				int result = o1.getTitle().compareTo(o2.getTitle());
				return result;
			}
		});

//		Collections.sort(list);
		return 1;
	}
	
	
	
	
}
