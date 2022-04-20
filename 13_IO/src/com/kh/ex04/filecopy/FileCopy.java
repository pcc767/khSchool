package com.kh.ex04.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {
	
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
	
	// source = ����, dest = ī�� �Ǵ� ���� 
		public static int fileCopyReadWriteVer(File source, File dest) {
			int fileSize = 0;
			
			try( FileReader fr = new FileReader(source);
					FileWriter fw = new FileWriter(dest);) {
				
				int read = 0;
				while((read = fr.read()) > -1) {
					fw.write(read);
					fileSize++;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return -1;	//error
			}
			return fileSize;
			
	}

	
	public static void main(String[] args) {
		File source1 = new File("./covid.txt");
		File dest1 = new File("./copy1_covid.txt");
		File dest2 = new File("./copy2_covid.txt");
		
		int result1 = FileCopy.fileCopyStreamVer(source1, dest1);
		int result2 = FileCopy.fileCopyReadWriteVer(source1, dest2);
		if(result1 == -1) {
			System.out.println("���� ���翡 �����߽��ϴ�!");
		}
		
		System.out.println("result1 : "+ result1);
		System.out.println("result2 : "+ result2);
		
//		result1 : 12128		: 	file�� ����ũ��
//		result2 : 9128		:	�ѱ�(2byte)�� ����(1byte)�� ����
		
		//---------------------------------------------------------------
		
		File source3 = new File("./covid_UTF16.txt");
		File dest3 = new File("./copy1_covid_UTF16.txt");
		File dest4 = new File("./copy2_covid_UTF16.txt");
		
		int result3 = FileCopy.fileCopyStreamVer(source3, dest3);
		int result4 = FileCopy.fileCopyReadWriteVer(source3, dest4);
		
		System.out.println("result3 : "+ result3);
		System.out.println("result4 : "+ result4);

		// ---------------------------------------------------------------
		File source5 = new File("./images.jpg");
		File dest5 = new File("./copy1_images.jpg");
		File dest6 = new File("./copy2_images.jpg");

		int result5 = FileCopy.fileCopyStreamVer(source5, dest5);
		int result6 = FileCopy.fileCopyReadWriteVer(source5, dest6);

		System.out.println("result5 : " + result5);
		System.out.println("result6 : " + result6);

		
		// ���
		// Reader, Write ���� Binary ���� ���簡 �Ұ��� �ϴ�. -> ���� �Ҷ� ���� ����~~!!
		// ���ڵ��� �ٸ��ų� ������ Binary����(�̹���, ������, ��Ÿ ����)�� �����ϱ� ���ؼ� 
		//	-> Stream�� ���� ���糪 ���� �� ��~~~~~~
		
		

	}

	
	
	

}
