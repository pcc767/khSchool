package com.kh.ex02.poly_example;

public class Grandure extends Car {

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
	
	public void grandureNickName() {
		System.out.println("���׷���");
	}
}
