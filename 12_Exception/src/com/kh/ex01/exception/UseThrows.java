package com.kh.ex01.exception;

import java.io.IOException;

public class UseThrows {
	
	//throws : ���ܰ� �߻��ϸ� ȣ���� �޼ҵ忡�� ������ å���� �����ϴ� Ű����
	// 		   ��, main���� �߻��� ���α׷� ���Ḧ �ǹ�
	
	//thorw : ���ܸ� ���� ������ Ű����.
	
	public static void method() throws IOException {
		System.out.println("TEST1");
		if(true)
			throw new IOException("TEST");
		System.out.println("TEST2"); // ���� �߻��� �Ʒ��� ������ ������� ����.
	}

	
	public static void main(String[] args) throws IOException {
		method();
	}

}
