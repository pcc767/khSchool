package com.kh.ex01.exception;

import java.io.IOException;

public class UseThrows2 {
	
	//throws : ���ܰ� �߻��ϸ� ȣ���� �޼ҵ忡�� ������ å���� �����ϴ� Ű����
	// 		   ��, main���� �߻��� ���α׷� ���Ḧ �ǹ�
	
	//thorw : ���ܸ� ���� ������ Ű����.
	
	public static void method() throws IOException {
		System.out.println("TEST1");
		if(true)
			throw new IOException("TEST");
		System.out.println("TEST2"); // ���� �߻��� �Ʒ��� ������ ������� ����.
	}

	
	public static void main(String[] args){
		try { //������ ���ܸ� �޾��ִ� try��
			method();
		} catch (IOException e) {	
			// ���ܰ� �߻��ϸ� ó������� ����			
			e.printStackTrace();
			// ex) �α׸� ��´ٴ���, ��ڿ��� e-mail�� �����ٴ���.
		}
	}

}
