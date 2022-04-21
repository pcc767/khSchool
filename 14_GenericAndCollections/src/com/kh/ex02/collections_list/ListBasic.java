package com.kh.ex02.collections_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListBasic {
	
//	ArrayList - ★★★★★ 추천
//	 -> 주로 ArrayList를 사용하는데, 이유는 DB에서 데이터를 담고 탐색 용도로 많이 활용함
//	- 장점 : 탐색속도가 빠르고, 메모리를 적게 차지한다. 
//	- 단점 : 삽입, 삭제, 수정이 느리다. 

//	LinkedList
//	 -> 굳이 삽입 삭제가 빈번하지 않으면 사용하지 않음... -> 이럴 경우가 많이 없거나 다른 컬랙션(Map)을 사용함
//	- 장점 : 삽입, 삭제, 수정이 빠르다.
//	- 단점 : 탐색속도가 느리고, 메모리를 많이 차지한다.

//	Vector
//	-> Thread safe 할때 사용하나... 더 좋은 컬랙션이 많다. 굳이 안쓴다.
	
	
	public static void main(String[] args) {
		// 객체배열 문법
		UserVO[] userArray = new UserVO[3];
		userArray[0] = new UserVO("testID1", "김길동", 23, 100000.123);
		userArray[1] = new UserVO("testID2", "홍길동", 43, 200000.123);
		userArray[2] = new UserVO("testID3", "박길동", 53, 300000.123);
//		userArray[3] = new UserVO("testID3", "박길동", 53, 300000.123);
		
		// 배열의 단점
		// 1 . 배열의 크기를 지정하고, 크기보다 커지면 새로운 배열을 생성하고 복사 필요.
		// 2 . 중간에 데이터 삽입/삭제가 어렵다. -> 반드시 빈데이터를 메꿔야 한다.
		// 3 . 복사도 어렵고, 사용자 실수가 많다.
		// 4 . 결론 : 프로그래머라면 누구든 고통 받는다.
		
		// List 사용법
		// 1 . 초기화 문법
		// - 선언시 Type은 List<>로 하는 것이 일반적이다. ( ArrayList 명시하지 않는다.)
		List<UserVO> list1 = new ArrayList<>();				// 1. 뒤에 제네렉 문장을 생략하는 문법 (최신 문법)
		List<UserVO> list2 = new ArrayList<UserVO>();		// 2. 제네렉 문장 생략 X
		List<UserVO> list3 = new LinkedList<>();			// 3. List는 Array/Linked 호환 가능
		
		// 2. 배열을 List로 변환하는 방법
		// 1) asList 활용
		List<UserVO> userList1 = new ArrayList<UserVO>(Arrays.asList(userArray));
		
		// 2) 고전적인 알고리즘 활용법 1.
		List<UserVO> userList2 = new ArrayList<UserVO>();
		for(UserVO user : userArray) {
			userList2.add(user);
		}
		
		// 3) 고전적인 알고리즘 활용법 2.
		List<UserVO> userList3 = new ArrayList<UserVO>();
		for (int i = 0; i < userArray.length; i++) {
			userList3.add(i, userArray[i]); 	//앞쪽에 index 지정 가능.
		}
		
		//출력 방법
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
