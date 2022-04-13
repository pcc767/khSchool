package com.kh.ex01.basic_inherit;

import java.util.Date;

public class BasicInherit /*extends Object*/{
	//모든 클래스는 Object에서 상속받아 생성한 클래스이며, Object 상속 문법은 생략 가능하다.
	
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new String("안녕?");
		Object obj3 = new Date();
		Object obj4 = new BasicInherit();
		
		// Class 의 이름 출력
		System.out.println(obj1.getClass().getName());	
		System.out.println(obj2.getClass().getName());	
		System.out.println(obj3.getClass().getName());	
		System.out.println(obj4.getClass().getName());	
		
		// Class의 조상을 알아보는 방법
		System.out.println(obj1.getClass().getSuperclass());	// null : 부모가 없다. 시조이닌까!!!!
		System.out.println(obj2.getClass().getSuperclass());	
		System.out.println(obj3.getClass().getSuperclass());	
		System.out.println(obj4.getClass().getSuperclass());	
	

	}

}
