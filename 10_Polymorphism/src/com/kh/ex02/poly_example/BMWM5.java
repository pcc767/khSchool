package com.kh.ex02.poly_example;

public class BMWM5 extends Car {

	public BMWM5() {
		super(4395); // 4395cc 배기량이 올라갈수록 세금도 올라고 힘, 토크, 마력
	}
	
	@Override
	public void oilling() {
		System.out.println("고급 휘발유를 주유중입니다.");
		System.out.println("휘발유 먹는 하마입니다.");
	}
	
	@Override
	public void move() {
		System.out.println("부오아와오아와앙아앙앙(최대한 시끄럽게)");
	}
	
	public void doc3sa() { // 독삼사 = BMW, 벤츠, 아우디...
		System.out.println("독일에서 온 차입니다.");
	}
	
}
