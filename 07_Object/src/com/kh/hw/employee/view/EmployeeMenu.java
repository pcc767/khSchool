package com.kh.hw.employee.view;

import java.util.Scanner;

import com.kh.hw.employee.controller.EmployeeController;

public class EmployeeMenu {
	
	public static Scanner sc = new Scanner(System.in);
	EmployeeController eyc = new EmployeeController();
	
	public EmployeeMenu() {
		System.out.println("1. 사원 추가");
		System.out.println("2. 사원 수정");
		System.out.println("3. 사원 삭제");
		System.out.println("4. 사원 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		int inputNum = Integer.parseInt(sc.nextLine());
		
		switch(inputNum) {
		case 1 :
			insertEmp();
			break;
		case 2 :
			updateEmp();
			break;
		case 3 :
			deleteEmp();
			break;
		case 4 :
			printEmp();
			break;
		case 9 :
			System.out.println("프로그램을 종료합니다.");
			return;
		default :
			System.out.println("번호를 잘 못 입력하셨습니다.");
			continue;
				
		}
	}
	
	public void insertEmp() {
		
		System.out.println("사원 번호 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		System.out.println("사원 이름 : ");
		String name = sc.nextLine(); 
		System.out.println("사원 성별 : ");
		char gender = sc.next().charAt(0);
		System.out.println("전화 번호 : ");
		String phone = sc.nextLine();
		System.out.println("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		
		
		
	
		
	}
	
	

}
