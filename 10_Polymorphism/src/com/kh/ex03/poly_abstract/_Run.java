package com.kh.ex03.poly_abstract;

public class _Run {
	public static void main(String[] args) {
		Car[] carArray = new Car[4];
		
//		carArray[0] = new Car(1000); // abstract임으로 생성 불가!
		carArray[0] = new Avante();
		carArray[1] = new Sonata();
		carArray[2] = new Grandure();
		carArray[3] = new BMWM5();
		
		for(int i = 0; i< carArray.length; i++) {
			printCar(carArray[i]);
			
			// java.lang.ClassCastException으로 동적 일 때 죽는 문장
//			((Avante)carArray[i]).avanteNickName(); // 정적일땐 문제 없다!
		}
	}

	private static void printCar(Car car) { // 인자가 다형성 속성을 사용중!
		System.out.println(car.toString()); // 정적 바인딩 가능! Car만 메소드 보유중
		
		car.move(); // 동적 바인딩 : 실행 전에 호출될 메소드를 특정하지 못하여 정하지 못하고,	
					//            실행 중에 실시간(동적)으로 호출될 메소드가 정해지는 방법
		car.oilling();
		
		if(car instanceof HyundaiCar) {
			((HyundaiCar)car).nickName();
			((HyundaiCar)car).service();
		}
		if(car instanceof BMWM5) {
			((BMWM5)car).doc3sa();
		}
		
		System.out.println("--------------------------------------");
	}
}
