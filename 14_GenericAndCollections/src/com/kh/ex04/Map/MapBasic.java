package com.kh.ex04.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapBasic {
	// Map
	// Key - Value로 데이터가 구성되어 있는 컬렉션,
	// Key는 주로 숫자나 문자 활용, Value는 객체를 활용
	// Key 기준으로만 중복확인함 -> Comparable, equals 필요 없음!
	
	// HashMap 		 : 순서보장 안되고, 제일 빠른 성능, 가장 많이 사용하는 Map. ★★★★★
	// LinkedHashMap : Key의 삽입순서 보장. ★★
	// TreeMap 		 : Key의 문자열로 정렬. ★★
	// HashTable 	 : HashMap Thread Safe Version ★ 
	//					현업에서 자주사용  -> ConcurrentHashMap ★★★

	public static void main(String[] args) {
		
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("testID1", "김길동1", 21, 10000.123));
		list.add(new UserVO("testID1", "김길동1", 21, 10000.123)); // 완전동일
		list.add(new UserVO("testID3", "김길동3", 23, 444000.123));
		list.add(new UserVO("testID2", "홍길동3", 41, 3300.123)); // ID 만 다름
		list.add(new UserVO("testID2", "김길동2", 22, 10000.123));
		
	
		//    key   value
		Map<String, UserVO> hashMap = new HashMap<>();
		Map<String, UserVO> linkedHashMap = new LinkedHashMap<>();
		Map<String, UserVO> treeMap = new TreeMap<>();
		
		// 데이터 삽입
		// 방법 1)
		for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).getId();
			UserVO user = list.get(i);
			hashMap.put(id, user);
			hashMap.put(list.get(i).getId(),user);
		}
		
		// 방법 2)
		for(UserVO user : list) {
			linkedHashMap.put(user.getId(), user);
		}
		
		// 방법 3)  -> 최신 문법
		list.forEach((user) -> treeMap.put(user.getId(),user));
		
		
		System.out.println("hashMap");
		System.out.println(hashMap);
		System.out.println(hashMap.keySet().size());
		System.out.println(hashMap.size());
		System.out.println(hashMap.get("testID2"));
		System.out.println();

		System.out.println("linkedHashMap");
		System.out.println(linkedHashMap);
		System.out.println(linkedHashMap.keySet().size());
		System.out.println(linkedHashMap.size());
		System.out.println(linkedHashMap.get("testID2"));
		System.out.println();
		
		System.out.println("treeMap");
		System.out.println(treeMap);
		System.out.println(treeMap.keySet().size());
		System.out.println(treeMap.size());
		System.out.println(treeMap.get("testID2"));
		System.out.println();


		
	}
	
	
	


}
