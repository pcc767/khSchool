package com.kh.ex02.singletone;

/**
 * �ʹݺ��� �����Ǵ� �������� �ذ��ϰ�, ����Ҷ��� ��ü�� �����ϵ��� ������ �ܼ���������
 * synchronized�� Ű���� ���� �޼ҵ� ������ ����(Atomic) ������ ������.
 * -> ����ȭ �������� �Ӱ迵��(���� ����)�� ���� ��ȣ�� Ȯ�������� �Ѱ� �̻��� ��ü�� �����Ҽ� ����.
 * 
 * ������ : ������ ���信�� ����ϱ� �ſ� ������.
 * 
 */



public class SingleToneV3 {
	private static SingleToneV3 instance;
	
	public static int count = 0;	
	//private construct
	private SingleToneV3() {
		count++;
	}
	
	//synchronized : �ش� �޼ҵ忡�� �ϳ��� thread ��ü�� ������ �� �ִ�.
	public static synchronized SingleToneV3 getInstance() {
		if(instance == null) {
			instance = new SingleToneV3();
		}
		return instance;
	}

}
