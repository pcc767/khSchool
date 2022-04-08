package com.kh.homework;

import java.util.Scanner;

public class CastingPractice_02 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("±¹¾î : ");
		double kor = sc.nextDouble();
		System.out.println("¿µ¾î : ");
		double eng = sc.nextDouble();
		System.out.println("¼öÇÐ : ");
		double math = sc.nextDouble();
		
		double total = kor+eng+math;
		double avg = total/3;
		
		System.out.println("ÃÑÁ¡ : "+(int)total);
		System.out.println("Æò±Õ : "+(int)avg);
		
		

		
		
	}

}
