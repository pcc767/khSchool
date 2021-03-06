package com.kh.ex04.filecopy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy2 {
	
	// File IO시 Close문이 생략된 버전으로 작성.(Close를 자동으로 해줌.)
	// try - catch resource 버전 문법, 자바7 이후 부터 가능.
	
	// 전체 파일 용도 (Binary + 문자열 모두 됨)
	// source = 원본, dest = 복사 되는 파일 
	// 가장 고전적인 방법으로 파일 카피! = 고전 = 느리다.
	
	public static int fileCopyStreamVer(File source, File dest) {
		int fileSize = 0;
		
		try(FileInputStream fis = new FileInputStream(source);
				FileOutputStream fos = new FileOutputStream(dest);){
			
			int read = 0;
			while((read = fis.read()) > -1) {
				fos.write(read);
				fileSize++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1; // error 설계
			
		}

		return fileSize;
		
	}
	
	// Buffered + 고전 방식의 IO 코딩
	public static int fileCopyBufferdStreamVer(File source, File dest) {
		
		int readSize = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;	// buffer 내장해서 읽기/쓰기 속도 향상 class
		BufferedInputStream bis = null; 

		try {
			
			fis = new FileInputStream(source);
			fos = new FileOutputStream(dest);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int read = 0;
			while( (read = bis.read()) > -1 ) {
				bos.write(read);
				readSize++;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Colse부 요령 : open한 class의 역순으로 닫는다.
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bis != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return readSize;
	}

	// ★★★★★★★★필드에서 제일 많이 쓰는 문법
	public static int fileCopyBufferdReadWriteVer(File source, File dest) {
		int readLineCount = 0;
		
		try(FileReader fr = new FileReader(source);
				FileWriter fw = new FileWriter(dest);
				BufferedReader br = new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw);) {
			
			String readLine = null;
			while( (readLine = br.readLine()) != null) {
				bw.append(readLine);
				bw.newLine();
				readLineCount++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		return readLineCount;
		
		
		
	}

	
	
	
	
	// source = 원본, dest = 카피 되는 파일 
	public static int fileCopyReadWriteVer(File source, File dest) {
		int fileSize = 0;

		try (FileReader fr = new FileReader(source); FileWriter fw = new FileWriter(dest);) {

			int read = 0;
			while ((read = fr.read()) > -1) {
				fw.write(read);
				fileSize++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1; // error
		}
		return fileSize;

	}

	public static void main(String[] args) {
		File source1 = new File("./covid.txt");
		File dest1 = new File("./copy1_covid.txt");
		File dest2 = new File("./copy2_covid.txt");

		int result1 = FileCopy2.fileCopyStreamVer(source1, dest1);
		int result2 = FileCopy2.fileCopyReadWriteVer(source1, dest2);
		if (result1 == -1) {
			System.out.println("파일 복사에 실패했습니다!");
		}

		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);

//		result1 : 12128		: 	file의 실제크기
//		result2 : 9128		:	한글(2byte)과 영문(1byte)의 갯수

		// ---------------------------------------------------------------

		File source3 = new File("./covid_UTF16.txt");
		File dest3 = new File("./copy1_covid_UTF16.txt");
		File dest4 = new File("./copy2_covid_UTF16.txt");

		int result3 = FileCopy2.fileCopyStreamVer(source3, dest3);
		int result4 = FileCopy2.fileCopyReadWriteVer(source3, dest4);

		System.out.println("result3 : " + result3);
		System.out.println("result4 : " + result4);

		// ---------------------------------------------------------------
		File source5 = new File("./images.jpg");
		File dest5 = new File("./copy1_images.jpg");
		File dest6 = new File("./copy2_images.jpg");

		int result5 = FileCopy2.fileCopyStreamVer(source5, dest5);
		int result6 = FileCopy2.fileCopyReadWriteVer(source5, dest6);

		System.out.println("result5 : " + result5);
		System.out.println("result6 : " + result6);
		
		// 결론
		// Reader, Write 사용시 Binary 파일 복사가 불가능 하다. -> 복사 할때 쓰지 말것~~!!
		// 인코딩이 다르거나 각족ㅇ Binary파일(이미지, 동영상, 기타 파일)을 전송하기 위해선 
		//	-> Stream을 통해 복사나 전달 할 것~~~~~~

	}

	
	
	

}
