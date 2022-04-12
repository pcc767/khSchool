package com.kh.hw.member.model;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	
	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;
	
	public int existMemberNum() {
		int current = 0;
		for(int i=0; i<m.length; i++) {
			if(m[i] != null) {
				current++;
			}
		}
		return current;		
	}
	
	public boolean checkId(String inputId) {
		for(int i=0; i<m.length; i++) {
			if(m[i]==null) {
				break;				
			}
			
			if(inputId.equals(m[i].getId())) {
				return true;
			}	
		}
		return false;
	}
	
	public void insertMember(String id, String name ,String password, String email, char gender, int age) {
		for(int i=0; i<m.length; i++) {
			if(m[i]==null) {
				m[i] = new Member(id, name, password, email, gender, age);
				break;
			}
		}
	}
	
public String searchId(String id) {
		
		String str="";
		for(int i=0;i<m.length;i++) {
			if(m[i]==null) {
				break;
			}
			if(m[i].getId().equals(id)) {
				str+=m[i].getId()+" ";
				str+=m[i].getName()+" ";
				str+=m[i].getPassword()+" ";
				str+=m[i].getEmail()+" ";
				str+=m[i].getGender()+" ";
				str+=m[i].getAge()+" ";
				break;
			}
		}
		
		return str;
	}
	
	public Member[] searchName(String name) {
		Member[] search = new Member[SIZE];
		int count=0;
		for(int i=0;i<m.length;i++) {
			if(m[i]==null) {
				continue;
			}else if(m[i].getName().equals(name)) {
				search[count] = m[i];
				count++;
			}
		}
		return search;
		
	}

	public Member[] searchEmail(String email) {
		Member[] search = new Member[SIZE];
		int count=0;
		for(int i=0;i<m.length;i++) {
			if(m[i]==null) {
				continue;
			}else if(m[i].getEmail().equals(email)) {
				search[count] = m[i];
				count++;
			}
		}
		return search;	
	}
	
	public boolean updatePassword(String id,String password) {
		for(int i=0; i<m.length;i++) {
			if(m[i]==null) {
				continue;
			}else if(m[i].getId().equals(id)){
				m[i].setPassword(password);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateName(String id,String name) {
		for(int i=0; i<m.length;i++) {
			if(m==null) {
				continue;
			}else if(m[i].getId().equals(id)){
				m[i].setName(name);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateEmail(String id,String email) {
		for(int i=0; i<m.length;i++) {
			if(m==null) {
				continue;
			}else if(m[i].getId().equals(id)){
				m[i].setEmail(email);
				return true;
			}
		}
		return false;
	}
	public boolean delete(String id) {
		for(int i=0; i<m.length;i++) {
			if(m==null) {
				continue;
			}else if(m[i].getId().equals(id)){
				m[i]=null;
				return true;
			}
		}
		return false;
	}
	
	public void delete() {
		for(int i=0;i<m.length;i++) {
			
			m[i]=null;
			Member temp = m;
			
			
			
		}
	}
	
	public Member[] printAll() {
		Member[] print = new Member[SIZE];
		int count=0;
		for(int i=0; i<m.length;i++) {
			if(m[i]!=null) {
			print[count] = m[i];
			count++;
			}
		}
		return print;
	}


}



