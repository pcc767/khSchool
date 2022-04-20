package com.kh.ex02.io_basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class StreamRW {
	// ���ڿ� ������(2byte�� ó��)
	
	public static void main(String[] args) {
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		
		try {
			isr = new InputStreamReader(System.in);
			osw = new OutputStreamWriter(System.out);
			
			osw.append("���ڿ��� �Է����ּ���!!\n");

			osw.flush();
			
			// ���ڿ� �о���� ��
			char[] temp = new char[10];		// buffer�� ũ�⸦ �����Ҷ� 2�� ������ �� ��  �����ϴ�.
			int size = isr.read(temp);		// Blocking �Լ� : ������� �̺�Ʈ�� ���;� �絿���ϴ� �Լ�.
			
			osw.append("Read size : "+ size + "\n");
			osw.append(String.valueOf(temp)+"\n");
			osw.append(Arrays.toString(temp)+"\n");
			
			osw.flush();

	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
}
