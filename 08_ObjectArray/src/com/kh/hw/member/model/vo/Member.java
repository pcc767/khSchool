package com.kh.hw.member.model.vo;

public class Member {
	// Model(DB/사전)의 책임 범위(Responsibility Scope)
	// - 요청한 데이터를 DB에서 처리(CRUD)하여 결과를 Controller에게 올바르게 전달하는 역할
	// - Model이 해야하는 일 : DB 연결관리, Data를 올바르게 저장, 검색, 삭제 때에 따라 로지컬한 판단.
	// - Model이 하면 안되는 일 : 화면을 컨트롤 한다던가, 흐름을 제어 한다던가하면 안된다.

	private String id; // Primary Key (PK) = 주키, 데이터의 컬럼 중에서 겹치지 않고 유일한 것.
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
