package com.kh.ex01.basic;

import java.math.BigDecimal;

public class BasicVariable2 {
	// �⺻�� Type  = 8��.
	// 1. ������ : byte(1), short(2), int(4), long(8)
	// 2. �Ǽ� : float(4), double(8)
	// 3. ���� : char(2)
	// 4. ���� : boolean(1)
	// �⺻���� Ư¡ : �޸𸮿� ���� ���� ����Ǵ� ����.
	// ���� : �������� ��� �޸𸮿� ����Ǵ� ���� �޸�(heap ����) �ּ����� �����.
	
	public static void main(String[] args) {
		byte byteValue = 100;
		short shortValue = 200;
		int intValue = 40000;
		long longValue = 1000000000000000000L;  // long ���ͷ��� �ݵ�� �ڿ� l or L �� �پ����.
		
		float floatValue = 3.141592653589793238f;
		double doubleValue = 3.141592653589793238;
		

		System.out.println(floatValue);
		System.out.println(doubleValue);
		// �ε��Ҽ����� ǥ���� ������ �����Ѵٴ� ���� �����ϰ� ���.
		// ��ǻ�Ϳ��� �ε��Ҽ��� ������ �׻� ������ �����ϳ� double�� ����� ��� ������ ���� ����.
		// �ε������� ǥ�� ����� ������(10^-1), ������(314159265...)�� �����Ǿ� ����.
		// ���� ���� ũ�⿡ ���� ǥ���� �������̴�.
		
		// BigDeciaml -> ������ ���� �� ��.
		// ���� : �ε��Ҽ��� ���� ��ü�� ������, �ε��Ҽ��� ���꺸�� 10�� �� ����...
		BigDecimal bigValue = new BigDecimal(3.14159265358964354968504968793238);
		
		float testFloat = 0.1f + 0.2f;
		double testDouble = 0.1 + 0.2;
		System.out.println(testFloat); // 0.3
		System.out.println(testDouble); // 0.3
		// ��� : �ε��Ҽ����� �׻� ���� ���������� �ڸ��� ������ �׻� �����ʿ�.
		
		String str = String.format("%.2f", testDouble);
		System.out.println(str);
		
		// 3. ���� : char(2)
		char charValue1 = 65;	//A
		char charValue2 = 'A';
		char charValue3 = '��';
		
		String strValue = "�ȳ��ϼ���";
		
		System.out.println(charValue1);
		System.out.println(charValue2);
		System.out.println(charValue3);
		System.out.println(strValue);
		System.out.println(strValue+charValue1+charValue2+charValue3);
		System.out.println(charValue1+charValue2+charValue3+strValue);
		
		for(int i =0; i<26; i++) 
			System.out.print((char)(i+65));
		
		System.out.println();
		System.out.println((int)'��');
		
		// 4. ���� : boolean(1)
		boolean isTrue = true;
		System.out.println(isTrue);
		isTrue = false;
		System.out.println(isTrue);
		
		//�����? ���α׷��ֿ��� ���� ������ �ʴ� ��
		//��� ǥ��� : ��� �빮�� ����ϰ� ����� '_' ����� ��
		final int LECTURE_MAX_SIZE = 30;
//		LECTURE_MAX_SIZE = 60;
		
		System.out.println(LECTURE_MAX_SIZE);
		System.out.println(LECTURE_MAX_SIZE2);

		
	}
	
	// ����� public final static���� ǥ���ϴ� ���� ����
	public final static int LECTURE_MAX_SIZE2 = 60;


}
