package com.kh.ex03.object_app;


// 객체란? 현실 대상을 추상화한 데이터 + 메소드
// person -> 한 사람의 개인정보를 추상화시켜 놓은 것
public class Person {
	
	//선언부 - 멤버 변수 선언하는 곳
	public String name;
	public int age;
	public String phoneNum;
	public String Pid;
	
	// 생성자란?
	// - 객체가 생성될때 호출되는 특별한 메소드
	// - 용도 : 객체의 멤버변수를 초기화 하거나 초기화에 필요한 메소드를 호출할때
	public Person() {		// 생성자
		name = "이름 없음";
	}
	
	//setter - wrint only(쓰기 전용)
	public void setName(String name) {		// 지역변수이자 파라메터 name
		this.name = name;					// 멤버변수 name = 지역변수 파라메터 name
	}
	
	//getter - read only(읽기 전용)
	public String getName() {
		return name;
	}

	
	
	
	
	
}

