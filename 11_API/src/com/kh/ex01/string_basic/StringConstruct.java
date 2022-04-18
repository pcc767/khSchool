package com.kh.ex01.string_basic;

public class StringConstruct {

	public static void main(String[] args) {
		
		// String ��� Tip
		// 1. String�� ����Ҵ� Heap�� String constant pool �ΰ����� �ִ�.
		// 2. String constant pool�� ����ϴ� ���� �޸� �������鿡�� �����ϴ�.
		// 3. String�� new �������� �ʴ´�. // Heap�� ������ ������� �ʴ´�.

		
		//String Pool Test
		String str1 = "Test String";
		String str2 = new String("Test String");
		String str3 = str2.toString();
		String str4 = str2.intern();
		
		System.out.println(str1.hashCode()); // ��ü�� �����ϰ� �ĺ��ϱ� ���� ��ǥ��
		System.out.println(str2.hashCode()); // 1/42��
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		
		// equals�� hashCode������� �񱳰� �ȴ�.
		System.out.println("-------equals--------");
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str4));
		System.out.println("---------------------");

		// ==�� �޸����� �ּҰ����� ���Ѵ�.
		System.out.println("------- ==(��) ------");
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);
		System.out.println("---------------------");
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		// ���ڿ� �ʱ�ȭ ���(���� ��õ ����)
		String temp = ""; //�������� �ʱ�ȭ
		temp += "123"+","+"ȫ�浿";
		System.out.println(temp);

		
		
		
		
	}

}
