package com.kh.hw.employee.controller;

import com.kh.hw.employee.model.vo.Employee;

public class EmployeeController {

	private Employee ey = new Employee();

    public void add(int empNo, String name, char gender, String phone) {

        ey = new Employee(empNo, name, gender, phone);
        
//        + add(empNo:int,name:String, gender:char,phone:String) : void ; 매개변수  있는  생성자를 이용하여  데이터  저장하는  메소드
        //+calcPerimeter(height:double,width:double) : double;  모양  타입  번호와  받은 매개변수를  매개변수  있는  생성자로  초기화  시킨후  둘레  반환
    }

    public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {

    	ey = new Employee(empNo, name, gender, phone, dept, salary, bonus);
    	
    }
    

    public void modify(String phone) {
        ey.setPhone(phone);
    }

    public void modify(int salary) {
        ey.setSalary(salary);
    }

    public void modify(double bonus) {
        ey.setBonus(bonus);
    }


    // 마지막 객체를 돌려줘야한다.
    // 자신의 가진 객체를 삭제해야한다.
    public Employee remove() {
    	Employee temp = ey;
    	ey=new Employee();    	
        return temp;
    	
//    	return ey = null;
    }

    public String inform() {
//        if(ey == null) {
//            return null;
//        }else {
//            return ey.toString();
//        }
        
        if(ey.getName()== null) {
        	return "사원정보가 없습니다.";
        }
        return ey.toString();
    }

	
	
	
	
}
