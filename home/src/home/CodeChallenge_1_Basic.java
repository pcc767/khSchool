package home;

import java.util.Arrays;
import java.util.Scanner;

public class CodeChallenge_1_Basic {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// ������� �ڵ� ¥�ּ���.
		// 1. �˸��� ���� �����ϰ� ����ϱ�
		//  Ex) ���������� 1000 ��� �ϱ�
		int value = 1000;
		System.out.println(value);
		
		// 1.1 ���������� 94743616344 ����ϱ�
		long val_1 = 94743616344L;
		System.out.println(val_1);
		
		// 1.2 �Ǽ������� 3.14 ����ϱ�
		double val_2 = 3.14;
		System.out.println(val_2);
		
		// 1.3 100�� 3���� ������, �Ҽ��� ǥ���ϱ� ex) 33.333333
		
		double val_3 = 100 / 3.0;
		System.out.println(String.format("%.6f", val_3));

		// 1.4 �Ǽ� 12.71�� �����ϰ�, �Ҽ��� ������ ex) 12
		double val_4 = 12.71;
		System.out.println(String.format("%.0f", val_4-1));
		
		
		// 1.5 byte b�� 128�� �ʱ�ȭ ������ ��Ű�� 
		byte val_5 = 5;
		val_5 = (byte)128;
		System.out.println(val_5);
		
		
		
//		2. ���� �����ڿ� if�� Switch�� �Բ� ����ϱ�
		// Ex) val2��� ���ڰ� 100���� ū�� Ȯ���ϰ�, ��� '��' '�ƴϿ�' ����ϱ�
		int val2 = 123;
		if(val2 > 100) {
			System.out.println("��");
		}else {
			System.out.println("�ƴϿ�");
		}
		
		//2.1 �Ѽ��� �Է¹޾� 2�� ���, 3�� ���, 5�� ������� Ȯ���ϼ���. 
		
		
		//2.2 // 1~300 �߿� �Ѽ��� �Է¹ް�, 
			  // 1~100���� ����, 100�ʰ� ~ 200 ���� ����, 200~�ʰ� �������� �и��Ͽ� ����ϼ���.
		      // 50 = 1~100 ���� , 124 = 100~200����

		//2.3 switch���� ���� ���ڿ� ���ڸ� �����ϴ� �ڵ带 �ۼ��ϼ���.
		
		
		//2.4 ID/PW�� �Է¹ް�, ID�� 5���� �̻��̰�, ID�� PW�� ���Ե��� ���� ���¸�
 		//    if�� �ϳ��� üũ���ּ���.
		
		
//		3. �ݺ���
		// ex) 1~10���� ����ϱ�
		for(int i =0; i<10; i++) {
			System.out.println(i);
		}
		
		// 3.1 ������ 2�ܸ� ����ϱ� ex) 2 X 1 = 2 �÷�
		for(int i=1; i<10; i++) {
			System.out.println("2 X "+i+" = "+2*i);
		}
		
		// 3.2 1���� 100���� ¦���� ��� ����ϱ�
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		System.out.println("-----------------------\n");
		
		// 3.3 1���� 100���� �� �߿� 5�� ����� 7�� ����� Ȯ���ϰ� ����ϱ�.
		for(int i=1; i<=100; i++) {
			if(i%5 == 0 || i%7 == 0) {
				System.out.println(i);
			}
		}
		System.out.println("-----------------------\n");
		
		// 3.4 1���� 1000���� �� �߿� 
		//     3�� ����̸鼭 4�� ����� ���� ��� ã��,
		//     ���߿� 20���� ã���� �ݺ��� �����ϱ�.
		int count = 0;			
		for(int i=1; i<1000; i++) {			
			if(i%3==0 && i%4==0) {
				System.out.println(i);
				count++;
			}
			if(count == 20) {
				break;
			}
		}
		
