package com.kh.ex02.loop;

public class LoopStatement3_GuGuDan {
	public static void main(String[] args) {
		// step 1. 이중for문으로 기계적으로 완성
		for(int i=0; i<10; i++) {
			for(int j=0; j<10;j++) {
				System.out.println(i+"X"+j+"="+(i*j));
			}
		}
		
		//step 2. i와 j의 시작점과 끝점을 조절하면서 구구단을 완성시킨다.
		for(int i=2; i<10; i++) {
			for(int j=1; j<10;j++) {
				System.out.println(i+"X"+j+"="+(i*j));
			}
		}
		
		//Step 3. 안쪽 반복문 위와 아래에 공간이 있다는 것을 생각해보자~
//		for(int i=2; i<10; i++) {
//			System.out.println(i+"단 시작");
//			System.out.println("-----------------");
//			for(int j=1; j<10;j++) {
//				System.out.println(i+"X"+j+"="+(i*j));
//			}
//			System.out.println("-----------------");
//		}
		
		for(int i=2; i<10; i++) {
			System.out.println(i+"단 시작");
			System.out.println("-----------------");
			for(int j=1; j<10;j++) {
				System.out.println(i+"X"+j+"="+(i*j));
			}
			System.out.println("-----------------");
		}
		
		
	}
	

}
