package com.kh.ex02.singletone;

/**
 * ������ �����̶�?
 *  - ���α׷��� ���� ���� ȿ�����̰� �����ذῡ ������ ���� �Ǵ� ��Ÿ��
 *  - 20���� ������ ������ ���� GoF ���� �̷� �߿� 2���� ���� 
 *  
 * �̱��� ����
 *  - ��ü�� Java�󿡼� �� �ϳ��� �����Ҽ� �ִ� ��� 
 *  - �ַ� ��Ƽ ������ ȯ��(����)���� �޸� ���� �Ǵ� ���� ��ü ������ ���� �����͸� �ٷ�� ���� ���
 *
 * ù��° ���Ͽ� ����
 *  -> ���� �Ǽ��� ��� ���� ���ٰ���....
 *  -> Class�� ��������� �ʴµ� Class�� �ڴ�� �����Ǿ� �޸𸮳� �ڿ��� �����.
 *  
 */

// ��õ�ϴ� �̱��� ����
public class SingleToneV1 {
	private static SingleToneV1 instance = new SingleToneV1();
	
	//��Ŭ���� �ٽ� = �����ڸ� private�� �缱���Ѵ�.
	//	-> �ܺο��� ������ �� ������ ����� �ֿ� ��Ŀ����.	
	//private construct
	private SingleToneV1() {};
	
	public static SingleToneV1 getInstance() {
		return instance;
	}
	
	// �̱���� ������ �Ϲ� �Լ��� ���� �ڸ�.
	String getName() {
		return "ȫ�浿";
	}
}
