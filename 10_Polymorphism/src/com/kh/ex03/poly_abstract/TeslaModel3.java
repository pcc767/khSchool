package com.kh.ex03.poly_abstract;

// ������ �귣��
public class TeslaModel3 extends Car{
	
	public TeslaModel3() {
		// �������ε� CC���..?
		super(175); // kW/h �����ε�..?
	}
	
	@Override
	public void oilling() { // �������ε�?
		System.out.println("�⸧�� �ȸԽ��ϴ�.");
	}
	
	@Override
	public void move() {
		System.out.println("������������ (������)");
	}

}
