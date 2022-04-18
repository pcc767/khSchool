package home;

import java.util.Arrays;
import java.util.Scanner;

public class CodeChallenge_1_Basic {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 순서대로 코드 짜주세요.
		// 1. 알맞은 변수 선언하고 출력하기
		//  Ex) 정수형으로 1000 출력 하기
		int value = 1000;
		System.out.println(value);
		
		// 1.1 정수형으로 94743616344 출력하기
		long val_1 = 94743616344L;
		System.out.println(val_1);
		
		// 1.2 실수형으로 3.14 출력하기
		double val_2 = 3.14;
		System.out.println(val_2);
		
		// 1.3 100을 3으로 나누고, 소수점 표시하기 ex) 33.333333
		
		double val_3 = 100 / 3.0;
		System.out.println(String.format("%.6f", val_3));

		// 1.4 실수 12.71을 선언하고, 소수점 버리기 ex) 12
		double val_4 = 12.71;
		System.out.println(String.format("%.0f", val_4-1));
		
		
		// 1.5 byte b에 128로 초기화 억지로 시키기 
		byte val_5 = 5;
		val_5 = (byte)128;
		System.out.println(val_5);
		
		
		
//		2. 각종 연산자와 if문 Switch문 함께 사용하기
		// Ex) val2라는 인자가 100보다 큰지 확인하고, 결과 '예' '아니오' 출력하기
		int val2 = 123;
		if(val2 > 100) {
			System.out.println("예");
		}else {
			System.out.println("아니오");
		}
		
		//2.1 한수를 입력받아 2의 배수, 3의 배수, 5의 배수인지 확인하세요. 
		
		
		//2.2 // 1~300 중에 한수를 입력받고, 
			  // 1~100이하 구간, 100초과 ~ 200 이하 구간, 200~초과 구간으로 분리하여 출력하세요.
		      // 50 = 1~100 구간 , 124 = 100~200구간

		//2.3 switch문을 통해 숫자와 문자를 구별하는 코드를 작성하세요.
		
		
		//2.4 ID/PW를 입력받고, ID가 5글자 이상이고, ID에 PW가 포함되지 않은 상태를
 		//    if문 하나로 체크해주세요.
		
		
//		3. 반복문
		// ex) 1~10까지 출력하기
		for(int i =0; i<10; i++) {
			System.out.println(i);
		}
		
		// 3.1 구구단 2단만 출력하기 ex) 2 X 1 = 2 꼴로
		for(int i=1; i<10; i++) {
			System.out.println("2 X "+i+" = "+2*i);
		}
		
		// 3.2 1부터 100까지 짝수만 골라서 출력하기
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		System.out.println("-----------------------\n");
		
		// 3.3 1부터 100까지 수 중에 5의 배수와 7의 배수를 확인하고 출력하기.
		for(int i=1; i<=100; i++) {
			if(i%5 == 0 || i%7 == 0) {
				System.out.println(i);
			}
		}
		System.out.println("-----------------------\n");
		
		// 3.4 1부터 1000까지 수 중에 
		//     3의 배수이면서 4의 배수인 수를 모두 찾고,
		//     이중에 20번을 찾으면 반복문 정지하기.
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
		
//		4. 중첩 반복문
		// 4.1 구구단 1단부터 9단까지 모두 출력하는데, 단이 바뀔때마다 "x단" 표시하기
		// ex) 2 X 9 = 18;
		//     3단 시작!
		//     3 X 1 = 3
		
		for(int i=2; i<10; i++) {
			System.out.println(i+"단 시작");
			for(int j=1; j<10; j++) {
				System.out.println(i+ " X "+j+" = "+i*j);
			}
		}
		
		System.out.println("-----------------------\n");
		
		// 4.2 구구단 1단부터 9단까지 모두 출력하는데
		// 9단까지 가로로 출력하기
		// ex) 2X1=1 3X1=3 4X1=4 ...
		//     2X2=2 3X2=6 4X2=8
		
		for(int i=2; i<10; i++) {
			System.out.print(i+"단 시작\t\t");
			
		}
		System.out.println();
		for(int i=1; i<10; i++) {
			for(int j=2; j<10; j++) {
				System.out.print(j+ " X "+i+" = "+j*i+"\t");
			}
			System.out.println();
		}
		System.out.println("-----------------------\n");
		
		
		// 4.3 사용자에게 1~100 수중 2개를 입력 받고, 두 수의 범위 안의 숫자 모두 출력하기.
		//     단, 무한 반복하기.
		// 입력 53, 47
		// 출력 48, 49, 50, 51, 52		
		
		
//		System.out.println("1~100까지 두 수를 선택 하시오 ");
//		System.out.print("첫번째 수 : ");
//		int firtNum = Integer.parseInt(sc.nextLine());		
//		System.out.print("두번째 수 : ");
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
		
		
//		5. 배열
//		5.1 배열 정수형으로 10개 칸을 선언하고, 1부터 10까지로 값 초기화 하기
		int[] num = new int[10];
		for(int i=0; i<10; i++) {
			System.out.println(num[i] = i);
		}
		System.out.println("-----------------------\n");
		
		
			
		

//		5.2 배열 정수형으로 100개까지 선언하고, 3과 7의 배수 100개 찾아서 넣기
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

		

//		5.3 배열 String형으로 10개 공간 선언하고 사용자의 값을 입력받아 값 저장하기.
		//  단, exit로 입력시 바로 종료하고 저장 받은 데이터 모두 출력
		
//		5.4 배열 String형으로 10개 공간 선언하고 사용자의 값을 입력받아 값 저장하기.
		//  이중에 숫자로 입력된 값만 출력하기
		
//		5.5 배열 String형으로 10개 공간 선언하고 사용자에게 '영문' 값을 입력받아 값 저장하기.
		//  이중에 알파벳 별로 모두 count 해보기.
		// abc bbb ccc
		// a : 1개
		// b : 4개
		// c : 4개
		
	}

}
