package com.kh.ex02.loop;

public class LoopStatement2 {
	//Ȧ¦ ���⸦ while, do-while, for������ �����ϱ�
	
	public static void testWhileLoop() {
		int i=0;
		while(i<10) {
			if(i%2==0) {
				System.out.println(i+"�� ¦��");
			} else {
				System.out.println(i+"�� Ȧ��");
			}
			i++;
		}
	}
	
	public static void testDoWhileLoop() {
		int i=0;
		do {
			if(i%2 == 0) {
				System.out.println(i+"�� ¦��");
			} else {
				System.out.println(i+"�� Ȧ��");
			}
			i++;
		} while(i<10);
	}
	
	public static void testForLoop() {
		for (int i = 0; i < 10; i++) {
			if(i%2 == 0) {
				System.out.println(i+"�� ¦��");
			} else {
				System.out.println(i+"�� Ȧ��");
			}
		}		
	}
	
	public static void main(String[] args) {
		testWhileLoop();
		testDoWhileLoop();
		testForLoop();
	}


}
