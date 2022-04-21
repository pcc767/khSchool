package com.kh.ex01.generic;

// 제네릭 기반의 배열 Class

public class MyGenericArray <T> {
	// 제네릭이란? Type을 사용자가 외부에서 주입 시켜 정의하는 문법.
	// T는 Type의 약자로 활용, <T>로 외부에서 타입을 주입시켜서 내부에서 Type 대체된다.
	// T는 정해져 있지 않은 상태에서 활용이 가능하다.
	
	private Object[] arrays;
	private int index = 0;
	
	public MyGenericArray(int size) {
		arrays = new Object[size];
	}
	
	public int add(T data) {
		if(index >= arrays.length) {
			return -1;
		}
		arrays[index++] = data;
		return index;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if(index < 0 || index >= this.index) {
			return null;
		}
		return (T)arrays[index];
	}
	
	
	

	

}
