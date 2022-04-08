package com.kh.homework;

import java.util.Scanner;

public class VariablePractice_01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		String gen = null;
		int age = 0;
		int tall = 0;
		
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		
		System.out.println("성별을 입력하세요.");
		gen = sc.nextLine();
		
		System.out.println("나이를 입력하세요.");
		age = Integer.parseInt(sc.nextLine());
		
		System.out.println("키를 입력하세요.");
		tall = Integer.parseInt(sc.nextLine());
		
		System.out.println();
		System.out.println("키 "+tall+"cm인 "+age+"살"+" "+gen+" "+name+"님 반갑습니다.");
		
		
		
	}

}
