package com.kh.ex01.conditional;

public class SwitchStatement1 {
	public static void main(String[] args) {
		// ���� 1���~4��� (����, ��� �������� ����)
		// 100~81 1���, 80~70 2���....
		
		double score = 90.7;
		int grade = (int)(score/20);
		
		// switch(�̰��� ��� ������ type : int, chat, String) // double(�Ǽ�)�� �ȵ�
		switch(grade) {
			case 5 : 
			case 4 : 
				System.out.println("1��� �Դϴ�.");
				break;
			case 3 : 
				System.out.println("2��� �Դϴ�.");
				break;
			case 2 : 
				System.out.println("3��� �Դϴ�.");
				break;
			case 1 : 
				System.out.println("4��� �Դϴ�.");
				break;
			default : 
				System.out.println("���ܰ��Դϴ�.");
			
		
		}
	}

}
