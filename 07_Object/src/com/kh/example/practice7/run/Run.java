package com.kh.example.practice7.run;

import com.kh.example.practice7.model.vo.Employee;

public class Run {
	 public static void main(String[] args) {

	        Employee ey = new Employee();

	        ey.setEmpNo(100);
	        ey.setEmpName("ȫ�浿");
	        ey.setDept("������");
	        ey.setJob("����");
	        ey.setAge(25);
	        ey.setGender('��');
	        ey.setSalary(2500000);
	        ey.setBonusPoint(0.05);
	        ey.setPhone("010-1234-5678");
	        ey.setAddress("����� ������");

	        System.out.println("empNo : "+ey.getEmpNo()+" ");
	        System.out.println("empName : "+ey.getEmpName()+" ");
	        System.out.println("dept : "+ey.getDept()+" ");
	        System.out.println("job : "+ey.getJob()+" ");
	        System.out.println("age : "+ey.getAge()+" ");
	        System.out.println("gender : "+ey.getGender()+" ");
	        System.out.println("salary : "+ey.getSalary()+" ");
	        System.out.println("bonusPoint : "+ey.getBonusPoint()+" ");
	        System.out.println("phone : "+ey.getPhone()+" ");
	        System.out.println("address : "+ey.getAddress()+" ");
	        
	 }

}
