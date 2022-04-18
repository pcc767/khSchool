package com.kh.ex04.poly_interface;

// �׽��� �귣�� �ڵ���
public abstract class TeslaCar extends Car {
	protected double kWh = 0; // ���������� ��ⷮ�� ���� ���� �뷮
	
	public TeslaCar(double kWh) {
		super(0);
		this.kWh = kWh;
	}
	
	@Override
	public void move() {
		System.out.println("(���� ����)��������");
	}
	
	// �׽��� �ڵ����� ��Ʈ�������� �ŷ� ����!
	public abstract void buyBitcoin();
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Name : " + this.getClass().getSimpleName());
		sb.append(", Brand : Tesla");
		sb.append(", kWh : " + kWh);
		return sb.toString();
	}
}
