package com.kh.ex03.poly_abstract;

// 전기차 브랜드
public class TeslaModel3 extends Car{
	
	public TeslaModel3() {
		// 전기차인데 CC라니..?
		super(175); // kW/h 단위인데..?
	}
	
	@Override
	public void oilling() { // 전기차인데?
		System.out.println("기름은 안먹습니다.");
	}
	
	@Override
	public void move() {
		System.out.println("위이이이이잉 (조용히)");
	}

}
