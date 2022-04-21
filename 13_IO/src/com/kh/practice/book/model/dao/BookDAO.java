package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {
	
	private Book[] bArr = new Book[10];
	
	
	public void fileSave(Book[] bArr) {
		
		try(
				FileOutputStream fos = new FileOutputStream("book.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
			){
			for(int i=0; i<bArr.length; i++) {
				if(bArr[i] != null) {
					oos.writeObject(bArr);
				}				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public Book[] fileRead(){
		
		Object bAll = null;
		
		try (FileInputStream fis = new FileInputStream("book.txt");
			 ObjectInputStream ois = new ObjectInputStream(fis);				
			) {
			
			bAll = ois.readObject();

			
		} catch (EOFException e2) {
			e2.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return (Book[])bAll;
		
	}
		
	


}
