package com.kh.ex04.poly_interface;

public abstract class HyundaiCar extends Car {
	// abstract Ŭ������ Ư¡
	// 1. new�� �������� �ʴ´�!
	// 2. abstract �޼ҵ带 ������ �ִ�.
	// 3. �Ϲ� �޼ҵ峪 ��� ���� ������ �����Ӵ�!
	
	// ���� : ����̳� type���� Ȱ��ȴ�.
	
	// �߻� Ŭ������ ��� ������ ���� �� �ִ�.
	public String serviceName = "�������";
	
	public HyundaiCar(int cc) {
		super(cc);
	}
	
	// �߻�޼ҵ� : ������ ������ �ʴ´�. �׸��� ��ӹ��� Class(�ڽ�)���� ������ �����ؾ��Ѵ�!
	abstract public void nickName();
	
	// �Ϲݸ޼ҵ� : �������� ����� �����Ҷ��� �Ϲ� �޼ҵ带 ����Ѵ�.
	public void service() { // �������� ����.
		System.out.println(serviceName + "���� ����մϴ�.");
	}
	
//	public static void main(String[] args) {
//		HyundaiCar car = null;
//		car = new HyundaiCar(13); // �߻�Ŭ������ ���� �Ұ����ϴ�!
//	}
}
