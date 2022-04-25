package com.kh.ex02.Thread_app;

import java.util.ArrayList;

public class ThreadSum {
	// 병렬 프로그래밍 알고리즘
	
	// -> 그래픽카드 연산하거나 산술연산중에 독립적인 연산을 병렬적으로 처리할때 사용
	public static void main(String[] args) {
		int threadNum = 10000; 		//thread의 수
		//0-1억까지 더하는 프로그래밍
		// double -> 부동소수점 -> int 50배 느리
		// 적정 쓰레드 이후부터는 늘어나거나 유지되는게 정상.
		
		//결론 : 적절한 쓰레드의 갯수를 유지하는 것이 중요
		//		쓰레드가 많이지면 오히려 쓰레드 간의 스왑시간으로 인해 성능저하 발생
		//		적절? 시스템이나 돌아가는 프로그램마다 달라짐으로 이걸 찾아내는게 엔지니어의 일.
		
		
		double startValue = 0;
		double endValue   = 1_000_000_000; // threadNum 배수만큼만!
		double sumValue   = 0;
		long start = System.currentTimeMillis();
		
		if(endValue % threadNum != 0) {
			System.out.println("다시 입력해주세요.");
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

