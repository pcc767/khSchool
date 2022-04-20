package com.kh.ex01.exception;

import java.io.IOException;

public class Trycatch {
	
	public static void main(String[] args) {
		
		try {//예외 발생 가능성이 있는 구문을 쓰는 곳
			System.out.println("파일 관련 에러");
			if(false) {
				throw new IOException();				
			}	
			System.out.println("정상인 경우");
			return; // 리턴을 만나도 파이널이 실행되고 리턴됨.
			
		} catch (Exception e) {
			System.out.println("예외를 받는 구문");
			e.printStackTrace();	//예외가 발생하는 경우 예외를 알려주고, error Line도 알려줌
		} finally {
			System.out.println("예외가 발생하든 안하든 실행되는 문장!!");
		}
		
	}

}
