package com.kh.ex02.singletone;

/**
 * 디자인 패턴이란?
 *  - 프로그래밍 설계 패턴 효율적이고 문제해결에 적합한 구조 또는 스타일
 *  - 20개의 유명한 디자인 패턴 GoF 정립 이론 중에 2개만 정리 
 *  
 * 싱글톤 패턴
 *  - 객체를 Java상에서 단 하나만 생성할수 있는 기법 
 *  - 주로 멀티 쓰레드 환경(서버)에서 메모리 절약 또는 단일 객체 생성을 통한 데이터를 다루기 위해 사용
 *
 * 첫번째 패턴에 문제
 *  -> 강사 피셜은 사실 문제 없다고함....
 *  -> Class를 사용하지도 않는데 Class가 멋대로 생성되어 메모리나 자원이 낭비됨.
 *  
 */

// 추천하는 싱글톤 패턴
public class SingleToneV1 {
	private static SingleToneV1 instance = new SingleToneV1();
	
	//싱클톤의 핵심 = 생성자를 private로 재선언한다.
	//	-> 외부에서 생성할 수 없도록 만드는 주요 매커니즘.	
	//private construct
	private SingleToneV1() {};
	
	public static SingleToneV1 getInstance() {
		return instance;
	}
	
	// 싱글톤과 무관한 일반 함수가 오는 자리.
	String getName() {
		return "홍길동";
	}
}
