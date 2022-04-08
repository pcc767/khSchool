package com.kh.ex07.overloading;

public class Overloading {
	//�޼ҵ� �����ε��̶�?
	// - ���� �޼ҵ�(�Լ�)���̸鼭 �ٸ� Ÿ���� ���ڸ� �޾Ƶ��̰� ���� ����� �����ϰԲ� �����Ҷ� ���
	
	/*�޼ҵ� �������̵� ��Ģ
		  1. �޼ҵ��� �̸��� ���ƾ��Ѵ�.
	  	  2. �Ű������� ������ �ٸ��ų�
		  3. �Ű������� Type(����)�� �ٸ��ų�
		  4. �Ű������� Type ������ �ٸ��ų�
		  5. ��ȯ���� �����ϴ�. (return �� �ϵ� ���ϵ� �ȴ�.)
		  6. �������� �����ϴ�. (Type���θ� �Ǵ���!)
	  */
	
	void myMethod(int arg) {
		System.out.println(arg);
	}
	
	int myMethod(int arg1, int arg2) {
		System.out.println(arg1+arg2);
		return arg1+arg2;
	}
	 
	int myMethod(String arg) {
		System.out.println(arg);
		return arg.length();
	}

	
	
	public static void main(String[] args) {
		//��ǥ���� �����ε� �Լ� :
		System.out.println(12);
		System.out.println(3.14);
		System.out.println('a');
		System.out.println("hello");
		
		
		Overloading test = new Overloading();
		test.myMethod(12);
		test.myMethod("hello!!!");
		test.myMethod(12,14);
		
		
		
	}
	
	

}
