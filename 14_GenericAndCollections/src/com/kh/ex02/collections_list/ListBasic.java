package com.kh.ex02.collections_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListBasic {
	
//	ArrayList - �ڡڡڡڡ� ��õ
//	 -> �ַ� ArrayList�� ����ϴµ�, ������ DB���� �����͸� ��� Ž�� �뵵�� ���� Ȱ����
//	- ���� : Ž���ӵ��� ������, �޸𸮸� ���� �����Ѵ�. 
//	- ���� : ����, ����, ������ ������. 

//	LinkedList
//	 -> ���� ���� ������ ������� ������ ������� ����... -> �̷� ��찡 ���� ���ų� �ٸ� �÷���(Map)�� �����
//	- ���� : ����, ����, ������ ������.
//	- ���� : Ž���ӵ��� ������, �޸𸮸� ���� �����Ѵ�.

//	Vector
//	-> Thread safe �Ҷ� ����ϳ�... �� ���� �÷����� ����. ���� �Ⱦ���.
	
	
	public static void main(String[] args) {
		// ��ü�迭 ����
		UserVO[] userArray = new UserVO[3];
		userArray[0] = new UserVO("testID1", "��浿", 23, 100000.123);
		userArray[1] = new UserVO("testID2", "ȫ�浿", 43, 200000.123);
		userArray[2] = new UserVO("testID3", "�ڱ浿", 53, 300000.123);
//		userArray[3] = new UserVO("testID3", "�ڱ浿", 53, 300000.123);
		
		// �迭�� ����
		// 1 . �迭�� ũ�⸦ �����ϰ�, ũ�⺸�� Ŀ���� ���ο� �迭�� �����ϰ� ���� �ʿ�.
		// 2 . �߰��� ������ ����/������ ��ƴ�. -> �ݵ�� �����͸� �޲�� �Ѵ�.
		// 3 . ���絵 ��ư�, ����� �Ǽ��� ����.
		// 4 . ��� : ���α׷��Ӷ�� ������ ���� �޴´�.
		
		// List ����
		// 1 . �ʱ�ȭ ����
		// - ����� Type�� List<>�� �ϴ� ���� �Ϲ����̴�. ( ArrayList ������� �ʴ´�.)
		List<UserVO> list1 = new ArrayList<>();				// 1. �ڿ� ���׷� ������ �����ϴ� ���� (�ֽ� ����)
		List<UserVO> list2 = new ArrayList<UserVO>();		// 2. ���׷� ���� ���� X
		List<UserVO> list3 = new LinkedList<>();			// 3. List�� Array/Linked ȣȯ ����
		
		// 2. �迭�� List�� ��ȯ�ϴ� ���
		// 1) asList Ȱ��
		List<UserVO> userList1 = new ArrayList<UserVO>(Arrays.asList(userArray));
		
		// 2) �������� �˰��� Ȱ��� 1.
		List<UserVO> userList2 = new ArrayList<UserVO>();
		for(UserVO user : userArray) {
			userList2.add(user);
		}
		
		// 3) �������� �˰��� Ȱ��� 2.
		List<UserVO> userList3 = new ArrayList<UserVO>();
		for (int i = 0; i < userArray.length; i++) {
			userList3.add(i, userArray[i]); 	//���ʿ� index ���� ����.
		}
		
		//��� ���
		// 1)
		System.out.println(userList1);
		
		// 2)
		for(UserVO user : userList2) {
			System.out.println(user);
		}
		
		// 3)
		for (int i = 0; i < userList3.size(); i++) {
			System.out.println(userList3.get(i));
		}
		
		
		
	}

	
	


}