		System.out.println("-----------------------\n");
		
//		4. ��ø �ݺ���
		// 4.1 ������ 1�ܺ��� 9�ܱ��� ��� ����ϴµ�, ���� �ٲ𶧸��� "x��" ǥ���ϱ�
		// ex) 2 X 9 = 18;
		//     3�� ����!
		//     3 X 1 = 3
		
		for(int i=2; i<10; i++) {
			System.out.println(i+"�� ����");
			for(int j=1; j<10; j++) {
				System.out.println(i+ " X "+j+" = "+i*j);
			}
		}
		
		System.out.println("-----------------------\n");
		
		// 4.2 ������ 1�ܺ��� 9�ܱ��� ��� ����ϴµ�
		// 9�ܱ��� ���η� ����ϱ�
		// ex) 2X1=1 3X1=3 4X1=4 ...
		//     2X2=2 3X2=6 4X2=8
		
		for(int i=2; i<10; i++) {
			System.out.print(i+"�� ����\t\t");
			
		}
		System.out.println();
		for(int i=1; i<10; i++) {
			for(int j=2; j<10; j++) {
				System.out.print(j+ " X "+i+" = "+j*i+"\t");
			}
			System.out.println();
		}
		System.out.println("-----------------------\n");
		
		
		// 4.3 ����ڿ��� 1~100 ���� 2���� �Է� �ް�, �� ���� ���� ���� ���� ��� ����ϱ�.
		//     ��, ���� �ݺ��ϱ�.
		// �Է� 53, 47
		// ��� 48, 49, 50, 51, 52		
		
		
//		System.out.println("1~100���� �� ���� ���� �Ͻÿ� ");
//		System.out.print("ù��° �� : ");
//		int firtNum = Integer.parseInt(sc.nextLine());		
//		System.out.print("�ι�° �� : ");
//		int secNum = Integer.parseInt(sc.nextLine());		
//		
//		if(firtNum > secNum) {
//			for(int i=secNum; i<=firtNum; i++) {
//				System.out.println(i);
//			}
//		}else if (firtNum < secNum) {
//			for(int i=firtNum; i<=secNum; i++) {
//				System.out.println(i);
//			}
//		}
		System.out.println("-----------------------\n");
		
		
//		5. �迭
//		5.1 �迭 ���������� 10�� ĭ�� �����ϰ�, 1���� 10������ �� �ʱ�ȭ �ϱ�
		int[] num = new int[10];
		for(int i=0; i<10; i++) {
			System.out.println(num[i] = i);
		}
		System.out.println("-----------------------\n");
		
		
			
		

//		5.2 �迭 ���������� 100������ �����ϰ�, 3�� 7�� ��� 100�� ã�Ƽ� �ֱ�
		// 21, 42 .....
		int[] num1 = new int[100];
		int startNum = 1;
		count =0;

		while(true) {
			startNum++;
			if(startNum%3==0 && startNum%7==0) {
				num1[count]=startNum;
				count++;		
				System.out.println(count+" : "+num1[count]);
			}
			if(count == 100) {
				break;
			}
			
		}
		
		
		
//		for(int i=0; i<=startNum; i++) {
//			if(i%3==0 && i%7==0) {
//				num1[count]=i;				
//				System.out.println(num1[i]);
//				count++;
//			}
//		}			
//		if(count == 100) {
//			break;
//		}

		

//		5.3 �迭 String������ 10�� ���� �����ϰ� ������� ���� �Է¹޾� �� �����ϱ�.
		//  ��, exit�� �Է½� �ٷ� �����ϰ� ���� ���� ������ ��� ���
		
//		5.4 �迭 String������ 10�� ���� �����ϰ� ������� ���� �Է¹޾� �� �����ϱ�.
		//  ���߿� ���ڷ� �Էµ� ���� ����ϱ�
		
//		5.5 �迭 String������ 10�� ���� �����ϰ� ����ڿ��� '����' ���� �Է¹޾� �� �����ϱ�.
		//  ���߿� ���ĺ� ���� ��� count �غ���.
		// abc bbb ccc
		// a : 1��
		// b : 4��
		// c : 4��
		
	}

}
