package com.kh.homework;

import java.util.Scanner;

public class VariablePractice_03 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("가로 : ");
		double width = Double.parseDouble(sc.nextLine()) ;
		System.out.println("세로 : ");
		double height = Double.parseDouble(sc.nextLine()) ;
		
		
		System.out.println();
		System.out.println("===== 결과 =====");
		System.out.println("면적 : "+(width*height));
		System.out.println("둘레 : "+(width+height)*2);		
		
		
	}

}
