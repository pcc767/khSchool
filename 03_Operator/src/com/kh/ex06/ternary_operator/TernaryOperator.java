package com.kh.ex06.ternary_operator;

public class TernaryOperator {
	
	// ���� ������ + if��
	public static void main(String[] args) {
		int a = 100;
		int b = 50;
		int c = 30;
		
		//���׿�����
		//���� : (����) ? (���϶� ����Ǵ� ����) : (�����϶� ����Ǵ� ����);
		String result = a>b ? "a�� b���� Ů�ϴ�." : "a�� b���� �۽��ϴ�.";
		System.out.println(result);
		
		// ��ø��� -> ��õ���� �ʴ´�.!! -> �������� ��ø ������� �ʴ´�.
		result = a>b ? (b>c ? "a�� b���� ũ�� b�� c���� ŭ" : "a�� b���� ũ�� b�� c���� ����") 
						: (b>c ? "a�� b���� �۰� b�� c���� ŭ" : "a�� b���� �۰� b�� c���� ����" );
		System.out.println(result);		
		
		// if�� - �����δ� 3�� �����ں��� ���� ����.
		// if(���ǽ�) {���ǽ��� ���϶� ����Ǵ� ����}
		// else {���ǽ��� �����϶� ����Ǵ� ����}
		if(a>b)
			result = "a�� b���� Ů�ϴ�.";
		else
			result = "a�� b���� �۽��ϴ�.";
		
		System.out.println(result);
		
//		if(a>b) {
//			if(b>c) {
//				result = "a�� b���� ũ�� b�� c���� ŭ";
//			}else {
//				result = "a�� b���� ũ�� b�� c���� ����";
//			}
//		}else {
//			if(b>c) {
//				result = "a�� b���� �۰� b�� c���� ŭ";
//			}else {
//				result = "a�� b���� �۰� b�� c���� ����";
//			}
//		}
		
		
		if(a>b) {
			if(b>c)
				result = " a�� b���� ũ�� b�� c���� ŭ";
			else
				 result = "a�� b���� ũ�� b�� c���� ����";
		} else {
			if(b>c)
				result = " a�� b���� �۰� b�� c���� ŭ";
			else
				 result = "a�� b���� �۰� b�� c���� ����";
				 }
		System.out.println(result);
		
		
		
		
		
	}

}
