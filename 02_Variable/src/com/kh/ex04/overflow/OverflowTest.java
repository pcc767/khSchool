package com.kh.ex04.overflow;

public class OverflowTest {
	
	public static void main(String[] args) {
		byte temp = 125;
		System.out.println(++temp);
		System.out.println(++temp);
		System.out.println(++temp);
		System.out.println(++temp);
		// 의도하지 않은 overflow.
		
		// 300이 되지 않고 무한반복, 그렇기 때문에 int를 사용한다.
		for(byte i=0; i<300; i++)
			System.out.println(++temp);
	}

}
