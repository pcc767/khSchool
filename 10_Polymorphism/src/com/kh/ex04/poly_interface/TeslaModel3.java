package com.kh.ex04.poly_interface;

// ������ �귣��
public class TeslaModel3 extends TeslaCar implements ElectricType, OverseasType{
	public TeslaModel3() {
		super(175);
	}
	
	@Override
	public void oilling() {
		charge();
	}
	
	@Override
	public void buyBitcoin() {
		System.out.println("1 ��Ʈ�������� �����մϴ�.");
	}

	@Override
	public void charge() {
		System.out.println("�������� �����մϴ�.");
		System.out.println("�������� 1�ð� ���ҽ��ϴ�.");
	}

	@Override
	public void origin() {
		System.out.println("Made in china");
	}
	
	
}
