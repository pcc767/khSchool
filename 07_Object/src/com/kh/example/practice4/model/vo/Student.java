package com.kh.example.practice4.model.vo;

public class Student {

	private int grade;
    private int classroom;
    private String name;
    private double height;
    private char gender;

    public Student() {

    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public void setGender(char gender) {
        this.grade = gender;
    }

    public char getGender(){
        return gender;
    }

    public void information()  {
        System.out.println(grade);
        System.out.println(classroom);
        System.out.println(name);
        System.out.println(height);
        System.out.println(gender);
    }
	
	
	
	
}
