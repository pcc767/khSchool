package com.kh.ex02.user_exception;

public class UseException {
	
	public static void main(String[] args) {
		String userID = "test";
		String userPW = "1234";
		
		String inputID = "test123";
		String inputPW = "1234";
		
		try {
			if(userID.equals(inputID) == false) {
				throw new LoginException("���̵� ���� �ʽ��ϴ�.");
				// throw�� ������ return�� ���� ȿ�� �߻�
			}
			if(userPW.equals(inputPW) == false) {
				throw new LoginException("��й�ȣ�� ���� �ʽ��ϴ�.");
			}
			System.out.println("�α��� ����");
			
		} catch (LoginException e) {
			System.out.println("�α��� ����ó����");
			e.printStackTrace();
		} finally {
			// �ֿ� �ڿ��� �����ϴ� ��.
			inputID = null;
			inputPW = null;
			System.out.println("�ڿ��� �����Ǿ����ϴ�.");
		}
		
		
	}

}
