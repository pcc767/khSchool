package com.kh.ex02.SearchArray;

import java.util.Random;

public class ArraySearch {
	// 응용 버전
	// 배열의 특정한 난수(랜덤)수로 초기화를 하고, 그 배열에서 특정값을 찾아는 방법
	
	public static int[] array; // static(글로벌)영역에 Array 선언!
	public static final int MAX_SIZE = 100000; // 상수 선언!
	public static Random random = new Random(System.currentTimeMillis());
	// 완벽한 난수를 뽑아 내는 방법
	// 컴퓨터에서 난수란? 의사난수 = 특정한 공식에 의해 난수가 발생되는데.
	// 의사난수 문제점 : 유추가 가능하다.
	// 의사난수를 완벽한 난수로 바꾸기위해 Seed값(특정수) 필요하다. -> Seed를 현재 시간으로 사용
	// System.currentTimeMillis() : 현재시간을 long 값으로 저장하고 있는 시스템 변수
	//                              since 1970-01-01 00:00:00.000
	
	// 선언된 array 배열에 난수로 초기화하는 함수
	public static void init() { // initialize : 초기화 문
		array = new int[MAX_SIZE]; // 배열을 MAX_SIZE만큼 생성
		for(int i = 0; i < array.length; i++) { // MAX_SIZE를 써도 되나 비추!
			array[i] = randomValue();
		}
	}

	// 특정한 랜덤 값을 가져오는 함수
	// return (변수) : 함수에서 사용하던 로컬변수를 리턴하는 문장
	public static int randomValue() {
		int randomValue = random.nextInt(MAX_SIZE); // 한줄로 해도 OK
		return randomValue;
	}
	
	// index를 통해 순차 탐색하는 알고리즘
	public static int search(int searchValue) {
		for(int i =0; i < array.length; i++) {
			if(array[i] == searchValue) {
				return i; // 값을 찾은 경우 index를 반환한다.
			}
		}
		return -1; // 값이 없는경우 -1로 리턴
	}
	
	//String[] args : java 실행 명령문으로부터 특정한 문자열 option값을 받을때 사용하는 파라메터
	public static void main(String[] args) {
		init();
		int pickValue = array[randomValue()]; // 배열에서 특정값을 랜덤으로 뽑아옴!
		long startTime = 0; // 탐색이 시작한 시간
		long endTime = 0; // 탐색이 끝난 시간
		int index = 0; // 찾은 index
	
		System.out.println("pickValue : " + pickValue); // 선택된 값
		
		// 1. 현재 코드에서 작성된 search 함수를 통해 탐색하고 시간을 계산하는 코드
		startTime = System.currentTimeMillis(); // 시작시간 저장!

		for(int i =0; i< 100000; i++) { // 탐색 시간이 너무 빠름으로 측정을 위해 100000번 돌린다!
			index = search(pickValue); // 랜덤값의 index를 찾는 방법
		}
		
		endTime = System.currentTimeMillis(); // 끝나는 시간 저장!
		
		System.out.println("찾은 index : " + index);
		System.out.println("찾은 값 : " + array[index]);
		System.out.println("첫번째 걸린 시간 : " + (endTime - startTime) +"ms");
		
	}
}










