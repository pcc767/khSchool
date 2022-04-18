package com.kh.ex04.poly_interface;

public class _Run {
	public static void main(String[] args) {
		Car[] carArray = new Car[5];
		
//		carArray[0] = new Car(1000); // abstract������ ���� �Ұ�!
		carArray[0] = new Avante();
		carArray[1] = new Sonata();
		carArray[2] = new Grandure();
		carArray[3] = new BMWM5();
		carArray[4] = new TeslaModel3();
		
		for(int i = 0; i< carArray.length; i++) {
			printCar(carArray[i]);

		}
	}

	private static void printCar(Car car) { // ���ڰ� ������ �Ӽ��� �����!
		System.out.println(car.toString()); // ���� ���ε� ����! Car�� �޼ҵ� ������
		
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
//			((TeslaCar)car).buyBitcoin();		\\�Ʒ��� ����
			TeslaCar teslaCar = (TeslaCar)car;
			teslaCar.buyBitcoin();
		}
		
		if(car instanceof OverseasType) {
			((OverseasType)car).origin();
		}

		
		System.out.println("--------------------------------------");
	}
}
