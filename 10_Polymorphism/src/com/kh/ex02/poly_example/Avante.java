package com.kh.ex02.poly_example;

public class Avante extends Car {

	public Avante() {
		super(1600); // �ƹݶ��� 1600cc �̴�.
	}
	
	@Override
	public void oilling() {
		System.out.println("�ֹ����� �������Դϴ�.");
	}
	
	public void avanteNickName() {
		System.out.println("�ƹ���");
	}
}
