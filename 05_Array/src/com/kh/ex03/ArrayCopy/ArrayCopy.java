package com.kh.ex03.ArrayCopy;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args) {
		
		int[] array1 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
		int[] array2 = array1; // ���� ���� Shallow copy 
		
		array1[1] = 10;
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		
		int[] array3 = null;
		// deep copy, ���� ���� �ڡڡڡڡ�
		array3 = Arrays.copyOf(array1, array1.length); // ���1 �ڡڡڡڡ�
		array3 = array1.clone(); 			   		   // ���2
		
		array3 = new int[array1.length];
		for(int i = 0; i < array1.length; i++) {
			array3[i] = array1[i];
		} // ���3 ���� �������� ���. �ڵ�� �˾ƾ� �Ѵ�.
		
		array1[2] = 1000; 
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array3));
		
	}
}
