package com.kh.hw.employee.view;

import java.util.Scanner;

import com.kh.hw.employee.controller.EmployeeController;
import com.kh.hw.employee.model.vo.Employee;

public class EmployeeMenu {
	
	 private static Scanner sc = new Scanner(System.in);
	 private EmployeeController ec = new EmployeeController();

	    public EmployeeMenu() {
//	    	String menu = "1. ��� �߰�\n2. ��� ����............"
	        while(true) {
	            System.out.println("1. ��� �߰�");
	            System.out.println("2. ��� ����");
	            System.out.println("3. ��� ����");
	            System.out.println("4. ��� ���");
	            System.out.println("9. ���α׷� ����");
	            System.out.print("�޴� ��ȣ�� �������� : ");
	            int inputNum = Integer.parseInt(sc.nextLine());

	            switch (inputNum) {
	                case 1:
	                    insertEmp();
	                    break;
	                case 2:
	                    updateEmp();
	                    break;
	                case 3:
	                    deleteEmp();
	                    break;
	                case 4:
	                    printEmp();
	                    break;
	                case 9:
	                    System.out.println("���α׷��� �����մϴ�.");
	                    return;
	                default:
	                    System.out.println("��ȣ�� �� �� �Է��ϼ̽��ϴ�.");
	                    break;
	            }
	        }
	    }

	    public void insertEmp() {

	        System.out.print("��� ��ȣ : ");
	        int empNo = Integer.parseInt(sc.nextLine());
	        System.out.print("��� �̸� : ");
	        String name = sc.nextLine();
	        System.out.print("��� ���� : ");
	        char gender = sc.next().charAt(0);
	        sc.nextLine();
	        System.out.print("��ȭ ��ȣ : ");
	        String phone = sc.nextLine();
	        while (true) {
	            System.out.print("�߰� ������ �� �Է��Ͻðڽ��ϱ�?(y/n) : ");
	            char inputChar = sc.next().charAt(0);
	            sc.nextLine();

	            if (inputChar == 'y' || inputChar == 'Y') {
	                System.out.print("��� �μ� : ");
	                String dept = sc.nextLine();
	                System.out.print("��� ���� : ");
	                int salary = Integer.parseInt(sc.nextLine());
	                System.out.print("���ʽ��� : ");
	                double bonus = Double.parseDouble(sc.nextLine());

	                ec.add(empNo, name, gender, phone, dept, salary, bonus);

	            } else if (inputChar == 'n' || inputChar == 'N') {
	                ec.add(empNo, name, gender, phone);
	            }
	            break;
	        }
	    }

	    public void updateEmp(){
	        System.out.println("���� �ֽ��� ��� ������ �����ϰ� �˴ϴ�.");
	        System.out.println("����� � ������ �����Ͻðڽ��ϱ�?");
	        System.out.println("1. ��ȭ��ȣ");
	        System.out.println("2. �������");
	        System.out.println("3. ���ʽ� ��");
	        System.out.println("9. ���ư���");
	        System.out.print("�޴� ��ȣ�� �������� : ");
	        int inputNum = Integer.parseInt(sc.nextLine());

	        switch (inputNum){
	            case 1 :
	                System.out.print("������ ��ȭ��ȣ : ");
	                String phone = sc.nextLine();
	                ec.modify(phone);
	                break;

	            case 2 :
	                System.out.print("������ ������� : ");
	                String salary = sc.nextLine();
	                ec.modify(salary);
	                break;

	            case 3 :
	                System.out.print("������ ���ʽ��� : ");
	                double bonus = Double.parseDouble(sc.nextLine()) ;
	                ec.modify(bonus);
	                break;

	            case 9 :
	                System.out.println("���θ޴��� ���ư��ϴ�.");
	                break;

	            default :
	                System.out.println("�� �� �Է��ϼ̽��ϴ�.");
	                break;
	        }

	    }

	    public void deleteEmp(){
	        System.out.print("���� �����Ͻðڽ��ϱ�?(y/n) : ");
	        String inputStr = sc.nextLine();

	        if(inputStr.equals("y") || inputStr.equals("Y")) {
//	            System.out.println("������ ������ �����Ͽ����ϴ�.");	        
	        	Employee e = ec.remove();
		        if(e != null) {
		        	System.out.println("������ ������ �����ϼ̽��ϴ�.");
		        }else {
		        	System.out.println("������ ������ �����Ͽ����ϴ�.");
		        }
	        }
	    }


	    public void printEmp(){
//	        if(ec.inform()==null){
//	            System.out.println("��� �����Ͱ� �����ϴ�.");
//	        }else
	            System.out.println(ec.inform());

	    }
	
	

}
