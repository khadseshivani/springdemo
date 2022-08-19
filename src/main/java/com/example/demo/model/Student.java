package com.example.demo.model;

import org.springframework.data.annotation.Id;

public class Student 
{
	@Id
	private int id;
	
	private String name;
	private int age;
	private long phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	public Student(int id,String name, int age, long phone) {
		super();
		this.id=id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
