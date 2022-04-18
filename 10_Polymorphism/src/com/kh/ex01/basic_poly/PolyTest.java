package com.kh.ex01.basic_poly;

import java.math.BigDecimal;
import java.util.Date;

public class PolyTest {
	public static void main(String[] args) {
		Object[] objArray = new Object[5]; 
		// �������� ���� ��� ��ü�� ���� Object�� ��ü�ɼ� �ִ�.
		// �����̸� �� Object? �ֻ��� �θ�(����)������
		
		objArray[0] = new Object();
		objArray[1] = new String("test");
		objArray[2] = new Date();
		objArray[3] = new BigDecimal("12412412.1231234123");
		objArray[4] = (Integer)105; // Auto Boxing
//		objArray[4] = new Integer(105); // deprecated since version 9 and marked for removal
		
		for(int i = 0; i < objArray.length; i++) {
			System.out.println(objArray[i].toString());
			// �θ��� �޼ҵ带 toString���� �������̵� �� ����
			// �������̵� �� ��� �ڽ��� toString �޼ҵ带 ȣ��
		}
	}
}
