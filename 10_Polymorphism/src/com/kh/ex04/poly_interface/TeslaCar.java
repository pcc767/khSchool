package com.kh.ex04.poly_interface;

// 테슬라 브랜드 자동차
public abstract class TeslaCar extends Car {
	protected double kWh = 0; // 전기차에서 배기량과 같은 충전 용량
	
	public TeslaCar(double kWh) {
		super(0);
		this.kWh = kWh;
	}
	
	@Override
	public void move() {
		System.out.println("(거의 무음)위이이잉");
	}
	
	// 테슬라 자동차는 비트코인으로 거래 가능!
	public abstract void buyBitcoin();
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Name : " + this.getClass().getSimpleName());
		sb.append(", Brand : Tesla");
		sb.append(", kWh : " + kWh);
		return sb.toString();
	}
}
