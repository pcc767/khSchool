package com.kh.ex01.basic_thread;

public class BasicThread {
	
	public static void main(String[] args) {
		// 1�ʸ� �����ִ� ���α׷�.
		// Main Thread�� ��.
		int second = 0;
		while(true) {
			System.out.println(second + " �� �Դϴ�.");
			second++;
			
			try {
				Thread.sleep(1000);	// ms��> 1000ms = 1��, 1/1000��
				// sleep�� �ָ� ��� Thread�� ������ �ð����� �����ߴ� �ٽ� ����Ǵ� ����.
				// sleep�� ��ļ����� �ݵ�� �˾ƾ��ϰ�, ���μ��� �����ֱ� ����� ���� �˾ƾ���.
				// -> ���� �������� ������ ������̳� �ۼ��� ���� �̽��� �߻��ϴ� ��� sleep�� �ָ� �ذ�ɼ� �ִ�.
				// -> ó������ 100ms ���� �ְ� õõ�� �ٿ��� ����ȭ ���Ѿ� �Ѵ�.
				// -> �ֱٿ��� nano second ���� ����
		
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
		}
	}
	

}
