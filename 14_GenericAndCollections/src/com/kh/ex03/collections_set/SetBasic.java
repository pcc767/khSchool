package com.kh.ex03.collections_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetBasic {
	// TreeSet : �ߺ��� �����͸� ������� �ʰ�, �����Ͱ� ���ĵ� �ڡڡڡڡڡ�
	//           -> Comparable�� ����Ͽ� ����, �ߺ��� ����
	// LinkedHashSet : Hash�ڵ� �������� �ߺ��� ����, ���� ������ ����
	//			 -> hashCode()�� �����
	// HashSet : Hash�ڵ� �������� �ߺ��� ����, �ƹ� ������ ������� ���� -> ���Ϻ�����. ��
	//           -> hashCode()�� �����
	
	public static void main(String[] args) {
		Set<UserVO> treeSet = new TreeSet<>();
		Set<UserVO> linkedHashSet = new LinkedHashSet<>();
		Set<UserVO> hashSet = new HashSet<>();
		
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("testID1", "��浿1", 21, 10000.123));
		list.add(new UserVO("testID1", "��浿1", 21, 10000.123)); // ��������
		list.add(new UserVO("testID3", "��浿3", 23, 444000.123));
		list.add(new UserVO("testID2", "ȫ�浿3", 41, 3300.123)); // ID �� �ٸ�
		list.add(new UserVO("testID2", "��浿2", 22, 10000.123));
		
		// 1. Set�� ������ �߰��ϴ� ���
		treeSet.addAll(list);
		
		linkedHashSet.addAll((ArrayList<UserVO>)list.clone()); // ����� List�� ���µ�...
		for(UserVO user : list) {
			hashSet.add(user);
		}
		
		// 2. Set ��ȸ�ϴ� ��
		// 1) Iterator ��� �ڡڡڡڡ�
		System.out.println("TreeSet"); // 3��, Comparable ID����
		Iterator<UserVO> iterator = treeSet.iterator();
		while(iterator.hasNext()) { // hasNext : ������ �����Ͱ� �ִ� ��츸 True
			UserVO data = iterator.next(); // next : �����͸� �������� �޼ҵ�
			System.out.println(data);
		}
		System.out.println("--------------------------------");
		
		// 2) List�� ��ȯ�Ͽ� ����ϴ� ��
		System.out.println("linkedHashSet"); // 5��, ���۾��� -> 4�� hashCode����
		List<UserVO> tempList = new ArrayList<>();
		tempList.addAll(linkedHashSet);
		for(UserVO user : tempList) {
			System.out.println(user);
		}
		System.out.println("--------------------------------");
	
		// 3) �Լ��� ���α׷��� ���� (Since Java8) -> 4�� hashCode����
		System.out.println("HashSet");
		hashSet.forEach((value) -> System.out.println(value));
		
	}
}








