package com.kh.ex01.conditional;

import java.util.Scanner;

public class IfStatement2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요 : ");
		int value = sc.nextInt();
		
		//양수 , 0 , 음수인지 판별
		
		if(value >= 1) {
			System.out.println("양수 입니다.");
		} else if (value == 0) {
			System.out.println("0입니다.");
		} else {
			System.out.println("음수입니다.");
		}
		
		// 100, 1000, 1000보다 작거나 , 10000보다 큰 수 구별
		if(value < 100) {
			System.out.println("100보다 작습니다.");
		} else if (value < 1000) {
			System.out.println("1000보다 작습니다.");
		} else if (value < 10000) {
			System.out.println("10000보다 작습니다.");
		} else{
			System.out.println("10000보다 큽니다.");
		}
		
		// 조건식이 양수일 경우 작은 수에서 큰 수로 조건식 처리.(큰수부터 할 경우 작은수의 조건문은 선택되지 않음)
		// 큰 수부터 할 경우 &&연산자 사용  -> 비추천.
//		if(value > 10000) {
//			System.out.println("10000보다 큽니다.");
//		} else if (value <= 10000 && value > 1000) {
//			System.out.println("10000보다 작습니다.");
//		} else if (value <= 1000 && value > 100 ) {
//			System.out.println("1000보다 작습니다.");
//		} else {
//			System.out.println("100보다 작습니다.");
//		}
		

		
		// 결론 : 순서를 정리한면 깔끔하게 짤수 있고, 순서 잘못되면 조건문이 복잡해진다.
			
		
		
		
		
	}

}
