package com.kh.ex01.generic;

// ���׸� ����� �迭 Class

public class MyGenericArray <T> {
	// ���׸��̶�? Type�� ����ڰ� �ܺο��� ���� ���� �����ϴ� ����.
	// T�� Type�� ���ڷ� Ȱ��, <T>�� �ܺο��� Ÿ���� ���Խ��Ѽ� ���ο��� Type ��ü�ȴ�.
	// T�� ������ ���� ���� ���¿��� Ȱ���� �����ϴ�.
	
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
