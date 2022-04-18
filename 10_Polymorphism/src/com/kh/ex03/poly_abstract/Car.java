package com.kh.ex03.poly_abstract;

public abstract class Car { // 부모 클래스
	protected int cc = 0; // 배기량

	public Car(int cc) {
		this.cc = cc;
	}

	public void oilling() {
		System.out.println("주유중 입니다.");
	}
	
	public void move() {
		System.out.println("부릉부릉");
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Name : " + this.getClass().getSimpleName());
		sb.append(", cc : " + cc);
		return sb.toString();
	}
}





