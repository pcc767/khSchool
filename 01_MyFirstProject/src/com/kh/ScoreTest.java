package com.kh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreTest {
	public static void main(String[] args) {
		File file = new File("score");
		FileReader fr = null;
		BufferedReader br = null;
		
		List<User> list = new ArrayList<User>();
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine()) != null) {
//				System.out.println(line);
				//±è¿µÈÄ,372
				String[] array = line.split(",");
				String name = array[0];
				int score = Integer.parseInt(array[1]);
				User user = new User(name, score);
				list.add(user);
			}
			
//			System.out.println(list);
			Collections.sort(list);
//			System.out.println(list);
			for(User u : list) {
				System.out.println(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class User implements Comparable<User>{
	private String name;
	private int score;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", score=" + score + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public User(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public User() {
		super();
	}
	
	@Override
	public int compareTo(User o) {
		return Integer.compare(o.getScore(), this.getScore());
	}
}
