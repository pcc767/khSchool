package com.kh.ex03.poly_abstract;

public class BMWM5 extends Car {

	public BMWM5() {
		super(4395); // 4395cc ��ⷮ�� �ö󰥼��� ���ݵ� �ö�� ��, ��ũ, ����
	}
	
	@Override
	public void oilling() {
		System.out.println("��� �ֹ����� �������Դϴ�.");
		System.out.println("�ֹ��� �Դ� �ϸ��Դϴ�.");
	}
	
	@Override
	public void move() {
		System.out.println("�ο��ƿͿ��ƿ;ӾƾӾ�(�ִ��� �ò�����)");
	}
	
	public void doc3sa() { // ����� = BMW, ����, �ƿ��...
		System.out.println("���Ͽ��� �� ���Դϴ�.");
	}
	
}
