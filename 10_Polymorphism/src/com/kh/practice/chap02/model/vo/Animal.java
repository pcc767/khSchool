package com.kh.practice.chap02.model.vo;

public abstract class Animal {
	
	private String name;
    private String kinds;

    protected Animal(){}

    protected Animal(String name, String kinds) {
        this.name = name;
        this.kinds = kinds;
    }

    public abstract void speak();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", kinds='" + kinds + '\'' +
                '}';
    }

}
