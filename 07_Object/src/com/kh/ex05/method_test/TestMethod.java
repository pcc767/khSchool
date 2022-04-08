package com.kh.ex05.method_test;

public class TestMethod {
	public static void main(String[] args) {
		MyObject test = new MyObject();
		
		// static method ���� : class��Ī.�޼ҵ� �̸�
		MyObject.staicMethod();	// ststic�϶��� ���ڸ�ü�� ����, �̰� ǥ������ ����
		test.staicMethod(); 	// ������ ��ü�� ���� ���ٰ����ϳ� �������� ����.
		
		// �ϳ��� ���ڸ� �����
		test.singleParameter("�̱� �Ķ���� ����~");
		
		// ���� ���� ����
		test.multipleParameter(3, 5, "test");
		
		//���ϰ� �޴� �޼ҵ�
		int value = test.returnValue(10, 20);
		System.out.println(value);
		
		
		
		
	}

}


class MyObject{
	
	// static �޼ҵ� : �ܺο��� Ŭ������ �������� �̸����� ���� ������ �޼ҵ�. (�߿�!!!)	
	public static void staicMethod() {
		System.out.println("Call static method!!!!");
	}
	
	//1���� ���� �޴� �޼ҵ�(Parameter : ����)
	public void singleParameter(String str) {
		System.out.println(str);
	}
	
	// 2���� �̻��� ���ڸ� ������
	protected void multipleParameter(int a, int b, String str) {
		System.out.println(a +b);
		System.out.println(str);		
	}
	
	//��ȯ ���� �ִ� �޼ҵ�
	int returnValue(int a, int b) {
		return a+b;
	}
	
	
}