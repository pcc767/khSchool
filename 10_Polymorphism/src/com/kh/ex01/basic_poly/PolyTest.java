package com.kh.ex01.basic_poly;

import java.math.BigDecimal;
import java.util.Date;

public class PolyTest {
	public static void main(String[] args) {
		Object[] objArray = new Object[5]; 
		// 다형성을 통해 모든 객체의 형은 Object로 대체될수 있다.
		// 하필이면 왜 Object? 최상위 부모(조상)임으로
		
		objArray[0] = new Object();
		objArray[1] = new String("test");
		objArray[2] = new Date();
		objArray[3] = new BigDecimal("12412412.1231234123");
		objArray[4] = (Integer)105; // Auto Boxing
//		objArray[4] = new Integer(105); // deprecated since version 9 and marked for removal
		
		for(int i = 0; i < objArray.length; i++) {
			System.out.println(objArray[i].toString());
			// 부모의 메소드를 toString으로 오버라이딩 된 상태
			// 오버라이딩 된 경우 자식의 toString 메소드를 호출
		}
	}
}
