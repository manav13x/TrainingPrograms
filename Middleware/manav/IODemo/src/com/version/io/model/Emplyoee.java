package com.version.io.model;

import java.io.Serializable;

public class Emplyoee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7809930888121857102L;
	private int empId;
	private String name;
	private double basic;

	public Emplyoee() {	}

	public Emplyoee(int empId, int basic, String name) {
		super();		
		this.empId = empId;	
		this.basic = basic;		
		this.name = name;	
		}
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", basic=" + basic + ", name=" + name + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
