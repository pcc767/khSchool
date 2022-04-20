package com.kh.ex03.file_straem_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {
	
	//	FileInputStream 생성법 3가지
	//	1. File 객체를 통해 file을 여는 방법
	//	2. 상대 경로를 통해 file을 여는 방법 ★
	//	3. 절대 경로를 통해 file을 여는 방법 ※가급적 쓰지 말것

	public static void main(String[] args) {
		//문자열이 아닌 byte로 읽어오는 IO객체
		FileInputStream fis = null;
		
		try {
			//오픈부
			// 1. 파일 객체 활용법
//			File file = new File("./text.txt");
//			fis = new FileInputStream(file);
			
			// . 절대 또는 상대 경로로 활용하는 법
//			fis = new FileInputStream("./text.txt");		// ok 잘 읽어옴.
			fis = new FileInputStream("./covid.txt");		// MS949인코딩 사용, 영문은 1byte, 한글,그리스어 2byte읽어옴.
			
			//알고리즘부
			int read = 0;
			while((read = fis.read()) > -1 ) {		// 파일에서 1byte 읽어오는 코드
				System.out.print((char)read);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 클로즈 부
			
			if(fis != null) {		// 실제 오픈되지 않은 상황을 제외하고
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
