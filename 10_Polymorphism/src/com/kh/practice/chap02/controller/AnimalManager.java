package com.kh.practice.chap02.controller;

import com.kh.practice.chap02.model.vo.Animal;
import com.kh.practice.chap02.model.vo.Cat;
import com.kh.practice.chap02.model.vo.Dog;

public class AnimalManager {

	public static void main(String[] args) {
		
		 Animal[] animals = new Animal[5];

	        animals[0] = new Dog(5);
	        animals[1] = new Dog("복실이","뉴트리버",15);
	        animals[2] = new Cat("우리집","블루");
	        animals[3] = new Cat("옹이","러시안블루","우리집","블루");
	        animals[4] = new Cat();

	        for(int i=0; i<animals.length; i++){
	            animals[i].speak();
	        }

	}

}
