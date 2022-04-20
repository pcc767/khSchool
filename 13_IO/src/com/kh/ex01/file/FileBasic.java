package com.kh.ex01.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class FileBasic {
	
	// 파일 경로(Path)란?
		// - File이 저장 되어 있는 보조기억장치(HDD,SSD)의 경로(위치)
		
		// 절대경로 vs 상대경로
		// 1. 절대 경로
		//  - Root (윈도우 : C:\ , 리눅스 : \)로 부터 표기되는 절대적인 경로
		//  - ex) C:\Users\text.txt 
		//  - ex) C:\Dev\dev-source\13_IO\covid.txt
		
		// 2. 상대 경로
		//  - 프로그램의 실행 위치로부터의 표기되는 상대적인 경로 '.', '..'으로 표기되는 경로
		//  - '.' : 현재위치, '..' : 상위폴더 위치
		//  - ex) ./covid.txt,
	
	public static void main(String[] args) {
		File file1 = new File("./covid.txt");
		File file2 = new File("C:\\Dev\\dev-source\\13_IO\\covid.txt");
//		File file2 = new File(file1.getAbsolutePath());
		
		System.out.println(file1.getPath());				//상대경로
		System.out.println(file2.getAbsolutePath());		//절대경로
		System.out.println("-------------------------------------------------");
		
		
		// 부모 출력하기
		System.out.println(file1.getParent());		// .
		System.out.println(file2.getParent());		// C:\Dev\dev-source\13_IO
		System.out.println("-------------------------------------------------");
		
		//권한 물어보기
		System.out.println(file1.canRead());		// 읽기
		System.out.println(file1.canWrite());		// 쓰기
		System.out.println(file1.canExecute());		// 실행(리눅스)
		
		//권한 설정하기
		file1.setWritable(false);
		System.out.println(file1.canExecute());
		file1.setWritable(true);		// win+java setWritable 설정말 가능
		System.out.println("-------------------------------------------------");
		
		//이름 바꾸기
//		File newFile = new File("./covid2.txt");
//		file1.renameTo(newFile);
		
		// 사용 이력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(file1.lastModified()));
		System.out.println("-------------------------------------------------");
		
		//파일 길이
		System.out.println(file1.length()+" byte");
		System.out.println(file1.length()/1024+" kbyte");
		System.out.println("-------------------------------------------------");
		
		//파일 삭제
//		file1.delete();
		
		//디렉토리 (폴더) 다루기
		
		File folder = new File(".");
		if(folder.isDirectory() == true) {
			System.out.println("디렉토리 입니다.");
		}
		System.out.println(Arrays.toString(folder.listFiles()));
		
		
		
		
		
		
		
		
	}


}
