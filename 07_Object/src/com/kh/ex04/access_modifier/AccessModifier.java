package com.kh.ex04.access_modifier;

// ���� ������
public class AccessModifier {
	public int 		publicValue;		//��𼭵� ��� ����
	protected int 	protectedValue;		//��ӽ� �θ��ڽİ� ��밡��
	int				defaultValue;		//���������� ������ default
	private	int		privateValue;		//�ڱ� �ڽŸ� ����� �� �ִ� ����������
	
	public void myMethod() {
		publicValue = 1;
		protectedValue = 2;
		defaultValue = 3;
		privateValue = 4;
	}
	
	
	
}
