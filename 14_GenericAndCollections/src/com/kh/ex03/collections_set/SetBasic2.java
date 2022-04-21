package com.kh.ex03.collections_set;

import java.util.Set;
import java.util.TreeSet;

public class SetBasic2 {
	
	// �Ϲ������� Set�� ���� �����͸� �����ϱ⺸��, List�� �����ϰ�
	// Set���� �ߺ������Ҷ��� ��� �����.

	
	public static void main(String[] args) {		
		
		Set<UserVO> set = new TreeSet<UserVO>();

		UserVO user = new UserVO("testID1", "��浿1", 21, 10000.123); // Primary Key
		set.add(user);
		set.add(new UserVO("testID1", "��浿1", 21, 10000.123));
		set.add(new UserVO("testID3", "��浿3", 23, 444000.123));
		set.add(new UserVO("testID2", "ȫ�浿3", 41, 3300.123));
		set.add(new UserVO("testID2", "��浿2", 22, 10000.123));
		
		//��ü�� ������ �ִ��� Ȯ���ϴ� ���
		System.out.println(set.contains(user));
		System.out.println(set.contains(new UserVO("testID5", "��浿3", 21, 10000.123)));
		
		//��ü ������� ���
		set.remove(user);
		
		//��¹�
		System.out.println(set);


		
	}
	
	

}
