package com.kh.ex02.Thread_app;

import java.util.ArrayList;

public class ThreadSum {
	// ���� ���α׷��� �˰���
	
	// -> �׷���ī�� �����ϰų� ��������߿� �������� ������ ���������� ó���Ҷ� ���
	public static void main(String[] args) {
		int threadNum = 10000; 		//thread�� ��
		//0-1����� ���ϴ� ���α׷���
		// double -> �ε��Ҽ��� -> int 50�� ����
		// ���� ������ ���ĺ��ʹ� �þ�ų� �����Ǵ°� ����.
		
		//��� : ������ �������� ������ �����ϴ� ���� �߿�
		//		�����尡 �������� ������ ������ ���� ���ҽð����� ���� �������� �߻�
		//		����? �ý����̳� ���ư��� ���α׷����� �޶������� �̰� ã�Ƴ��°� �����Ͼ��� ��.
		
		
		double startValue = 0;
		double endValue   = 1_000_000_000; // threadNum �����ŭ��!
		double sumValue   = 0;
		long start = System.currentTimeMillis();
		
		if(endValue % threadNum != 0) {
			System.out.println("�ٽ� �Է����ּ���.");
			return;
		}
		
		ArrayList<SumThread> threadList = new ArrayList<>(threadNum);
		
		// start!!
		for(int i=0; i<threadNum; i++) {
			double threadStart = (endValue / threadNum) * (i)+1;
			double threadEnd = (endValue / threadNum) * (i+1)+1;
			SumThread thread = new SumThread(threadStart, threadEnd);
			threadList.add(thread);
			thread.start();
		}
		
		// calc!!
		for(int i=0; i<threadList.size(); i++) {
			try {
				threadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// finish!!
		long end = System.currentTimeMillis();
		
		for(int i=0; i<threadList.size(); i++) {
			sumValue += threadList.get(i).getSumValue();
		}
		
		double estimated = end - start;
		
		System.out.println("sumValue : "+ sumValue);
		System.out.println("time estimated : " + estimated);
	}
}


class SumThread extends Thread{
	private double sumValue   = 0;
	private double startValue = 0;
	private double endValue   = 0;
	
	public SumThread(double startValue, double endValue) {
		this.startValue = startValue;
		this.endValue   = endValue;
	}

	public double getSumValue() {
		return sumValue;
	}

	public void run() {
		for(double i = startValue; i < endValue; i++ ) {
			sumValue += i;
		}
	}
}

