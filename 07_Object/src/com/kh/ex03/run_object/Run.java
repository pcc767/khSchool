package com.kh.ex03.run_object;


import com.kh.ex03.object_app.Person;  // import문을 통해 해당 class만 사용하는 방법 => 이게 표준
import com.kh.ex03.object_app.*; 		// *은 와일드카드로 해당 패키지에 해당하는 모든 클래스를 임포트

public class Run {
	public static void main(String[] args) {
		Person person = new Person();	//객체 생성하는 법
		System.out.println(person.name);	// default 생성자에서 "이름 없음"으로 초기화 줌
		System.out.println(person.age);		// 0
		System.out.println(person.phoneNum);	// null
		System.out.println(person.Pid);			//	null
		System.out.println("--------------------------------------");
		
		//멤버변수 접근하는 법
		person.name = "홍길동";
		System.out.println(person.name);
		System.out.println("--------------------------------------");
		
		//setter, getter를 통해서 접근하는 법  -> 메소드 통해 접근
		person.setName("최길동");
		System.out.println(person.getName());
		System.out.println("--------------------------------------");
		
		Person2 person2 = new Person2("김길동", 31, "010-0000-0000", "910290-0000000");
		System.out.println(person2.getName());		
		System.out.println(person2.toString());
//		person2.name = "박길동" // 안됨 private로 막아서
		person2.setPhoneNum("010-3445-5555");
		System.out.println(person2.toString());
		
		
		
		
//		Person2 person2 = null;
	}

}
