package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
//		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오 : ");
		System.out.println(Integer.parseInt(sc.nextLine())>0 ? "양수다." : "양수가 아니다.");
		
//		int val = sc.nextInt();
//		String str = val>0 ? "양수다" : "양수가 아니다.";
//		System.out.println(str);
	}
	
	public void practice2() {
//		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오 : ");		
		int val = sc.nextInt();
		
		String str = val>0 ? "양수다" : (val == 0 ? "0이다" : "음수다");
		System.out.println(str);
	}
	
	public void practice3() {
//		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오 : ");
		int val = sc.nextInt();
		
		String str = val%2 == 0 ? "짝수다" : "홀수다";
		System.out.println(str);	
		
	}
	
	public void practice4() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("인원 수 : ");
//		int people = sc.nextInt();
//		System.out.println("사탕 개수 : ");
//		int candy = sc.nextInt();
//		
//		int peo = candy / people;
//		int can = candy % people;
//		
//		System.out.println("1인당 사탕 개수 : "+peo);	
//		System.out.println("남는 사탕 개수 : "+can);	
		
		//c언어 old style
		//선언부 시작
		int iUserNum = 0;
		int iCandyNum = 0;
		//선언부 끝
		
		//입력부 시작
		System.out.println("사람의 수는? : ");
		iUserNum = Integer.parseInt(sc.nextLine());
		
		System.out.println("사탕의 수는? : ");
		iCandyNum = Integer.parseInt(sc.nextLine());
		//입력부 끝
		
		// 출력부
		System.out.println("1인당 사탕 개수 : "+ (iCandyNum / iUserNum));
		System.out.println("남는 사탕 개수 : " + (iCandyNum % iUserNum));	
		
	}
	
	public void practice5() {

//        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("학년(숫자만) : ");
        int grade = sc.nextInt();
        sc.nextLine();

        System.out.print("반(숫자만) : ");
        String _class = sc.nextLine();

        System.out.print("번호(숫자만) : ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("성별(M/F) : ");
        String gen = sc.nextLine();

        System.out.print("성적(소수점 아래 둘째자리까지) : ");
        double grade_ = sc.nextDouble();

        String girl = "여학생";
        String boy = "남학생";

        String str = gen.equals("F") ? grade + "학년 " + _class + "반 " + num + "번 " + name + " " + girl + "의 성적은 " + grade_ + "이다" :
                grade + "학년 " + _class + "반 " + num + "번 " + name + " " + boy + "의 성적은 " + grade_ + "이다";

        System.out.println(str);
    }


    public void practice6() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력하시요 : ");
        int age = sc.nextInt();

        String result = age<=13 ? "어린이" : (age>13 && age<=19 ? "청소년" : "성인");
        System.out.println(result);
    }

    public void practice7() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("국어 : ");
        int kor = sc.nextInt();
        System.out.print("영어 : ");
        int eng = sc.nextInt();
        System.out.print("수학 : ");
        int math = sc.nextInt();

        int total = kor+eng+math;
        double avg = total/3.0;

        System.out.println("합계 : "+total);
        System.out.printf("평균 : %.2f\n", avg);
//        System.out.println("평균 : "+avg);

        String result = kor>=40 && eng>=40 && math>=40 ? (total>=60 ? "합격" : "불합격") : "불합격";
        System.out.println(result);

    }

    public void practice8() {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("주민번호를 입력하시요(- 포함) : ");
//        String id = sc.nextLine();
//
//        String result = id.charAt(7)=='2' ? "여자" : "남자";
//        System.out.println(result);
        
    	System.out.print("주민번호를 입력하시요(- 포함) : ");
    	String privateNum = sc.nextLine();
    	char gendrchar = privateNum.charAt(7);
    	
    	if(gendrchar == '1' || gendrchar == '3') 
    		System.out.println("남자");
    	 else 
    		System.out.println("여자");        
      
    }

    public void practice9() {
//        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 정수는 두번째 정수보다 작아야한다.");
        System.out.print("첫 번째 정수를 입력하세요 : ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 정수를 입력하세요 : ");
        int num2 = sc.nextInt();
        System.out.print("비교할 정수 입력 : ");
        int num3 = sc.nextInt();

        String result = num1<=num3 ? (num2<num3 ? "true" : "false") : "false";
        System.out.println(result);

    }

    public void practice10() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("입력 1 : ");
        int num1 = sc.nextInt();
        System.out.print("입력 2 : ");
        int num2 = sc.nextInt();
        System.out.print("입력 3 : ");
        int num3 = sc.nextInt();

        String result = num1 == num2 ? (num2 == num3 ? "true" : "false") : "false";
        System.out.println(result);

    }

    public void practice11() {
//        Scanner sc = new Scanner(System.in);
        System.out.print("A사원의 연봉 : ");
//        int payA = sc.nextInt();
        int patA = Integer.parseInt(sc.nextLine());  // -> 이 방법으로 통일!!!!!!!        
        System.out.print("B사원의 연봉 : ");
        int payB = sc.nextInt();
        System.out.print("C사원의 연봉 : ");
        int payC = sc.nextInt();

        double incenA = payA * 1.4;
        double incenB = payB;
        double incenC = payC * 1.15;

        String resultA = incenA >= 3000 ? "A사원 연봉/연봉+a : "+payA+"/"+incenA+"\n 3000 이상" :
                         "A사원 연봉/연봉+a : "+payA+"/"+incenA+"\n3000 미만";
        String resultB = incenB >= 3000 ? "B사원 연봉/연봉+a : "+payB+"/"+incenB+"\n 3000 이상" :
                         "B사원 연봉/연봉+a : "+payB+"/"+incenB+"\n 3000 미만";
        String resultC = incenC >= 3000 ? "C사원 연봉/연봉+a : "+payC+"/"+incenC+"\n 3000 이상" :
                         "C사원 연봉/연봉+a : "+payC+"/"+incenC+"\n 3000 미만";

        System.out.println(resultA);
        System.out.println(resultB);
        System.out.println(resultC);


    }
    
   

	
}
