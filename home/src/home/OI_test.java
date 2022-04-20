package home;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class OI_test {
	
	
	public static int fileCopyBufferedStreamVer (File source, File dest) {
		int readLinecount = 0;

		
		try(
				FileReader fr = new FileReader(source);
				FileWriter fw = new FileWriter(dest);
				BufferedReader br = new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw);
		
				){
			String readLine = null;
			while( (readLine = br.readLine()) != null) {
				bw.append(readLine);
				bw.newLine();
				readLinecount++;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return readLinecount;
	
	}
		
}
