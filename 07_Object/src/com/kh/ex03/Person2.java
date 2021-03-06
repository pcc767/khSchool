package com.kh.ex03.object_app;

public class Person2 {
	// Person의 제대로 된 버전 -> 표준
	// ValueObject : VO로 읽고, 데이터만 있는 객체의 표현법, 멤버 변수 + getter, setter + 기타(toString)
	// ValueObject의 객체에서는 멤버변수를 private으로 접근 제한 한다.
	// 이유 : 외부에서 직접 변수로 접근하지 않고, getter/setter로 기능을 제한.
	
	private String name;
	private int age;
	private String phoneNum;
	private String pId;
	
	// 인자 없는 생성자.
	public Person2() {
		name = "이름 없음";		
	}
	
	// 인자 있는 생성자 만드는 법
	// 1. 지역변수, 로컬변수의 이름을 불일치 -> 현업에서 사용하지 않음.
//	public Person2(String _name, int _age, String _phoneNum, String _pId) {
//		// 객체를 생성할떄 멤버변수의 초기값을 받아 입력하는 생성자
//		name = _name;
//		age = _age;
//		phoneNum = _phoneNum;
//		pId = _pId;
//
//	}
	
	//인자 있는 생성자 만드는 법 -> 현업에서 추천
	public Person2(String name, int age, String phoneNum, String pId) {
		// 객체를 생성할떄 멤버변수의 초기값을 받아 입력하는 생성자
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.pId = pId;
		
	}
	
	// getter - 이름을 read only로 사용
	public String getName() {
		return name;
	}
	
	// setter - 전화번호 - Write only로 수정 가능하게끔
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String toString() {
		String result = "";
		result = result +  "이름 : "+name+"\n";
		result = result +  "나이 : "+age+"\n";		
		result += "전화번호 : "+phoneNum+"\n";
		result += "주민번호 : "+pId+"\n";
		return result;
	}
	
	
	
}
