package com.kh.ex06.inoutput;

public class outputPractice {

	public static void main(String[] args) {
		String name = "��浿";
		int age = 27;
		double height = 180.5;
		double weight = 65.5;
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(weight);
		
		System.out.println("�ȳ��ϼ���? ���� " + name + " �Դϴ�.");

		// printf = format ���
		System.out.printf("�̸��� %s, ���̴� %d, Ű�� %f, �����Դ� %f\n"
													,name , age, height, weight);
		
		System.out.printf("Ű�� %.2f, �����Դ� %.2f\n",  height, weight);
		
		System.out.println("�ȳ��ϼ���? ���� " + name + " �Դϴ�. Ű�� " + height + "�Դϴ�");
		
		String heightStr = String.format("%.2f", height);
		System.out.println("�ȳ��ϼ���? ���� " + name + " �Դϴ�. Ű�� " + heightStr + "�Դϴ�");
	}
}
