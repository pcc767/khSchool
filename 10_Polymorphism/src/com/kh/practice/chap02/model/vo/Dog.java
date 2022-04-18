package com.kh.practice.chap02.model.vo;

public class Dog extends Animal{
	
	public static final String PLACE = "局斑墨其";
    private int weight;

    public Dog(int weight) {
        this.weight = weight;
    }

    public Dog(String name, String kinds, int weight) {
        super(name, kinds);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void speak() {
        System.out.println("港港港!!");
    }
	
}
