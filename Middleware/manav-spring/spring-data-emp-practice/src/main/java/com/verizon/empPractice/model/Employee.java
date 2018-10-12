package com.verizon.empPractice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="empl")
public class Employee {

	private long empid;
	private String fName;
	private String lName;
	private GENDER gender;
	private DEPT dept;
	private LocalDate dob;
	private String mobNo;
	private String emailId;
	private  double basic;
	private double hra;
	
	
	
	
}
