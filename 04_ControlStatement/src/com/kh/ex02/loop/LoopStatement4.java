package com.kh.ex02.loop;

public class LoopStatement4 {
	
	public static void main(String[] args) {
		//for�� ���� -> 2�� �����ϴ� �ݺ���
		for(int i=0;i<10;i+=2) {
			System.out.println(i);
		}
		
		for(int i = 0; ; i+=2) {
			System.out.println(i);
			if(i==100) {
				break;
			}
		}
		
	}
	
}
