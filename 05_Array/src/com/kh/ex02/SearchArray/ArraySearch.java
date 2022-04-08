package com.kh.ex02.SearchArray;

import java.util.Random;

public class ArraySearch {
	// ���� ����
	// �迭�� Ư���� ����(����)���� �ʱ�ȭ�� �ϰ�, �� �迭���� Ư������ ã�ƴ� ���
	
	public static int[] array; // static(�۷ι�)������ Array ����!
	public static final int MAX_SIZE = 100000; // ��� ����!
	public static Random random = new Random(System.currentTimeMillis());
	// �Ϻ��� ������ �̾� ���� ���
	// ��ǻ�Ϳ��� ������? �ǻ糭�� = Ư���� ���Ŀ� ���� ������ �߻��Ǵµ�.
	// �ǻ糭�� ������ : ���߰� �����ϴ�.
	// �ǻ糭���� �Ϻ��� ������ �ٲٱ����� Seed��(Ư����) �ʿ��ϴ�. -> Seed�� ���� �ð����� ���
	// System.currentTimeMillis() : ����ð��� long ������ �����ϰ� �ִ� �ý��� ����
	//                              since 1970-01-01 00:00:00.000
	
	// ����� array �迭�� ������ �ʱ�ȭ�ϴ� �Լ�
	public static void init() { // initialize : �ʱ�ȭ ��
		array = new int[MAX_SIZE]; // �迭�� MAX_SIZE��ŭ ����
		for(int i = 0; i < array.length; i++) { // MAX_SIZE�� �ᵵ �ǳ� ����!
			array[i] = randomValue();
		}
	}

	// Ư���� ���� ���� �������� �Լ�
	// return (����) : �Լ����� ����ϴ� ���ú����� �����ϴ� ����
	public static int randomValue() {
		int randomValue = random.nextInt(MAX_SIZE); // ���ٷ� �ص� OK
		return randomValue;
	}
	
	// index�� ���� ���� Ž���ϴ� �˰���
	public static int search(int searchValue) {
		for(int i =0; i < array.length; i++) {
			if(array[i] == searchValue) {
				return i; // ���� ã�� ��� index�� ��ȯ�Ѵ�.
			}
		}
		return -1; // ���� ���°�� -1�� ����
	}
	
	//String[] args : java ���� ��ɹ����κ��� Ư���� ���ڿ� option���� ������ ����ϴ� �Ķ����
	public static void main(String[] args) {
		init();
		int pickValue = array[randomValue()]; // �迭���� Ư������ �������� �̾ƿ�!
		long startTime = 0; // Ž���� ������ �ð�
		long endTime = 0; // Ž���� ���� �ð�
		int index = 0; // ã�� index
	
		System.out.println("pickValue : " + pickValue); // ���õ� ��
		
		// 1. ���� �ڵ忡�� �ۼ��� search �Լ��� ���� Ž���ϰ� �ð��� ����ϴ� �ڵ�
		startTime = System.currentTimeMillis(); // ���۽ð� ����!

		for(int i =0; i< 100000; i++) { // Ž�� �ð��� �ʹ� �������� ������ ���� 100000�� ������!
			index = search(pickValue); // �������� index�� ã�� ���
		}
		
		endTime = System.currentTimeMillis(); // ������ �ð� ����!
		
		System.out.println("ã�� index : " + index);
		System.out.println("ã�� �� : " + array[index]);
		System.out.println("ù��° �ɸ� �ð� : " + (endTime - startTime) +"ms");
		
	}
}










