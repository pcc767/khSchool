package com.kh.pratice.list.library.controller;

import java.util.ArrayList;
import java.util.Comparator;

import com.kh.pratice.list.library.model.vo.Book;

public class BookController {
	
	ArrayList<Book> list = new ArrayList<>();
	
	public BookController() {
		
		list.add(new Book("자바의 정석", "남궁성", "기타", 20000));
		list.add(new Book("쉽게 배우는 알고", "문병로", "기타", 15000));
		list.add(new Book("대화의 기술", "강보람", "인문", 17500));
		list.add(new Book("암 정복기", "박신우", "의료", 20000));		
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
