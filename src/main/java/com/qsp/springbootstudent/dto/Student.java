package com.qsp.springbootstudent.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name Cant be Blank")
	@NotNull(message = "Name Cant be Null")
	private String name;
	@Min(value = 1)
	private int age;
	private String address;
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@Column(unique = true)
	@NotBlank(message = "Email Can't Be Blank")
	@NotNull(message = "Email Can't Be  Null")
	@Email(regexp = ".+@.+\\..+", message = "Invalid email format")
	private String email;
	@Max(value = 600)
	private int securedmarks;
	private int totalmarks;
	private double percentage;
	private String grade;
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
	public String getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSecuredmarks() {
		return securedmarks;
	}
	public void setSecuredmarks(int securedmarks) {
		this.securedmarks = securedmarks;
	}
	public int getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", securedmarks=" + securedmarks + ", totalmarks=" + totalmarks + ", percentage="
				+ percentage + ", grade=" + grade + "]";
	}
	
	
	

}
