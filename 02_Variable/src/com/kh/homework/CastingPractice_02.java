package com.kh.homework;

import java.util.Scanner;

public class CastingPractice_02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("���� : ");
		double kor = sc.nextDouble();
		System.out.println("���� : ");
		double eng = sc.nextDouble();
		System.out.println("���� : ");
		double math = sc.nextDouble();
		
		double total = kor+eng+math;
		double avg = total/3;
		
		System.out.println("���� : "+(int)total);
		System.out.println("��� : "+(int)avg);
		
		

		
		
	}

}
