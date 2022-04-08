package com.kh.ex02.loop;

public class LoopStatement1 {

	public static void myFirstWhileLoop() {
		while (true) {
			System.out.println("���� �ݺ�!!!");
		}
	}

	public static void testWhileLoop() {
		int i = 0; // ������
		while (i < 10) { // ������ ���̰�, 0~9���� ����, 10�� �������� �ʴ´�.
			System.out.println(i++);
		}
		System.out.println("while ���� ��!");

		// while�� Ȱ��Ǵ� ���̽�
		// 1. ���� �ݺ���
		// 2. ���� �������� �ʰ� Ž���� �ʿ��ҋ�!(�Ʒ��� ���� ���̽�)
		while (true) {
			i++;
			if (i % 133 == 0) { // 133�� ����϶�
				break;
			}
		}

	}

	public static void testDoWhileLoop() {
		// �� �Ⱦ���.
		int i = 0;
		do {
			System.out.println(i++);
		} while (i < 10);
		System.out.println("do-while ���� ��");

		i = 100;
		do {
			System.out.println("�� ���� � ���̵� ���� 1ȸ�� ����Ǵ� ��!!!!");
		} while (i < 10);

	}

	public static void testForLoop() {
		// �ڡڡڡڡ� �Ʒ��� ������ �ܿﶧ���� ��� �ĺ��°��� ��õ
		// ���� ���� ���Ǵ� �ݺ���
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		System.out.println("���� ��");
		
		//1~10���� ����
		//���� 1 -> �����ϴ� ���
		for(int i = 1; i<=10; i++) {
			System.out.println(i);
		}
		System.out.println("���� ��");
		
		//���� 2  -> �ڡ� ��õ �ڡ�
		for(int i = 0;i<10; i++) {
			System.out.println(i+1);
		}
		System.out.println("���� ��");
		

	}

	public static void main(String[] args) {
//		myFirstWhileLoop();
//		testWhileLoop();
//		testDoWhileLoop();
		testForLoop();
	}

}
