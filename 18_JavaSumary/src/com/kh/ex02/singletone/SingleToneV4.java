package com.kh.ex02.singletone;

/**
 * 2�� Locking ����� ���� �Ӱ� ������ ���� ���ڼ��� �ذ��ϰ� �ӵ��� �ذ���.
 * 
 */
public class SingleToneV4 {
	private static SingleToneV4 instance;
	private SingleToneV4() {
		value++;
	}
	public static int value = 0;
	
	public static SingleToneV4 getInstance() {
		if(instance == null) {
			synchronized(SingleToneV4.class) { // 2�� lock ��� 
				if(instance == null) {
					instance = new SingleToneV4();
				}
			}
		}
		return instance;
	}
}
