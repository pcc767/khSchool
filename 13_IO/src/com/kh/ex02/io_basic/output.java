package com.kh.ex02.io_basic;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class output {
	
	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter("test.txt");
			
			fw.write("고맙습니다.");
			fw.write("감사합니다.");
			
			fw.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				fw.close();
		
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		
	}
	

}
