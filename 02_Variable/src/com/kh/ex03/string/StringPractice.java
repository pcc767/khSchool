package com.kh.ex03.string;

public class StringPractice {
	
	// String은 자바에서 가장 많이 사용되는 Type
	// 현제 인터넷에서 가장 많이 사용되는 자료형은 문자열이다.
	
	public static void main(String[] args) {
		String str = "abc";
		str = new String("abc");
		str = "ABC" + "DEF";
		str = new String("ABC" + "DEF");
		System.out.println(str);
		
		
		// 12345ABCDEF -> 안된다.
		str = 123 + 45 + "ABC" + "DEF";
		System.out.println(str);
		
		// 123456ABCDEF
		str = 123 + (45 + "ABC") + "DEF";
		System.out.println(str);
		
		str = "한글도 출력됩니다.";
		System.out.println(str);
		
		// \t tab
		System.out.println("ABCVDS\tDDD\tDDD");
		System.out.println("ABC\tDDDE\tFFFF");
		System.out.println("ABC\tDDD\tFFED");
		
		
		// \n new line
		System.out.print("ABC\n");
		System.out.print("DEF\n");
		System.out.print("ABC" + "\n");
		System.out.print("DEF\n");
		
		
		// \" 
		System.out.println("\"안녕?\"");
		
		// File path
		System.out.println("path : '\\'");
		System.out.println("C:\\Program Files");
		
		// unicode 출력
		System.out.println('A');
		System.out.println((int) 'A');
		System.out.println(Integer.toHexString((int)'A'));
		System.out.println("\u0041");
			
		
		
	}

}
