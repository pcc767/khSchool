package com.kh.ex03.poly_abstract;

public class Sonata extends HyundaiCar{

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

	@Override
	public void nickName() {
		System.out.println("�ҳ� Ÿ�� ��"); // ���� �̸��� ����, �� ���ֿ� ȸ����... 
	}
}
