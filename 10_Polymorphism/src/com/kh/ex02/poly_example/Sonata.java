package com.kh.ex02.poly_example;

public class Sonata extends Car{

	public Sonata() {
		super(2000); // 2000cc
	}

	@Override
	public void oilling() {
		System.out.println("�ֹ����� �������Դϴ�.");
	}
	
	@Override
	public void move() {
		System.out.println("�ҳ�Ÿ�� �θ���������");
	}
	
	public void sonataNickName() {
		System.out.println("�ҳ� Ÿ�� ��"); // ���� �̸��� ����, �� ���ֿ� ȸ����... 
	}
}
