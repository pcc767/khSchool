package com.kh.ex02.singletone;

/**
 * �ʹݺ��� �����Ǵ� �������� �ذ��ϰ�, ����Ҷ��� ��ü�� �����ϵ��� ������ �ܼ�����
 * ������ : ��ü�� ������ �����ɼ� �ִ�.
 */


public class SingleToneV2 {
	private static SingleToneV2 instance;
	
	public static int count = 0;	
	//private construct
	private SingleToneV2() {
		count++;
	}
	
	//��ɾ�� ���� ���� ������ ������� �������� ���� �Ʒ� �ڵ忡 ������ ����.
	public static SingleToneV2 getInstance() {
		if(instance == null) {
			instance = new SingleToneV2();
		}
		return instance;
	}

}
