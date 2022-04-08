package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
//		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��Ͻÿ� : ");
		System.out.println(Integer.parseInt(sc.nextLine())>0 ? "�����." : "����� �ƴϴ�.");
		
//		int val = sc.nextInt();
//		String str = val>0 ? "�����" : "����� �ƴϴ�.";
//		System.out.println(str);
	}
	
	public void practice2() {
//		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��Ͻÿ� : ");		
		int val = sc.nextInt();
		
		String str = val>0 ? "�����" : (val == 0 ? "0�̴�" : "������");
		System.out.println(str);
	}
	
	public void practice3() {
//		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��Ͻÿ� : ");
		int val = sc.nextInt();
		
		String str = val%2 == 0 ? "¦����" : "Ȧ����";
		System.out.println(str);	
		
	}
	
	public void practice4() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("�ο� �� : ");
//		int people = sc.nextInt();
//		System.out.println("���� ���� : ");
//		int candy = sc.nextInt();
//		
//		int peo = candy / people;
//		int can = candy % people;
//		
//		System.out.println("1�δ� ���� ���� : "+peo);	
//		System.out.println("���� ���� ���� : "+can);	
		
		//c��� old style
		//����� ����
		int iUserNum = 0;
		int iCandyNum = 0;
		//����� ��
		
		//�Էº� ����
		System.out.println("����� ����? : ");
		iUserNum = Integer.parseInt(sc.nextLine());
		
		System.out.println("������ ����? : ");
		iCandyNum = Integer.parseInt(sc.nextLine());
		//�Էº� ��
		
		// ��º�
		System.out.println("1�δ� ���� ���� : "+ (iCandyNum / iUserNum));
		System.out.println("���� ���� ���� : " + (iCandyNum % iUserNum));	
		
	}
	
	public void practice5() {

//        Scanner sc = new Scanner(System.in);
        System.out.print("�̸� : ");
        String name = sc.nextLine();

        System.out.print("�г�(���ڸ�) : ");
        int grade = sc.nextInt();
        sc.nextLine();

        System.out.print("��(���ڸ�) : ");
        String _class = sc.nextLine();

        System.out.print("��ȣ(���ڸ�) : ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("����(M/F) : ");
        String gen = sc.nextLine();

        System.out.print("����(�Ҽ��� �Ʒ� ��°�ڸ�����) : ");
        double grade_ = sc.nextDouble();

        String girl = "���л�";
        String boy = "���л�";

        String str = gen.equals("F") ? grade + "�г� " + _class + "�� " + num + "�� " + name + " " + girl + "�� ������ " + grade_ + "�̴�" :
                grade + "�г� " + _class + "�� " + num + "�� " + name + " " + boy + "�� ������ " + grade_ + "�̴�";

        System.out.println(str);
    }


    public void practice6() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("���̸� �Է��Ͻÿ� : ");
        int age = sc.nextInt();

        String result = age<=13 ? "���" : (age>13 && age<=19 ? "û�ҳ�" : "����");
        System.out.println(result);
    }

    public void practice7() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("���� : ");
        int kor = sc.nextInt();
        System.out.print("���� : ");
        int eng = sc.nextInt();
        System.out.print("���� : ");
        int math = sc.nextInt();

        int total = kor+eng+math;
        double avg = total/3.0;

        System.out.println("�հ� : "+total);
        System.out.printf("��� : %.2f\n", avg);
//        System.out.println("��� : "+avg);

        String result = kor>=40 && eng>=40 && math>=40 ? (total>=60 ? "�հ�" : "���հ�") : "���հ�";
        System.out.println(result);

    }

    public void practice8() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("�ֹι�ȣ�� �Է��Ͻÿ�(- ����) : ");
//        String id = sc.nextLine();
//
//        String result = id.charAt(7)=='2' ? "����" : "����";
//        System.out.println(result);
        
    	System.out.print("�ֹι�ȣ�� �Է��Ͻÿ�(- ����) : ");
    	String privateNum = sc.nextLine();
    	char gendrchar = privateNum.charAt(7);
    	
    	if(gendrchar == '1' || gendrchar == '3') 
    		System.out.println("����");
    	 else 
    		System.out.println("����");        
      
    }

    public void practice9() {
//        Scanner sc = new Scanner(System.in);
        System.out.println("ù��° ������ �ι�° �������� �۾ƾ��Ѵ�.");
        System.out.print("ù ��° ������ �Է��ϼ��� : ");
        int num1 = sc.nextInt();
        System.out.print("�� ��° ������ �Է��ϼ��� : ");
        int num2 = sc.nextInt();
        System.out.print("���� ���� �Է� : ");
        int num3 = sc.nextInt();

        String result = num1<=num3 ? (num2<num3 ? "true" : "false") : "false";
        System.out.println(result);

    }

    public void practice10() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("�Է� 1 : ");
        int num1 = sc.nextInt();
        System.out.print("�Է� 2 : ");
        int num2 = sc.nextInt();
        System.out.print("�Է� 3 : ");
        int num3 = sc.nextInt();

        String result = num1 == num2 ? (num2 == num3 ? "true" : "false") : "false";
        System.out.println(result);

    }

    public void practice11() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("A����� ���� : ");
//        int payA = sc.nextInt();
        int patA = Integer.parseInt(sc.nextLine());  // -> �� ������� ����!!!!!!!        
        System.out.print("B����� ���� : ");
        int payB = sc.nextInt();
        System.out.print("C����� ���� : ");
        int payC = sc.nextInt();

        double incenA = payA * 1.4;
        double incenB = payB;
        double incenC = payC * 1.15;

        String resultA = incenA >= 3000 ? "A��� ����/����+a : "+payA+"/"+incenA+"\n 3000 �̻�" :
                         "A��� ����/����+a : "+payA+"/"+incenA+"\n3000 �̸�";
        String resultB = incenB >= 3000 ? "B��� ����/����+a : "+payB+"/"+incenB+"\n 3000 �̻�" :
                         "B��� ����/����+a : "+payB+"/"+incenB+"\n 3000 �̸�";
        String resultC = incenC >= 3000 ? "C��� ����/����+a : "+payC+"/"+incenC+"\n 3000 �̻�" :
                         "C��� ����/����+a : "+payC+"/"+incenC+"\n 3000 �̸�";

        System.out.println(resultA);
        System.out.println(resultB);
        System.out.println(resultC);


    }
    
   

	
}
