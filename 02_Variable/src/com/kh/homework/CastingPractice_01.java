package com.kh.homework;

import java.util.Scanner;

public class CastingPractice_01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("���ڸ� �Է��ϼ���(����) : ");
		char cha = sc.next().charAt(0);
//		String hex = String.format("%x",(int)cha);
//		System.out.println("unicode : "+hex);
		System.out.println(cha + "unicode : " + (int) cha);
		
		
	}

}
