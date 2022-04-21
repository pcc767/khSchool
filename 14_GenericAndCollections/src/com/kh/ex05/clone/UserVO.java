package com.kh.ex05.clone;

import java.util.Objects;

// Ŭ�� ���鶧�� Cloneable ���� �ʿ�

public class UserVO implements Comparable<UserVO>,Cloneable{
	private String id;
	private String name;
	private int age;
	private double account; // ���� �ܾ�;
	
	public UserVO() {
		super();
	}

	public UserVO(String id, String name, int age, double account) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.account = account;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", age=" + age + ", account=" + account + "]";
	}

	
	// ��ü �񱳽� �˰���(�켱����, ����)�� ���ϴ� �޼ҵ�
	@Override
	public int compareTo(UserVO o) {
		// ID �������� �������� ����
		return this.id.compareTo(o.getId());	//compareTo : ������ -1, ���� 0, ũ�� +1
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Double.doubleToLongBits(account) == Double.doubleToLongBits(other.account) && age == other.age
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
//	@Override  //��������
//	public int compareTo(UserVO o) {
//		// ID �������� �������� ����
//		return o.getId().compareTo(id);	//compareTo : ������ -1, ���� 0, ũ�� +1
//	}
	
	
	
	// ��� 2
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//
//		return super.clone();
//	}
	
	//clone ����� ��
	@Override
	public UserVO clone() {
		
		try {
			return (UserVO) super.clone();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	

}
