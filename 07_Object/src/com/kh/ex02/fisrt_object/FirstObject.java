package com.kh.ex02.fisrt_object;

// JAVA 언어 규칙중 하나
//	-> 가능하면 '.java' 파일에는 하나의 public class 정의할 것(파일 하나당 하나의 public class만 가능)

// public class = .java파일과 이름이 일치하고 , 파일당 하나의 Class만 존재
// default class = public class가 아니고, 파일당 여러개의 class가 존재, 외부에서 접근 불가.


public class FirstObject {		// public class
	public static void main(String[] args) {
		
		Person person = new Person();
		
		person.name = "홍길동";
		person.age = 27;
		person.phoneNum = "010-0000-0000";
		person.pId = "900303-1392453";
		
		System.out.println(person.name);
		System.out.println(person.age);
		System.out.println(person.phoneNum);
		System.out.println(person.pId);
		
	}

}

class Person {		// default class
	String name;
	int age;
	String phoneNum;
	String pId;
}

class Person2 {
	String name;
	int age;
	String phoneNum;
	String pId;
}
