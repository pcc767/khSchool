package com.kh.hw.employee.controller;

import com.kh.hw.employee.model.vo.Employee;

public class EmployeeController {

	Employee ey = new Employee(); 
	
	public void add(int empNo, String name, char gender, String phone) {
		ey.setEmpNo(empNo);
		ey.setName(name);
		ey.setGender(gender);
		ey.setPhone(phone);
	}
	
	public void modify(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		ey.setEmpNo(empNo);
		ey.setName(name);
		ey.setGender(gender);
		ey.setPhone(phone);
		ey.setDept(dept);
		ey.setSalary(salary);
		ey.setBonus(bonus);			
	}
	
	public Employee remove() {
		return ey = null;	
	}
	
	public String inform() {
		if(ey == null) {
			return null;
		}else {
			return ey.toString();
		}
	}
	
	
	
	
}
