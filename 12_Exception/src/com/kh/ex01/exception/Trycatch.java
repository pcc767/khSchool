package com.kh.ex01.exception;

import java.io.IOException;

public class Trycatch {
	
	public static void main(String[] args) {
		
		try {//���� �߻� ���ɼ��� �ִ� ������ ���� ��
			System.out.println("���� ���� ����");
			if(false) {
				throw new IOException();				
			}	
			System.out.println("������ ���");
			return; // ������ ������ ���̳��� ����ǰ� ���ϵ�.
			
		} catch (Exception e) {
			System.out.println("���ܸ� �޴� ����");
			e.printStackTrace();	//���ܰ� �߻��ϴ� ��� ���ܸ� �˷��ְ�, error Line�� �˷���
		} finally {
			System.out.println("���ܰ� �߻��ϵ� ���ϵ� ����Ǵ� ����!!");
		}
		
	}

}
