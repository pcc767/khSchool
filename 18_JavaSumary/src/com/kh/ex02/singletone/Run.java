package com.kh.ex02.singletone;

import java.util.Calendar;

public class Run {
	public static void main(String[] args) {
		//대표적인 singletone 객체
		Calendar cal = Calendar.getInstance();
		
		
		//생성자가 private로 만들어져서 생성불가.
//		SingleToneV1 singObj = new SingleToneV1();
		SingleToneV1 singleObg = SingleToneV1.getInstance();
		System.out.println(singleObg.getName());
		
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					SingleToneV4.getInstance();
				}
			}).start();
		}
		System.out.println(SingleToneV4.value);

	}

}
