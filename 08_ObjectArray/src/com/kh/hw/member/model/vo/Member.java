package com.kh.hw.member.model.vo;

public class Member {
	// Model(DB/����)�� å�� ����(Responsibility Scope)
	// - ��û�� �����͸� DB���� ó��(CRUD)�Ͽ� ����� Controller���� �ùٸ��� �����ϴ� ����
	// - Model�� �ؾ��ϴ� �� : DB �������, Data�� �ùٸ��� ����, �˻�, ���� ���� ���� �������� �Ǵ�.
	// - Model�� �ϸ� �ȵǴ� �� : ȭ���� ��Ʈ�� �Ѵٴ���, �帧�� ���� �Ѵٴ����ϸ� �ȵȴ�.

	private String id; // Primary Key (PK) = ��Ű, �������� �÷� �߿��� ��ġ�� �ʰ� ������ ��.
	private String name;
	private String password;
	private String email;
	private char gender;
	private int age;

	public Member() {}

	public Member(String id, String name, String password, String email, char gender, int age) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.age = age;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String inform() {
		return id + " " + name + " " + password + " " + email + " " + gender + " " + age;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", age=" + age + "]";
	}
}
