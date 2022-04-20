package com.kh.ex03.file_straem_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {
	
	//	FileInputStream ������ 3����
	//	1. File ��ü�� ���� file�� ���� ���
	//	2. ��� ��θ� ���� file�� ���� ��� ��
	//	3. ���� ��θ� ���� file�� ���� ��� �ذ����� ���� ����

	public static void main(String[] args) {
		//���ڿ��� �ƴ� byte�� �о���� IO��ü
		FileInputStream fis = null;
		
		try {
			//���º�
			// 1. ���� ��ü Ȱ���
//			File file = new File("./text.txt");
//			fis = new FileInputStream(file);
			
			// . ���� �Ǵ� ��� ��η� Ȱ���ϴ� ��
//			fis = new FileInputStream("./text.txt");		// ok �� �о��.
			fis = new FileInputStream("./covid.txt");		// MS949���ڵ� ���, ������ 1byte, �ѱ�,�׸����� 2byte�о��.
			
			//�˰����
			int read = 0;
			while((read = fis.read()) > -1 ) {		// ���Ͽ��� 1byte �о���� �ڵ�
				System.out.print((char)read);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Ŭ���� ��
			
			if(fis != null) {		// ���� ���µ��� ���� ��Ȳ�� �����ϰ�
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
