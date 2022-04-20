package com.kh.ex02.io_basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamIO {
	
	// Stream�̶�? - (�ܹ��� ����)
	//	: Binary(����) �����͸� �ٷ�� Stream = 1byte�� ó�� ����
	// 	: Ȱ�� : �̹����� ������ ����, ��Ʈ��ũ, ���α׷��� ������ ���� ��
	
	// IO��ü ���� �ڵ� ��ũ��
	// 1. ���� ���ܿ� IO��ü�� �����ϰ�, null�� �ʱ�ȭ �Ѵ�. �̸��� �ձ��ڸ� �ٿ��� �����Ѵ�.
	// 2. try-catch������ ���� ����,e.printStackTracet ���� �� finally�� ����
	// 3. IO��ü�� �����Ѵ�.
	// 4. �ʿ��� IO�� �����Ѵ�. ���� while������ ����
	// 5. finally�� ����� IO��ü���� �����Ѵ�.
	
	public static void main(String[] args) {
		// �ʱ�ȭ��
		InputStream is = null;
		OutputStream os = null;
		
		try {
			// ���º�
			//is = new InputStream();		// abstract(�߻�) Ŭ������ �����Ұ�
			is = System.in;					// open�� ��ü�ϴ� �ڵ��, �ܼ� �Է�
			os = System.out;				// �ܼ� ���
			
			//���ۺ�
			System.out.println("���ڸ� �Է����ּ���.");
			int read = is.read();			// �� ����Ʈ�� �о�´�.
			os.write(read);					// writs�� ���� ���⸦ �������� ����. ������� �����Ͱ� ���� ������� ������
			os.flush();
			// write�� ����ȭ �ϴ� ��
			// 1. flush : write ���߿� �߰��� �����͸� ������ �аų����Ҷ� ��������� ���
			// 2 .close : �ڿ��� ���� �Ҷ� ���Ǹ鼭 flush�� ������ ����� ����.
			// ���� ���� �Ѵ� ����� �ʷ���.
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
			
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
