package com.kh.hw.member.util;

import java.util.Scanner;

public class Util {
	// ����ó��, ��¥, format ���� ��Ÿ ��ɵ� ������ ��
	
	static private Scanner sc = new Scanner(System.in);
	
	public static int readIntForConsol() { // �Ϻ��ϰ� �ֿܼ��� �Է°��� �޾ƿò� å��.
		int value = 0;
		sc.reset(); // sc�� �ʱ�ȭ. ���� ���� �Ͱ� ���� ȿ��.
		
		while(true) {
			String str = sc.nextLine(); // ���� �о�´�.
			if(str == null || str.length() < 1 ) { // �Ѵ� ����� �Է¹��� ���� ���.
				System.out.println("�ٽ� ���ڸ� �Է����ּ���.");
				continue;
			}
			
			try {
				value = Integer.parseInt(str); // ���ڰ� �ƴԿ�. 
			} catch (Exception e) {
				System.out.println("�ٽ� ���ڸ� �Է����ּ���.");
				continue;
			}
			break;
		}
		return value;
	}
	
	public static double readDoubleForConsol() { // �Ϻ��ϰ� �ֿܼ��� �Է°��� �޾ƿò� å��.
		double value = 0;
		sc.reset(); // sc�� �ʱ�ȭ. ���� ���� �Ͱ� ���� ȿ��.
		
		while(true) {
			String str = sc.nextLine(); // ���� �о�´�.
			if(str == null || str.length() < 1 ) { // �Ѵ� ����� �Է¹��� ���� ���.
				System.out.println("�ٽ� ���ڸ� �Է����ּ���.");
				continue;
			}
			
			try {
				value = Double.parseDouble(str); // ���ڰ� �ƴԿ�. 
			} catch (Exception e) {
				System.out.println("�ٽ� ���ڸ� �Է����ּ���.");
				continue;
			}
			break;
		}
		return value;
	}
	
	public static String readStrForConsol() { // �Ϻ��ϰ� �ֿܼ��� �Է°��� �޾ƿò� å��.
		String str = null;
		sc.reset(); // sc�� �ʱ�ȭ. ���� ���� �Ͱ� ���� ȿ��.
		
		while(true) {
			str = sc.nextLine(); // ���� �о�´�.
			if(str == null || str.length() < 1 ) { // �Ѵ� ����� �Է¹��� ���� ���.
				System.out.println("�ٽ� ���ڸ� �Է����ּ���.");
				continue;
			}
			break;
		}
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println("���� �Է�");
		int read = Util.readIntForConsol();
		System.out.println(read);
		System.out.println("���� �Է�");
		String str = Util.readStrForConsol();
		System.out.println(str);
	}
	
}
