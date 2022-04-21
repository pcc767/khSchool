package com.kh.ex01.generic;

public class GenericBasic {
	
	public static void main(String[] args) {
		// Type�� ������ �ʰ� Object �迭�� �����ϴ� ��� ������.
		// 1. ������ Type�� �ƴ� �ٸ� Type�� ���� Check�� �׻� �ʿ��ϴ�. (instanceof)
		// 2. �������� ��쿡�� �ݵ�� Casting�� �ؾ� �Ѵ�.
		
		Object[] arrays = new Object[10];
//		arrays[0] = new User("Test","ȫ�浿",21);
//		arrays[1] = "Test�� ȫ�浿�Դϴ�.";
//		
//		//�������� ���� -> �ݵ�� Type casting�� �ʿ��ϴ�.
//		System.out.println(((User)arrays[0]).getName());
//		
//		// ���������� ��� -> ���α׷��� �״´�.
//		System.out.println(((User)arrays[1]).getName());
		
//		MyGenericArray�� ���� �迭 ���� -> ������ �ذ��.
		
		MyGenericArray<User> userArrays = new MyGenericArray<User>(10);
		userArrays.add(new User("test1","ȫ�浿",21));
		userArrays.add(new User("test2","��浿",21));
		userArrays.add(new User("test3","�ڱ浿",21));
		userArrays.add(new User("test4","�ֱ浿",21));
		userArrays.add(new User("test5","�̱浿",21));
//		userArrays.add("���� ȫ�浿"); // �ȵǴ� ���� -> ���׸��� ���� ���� üũ�� �����Ͽ��� ���ش�.
		
		// casting�� �ʿ����.
		User user = userArrays.get(0);
		System.out.println(user.toString());
		System.out.println(userArrays.get(0));
		System.out.println(userArrays.get(1));
		System.out.println(userArrays.get(2));
		
		//MyGenericArray ����� ���� ���� 1
		MyGenericArray<? super Number> numberArrays = new MyGenericArray<>(10);
		numberArrays.add(new Integer(4));
		numberArrays.add(31);	// Auto Boxing
		numberArrays.add(new Double(3.131212));
		numberArrays.add(new Float(3.14));
//		numberArrays.add("test");
		
		System.out.println(numberArrays.get(0));
		System.out.println(numberArrays.get(1));
		System.out.println(numberArrays.get(2));
		System.out.println(numberArrays.get(3));
		
		System.out.println("--------------------------------------------------------\n");
		
		//MyGenericArray ����� ���� ���� 2 - �Ϲ����� ����
		MyGenericArray<Number> numberArrays2 = new MyGenericArray<>(10);
		numberArrays2.add(new Integer(4));
		numberArrays2.add(31);	// Auto Boxing
		numberArrays2.add(new Double(3.131212));
		
		System.out.println(numberArrays2.get(0));
		System.out.println(numberArrays2.get(1));
		System.out.println(numberArrays2.get(2));
		
	
		

	}

}
