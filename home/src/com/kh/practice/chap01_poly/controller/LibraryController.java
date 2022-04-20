package com.kh.practice.chap01_poly.controller;

import java.util.Arrays;

import com.kh.practice.chap01_poly.model.vo.AniBook;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.CookBook;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryController {
	
	Member mem = null;
	Book[] bList = new Book[5];
	
	{
		bList[0] = new CookBook("�������� ����", "������", "tvN", true);
		bList[1] = new AniBook("ž�ǽ�", "�Ұ��", "���̳�", 17);
		bList[2] = new AniBook("������ ���ǽ�", "����", "japan", 12);
		bList[3] = new CookBook("�������� �󸶳� ���ְԿ�", "������", "����", false);
		bList[4] = new CookBook("������ �� �����غ�", "������", "�ұ�å", true);
	}
	
	
	public void insertMember(Member mem) {
        this.mem = mem;
    }
	
	public Member myInfo() {
		return this.mem;
	}
	
	public Book[] selectAll() {
		return this.bList;
	}
	
	public Book[] searchBook(String keyword) {
		
		Book[] tempBook = new Book[bList.length];
		int count = 0;
		
		for(int i=0; i<bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {
				tempBook[count] = bList[i];
				count++;
			}
		}
		Book[] neoBooks = new Book[count];
		neoBooks = Arrays.copyOf(bList,count);
		
		return neoBooks;		
	}
	
	public int rentBook(int index) {
		
		int result = 0;
		
		// �ڡڡڡڡڡڡڡ� ���� ó���� �ڡڡڡڡڡڡ�
		if(index < 0 || index > bList.length || mem == null) {
			return -1;
		}
		// �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		
		if(bList[index] instanceof AniBook) {
			int accessAge = ((AniBook)bList[index]).getAccessAge();
			if (accessAge > mem.getAge());
			result = 1;			
		}
		
		if(bList[index] instanceof CookBook) {
			boolean isCoupon = ((CookBook)bList[index]).isCoupon();
			
			if(isCoupon == true) {
				mem.setCouponCount(mem.getCouponCount()+1);
				result = 2;	
			}
		}
		return result;		
	}
	
	

}
