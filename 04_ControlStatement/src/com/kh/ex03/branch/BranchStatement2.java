package com.kh.ex03.branch;

import java.util.Random;
import java.util.Scanner;

public class BranchStatement2 {
	
	public static void main(String[] args) {
		// ���� 1 ~ 10���� �������� ���� �ϳ��� �̰�,
		// �����е��� 5������ ���缭 �̱�� ���� ����
		
		Scanner sc = new Scanner(System.in);
		
		//int randomInt = new Random().nextInt(10);		// 0~9������ �������� �����ö�  -> ���������� Ʋ�� ��!!
		int randomInt = new Random().nextInt(10)+1;		// 1~10������ ������ ���ڰ� ������.
//		char randomChar = (char)('A'+new Random().nextInt(10));
		
		int i=5; // ��ȸ 5��
		boolean isWin = false;		// flag
		
		while (i>0) {
			System.out.print("1~10���� ���� �ϳ��� ������ �ּ��� : ");
			int pickNum = sc.nextInt();
			
			if(pickNum < 1 || pickNum >10) {
				System.out.println("�߸��� ���ڰ� �ԷµǾ����ϴ�. �ٽ� ������ �ּ���. :" +pickNum);
				continue;
			}
			
			if(pickNum == randomInt) {
				isWin = true;
				break;
			} else {
				System.out.println("Ʋ�Ƚ��ϴ�."+(i-1)+"�� ���ҽ��ϴ�.");
			}			
			
			i--;
		}
		
		if(isWin == true) {
			System.out.println("������ϴ�. ����� �¸��Ͽ����ϴ�.");
		} else {
			System.out.println("����� �����Դϴ�.!!");
		}
		System.out.println("���õ� ���ڴ� : "+randomInt);
		

	}

}
