package com.kh.ex01.conditional;

public class IfStatement1 {
	// if��
	// if(���ǽ�1) {
	//      (���ǽ� 1�� ���ϴ� ����Ǵ� ����)
	// } else if(���ǽ�2) {
	//      (���ǽ� 2�� ���϶� ����Ǵ� ����)
	// }
	// else {
	// (��� ������ �ش���� ������ ����Ǵ� ����)
	// }
	
	// ���� 1 : if
	// ���� 2 : if - else
	// ���� 3 : if - else if - else
	// ���� 4 : if - else if
	
	public static void main(String[] args) {
		int a = 7;
		
		//�⺻���� if�� ��Ÿ��
		if(a % 2 == 0) {
			System.out.println("¦�� �Դϴ�.");
		} else {
			System.out.println("Ȧ�� �Դϴ�.");
		}
		
		// c��� ��Ÿ��(old ��Ÿ��)  -> ��õ X
		if(a % 2 == 0) 
		{
			System.out.println("¦�� �Դϴ�.");
		} 
		else 
		{
			System.out.println("Ȧ�� �Դϴ�.");
		}
		
		
		// �߰�ȣ ���̵� if���� ��� ���� -> if���̳� else�� �Ʒ� ���ٸ� ����  -> ��õ X
		if(a % 2 == 0)		
			System.out.println("¦�� �Դϴ�.");		
		else 		
			System.out.println("Ȧ�� �Դϴ�.");	
			
		
		
	}
	
}
