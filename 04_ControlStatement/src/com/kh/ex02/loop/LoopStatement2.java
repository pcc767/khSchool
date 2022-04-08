package com.kh.ex02.loop;

public class LoopStatement2 {
	//È¦Â¦ ¼¼±â¸¦ while, do-while, for¹®À¸·Î ±¸ÇöÇÏ±â
	
	public static void testWhileLoop() {
		int i=0;
		while(i<10) {
			if(i%2==0) {
				System.out.println(i+"´Â Â¦¼ö");
			} else {
				System.out.println(i+"´Â È¦¼ö");
			}
			i++;
		}
	}
	
	public static void testDoWhileLoop() {
		int i=0;
		do {
			if(i%2 == 0) {
				System.out.println(i+"´Â Â¦¼ö");
			} else {
				System.out.println(i+"´Â È¦¼ö");
			}
			i++;
		} while(i<10);
	}
	
	public static void testForLoop() {
		for (int i = 0; i < 10; i++) {
			if(i%2 == 0) {
				System.out.println(i+"´Â Â¦¼ö");
			} else {
				System.out.println(i+"´Â È¦¼ö");
			}
		}		
	}
	
	public static void main(String[] args) {
		testWhileLoop();
		testDoWhileLoop();
		testForLoop();
	}


}
