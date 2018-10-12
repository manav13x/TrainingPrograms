package com.verizon.gua.model;

import java.time.LocalDate;

public class User {

	private String UsrName;
	private LocalDate dateOfBirth;
	private  int age;
	private String title;
	private Gender gender;
	
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getUsrName() {
		return UsrName;
	}
	public void setUsrName(String usrName) {
		UsrName = usrName;
	}
	public LocalDate getDatOfBirth() {
		return dateOfBirth;
	}
	public void setDatOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
