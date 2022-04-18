package com.kh.ex02.poly_example;

public class Sonata extends Car{

	public Sonata() {
		super(2000); // 2000cc
	}

	@Override
	public void oilling() {
		System.out.println("휘발유를 주유중입니다.");
	}
	
	@Override
	public void move() {
		System.out.println("소나타가 부르르르르릉");
	}
	
	public void sonataNickName() {
		System.out.println("소나 타는 차"); // 실제 이름의 유례, 고 정주영 회장의... 
	}
}
