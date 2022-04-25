package com.kh.ex01.basic_thread;

public class BasicThread2 {
	//thread 생성법 3가지
	// 1. thread를 상속 받아서 사용하기  =>  설계가 커지고 복잡할때 사용
	// 2. thread Runnable InterFace를 구현하기
	//  2-1. Class에서 직접 구현하기
	//	2-2. 익명 Class를 사용하는 방법, ★★★★★★ 짧은 thread를 만들때 사용한다.
	
	// 주의 
	// run 호출하는 것은 그냥 메소드 호출이다. Sub Thread 생성하기 위해선 반드시 start를 사용
	
	public static void main(String[] args) {
		// 1 .thread 상속하기
		MyThread thread1 = new MyThread("Thread1");
//		thread1.run(); // 잘 못된 문법
		thread1.start();	// 실제 쓰레드를 생성하고 돌아가는 문법
		
		//  2-1. .Runnable - Class에서 직접 구현하기
		Thread thread2 = new Thread(new RunnableClass("Thread2"));
//		thread2.run();
		thread2.start();
		
		//2.2 - Runnable 익명 Class 사용
		new Thread(new Runnable() {
			
			int count = 0;
			String name = "Thread3";
			
			@Override
			public void run() {
				
				while(true) {
					System.out.println(count+" 초 입니다."+name);
					count++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

}

// 1초씩 샐 수 있는 Thread를 생성
class MyThread extends Thread{
	private int count = 0;
	
	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(count+" 초 입니다."+getName());
			count++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class RunnableClass implements Runnable{
	
	private String name;
	private int count = 0;
	
	public RunnableClass(String name) {
		this.name = name;
	}


	@Override
	public void run() {		
		
		while(true) {
			System.out.println(count+" 초 입니다."+ name);
			count++;
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}





