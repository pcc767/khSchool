package com.kh.test;

public class Overloding {
	public void test() {};
	public void test(String str) {};
	public void test(int i) {};
	public void test(String s) {};
	public void test(char ch) {};
	public void test(String str, int i) {};
	public void test(int i, String str) {};
//	public void test(int i) {};
	public int test() {return 0;};

}
