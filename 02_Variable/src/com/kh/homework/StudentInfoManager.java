package com.kh.homework;

import java.util.Scanner;

public class StudentInfoManager {
	
	// 학사정보 관리 프로그램입니다.
	// 학생의 이름, 나이, 주소, 학년, 학점(소수점 까지 관리) 입력 받아주세요.
	// 모든 정보를 입력받으면 출력하는 기능을 만들어 주세요.
	// 누구나 쉽게 입력할수 있는 Interface로 작성해주세요.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하시오 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하시오 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		
		
		System.out.print("주소를 입력하시오 : ");
		String add = sc.nextLine();

		System.out.print("학년을 입력하시오(ex : x): ");
		int grade = Integer.parseInt(sc.nextLine());
		
		System.out.print("학점을 입력하시오 : ");
		double grade2 = Double.parseDouble(sc.nextLine());
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(add);
		System.out.println(grade);
		System.out.println(grade2);

		
		
		
		
		
		
	}

}
