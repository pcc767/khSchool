package com.kh.ex02.collections_list;


// Comparable : ������ �����ϵ��� ����� Interface
public class UserVO implements Comparable<UserVO>{
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
	
	
//	@Override  //��������
//	public int compareTo(UserVO o) {
//		// ID �������� �������� ����
//		return o.getId().compareTo(id);	//compareTo : ������ -1, ���� 0, ũ�� +1
//	}

}
