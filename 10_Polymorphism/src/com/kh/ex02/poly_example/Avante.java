package com.kh.ex02.poly_example;

public class Avante extends Car {

	public Avante() {
		super(1600); // 아반떼는 1600cc 이다.
	}
	
	@Override
	public void oilling() {
		System.out.println("휘발유를 주유중입니다.");
	}
	
	public void avanteNickName() {
		System.out.println("아방이");
	}
}
