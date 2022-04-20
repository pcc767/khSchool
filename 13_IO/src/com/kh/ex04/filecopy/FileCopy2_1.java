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
	// File IO �� Close���� ������ �������� �ۼ� (Close�� �ڵ����� ����)
	// Try-catch resource ���� ����, �ڹ�7 ���� ���� ����
	

	// ��ü ���� �뵵 (Binary + ���ڿ� ��� ��)
	// source = ����, dest = ���� �Ǵ� ���� 
	// ���� �������� ������� ���� ����! = ���� = ������.
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
			return -1; // error ����
		}
		return fileSize;
	}

	// Buffered + ���� ����� IO �ڵ�
	// �� ���� : �����
	public static int fileCopyBufferdStreamVer(File source, File dest) {
		int readSize = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null; // Buffer �����ؼ� �б�/���� �ӵ� ����ϴ� Class
		
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
			// Close�� ��� : ������ Class�� �������� �ݴ´�.
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
		
	
	// source = ����, dest = ī�� �Ǵ� ���� 
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
	
	
//	�� �ʵ忡�� ���� ���� ����ϴ� ����
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
		System.out.println("����");
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

// ���
// Buffered ����� ��.



