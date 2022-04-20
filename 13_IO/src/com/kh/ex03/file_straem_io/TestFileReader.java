package com.kh.ex03.file_straem_io;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class TestFileReader {
	
	public static void main(String[] args) {
		// 문자열을 읽어오는 IO객체
		FileReader fr = null;
		
		try {
			
//			fr = new FileReader("./covid.txt");			//정상 출력
//			fr = new FileReader("./covid_UTF16.txt");	// CharSet 이슈발생!!!
			
			//FileReader(String fileName, Charset charset)
			fr = new FileReader("./covid_UTF16.txt",Charset.forName("UTF-16"));	// CharSet 이슈발생!!!
			// CharSet을 UTF-16으로 encoding을 변경하는 코드.
			// BOM이라는 개념은 알고 있어야 한다.
			
			//buffer로 읽어오는 법
			char[] buf = new char[1024];	// 2^10 buffer = 임시공간, 예비공간
			while(fr.read(buf)>0) {			// 파일에서 buffer 크기만큼 읽어오는 법.
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
