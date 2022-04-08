package com.kh.ex01.conditional;

import java.util.Scanner;

public class SwitchStatement2 {
	//전공성적 입력받기  -> ABCDEF
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("전공성적을 입력하세요 : ");
		char grade = sc.nextLine().charAt(0);  // 앞에 한글자 가져오기!
		
		switch(grade) {
		case 'A' :
		case 'a' :
			System.out.println("A학점 입니다.");
			break;
		case 'B' :
		case 'b' :
			System.out.println("B학점 입니다.");
			break;
		case 'C' :
		case 'c' :
			System.out.println("C학점 입니다.");
			break;
		case 'D' :
		case 'd' :
			System.out.println("D학점 입니다.");
			break;
		default :
			System.out.println("F학점 입니다.");
			break;
			
			
		}
		
	}


}
