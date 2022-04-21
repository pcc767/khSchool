package com.kh.ex01.generic;

public class GenericBasic {
	
	public static void main(String[] args) {
		// Type을 정하지 않고 Object 배열을 선언하는 경우 문제점.
		// 1. 지정된 Type이 아닌 다른 Type에 대한 Check가 항상 필요하다. (instanceof)
		// 2. 정상적인 경우에도 반드시 Casting을 해야 한다.
		
		Object[] arrays = new Object[10];
//		arrays[0] = new User("Test","홍길동",21);
//		arrays[1] = "Test는 홍길동입니다.";
//		
//		//정상적인 사용법 -> 반드시 Type casting이 필요하다.
//		System.out.println(((User)arrays[0]).getName());
//		
//		// 비정상적인 상요 -> 프로그램이 죽는다.
//		System.out.println(((User)arrays[1]).getName());
		
//		MyGenericArray를 통한 배열 사용법 -> 문제가 해결됨.
		
		MyGenericArray<User> userArrays = new MyGenericArray<User>(10);
		userArrays.add(new User("test1","홍길동",21));
		userArrays.add(new User("test2","김길동",21));
		userArrays.add(new User("test3","박길동",21));
		userArrays.add(new User("test4","최길동",21));
		userArrays.add(new User("test5","이길동",21));
//		userArrays.add("저는 홍길동"); // 안되는 문법 -> 제네릭을 통해 문법 체크를 컴파일에서 해준다.
		
		// casting이 필요없다.
		User user = userArrays.get(0);
		System.out.println(user.toString());
		System.out.println(userArrays.get(0));
		System.out.println(userArrays.get(1));
		System.out.println(userArrays.get(2));
		
		//MyGenericArray 상속을 통한 문법 1
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
		
		//MyGenericArray 상속을 통한 문법 2 - 일반적인 문법
		MyGenericArray<Number> numberArrays2 = new MyGenericArray<>(10);
		numberArrays2.add(new Integer(4));
		numberArrays2.add(31);	// Auto Boxing
		numberArrays2.add(new Double(3.131212));
		
		System.out.println(numberArrays2.get(0));
		System.out.println(numberArrays2.get(1));
		System.out.println(numberArrays2.get(2));
		
	
		

	}

}
