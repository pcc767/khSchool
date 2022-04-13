package com.kh.hw.member.controller;

import java.util.Arrays;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	
	public static int MAX_SIZE = 10;
	private Member[] memberArray = new Member[MAX_SIZE];
	private int size = 0;
	
	public MemberController() {
		insertMember(new Member("test1","ȫ�浿","1234","aaa@aaa",'M',33));
	}
	
	public int existMemberNum() {
		return size;
	}
	
	private int searchIdForIndex(String id) {
		for(int i=0; i<size; i++) {
			if(memberArray[i].getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean checkId(String inputId) {
		int index = searchIdForIndex(inputId);
		if(index >= 0)
			return true;
		else
			return false;		
	}
	
	public Member searchId(String id) {
		int index = searchIdForIndex(id);
		if(index >= 0)
			return memberArray[index];
		else
			return null;	
		
	}
	
	public Member[] searchName(String name)	{
		Member[] tempArray = new Member[size];
		int count = 0;
		for(int i=0; i<size; i++) {
			if(memberArray[i].getName().equals(name))
				tempArray[count++] = memberArray[i];
		}
		return Arrays.copyOf(tempArray, count);
	}
	
	public Member[] searchEmail(String email)	{
		Member[] tempArray = new Member[size];
		int count = 0;
		for(int i=0; i<size; i++) {
			if(memberArray[i].getEmail().equals(email))
				tempArray[count++] = memberArray[i];
		}
		return Arrays.copyOf(tempArray, count);
	}
	
	public void insertMember(Member member) {
		if(size+1 >= MAX_SIZE) {
			MAX_SIZE= MAX_SIZE*2;
			memberArray = Arrays.copyOf(memberArray, MAX_SIZE);			
		}
		memberArray[size++] = member;
	}
	
	public boolean delete(String id) {
		int index = searchIdForIndex(id);
		
		if(index == -1) {
			return false;
		}
		for(int i=index; i<size-1; i++) {
			memberArray[i] = memberArray[i+1];
		}
		memberArray[size-1] = null;
		size--;
		return true;
	}
	
	public void delete() {
		MAX_SIZE = 10;
		size = 0;
		memberArray = new Member[MAX_SIZE];
	}
	
	public boolean updatePassword(String id, String password) {
		int index = searchIdForIndex(password);
		if(index == -1)
			return false;
		memberArray[index].setPassword(password);
		return true;
	}
	
	public boolean updateName(String id, String name) {
		int index = searchIdForIndex(name);
		if(index == -1)
			return false;
		memberArray[index].setPassword(name);
		return true;
	}
	
	public boolean updateEmail(String id, String email) {
		int index = searchIdForIndex(email);
		if(index == -1)
			return false;
		memberArray[index].setPassword(email);
		return true;
	}
	
	public Member[] printAll() {
		return Arrays.copyOf(memberArray, size);
	}
	
	
	public static void main(String[] args) {
		MemberController mc = new MemberController();
		
	}
	
	
	
	
	
}
	
	
	