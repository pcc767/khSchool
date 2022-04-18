package com.kh.ex02.poly_example;

public class Grandure extends Car {

	public Grandure() {
		super(3000); // 3000 cc
	}
	
	@Override
	public void oilling() {
		System.out.println("휘발유를 주유중입니다.");
	}

	@Override
	public void move() {
		System.out.println("(조용히)부르르르르르릉");
	}
	
	public void grandureNickName() {
		System.out.println("각그랜저");
	}
}
