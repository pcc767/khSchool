package com.kh.ex02.io_basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamIO {
	
	// Stream이란? - (단방향 빨대)
	//	: Binary(이진) 데이터를 다루는 Stream = 1byte씩 처리 가능
	// 	: 활용 : 이미지나 동영상 파일, 네트워크, 프로그램간 데이터 전송 때
	
	// IO객체 사용시 코딩 테크닉
	// 1. 가장 윗단에 IO객체를 선언하고, null로 초기화 한다. 이름은 앞글자를 줄여서 선언한다.
	// 2. try-catch문으로 문을 열고,e.printStackTracet 선언 및 finally문 선언
	// 3. IO객체를 오픈한다.
	// 4. 필요한 IO를 수행한다. 보통 while문으로 수행
	// 5. finally에 사용한 IO객체들을 정리한다.
	
	public static void main(String[] args) {
		// 초기화부
		InputStream is = null;
		OutputStream os = null;
		
		try {
			// 오픈부
			//is = new InputStream();		// abstract(추상) 클래스라 생성불가
			is = System.in;					// open을 대체하는 코드부, 콘솔 입력
			os = System.out;				// 콘솔 출력
			
			//동작부
			System.out.println("숫자를 입력해주세요.");
			int read = is.read();			// 한 바이트를 읽어온다.
			os.write(read);					// writs는 실제 쓰기를 보장하지 않은. 어느정도 데이터가 차면 써지기는 하지만
			os.flush();
			// write를 강제화 하는 법
			// 1. flush : write 도중에 중간에 데이터를 강제로 밀거내야할때 명시적으로 사용
			// 2 .close : 자원을 정리 할때 사용되면서 flush와 동일한 기능을 가짐.
			// 때에 따라 둘다 사용이 필료함.
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
			
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
