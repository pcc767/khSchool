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
	
	// File IO�� Close���� ������ �������� �ۼ�.(Close�� �ڵ����� ����.)
	// try - catch resource ���� ����, �ڹ�7 ���� ���� ����.
	
	// ��ü ���� �뵵 (Binary + ���ڿ� ��� ��)
	// source = ����, dest = ���� �Ǵ� ���� 
	// ���� �������� ������� ���� ī��! = ���� = ������.
	
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
			return -1; // error ����
			
		}

		return fileSize;
		
	}
	
	// Buffered + ���� ����� IO �ڵ�
	public static int fileCopyBufferdStreamVer(File source, File dest) {
		
		int readSize = 0;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;	// buffer �����ؼ� �б�/���� �ӵ� ��� class
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
			// Colse�� ��� : open�� class�� �������� �ݴ´�.
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

	// �ڡڡڡڡڡڡڡ��ʵ忡�� ���� ���� ���� ����
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

	
	
	
	
	// source = ����, dest = ī�� �Ǵ� ���� 
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
			System.out.println("���� ���翡 �����߽��ϴ�!");
		}

		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);

//		result1 : 12128		: 	file�� ����ũ��
//		result2 : 9128		:	�ѱ�(2byte)�� ����(1byte)�� ����

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
		
		// ���
		// Reader, Write ���� Binary ���� ���簡 �Ұ��� �ϴ�. -> ���� �Ҷ� ���� ����~~!!
		// ���ڵ��� �ٸ��ų� ������ Binary����(�̹���, ������, ��Ÿ ����)�� �����ϱ� ���ؼ� 
		//	-> Stream�� ���� ���糪 ���� �� ��~~~~~~

	}

	
	
	

}
