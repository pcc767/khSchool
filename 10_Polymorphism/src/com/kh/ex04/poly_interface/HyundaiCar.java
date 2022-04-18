package com.kh.ex04.poly_interface;

public abstract class HyundaiCar extends Car {
	// abstract 클래스의 특징
	// 1. new로 생성되지 않는다!
	// 2. abstract 메소드를 가질수 있다.
	// 3. 일반 메소드나 멤버 변수 선언이 자유롭다!
	
	// 사용법 : 상속이나 type으로 활용된다.
	
	// 추상 클래스도 멤버 변수를 가질 수 있다.
	public String serviceName = "블루핸즈";
	
	public HyundaiCar(int cc) {
		super(cc);
	}
	
	// 추상메소드 : 몸통을 가지지 않는다. 그리고 상속받은 Class(자식)에서 강제로 생성해야한다!
	abstract public void nickName();
	
	// 일반메소드 : 공통적인 기능을 구현할때는 일반 메소드를 사용한다.
	public void service() { // 블루핸즈로 간다.
		System.out.println(serviceName + "으로 출발합니다.");
	}
	
//	public static void main(String[] args) {
//		HyundaiCar car = null;
//		car = new HyundaiCar(13); // 추상클래스는 생성 불가능하다!
//	}
}
