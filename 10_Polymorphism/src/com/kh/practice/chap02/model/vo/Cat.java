package com.kh.practice.chap02.model.vo;

public class Cat extends Animal{

	private String location;
    private String color;

    public Cat(){}

    public Cat(String location, String color) {
        this.location = location;
        this.color = color;
    }

    public Cat(String name, String kinds, String location, String color) {
        super(name, kinds);
        this.location = location;
        this.color = color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void speak() {
        System.out.println("?߿?~~~??");
    }
	
}
