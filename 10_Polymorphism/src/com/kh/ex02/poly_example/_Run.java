package com.kh.ex02.poly_example;

public class _Run {
	public static void main(String[] args) {
		Car[] carArray = new Car[5];
		
		carArray[0] = new Car(1000); // ���� �ڵ���
		carArray[1] = new Avante();
		carArray[2] = new Sonata();
		carArray[3] = new Grandure();
		carArray[4] = new BMWM5();
		
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
		
		if(car instanceof Avante) {
			((Avante)car).avanteNickName();
		}
		if(car instanceof Sonata) {
			((Sonata)car).sonataNickName();
		}
		if(car instanceof Grandure) {
			((Grandure)car).grandureNickName();
		}
		if(car instanceof BMWM5) {
			((BMWM5)car).doc3sa();
		}
		
		System.out.println("--------------------------------------");
	}
}
