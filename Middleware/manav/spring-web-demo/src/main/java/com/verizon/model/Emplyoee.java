package com.verizon.model;

public class Emplyoee {
	 private int empId;
	 private String name;
	 private double basic;
	 private String dept;
	 private String gender;
	 private double experience;
	 private double hra;
	 private double ta;
	 private double netPay;

public  Emplyoee(){}

public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

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

public double getBasic() {
	return basic;
}

public void setBasic(double basic) {
	this.basic = basic;
}

public double getExperience() {
	return experience;
}

public void setExperience(double experience) {
	this.experience = experience;
}

public double getHra() {
	return hra;
}

public void setHra(double hra) {
	this.hra = hra;
}

public double getTa() {
	return ta;
}

public void setTa(double ta) {
	this.ta = ta;
}

public double getNetPay() {
	return netPay;
}

public void setNetPay(double netPay) {
	this.netPay = netPay;
}
	
}
