package home;

import java.util.Scanner;

public class home {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�Է� 1 : ");
		int num1 = sc.nextInt();
		System.out.println("�Է� 1 : ");
		int num2 = sc.nextInt();
		
		try {
			System.out.println("�� ���� ������ ��� : "+ num1/num2);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������� �������� �õ��Ͽ����ϴ�.");
		}

	}
	
}
