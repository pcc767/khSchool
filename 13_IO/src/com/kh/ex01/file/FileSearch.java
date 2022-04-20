package com.kh.ex01.file;

import java.io.File;

public class FileSearch {
	
	//��� ���α׷��� - Recursive Programming
	// -> �Լ����� ������ ������ ȣ���ϴ� ���α׷��� ���
	
	public static void search(File file, int depth) {
		String tempStr = " ".repeat(depth);
		
		if(file.isFile()==true) {		// break��1 . �����϶� �����.
			System.out.println(tempStr + "��" + file.getName());		//����Ʈ
			return;
		}
		//���丮 �϶�
		System.out.println(tempStr + file.getName());
		
		File[] list = file.listFiles();
		if(list == null || list.length == 0) {
			return;
		}
		
		for(File childFile : list) {
			search(childFile, depth+1); 	//�ڽ� ������ ���� �����
		}

	}

	
	public static void main(String[] args) {
		File file = new File("./");
		search(file, 0);
	}
	

}
