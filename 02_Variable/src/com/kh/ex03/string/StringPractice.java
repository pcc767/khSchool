package com.kh.ex03.string;

public class StringPractice {
	
	// String�� �ڹٿ��� ���� ���� ���Ǵ� Type
	// ���� ���ͳݿ��� ���� ���� ���Ǵ� �ڷ����� ���ڿ��̴�.
	
	public static void main(String[] args) {
		String str = "abc";
		str = new String("abc");
		str = "ABC" + "DEF";
		str = new String("ABC" + "DEF");
		System.out.println(str);
		
		
		// 12345ABCDEF -> �ȵȴ�.
		str = 123 + 45 + "ABC" + "DEF";
		System.out.println(str);
		
		// 123456ABCDEF
		str = 123 + (45 + "ABC") + "DEF";
		System.out.println(str);
		
		str = "�ѱ۵� ��µ˴ϴ�.";
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
		System.out.println("\"�ȳ�?\"");
		
		// File path
		System.out.println("path : '\\'");
		System.out.println("C:\\Program Files");
		
		// unicode ���
		System.out.println('A');
		System.out.println((int) 'A');
		System.out.println(Integer.toHexString((int)'A'));
		System.out.println("\u0041");
			
		
		
	}

}
