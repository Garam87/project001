package edu.kh.semi.model.vo;

import java.util.Objects;

public class Manager {

	// 필드
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private String address;
	
	// 생성자
	
	public Manager() {}

	public Manager(String id, String pw, String name, int age, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	
	
	// 메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, id, name, pw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(pw, other.pw);
	}

	@Override
	public String toString() {
		return "\n회원 [Id = " + id + ", " + "이름 = " + name + ", 나이 = " + age + ", 주소 = " + address + "]\n";
	}
	
	
	
	
	
	
	
	
}
