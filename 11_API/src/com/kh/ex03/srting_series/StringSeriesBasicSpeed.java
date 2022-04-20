package com.kh.ex03.srting_series;

public class StringSeriesBasicSpeed {
	public static void main(String[] args) {
		System.out.println("����");
		long current = System.currentTimeMillis();
		
//		String temp = "";
//		for(int i = 0; i < 100000; i++) {
//			temp += i;
//		}
		
//		StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder(); // ������ ���� ������.
		for(int i = 0; i < 100000; i++) {
			sb.append(i);
		}
		
		long finish = System.currentTimeMillis();
		System.out.println("����");
		System.out.println(finish - current);
		// String : 
		// StringBuffer : 
		// StringBuilder : 
	}
}
