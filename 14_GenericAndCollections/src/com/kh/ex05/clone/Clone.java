package com.kh.ex05.clone;

public class Clone {
	
	//��ü�� �����ϴ� ���
	public static void main(String[] args) {
		UserVO user1 = new UserVO("testID1", "��浿1", 21, 10000.123);
		UserVO user2 = new UserVO("testID2", "��浿2", 22, 10000.123);		
		
		// 1. �������� ��� �ڡڡ�
		UserVO user1copy = new UserVO(); // ������ �ʱ�ȭ
		user1copy.setId(user1.getId());
		user1copy.setName(user1.getName());
		user1copy.setAge(user1.getAge());
		user1copy.setAccount(user1.getAccount());
		
		
		System.out.println(user1copy == user1);
		System.out.println(user1copy.equals(user1));
		user1copy.setName("ȫ�浿777");
		System.out.println(user1);
		System.out.println(user1copy);
		System.out.println("------------------------------------------------");
		
		// 2. cloneable�� ��Ӹ� �ϴ� ���
		UserVO user2Copy = null;
		try {
			user2Copy = (UserVO)user2.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user2Copy);
		System.out.println("------------------------------------------------");
		
		
		//3. cloneable + Override + ����������(UserVO���� + clone @Override) ����ó�� �ڡڡڡڡڡڡڡڡڡڡ�
		
		UserVO user3Copy = user2.clone();
		System.out.println(user3Copy == user1);
		System.out.println(user3Copy.equals(user1));
		user3Copy.setName("ȫ�浿777");
		System.out.println(user2);
		System.out.println(user3Copy);
		
		

		

	}

}
