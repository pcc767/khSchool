package com.kh.ex02.io_basic;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class output {
	
	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter("test.txt");
			
			fw.write("�����ϴ�.");
			fw.write("�����մϴ�.");
			
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
