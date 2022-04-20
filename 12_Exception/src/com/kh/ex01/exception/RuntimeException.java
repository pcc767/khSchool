package com.kh.ex01.exception;

public class RuntimeException {
	public static void main(String[] args) {
		// ArithmeticException
//		int a = 10 / 0;
		
		// ArrayIndexOutOfBoundsException 
		int[] array = new int[10];
//		array[12] = 10;
		
		// NegativeArraySizeException
//		array = new int[-1];
		
		// NullPointerException
//		array = null;
//		array[10] = 10;
		
		// ClassCastException
//		Object obj = new Object();
//		String str = (String)obj;
		
		// Run time error 아님.
		// System Error / OutOfMemoryError : Required array length too large
//		String str = "11248901284092187409281490128490";
//		while(true) {
//			str += str;
//		}
		
		//java.lang.OutOfMemoryError: Java heap space
//		String str = "11248901284092187409281490128490";
//		StringBuffer sb = new StringBuffer();
//		while(true) {
//			sb.append(str);
//		}
		
		// java.lang.StackOverflowError
		method(); // 무한루프
	}
	
	public static void method() {
		int temp = 0;
		method();
	}
}
