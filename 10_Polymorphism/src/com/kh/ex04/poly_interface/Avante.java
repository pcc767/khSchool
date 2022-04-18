package com.kh.ex04.poly_interface;

public class Avante extends HyundaiCar {

	public Avante() {
		super(1600); // 아반떼는 1600cc 이다.
	}
	
	@Override
	public void oilling() {
		System.out.println("휘발유를 주유중입니다.");
	}
	
	@Override
	public void nickName() {
		System.out.println("아방이");
	}
}
