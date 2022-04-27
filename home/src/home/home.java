package home;

import java.util.Scanner;

public class home {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력 1 : ");
		int num1 = sc.nextInt();
		System.out.println("입력 1 : ");
		int num2 = sc.nextInt();
		
		try {
			System.out.println("두 수의 나눗셈 결과 : "+ num1/num2);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("부적절한 나눗셈을 시도하였습니다.");
		}

	}
	
}
