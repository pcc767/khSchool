package com.kh.ex03.branch;

import java.util.Random;
import java.util.Scanner;

public class BranchStatement2 {
	
	public static void main(String[] args) {
		// 숫자 1 ~ 10까지 랜덤으로 숫자 하나를 뽑고,
		// 여러분들이 5번까지 맞춰서 이기고 지는 게임
		
		Scanner sc = new Scanner(System.in);
		
		//int randomInt = new Random().nextInt(10);		// 0~9까지중 랜덤으로 가져올때  -> 문제에서는 틀린 값!!
		int randomInt = new Random().nextInt(10)+1;		// 1~10까지중 랜던함 숫자가 뽑힌다.
//		char randomChar = (char)('A'+new Random().nextInt(10));
		
		int i=5; // 기회 5번
		boolean isWin = false;		// flag
		
		while (i>0) {
			System.out.print("1~10까지 숫자 하나를 선택해 주세요 : ");
			int pickNum = sc.nextInt();
			
			if(pickNum < 1 || pickNum >10) {
				System.out.println("잘못된 숫자가 입력되었습니다. 다시 선택해 주세요. :" +pickNum);
				continue;
			}
			
			if(pickNum == randomInt) {
				isWin = true;
				break;
			} else {
				System.out.println("틀렸습니다."+(i-1)+"번 남았습니다.");
			}			
			
			i--;
		}
		
		if(isWin == true) {
			System.out.println("맞췄습니다. 당신은 승리하였습니다.");
		} else {
			System.out.println("당신은 루저입니다.!!");
		}
		System.out.println("선택된 숫자는 : "+randomInt);
		

	}

}
