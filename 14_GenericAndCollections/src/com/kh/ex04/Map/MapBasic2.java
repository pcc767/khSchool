package com.kh.ex04.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapBasic2 {
	public static void main(String[] args) {
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("testID1", "김길동1", 21, 10000.123));
		list.add(new UserVO("testID1", "김길동1", 21, 10000.123)); // 완전동일
		list.add(new UserVO("testID3", "김길동3", 23, 444000.123));
		list.add(new UserVO("testID2", "홍길동3", 41, 3300.123)); // ID 만 다름
		list.add(new UserVO("testID2", "김길동2", 22, 10000.123));
		
		//   Key    Value
		Map<String, UserVO> hashMap = new HashMap<>();

		// 1. 데이터 삽입하는 방법
		for(UserVO user : list) {
			hashMap.put(user.getId(), user); // 일반적인 사용법 : put
			
//			UserVO user2 = hashMap.putIfAbsent(null, user); // key값이 없을때 사용하는 메소드
//			if(user2 == null) {
//				System.out.println("Key값 없음!");
//			}
			//- Key 값이 존재하는 경우 Map의 Value의 값을 반환하고, 
			//  Key값이 존재하지 않는 경우 Key와 Value를 Map에 저장하고 Null을 반환합니다.
		}
		System.out.println(hashMap.toString().replace("],", "],\n")); // 디버깅용도 
		System.out.println("-------------------------------------");
		
		
		// 2. 순회하는 방법
		Set<String> keySet = hashMap.keySet(); // 키로 이뤄진 세트
		Iterator<String> iter = keySet.iterator();
//		Iterator<String> iter2 = hashMap.keySet().iterator();

//		System.out.println(hashMap.get("test 없는 아이디")); // 없으면 값이 null로 나옴!
		System.out.println(hashMap.getOrDefault("test 없는 아이디", new UserVO())); // 없으면 값이 디폴트 값!
		System.out.println("-------------------------------------");
		
		while(iter.hasNext()) {
			String key = iter.next();
//			System.out.println(hashMap.get(key)); // 값이 없으면 null 반환!
			System.out.println(hashMap.getOrDefault(key, new UserVO()));
			// 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환하고, 그렇지 않으면 디폴트 값이 반환됩니다.
		}
		System.out.println("-------------------------------------");
		
		ArrayList<String> list2 = new ArrayList<String>(keySet);
		for(String key : list2) {
			System.out.println(hashMap.get(key));
		}
		System.out.println("-------------------------------------");
		
		
		// 3. 데이터를 추가하고 중복된 데이터 확인하고 중복되지 않으면 Map에 데이터 넣는 코드
		list.add(new UserVO("testID4", "김길동4", 32, 40.123));
		list.add(new UserVO("testID5", "홍길동5", 23, 300.123)); 
//		for(UserVO user : list) {
//			System.out.println(user);
//		}
		System.out.println("-------------------------------------");
		
		for(UserVO user : list) {
			String key = user.getId();
			
			// map에 중복된 아이디가 있는지 묻는 코드
			if(hashMap.containsKey(key) == true) {
				// 중복된 경우
				System.out.println("ID가 중복되었습니다. Key : " + key);
				
				// 객체도 같은지 비교하는 코드
				if(user.equals(hashMap.get(key)) == true) {
					System.out.println("사용자 정보가 완전 일치합니다.");
					System.out.println(user);
				}else {
					System.out.println("ID는 중복되고, 사용자 정보가 일치하지 않습니다.");
					System.out.println(user);
				}
			}else {
				// 중복되지 않은 경우
				hashMap.put(key, user);
				System.out.println("중복되지 않았습니다.");
				System.out.println(user);
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");

		// 삭제하기
		System.out.println("--------------삭제하기--------------");
		UserVO removeUser = hashMap.remove("testID1");
		System.out.println("removeUser : " + removeUser);
		System.out.println(hashMap.get("testID1"));
		
		// 객체 수정하기
		System.out.println("--------------수정하기--------------");
		System.out.println(hashMap.get("testID2").getName());
		hashMap.get("testID2").setName("홍길순777");
		System.out.println(hashMap.get("testID2").getName());
		
		// 완전 객체를 변경하는 방법
		hashMap.replace("testID2", new UserVO("testID2", "황길순", 32, 444123));
		hashMap.put("testID2", new UserVO("testID2", "황길순", 32, 444123));
		System.out.println(hashMap.get("testID2"));

		// 데이터 모두 삭제하기.
		System.out.println("-----------clear------------");
		hashMap.clear();
		System.out.println(hashMap);
	}
}






















