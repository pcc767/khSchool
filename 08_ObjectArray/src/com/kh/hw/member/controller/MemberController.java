package com.kh.hw.member.controller;

import java.util.Arrays;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
	// Controller�� å�� ����(Responsibility Scope)
	// - View�� ���� ������� ��û�� ���� �޾� ��û/�信 ���� �帧�� �����ϴ� ����
	// - ������� �Է� �����͸� ���޹ް�, Model(DB)�� ���� ������ Ȯ���� ��ġ�� ����/���� ����¡�� ����
	
	// Controller(Back-end)�μ� å�������ϴ� �κ�!
	// - ���� �ڵ� �ȿ��� �ۿ��� �߻��Ҽ� �ִ� �پ��� ������ ������ �̸� �ذ��ؾ��Ѵ�.
	//   �ڡڡڡڡ� �ſ� �߿��� ����
	// - ���� : View������ 5���� �� �������� ���α׷����� �Ѱ谡 ����.
	// - if Array�� ��ȯ�ϸ�, �ִ� ũ�� �ȿ� null�� ����, �������� ũ�⸸ŭ �迭�� ��ȯ�Ǿ�� �Ѵ�.
	//    -> ���ϸ�? �ۿ��� null�̳� Array out of range�� ���� View���� ó���ϱ� ��ƴ�.

	private static int MAX_SIZE = 10;
	private Member[] memberArray = new Member[MAX_SIZE];
	private int size = 0; // ���� �迭�� ũ�⸦ �����ϴ� ����

	public MemberController() {
		insertMember(new Member("test1","ȫ�浿","1234","test1@test.com",'M',31));
		insertMember(new Member("test2","��浿","4321","test2@test.com",'M',32));
		insertMember(new Member("test3","�̱浿","1234","test3@test.com",'M',24));
		insertMember(new Member("test4","�ֱ��","4321","test4@test.com",'F',27));
		insertMember(new Member("test5","ȫ�浿","1234","test1@test.com",'M',41));
	}
	
	// ���� �����Ͱ� �ִ� ����� ��
	public int existMemberNum() {
		return size;
	}
	
	/**
	 * alt+shift+j
	 * @DESC : id�� �Է¹ް� Array���� Ž���Ͽ� index�� ����� �˷��ִ� �޼ҵ�
	 * @param id : ������� ID
	 * @return index���� ��ȯ, 0 �̻��� ��� �˻� ����, -1�� ��� �˻� ����
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
		if(index >= 0) { // id �ִ� ���
			return true;
		}else { // id�� ���� ���
			return false;
		}
	}

	public Member searchId(String id) {
		int index = searchIdForIndex(id);
		if(index >= 0) { // id �ִ� ���
			return memberArray[index];
		}else { // id�� ���� ���
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
			MAX_SIZE = MAX_SIZE * 2; // �迭�� �� �� ��� 2�辿 ������ �÷���!
			memberArray = Arrays.copyOf(memberArray, MAX_SIZE);
		}
		
		memberArray[size++] = member;
	}
	
	// �˻��� ����� �����ϰ� �迭�� ����� �ڵ�
	public boolean delete(String id) {
		int index = searchIdForIndex(id);
		
		if(index == -1) { // ���� ��� ���͸�
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
		mc.insertMember(new Member("test6","ȫ�浿","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test7","ȫ�浿","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test8","ȫ�浿","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test9","ȫ�浿","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test11","ȫ�浿","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test12","�̱浿","1234","test1@test.com",'M',41));
		mc.insertMember(new Member("test13","ȫ�浿","1234","test1@test.com",'M',41));
		mc.updateName("test12", "�ű浿");
		mc.delete("test13");
		
		System.out.println(mc.existMemberNum());
		System.out.println(Arrays.toString(mc.printAll()));
		System.out.println("1 " + Arrays.toString(mc.searchName("ȫ�浿")));
		System.out.println("2 " + Arrays.toString(mc.searchName("��浿")));
		System.out.println("3 " + Arrays.toString(mc.searchName("���°�")));
		Member[] arr = mc.searchName("���°�");
		if(arr.length == 0) {
			System.out.println("�� ����");
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
