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

public class FileCopy2_1 {
	// File IO 시 Close문이 생략된 버전으로 작성 (Close를 자동으로 해줌)
	// Try-catch resource 버전 문법, 자바7 이후 부터 가능
	

	// 전체 파일 용도 (Binary + 문자열 모두 됨)
	// source = 원본, dest = 복사 되는 파일 
	// 가장 고전적인 방법으로 파일 복사! = 고전 = 느리다.
	public static int fileCopyStreamVer(File source, File dest) {
		int fileSize = 0;
		
		try ( FileInputStream fis = new FileInputStream(source);
				FileOutputStream fos = new FileOutputStream(dest); ) {
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
	// ※ 주의 : 어려움
	public static int fileCopyBufferdStreamVer(File source, File dest) {
		int readSize = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null; // Buffer 내장해서 읽기/쓰기 속도 향상하는 Class
		
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(dest);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int read = 0;
			while((read = bis.read()) > -1) {
				bos.write(read);
				readSize++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close부 요령 : 오픈한 Class의 역순으로 닫는다.
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return readSize;
	}
		
	
	// source = 원본, dest = 카피 되는 파일 
	public static int fileCopyReadWriteVer(File source, File dest) {
		int fileSize = 0;
		
		try ( FileReader fr = new FileReader(source);
				FileWriter fw = new FileWriter(dest); ) {
			int read = 0;
			while((read = fr.read()) > -1) {
				fw.write(read);
				fileSize++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1; // error
		}
		return fileSize;
	}
	
	
//	★ 필드에서 제일 많이 사용하는 형태
	public static int fileCopyBufferdReadWriteVer(File source, File dest) {
		int readLineCount = 0;
		
		try( FileReader fr = new FileReader(source);
				FileWriter fw = new FileWriter(dest);
				BufferedReader br = new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw); ) {
			
			String readLine = null;
			while((readLine = br.readLine()) != null) {
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
	
	public static void main(String[] args) {
		System.out.println("시작");
		File source = new File("./covid.txt");
		
		long start = System.currentTimeMillis();
		int count = 0;
		while(count++ < 100) {
			FileCopy2_1.fileCopyStreamVer(source, new File("c_covid"+count+".txt"));
		}
		long end = System.currentTimeMillis();
		
		long estimated = end - start;
		System.out.println("fileCopyStreamVer estimated : "+estimated);
		
		start = System.currentTimeMillis();
		count = 0;
		while(count++ < 100) {
			FileCopy2_1.fileCopyBufferdStreamVer(source, new File("c2_covid"+count+".txt"));
		}
		end = System.currentTimeMillis();
		
		estimated = end - start;
		System.out.println("fileCopyBufferdStreamVer estimated : " + estimated);

	}
}

// 결론
// Buffered 사용할 것.



