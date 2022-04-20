package com.kh.ex01.file;

import java.io.File;

public class FileSearch {
	
	//재귀 프로그래밍 - Recursive Programming
	// -> 함수에서 본인을 스스로 호출하는 프로그래밍 기법
	
	public static void search(File file, int depth) {
		String tempStr = " ".repeat(depth);
		
		if(file.isFile()==true) {		// break점1 . 파일일때 멈춘다.
			System.out.println(tempStr + "└" + file.getName());		//프린트
			return;
		}
		//디렉토리 일때
		System.out.println(tempStr + file.getName());
		
		File[] list = file.listFiles();
		if(list == null || list.length == 0) {
			return;
		}
		
		for(File childFile : list) {
			search(childFile, depth+1); 	//자식 파일을 통해 재귀함
		}

	}

	
	public static void main(String[] args) {
		File file = new File("./");
		search(file, 0);
	}
	

}
