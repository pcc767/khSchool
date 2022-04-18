package com.kh.ex04.poly_interface;

public class _Run {
	public static void main(String[] args) {
		Car[] carArray = new Car[5];
		
//		carArray[0] = new Car(1000); // abstract임으로 생성 불가!
		carArray[0] = new Avante();
		carArray[1] = new Sonata();
		carArray[2] = new Grandure();
		carArray[3] = new BMWM5();
		carArray[4] = new TeslaModel3();
		
		for(int i = 0; i< carArray.length; i++) {
			printCar(carArray[i]);

		}
	}

	private static void printCar(Car car) { // 인자가 다형성 속성을 사용중!
		System.out.println(car.toString()); // 정적 바인딩 가능! Car만 메소드 보유중
		
		car.move();
					
		if(car instanceof ElectricType) {
			System.out.println(ElectricType.GAS_TYPE);
			((ElectricType)car).charge();
		}else {
			car.oilling();			
		}
		
		if(car instanceof HyundaiCar) {
			((HyundaiCar)car).nickName();
			((HyundaiCar)car).service();
		}
		
		if(car instanceof TeslaCar) {
//			((TeslaCar)car).buyBitcoin();		\\아래와 동일
			TeslaCar teslaCar = (TeslaCar)car;
			teslaCar.buyBitcoin();
		}
		
		if(car instanceof OverseasType) {
			((OverseasType)car).origin();
		}

		
		System.out.println("--------------------------------------");
	}
}
