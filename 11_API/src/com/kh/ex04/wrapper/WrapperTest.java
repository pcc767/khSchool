package com.kh.ex04.wrapper;

import java.util.ArrayList;

public class WrapperTest {
	// Wrapper Class의 역할
	// : 기본형을 Wrapping해서 참조형으로 변환 시켜주는 기능.
		//  - Integer, Double .. 
		// 1. 기본형의 도움을 줄수 있는 API를 제공함.
		// 2. ArrayList와 같은 객체기반의 자료구조에 기본형을 담을때 사용됨.
	
	public static void main(String[] args) {
		int age =26;
//		Integer ageObj = new Integer(age);	// 자바 6버전, 이전의 문법_1
//		Integer ageObj = (Integer)age;		// 자바 6버전, 이전의 문법_2
		Integer ageObj = age;				// 현재 문법, 오토박싱 = 기본형과 참조형간의 자동 형변환
		System.out.println(age);
		System.out.println(ageObj.toString());
		
		
//		ArrayList 선언시 기본형(int short ...) 선언 불가함.
//		ArrayList<int> list = new ArrayList<E>()	; 	//선언불가
		ArrayList<Integer> list = new ArrayList<>();	//선언가능
		list.add((Integer)2);	// old 문법
		list.add((Integer)3);	// old 문법
		list.add(4);			// 최신 문법
		list.add(5);			// 최신 문법
		System.out.println(list);
		
		
		// API적인 활용
		// 1. 최대 최소값
		System.out.println(Integer.MAX_VALUE);	//최대값
		System.out.println(Integer.MIN_VALUE);	//최소값
		
		// 2. 숫자간의 대소 비교 !!!꼭 알아둘 것
//		문자열의 비교 방법도 동일 ! ex) "abc".compareTo("abd");
		System.out.println(Integer.compare(30, 10));	//앞이 크면 +1
		System.out.println(Integer.compare(10, 30));	//뒤가 크면 -1
		System.out.println(Integer.compare(10, 10));	//같으면 0
		
		// 3. min, max
		System.out.println(Integer.max(5,2));	// 5
		System.out.println(Integer.min(5,2));	// 2
		
		// 4. 문자열을 숫자로 바꾸는 parse
		System.out.println(Integer.parseInt("314")+1);
		System.out.println(Double.parseDouble("3.14")+1.1);
		
		//추가로 : Math 알아둘것.
		

	}
	
	

	

}
