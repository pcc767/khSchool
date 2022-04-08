package com.kh.ex02.loop;

public class LoopStatement1 {

	public static void myFirstWhileLoop() {
		while (true) {
			System.out.println("무한 반복!!!");
		}
	}

	public static void testWhileLoop() {
		int i = 0; // 시작점
		while (i < 10) { // 끝나는 점이고, 0~9까지 돌고, 10은 도달하지 않는다.
			System.out.println(i++);
		}
		System.out.println("while 루프 끝!");

		// while문 활용되는 케이스
		// 1. 무한 반복문
		// 2. 끝이 정해지지 않고 탐색이 필요할떄!(아래와 같은 케이스)
		while (true) {
			i++;
			if (i % 133 == 0) { // 133의 배수일때
				break;
			}
		}

	}

	public static void testDoWhileLoop() {
		// 잘 안쓴다.
		int i = 0;
		do {
			System.out.println(i++);
		} while (i < 10);
		System.out.println("do-while 루프 끝");

		i = 100;
		do {
			System.out.println("이 곳은 어떤 값이든 최초 1회가 실행되는 곳!!!!");
		} while (i < 10);

	}

	public static void testForLoop() {
		// ★★★★★ 아래의 문장은 외울때까지 계속 쳐보는것을 추천
		// 제일 많이 사용되는 반복문
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println("루프 끝");
		
		//1~10루프 돌때
		//패턴 1 -> 비추하는 방법
		for(int i = 1; i<=10; i++) {
			System.out.println(i);
		}
		System.out.println("루프 끝");
		
		//패턴 2  -> ★★ 추천 ★★
		for(int i = 0;i<10; i++) {
			System.out.println(i+1);
		}
		System.out.println("루프 끝");
		

	}

	public static void main(String[] args) {
//		myFirstWhileLoop();
//		testWhileLoop();
//		testDoWhileLoop();
		testForLoop();
	}

}
