package com.kh.ex01.ArrayBasic;

import java.util.Arrays;

public class ArrayBasic {
	public static void main(String[] args) {
		System.out.println("1. 배열의 기본 생성법");
		int[] array = null;		// null로 초기화 가능하다? 답 = 참조형 변수
		array = new int[10];	// 10개의 공간을 Heap에 생성하고, Array 변수에 주소값을 할당.
								// 배열(객체)가 생성과 동시에 모든 값이 0으로 초기화 된다.!!
		
		System.out.println(array[0]);	//초기값 : 0
		System.out.println(array[1]);	//초기값 : 0
		
		//사용자가 직접 변수에 접근하여 초기화(재할당) 시킨는 법
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		
		// 순회는 반복문으로, i는 index의 약자!
		for(int i=0; i<10; i++) {		// -> 정상 문법
//		for(int i=0; i<= 9; i++) {		// -> 정상적이나 추천하지 않는 문법  -> 쓰지 말 것!!!
//		for(int i=0; i<= 10; i++) {		// -> 정상적이나 추천하지 않는 문법  -> 쓰지 말 것!!!
			//ArrayIndexOutOfBoundsException : 배열의 범위를 넘어설때 나오는 에러
			array[i] = i;
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		
		System.out.println("2. 배열 직접 선언하는 방법");
		int[] array2 = new int[10];		// 배열선언의 표준적인 문법
		int[] array3 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};		// 크기를 지정하지 않고 직접 초기화 하는 문법
//		int[] array3 = new int[5] {1,2,3,4,5};		// 크기를 지정하면? -? 에러 발생
		
		// Hard 코딩 : 사람이 직접 상수나 특정 데이터를 입력하는 방법!
		// Hard 코딩의 문제점 : 동적인 상황이나 실수에 대처가 되지 안음. ->  가급적 쓰지 않아야함.
		// 쓰는 경유 정해진 범위안에서 사용
		
		// 작게 지정한 경우
//		for(int i=0; i<10; i++) {
//			System.out.println(array3[i]);	// 모든 값이 출력되지 않는 문제 -> 엄청 큰 문제.!!!
//		}
//		
//		// 크게 지정한 경우
//		for(int i=0; i<20; i++) {
//			System.out.println(array3[i]);	// //ArrayIndexOutOfBoundsException : 배열의 범위를 벗어나서 에러
//		}
		
		//★★★★★ 배열에서 length를 통해 Hard 코딩하지 않는 방법 ★★★★★
		for(int i=0; i<array3.length; i++) {
			System.out.print(array3[i]+" ");
		}
		System.out.println();
		
		System.out.println("3. 배열을 가장 표준적으로 사용하는 방법");
		int[] array5 = new int[12];		// 배열 선언 및 배열을 0으로 초기화 하는 문장.
		
		for(int i = 0; i<array5.length; i++) {
			System.out.print(array5[i]);
		}
		System.out.println();
		
		// 문자열 배열
		String[] strArray = new String[] {"사과","바나나","딸기"};
		// for문 안쓰고 내용을 출력하는 방법!!!
		String str = Arrays.toString(strArray);		//Tip, String 외에도 int, double등도 가능
		String str1 = Arrays.toString(array5);		//Tip, String 외에도 int, double등도 가능
		System.out.println(str);
		System.out.println(str1);
		
		
		
		
		
		
		
		
		
	}

}
