package com.kh.homework;

import java.util.Scanner;

public class VariablePractice_02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		System.out.println();
		System.out.println("===== 결과 =====");
		System.out.println("더하기 결과 : "+(num1+num2));
		System.out.println("빼기 결과 : "+(num1-num2));
		System.out.println("곱하기 결과 : "+(num1*num2));
		System.out.println("나누기 몫 결과 : "+(num1%num2));
		
		
		
		
		
		
		
		
		
	}

}
