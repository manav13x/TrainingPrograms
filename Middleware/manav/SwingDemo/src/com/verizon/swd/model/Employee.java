package com.verizon.swd.model;

import java.util.Set;

public class Employee {

	private int empId;
	private String name;
	private String gender;
	private String maternalStatus;
	private String platform;
	private Set<String> skills;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaternalStatus() {
		return maternalStatus;
	}
	public void setMaternalStatus(String maternalStatus) {
		this.maternalStatus = maternalStatus;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Set<String> getSkills() {
		return skills;
	}
	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}
	
	
}
