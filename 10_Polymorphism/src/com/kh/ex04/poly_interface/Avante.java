package com.kh.ex04.poly_interface;

public class Avante extends HyundaiCar {

	public Avante() {
		super(1600); // �ƹݶ��� 1600cc �̴�.
	}
	
	@Override
	public void oilling() {
		System.out.println("�ֹ����� �������Դϴ�.");
	}
	
	@Override
	public void nickName() {
		System.out.println("�ƹ���");
	}
}
