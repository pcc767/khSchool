package com.kh.ex01.basic_thread;

public class BasicThread {
	
	public static void main(String[] args) {
		// 1초를 셀수있는 프로그램.
		// Main Thread인 곳.
		int second = 0;
		while(true) {
			System.out.println(second + " 초 입니다.");
			second++;
			
			try {
				Thread.sleep(1000);	// ms란> 1000ms = 1초, 1/1000초
				// sleep을 주면 잠시 Thread가 지정한 시간까지 정지했다 다시 실행되는 문자.
				// sleep은 상식선으로 반드시 알아야하고, 프로세스 생명주기 개념과 같이 알아야함.
				// -> 만일 현업에서 데이터 입출력이나 송수신 관련 이슈가 발생하는 경우 sleep을 주면 해결될수 있다.
				// -> 처음에는 100ms 정도 주고 천천히 줄여서 최적화 시켜야 한다.
				// -> 최근에는 nano second 까지 지원
		
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
		}
	}
	

}
