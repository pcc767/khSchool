package com.kh.ex06.inoutput;

import java.util.Scanner;

public class inputPractice {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문자열 입력받기
		System.out.println("문자열을 입력 바랍니다.");
		String str = sc.nextLine();
		System.out.println(str);
		
//		// 숫자 입력받기
//		System.out.println("숫자를 입력 바랍니다.");
//		int value = sc.nextInt();
//		System.out.println(value);
//		
//		// 실수 입력받기
//		System.out.println("실수를 입력 바랍니다.");
//		double value2 = sc.nextDouble();
//		System.out.println(value2);

		// 숫자 입력받기
		System.out.println("숫자를 입력 바랍니다.");
		str = sc.nextLine();
		int value3 = Integer.parseInt(str); // parseInt : 문자열을 숫자로 변환하는 함수
		System.out.println(value3);
		
		// 실수 입력받기
		System.out.println("실수를 입력 바랍니다.");
		str = sc.nextLine();
		double value4 = Double.parseDouble(str); // parseDouble : 문자열을 실수로 변환하는 함수
		System.out.println(value4);
		
	}

}
