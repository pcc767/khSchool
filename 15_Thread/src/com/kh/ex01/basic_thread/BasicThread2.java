package com.kh.ex01.basic_thread;

public class BasicThread2 {
	//thread ������ 3����
	// 1. thread�� ��� �޾Ƽ� ����ϱ�  =>  ���谡 Ŀ���� �����Ҷ� ���
	// 2. thread Runnable InterFace�� �����ϱ�
	//  2-1. Class���� ���� �����ϱ�
	//	2-2. �͸� Class�� ����ϴ� ���, �ڡڡڡڡڡ� ª�� thread�� ���鶧 ����Ѵ�.
	
	// ���� 
	// run ȣ���ϴ� ���� �׳� �޼ҵ� ȣ���̴�. Sub Thread �����ϱ� ���ؼ� �ݵ�� start�� ���
	
	public static void main(String[] args) {
		// 1 .thread ����ϱ�
		MyThread thread1 = new MyThread("Thread1");
//		thread1.run(); // �� ���� ����
		thread1.start();	// ���� �����带 �����ϰ� ���ư��� ����
		
		//  2-1. .Runnable - Class���� ���� �����ϱ�
		Thread thread2 = new Thread(new RunnableClass("Thread2"));
//		thread2.run();
		thread2.start();
		
		//2.2 - Runnable �͸� Class ���
		new Thread(new Runnable() {
			
			int count = 0;
			String name = "Thread3";
			
			@Override
			public void run() {
				
				while(true) {
					System.out.println(count+" �� �Դϴ�."+name);
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

// 1�ʾ� �� �� �ִ� Thread�� ����
class MyThread extends Thread{
	private int count = 0;
	
	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(count+" �� �Դϴ�."+getName());
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
			System.out.println(count+" �� �Դϴ�."+ name);
			count++;
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
}





