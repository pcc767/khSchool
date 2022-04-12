package com.kh.example.practice3.model.vo;

public class Circle {
	
	private static final double PI = 3.14;
    private int radius = 1;

    public Circle() {

    }

    public void setPI(double PI){
//        this.PI = PI;
    }

    public double getPI(){
        return PI;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void incrementRadius() {
        radius += 1;
    }

    public void getAreaOfCircle(){
        System.out.println((radius*radius)*PI);
    }

    public void getSizeOfCircle(){
        System.out.println((radius*2)*PI);
    }

	
	
	
	
	

}
