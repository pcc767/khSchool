package com.kh.ex04.poly_interface;

public class Grandure extends HyundaiCar {

	public Grandure() {
		super(3000); // 3000 cc
	}
	
	@Override
	public void oilling() {
		System.out.println("�ֹ����� �������Դϴ�.");
	}

	@Override
	public void move() {
		System.out.println("(������)�θ�����������");
	}

	@Override
	public void nickName() {
		System.out.println("���׷���");
	}
}
