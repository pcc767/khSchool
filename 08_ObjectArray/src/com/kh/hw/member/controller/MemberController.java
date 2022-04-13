package com.kh.hw.member.controller;

import java.util.Arrays;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	// Controller의 책임 범위(Responsibility Scope)
	// - View로 부터 사용자의 요청을 전달 받아 요청/답에 대한 흐름을 제어하는 역할
	// - 사용자의 입력 데이터를 전달받고, Model(DB)로 부터 데이터 확인을 거치고 성공/실패 페이징을 제어
	
	// Controller(Back-end)로서 책임져야하는 부분!
	// - 현재 코드 안에서 밖에서 발생할수 있는 다양한 에러나 문제를 미리 해결해야한다.
	//   ★★★★★ 매우 중요한 개념
	// - 이유 : View에서는 5개의 언어가 섞임으로 프로그래밍의 한계가 생김.
	// - if Array를 반환하면, 최대 크기 안에 null이 없고, 데이터의 크기만큼 배열이 반환되어야 한다.
	//    -> 안하면? 밖에서 null이나 Array out of range로 죽음 View에서 처리하기 어렵다.

	private static int MAX_SIZE = 10;
	private Member[] memberArray = new Member[MAX_SIZE];
	private int size = 0; // 현재 배열의 크기를 저장하는 변수

	public MemberController() {
		insertMember(new Member("test1","홍길동","1234","test1@test.com",'M',31));
		insertMember(new Member("test2","김길동","4321","test2@test.com",'M',32));
		insertMember(new Member("test3","이길동","1234","test3@test.com",'M',24));
		insertMember(new Member("test4","최길순","4321","test4@test.com",'F',27));
		insertMember(new Member("test5","홍길동","1234","test1@test.com",'M',41));
	}
	
	// 현재 데이터가 있는 멤버의 수
	public int existMemberNum() {
		return size;
	}
	
	/**
	 * alt+shift+j
	 * @DESC : id를 입력받고 Array에서 탐색하여 index로 결과를 알려주는 메소드
	 * @param id : 사용자의 ID
	 * @return index값이 반환, 0 이상인 경우 검색 성공, -1인 경우 검색 실패
	 */
	private int searchIdForIndex(String id) {
		for(int i = 0; i < size; i++) {
			if(memberArray[i].getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean checkId(String inputId) {
		int index = searchIdForIndex(inputId);
		if(index >= 0) { // id 있는 경우
			return true;
		}else { // id가 없는 경우
			return false;
		}
	}

	public Member searchId(String id) {
		int index = searchIdForIndex(id);
		if(index >= 0) { // id 있는 경우
			return memberArray[index];
		}else { // id가 없는 경우
			return null;
		}
	}

	public Member[] searchName(String name) {
		Member[] tempArray = new Member[size];
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(memberArray[i].getName().equals(name)) {
				tempArray[count++] = memberArray[i];
			}
		}
		return Arrays.copyOf(tempArray, count);
	}

	public Member[] searchEmail(String email) {
		Member[] tempArray = new Member[size];
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(memberArray[i].getEmail().equals(email)) {
				tempArray[count++] = memberArray[i];
			}
		}
		return Arrays.copyOf(tempArray, count);
	}

	
	public void insertMember(Member member) {
		if(size + 1 >= MAX_SIZE) {
			MAX_SIZE = MAX_SIZE * 2; // 배열이 꽉 찬 경우 2배씩 공간을 늘려줌!
			memberArray = Arrays.copyOf(memberArray, MAX_SIZE);
		}
		
		memberArray[size++] = member;
	}
	
	// 검색한 사람을 삭제하고 배열을 땅기는 코드
	public boolean delete(String id) {
		int index = searchIdForIndex(id);
		
		if(index == -1) { // 없는 경우 필터링
			return false;
		}
		
		for(int i = index; i < size - 1; i++) {
			memberArray[i] = memberArray[i + 1];
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
		int index = searchIdForIndex(id);
		if(index == -1) {
			return false;
		}
		memberArray[index].setPassword(password);
		return true;
	}

	public boolean updateName(String id, String name) {
		int index = searchIdForIndex(id);
		if(index == -1) {
			return false;
		}
		memberArray[index].setName(name);
		return true;
	}

	public boolean updateEmail(String id, String email) {
		int index = searchIdForIndex(id);
		if(index == -1) {
			return false;
		}
		memberArray[index].setEmail(email);
		return true;
	}

	public Member[] printAll() {
//		return memberArray;
		return Arrays.copyOf(memberArray, size);
	}
	
	public static void main(String[] args) {
		MemberController mc = new MemberController();
	
		System.out.println(Arrays.toString(mc.printAll()));
		mc.insertMember(new Member("test6","홍길동","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test7","홍길동","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test8","홍길동","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test9","홍길동","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test11","홍길동","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test12","이길동","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test13","홍길동","1234","test1@test.com",'M',41));
		mc.updateName("test12", "팍길동");
		mc.delete("test13");
		
		System.out.println(mc.existMemberNum());
		System.out.println(Arrays.toString(mc.printAll()));
		System.out.println("1 " + Arrays.toString(mc.searchName("홍길동")));
		System.out.println("2 " + Arrays.toString(mc.searchName("김길동")));
		System.out.println("3 " + Arrays.toString(mc.searchName("없는거")));
		Member[] arr = mc.searchName("없는거");
		if(arr.length == 0) {
			System.out.println("값 없음");
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
