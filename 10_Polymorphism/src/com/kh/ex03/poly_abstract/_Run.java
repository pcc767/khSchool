package com.kh.ex03.poly_abstract;

public class _Run {
	public static void main(String[] args) {
		Car[] carArray = new Car[4];
		
//		carArray[0] = new Car(1000); // abstract������ ���� �Ұ�!
		carArray[0] = new Avante();
		carArray[1] = new Sonata();
		carArray[2] = new Grandure();
		carArray[3] = new BMWM5();
		
		for(int i = 0; i< carArray.length; i++) {
			printCar(carArray[i]);
			
			// java.lang.ClassCastException���� ���� �� �� �״� ����
//			((Avante)carArray[i]).avanteNickName(); // �����϶� ���� ����!
		}
	}

	private static void printCar(Car car) { // ���ڰ� ������ �Ӽ��� �����!
		System.out.println(car.toString()); // ���� ���ε� ����! Car�� �޼ҵ� ������
		
		car.move(); // ���� ���ε� : ���� ���� ȣ��� �޼ҵ带 Ư������ ���Ͽ� ������ ���ϰ�,	
					//            ���� �߿� �ǽð�(����)���� ȣ��� �޼ҵ尡 �������� ���
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
