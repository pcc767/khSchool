package com.kh.ex01.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class FileBasic {
	
	// ���� ���(Path)��?
		// - File�� ���� �Ǿ� �ִ� ���������ġ(HDD,SSD)�� ���(��ġ)
		
		// ������ vs �����
		// 1. ���� ���
		//  - Root (������ : C:\ , ������ : \)�� ���� ǥ��Ǵ� �������� ���
		//  - ex) C:\Users\text.txt 
		//  - ex) C:\Dev\dev-source\13_IO\covid.txt
		
		// 2. ��� ���
		//  - ���α׷��� ���� ��ġ�κ����� ǥ��Ǵ� ������� ��� '.', '..'���� ǥ��Ǵ� ���
		//  - '.' : ������ġ, '..' : �������� ��ġ
		//  - ex) ./covid.txt,
	
	public static void main(String[] args) {
		File file1 = new File("./covid.txt");
		File file2 = new File("C:\\Dev\\dev-source\\13_IO\\covid.txt");
//		File file2 = new File(file1.getAbsolutePath());
		
		System.out.println(file1.getPath());				//�����
		System.out.println(file2.getAbsolutePath());		//������
		System.out.println("-------------------------------------------------");
		
		
		// �θ� ����ϱ�
		System.out.println(file1.getParent());		// .
		System.out.println(file2.getParent());		// C:\Dev\dev-source\13_IO
		System.out.println("-------------------------------------------------");
		
		//���� �����
		System.out.println(file1.canRead());		// �б�
		System.out.println(file1.canWrite());		// ����
		System.out.println(file1.canExecute());		// ����(������)
		
		//���� �����ϱ�
		file1.setWritable(false);
		System.out.println(file1.canExecute());
		file1.setWritable(true);		// win+java setWritable ������ ����
		System.out.println("-------------------------------------------------");
		
		//�̸� �ٲٱ�
//		File newFile = new File("./covid2.txt");
//		file1.renameTo(newFile);
		
		// ��� �̷�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(file1.lastModified()));
		System.out.println("-------------------------------------------------");
		
		//���� ����
		System.out.println(file1.length()+" byte");
		System.out.println(file1.length()/1024+" kbyte");
		System.out.println("-------------------------------------------------");
		
		//���� ����
//		file1.delete();
		
		//���丮 (����) �ٷ��
		
		File folder = new File(".");
		if(folder.isDirectory() == true) {
			System.out.println("���丮 �Դϴ�.");
		}
		System.out.println(Arrays.toString(folder.listFiles()));
		
		
		
		
		
		
		
		
	}


}
