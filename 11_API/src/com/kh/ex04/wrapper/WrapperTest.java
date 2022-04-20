package com.kh.ex04.wrapper;

import java.util.ArrayList;

public class WrapperTest {
	// Wrapper Class�� ����
	// : �⺻���� Wrapping�ؼ� ���������� ��ȯ �����ִ� ���.
		//  - Integer, Double .. 
		// 1. �⺻���� ������ �ټ� �ִ� API�� ������.
		// 2. ArrayList�� ���� ��ü����� �ڷᱸ���� �⺻���� ������ ����.
	
	public static void main(String[] args) {
		int age =26;
//		Integer ageObj = new Integer(age);	// �ڹ� 6����, ������ ����_1
//		Integer ageObj = (Integer)age;		// �ڹ� 6����, ������ ����_2
		Integer ageObj = age;				// ���� ����, ����ڽ� = �⺻���� ���������� �ڵ� ����ȯ
		System.out.println(age);
		System.out.println(ageObj.toString());
		
		
//		ArrayList ����� �⺻��(int short ...) ���� �Ұ���.
//		ArrayList<int> list = new ArrayList<E>()	; 	//����Ұ�
		ArrayList<Integer> list = new ArrayList<>();	//���𰡴�
		list.add((Integer)2);	// old ����
		list.add((Integer)3);	// old ����
		list.add(4);			// �ֽ� ����
		list.add(5);			// �ֽ� ����
		System.out.println(list);
		
		
		// API���� Ȱ��
		// 1. �ִ� �ּҰ�
		System.out.println(Integer.MAX_VALUE);	//�ִ밪
		System.out.println(Integer.MIN_VALUE);	//�ּҰ�
		
		// 2. ���ڰ��� ��� �� !!!�� �˾Ƶ� ��
//		���ڿ��� �� ����� ���� ! ex) "abc".compareTo("abd");
		System.out.println(Integer.compare(30, 10));	//���� ũ�� +1
		System.out.println(Integer.compare(10, 30));	//�ڰ� ũ�� -1
		System.out.println(Integer.compare(10, 10));	//������ 0
		
		// 3. min, max
		System.out.println(Integer.max(5,2));	// 5
		System.out.println(Integer.min(5,2));	// 2
		
		// 4. ���ڿ��� ���ڷ� �ٲٴ� parse
		System.out.println(Integer.parseInt("314")+1);
		System.out.println(Double.parseDouble("3.14")+1.1);
		
		//�߰��� : Math �˾ƵѰ�.
		

	}
	
	

	

}
