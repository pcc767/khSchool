package com.kh.ex03.file_straem_io;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class TestFileReader {
	
	public static void main(String[] args) {
		// ���ڿ��� �о���� IO��ü
		FileReader fr = null;
		
		try {
			
//			fr = new FileReader("./covid.txt");			//���� ���
//			fr = new FileReader("./covid_UTF16.txt");	// CharSet �̽��߻�!!!
			
			//FileReader(String fileName, Charset charset)
			fr = new FileReader("./covid_UTF16.txt",Charset.forName("UTF-16"));	// CharSet �̽��߻�!!!
			// CharSet�� UTF-16���� encoding�� �����ϴ� �ڵ�.
			// BOM�̶�� ������ �˰� �־�� �Ѵ�.
			
			//buffer�� �о���� ��
			char[] buf = new char[1024];	// 2^10 buffer = �ӽð���, �������
			while(fr.read(buf)>0) {			// ���Ͽ��� buffer ũ�⸸ŭ �о���� ��.
				System.out.println(buf);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fr != null) {
		
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	

}
