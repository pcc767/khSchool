package com.kh.ex04.poly_interface;

// 차량이 전기차임을 알리는 Interface
public interface ElectricType {
	// public static final 또는 public abstract가 생략된 문법
//	String GAS_TYPE = "ELECTRIC";
//	void charge(); // 전기 충전 기능
	
	// 표준적인 문법
	public static final String GAS_TYPE = "ELECTRIC"; // 상수
	public abstract void charge(); // 전기 충전 기능 // 추상클래스
}
