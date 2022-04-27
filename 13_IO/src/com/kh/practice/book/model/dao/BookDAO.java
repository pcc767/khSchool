package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {
	
	public void fileSave(Book[] bArr) {
		
		try(FileOutputStream fos = new FileOutputStream("book.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);				
			){
			oos.writeObject(bArr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public Book[] fileRead(){
		
		try (FileInputStream fis = new FileInputStream("book.txt");
			 ObjectInputStream ois = new ObjectInputStream(fis);				
			) {
			
			Book[] bArr = (Book[]) ois.readObject();
			return bArr;

		} catch (Exception e) {
			e.printStackTrace();
			return new Book[0];
		}

		
	}
		
	


}
