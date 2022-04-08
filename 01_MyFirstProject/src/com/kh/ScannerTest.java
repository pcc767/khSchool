package com.kh;

import java.util.Scanner;

// 에러 레벨
// 1. 에러 : 빨간줄로 표시되고, 파일 전체에서도 X표로 표기됨
//        -> 실제 실행이 되지 않는 에러, 반드시 해결해야 프로그램 실행가능
// 2. 워닝 : 노란줄로 표시되고, 프로그램은 실행이 가능하나... 언젠간 문제를 야기.
//        ※ 주의 : @SuppressWarnings를 사용하면 워닝을 가리는 문법으로 실제 문제는 발생할수 있음!!
//                 -> 프로젝트 차원에서 쓰지 않는 문법
//        -> 현업에서는 워닝도 방치하면 안된다. -> 언젠간 문제가 발생하는 큰 이슈


// 사용자의 키보드로 부터 입력을 받아오는 법
public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 사용자의 입력을 'System.in=콘솔입력'으로 받는다.
		System.out.println("문자열을 입력하세요!"); // 콘솔 출력

		String str = sc.nextLine(); // 문자열을 한줄 읽어오는 코드, 엔터로 문자열의 끝을 알림
		System.out.println(str);
		
//		sc.close(); //이게 맞는데...
//		당분간 과제 할 동안 닫지말것!
		
	}
}
