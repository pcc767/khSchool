package com.kh.ex05.clone;

public class Clone {
	
	//객체를 복사하는 방법
	public static void main(String[] args) {
		UserVO user1 = new UserVO("testID1", "김길동1", 21, 10000.123);
		UserVO user2 = new UserVO("testID2", "김길동2", 22, 10000.123);		
		
		// 1. 전통적인 방법 ★★★
		UserVO user1copy = new UserVO(); // 생성자 초기화
		user1copy.setId(user1.getId());
		user1copy.setName(user1.getName());
		user1copy.setAge(user1.getAge());
		user1copy.setAccount(user1.getAccount());
		
		
		System.out.println(user1copy == user1);
		System.out.println(user1copy.equals(user1));
		user1copy.setName("홍길동777");
		System.out.println(user1);
		System.out.println(user1copy);
		System.out.println("------------------------------------------------");
		
		// 2. cloneable을 상속만 하는 방법
		UserVO user2Copy = null;
		try {
			user2Copy = (UserVO)user2.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user2Copy);
		System.out.println("------------------------------------------------");
		
		
		//3. cloneable + Override + 내부적으로(UserVO파일 + clone @Override) 예외처리 ★★★★★★★★★★★
		
		UserVO user3Copy = user2.clone();
		System.out.println(user3Copy == user1);
		System.out.println(user3Copy.equals(user1));
		user3Copy.setName("홍길동777");
		System.out.println(user2);
		System.out.println(user3Copy);
		
		

		

	}

}
