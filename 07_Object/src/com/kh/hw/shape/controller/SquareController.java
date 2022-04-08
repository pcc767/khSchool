package com.kh.hw.shape.controller;

import com.kh.hw.shape.model.vo.Shape;

public class SquareController {
	
	private Shape s = new Shape();

    public double calPerimeter(double height, double width) {
        s.setHeight(height);
        s.setWidth(width);

        return (width*2)+(height*2);
    }

    public double calcArea(double height, double width){
        s.setHeight(height);
        s.setWidth(width);

        return width*height;
    }

    public void paintColor(String color) {
        s.setColor(color);
    }

    public String print() {
        return s.information();
    }
}
