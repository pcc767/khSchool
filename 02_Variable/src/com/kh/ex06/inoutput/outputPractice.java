package com.kh.ex06.inoutput;

public class outputPractice {

	public static void main(String[] args) {
		String name = "김길동";
		int age = 27;
		double height = 180.5;
		double weight = 65.5;
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(weight);
		
		System.out.println("안녕하세요? 저는 " + name + " 입니다.");

		// printf = format 출력
		System.out.printf("이름은 %s, 나이는 %d, 키는 %f, 몸무게는 %f\n"
													,name , age, height, weight);
		
		System.out.printf("키는 %.2f, 몸무게는 %.2f\n",  height, weight);
		
		System.out.println("안녕하세요? 저는 " + name + " 입니다. 키는 " + height + "입니다");
		
		String heightStr = String.format("%.2f", height);
		System.out.println("안녕하세요? 저는 " + name + " 입니다. 키는 " + heightStr + "입니다");
	}
}
