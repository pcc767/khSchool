package com.kh.homework;

import java.util.Scanner;

public class VariablePractice_03 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("���� : ");
		double width = Double.parseDouble(sc.nextLine()) ;
		System.out.println("���� : ");
		double height = Double.parseDouble(sc.nextLine()) ;
		
		
		System.out.println();
		System.out.println("===== ��� =====");
		System.out.println("���� : "+(width*height));
		System.out.println("�ѷ� : "+(width+height)*2);		
		
		
	}

}
