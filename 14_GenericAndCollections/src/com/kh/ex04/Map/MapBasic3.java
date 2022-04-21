package com.kh.ex04.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBasic3 {
	public static void main(String[] args) {
		// ID�� �ߺ��� �Ǿ HashMap���� �����ϴ� ���
		
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("testID1", "��浿1", 21, 10000.123));
		list.add(new UserVO("testID1", "Ȳ�浿2", 31, 10000.123)); 
		list.add(new UserVO("testID1", "��浿3", 51, 10000.123)); 
		list.add(new UserVO("testID2", "ȫ�浿1", 61, 3300.123)); 
		list.add(new UserVO("testID2", "��浿2", 32, 10000.123));
		list.add(new UserVO("testID2", "�ڱ浿3", 22, 10000.123));
		list.add(new UserVO("testID3", "�̱浿1", 13, 444000.123));
		list.add(new UserVO("testID3", "��浿2", 23, 444000.123));
		list.add(new UserVO("testID3", "ȫ�浿3", 33, 444000.123));

		// 2���� ���
		// 1. ID + �ٸ� �����͸� �����Ͽ� Key�� ��� -> �ļ��� ����� NG
		// 2. Map + List�� �����ϴ� ��� �ڡڡ�
		
		Map<String, List<UserVO>> listMap = new HashMap<>();
		
		for(UserVO item : list) {
			String key = item.getId(); 
			
			if(listMap.containsKey(key) == false) { // List�� �������� �ʴ� ���
				ArrayList<UserVO> tempList = new ArrayList<UserVO>();
				listMap.put(key, tempList);
			}	
			
			listMap.get(key).add(item);
		}
		
		//"testID2" ������
		System.out.println("-------testID2--------");
		List<UserVO> printList = listMap.get("testID2");
		printList.forEach((item) -> System.out.println(item));
		System.out.println("--------------------");
		
		for(UserVO item : printList) {
			System.out.println(item);
		}
		System.out.println("---------------------------");
		System.out.println(listMap);
		
//		{testID3=[UserVO [id=testID3, name=�̱浿1, age=13, account=444000.123], 
//		          UserVO [id=testID3, name=��浿2, age=23, account=444000.123], 
//		          UserVO [id=testID3, name=ȫ�浿3, age=33, account=444000.123]], 
//		testID1=[UserVO [id=testID1, name=��浿1, age=21, account=10000.123], 
//		         UserVO [id=testID1, name=Ȳ�浿2, age=31, account=10000.123], 
//		         UserVO [id=testID1, name=��浿3, age=51, account=10000.123]], 
//		testID2=[UserVO [id=testID2, name=ȫ�浿1, age=61, account=3300.123], 
//		         UserVO [id=testID2, name=��浿2, age=32, account=10000.123], 
//		         UserVO [id=testID2, name=�ڱ浿3, age=22, account=10000.123]]}
	}

}
