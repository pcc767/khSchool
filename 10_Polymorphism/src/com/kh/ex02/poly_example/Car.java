package com.kh.ex02.poly_example;

public class Car { // �θ� Ŭ����
	protected int cc = 0; // ��ⷮ

	public Car(int cc) {
		this.cc = cc;
	}

	public void oilling() {
		System.out.println("������ �Դϴ�.");
	}
	
	public void move() {
		System.out.println("�θ��θ�");
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Name : " + this.getClass().getSimpleName());
		sb.append(", cc : " + cc);
		return sb.toString();
	}
	
	
}




