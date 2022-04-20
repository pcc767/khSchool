package com.kh.ex02.io_basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class StreamRW {
	// 문자열 데이터(2byte씩 처리)
	
	public static void main(String[] args) {
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		
		try {
			isr = new InputStreamReader(System.in);
			osw = new OutputStreamWriter(System.out);
			
			osw.append("문자열을 입력해주세요!!\n");

			osw.flush();
			
			// 문자열 읽어오는 부
			char[] temp = new char[10];		// buffer의 크기를 선정할때 2의 제곱인 수 로  선언하다.
			int size = isr.read(temp);		// Blocking 함수 : 사용자의 이벤트가 들어와야 재동작하는 함수.
			
			osw.append("Read size : "+ size + "\n");
			osw.append(String.valueOf(temp)+"\n");
			osw.append(Arrays.toString(temp)+"\n");
			
			osw.flush();

	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
}
