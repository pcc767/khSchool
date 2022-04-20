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
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("탑의신", "소고기", "내이놈", 17);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
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
		
		// ★★★★★★★★ 예외 처리부 ★★★★★★★
		if(index < 0 || index > bList.length || mem == null) {
			return -1;
		}
		// ★★★★★★★★★★★★★★★★★★★★★★★★★
		
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
