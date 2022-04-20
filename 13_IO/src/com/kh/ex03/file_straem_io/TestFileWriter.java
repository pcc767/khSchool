package com.kh.ex03.file_straem_io;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
	
	// Write=append ������ ������
	// 1. �Ϲ� Write ���� ������ ���� ������ ������ �������� ����
	// 2. ���� �̾�⸦ ���ؼ��� open(��ü����)�� Append �ɼ� ���
	// 3. Write�� ���� �������� �ݵ�� Close�� �־���ϰ�, �ɼ����� flush ����� �ʿ�
	//    Close : ���� ���� ���� �� �ڿ�����, flush : ���� ���߿� ���Ϸ� ���� ������ ��ɾ��ϴ� �Լ�
	// 4. ���ڿ� ���õ� �����ؾ��Ѵ�. �������� ���� ��� workspace default���� ���󰣴�.

	
	public static void main(String[] args) {
		
		FileWriter fw = null;
		
		try {
//			FileWriter(String fileName, boolean append)

//			fw = new FileWriter("./test.txt");		// �Ϲ����� ����
			fw = new FileWriter("./test.txt",true);		// �̾��
			
			fw.append("�ȳ��ϼ���\n");
			fw.append("�ݰ����ϴ�.\n");
			fw.append("���� ȫ�浿�Դϴ�.\n");
			
//			fw.flush();	
			
		} catch (Exception e) {
			
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}
}
