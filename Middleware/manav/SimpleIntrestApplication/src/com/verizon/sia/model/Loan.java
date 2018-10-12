package com.verizon.sia.model;

public class Loan {
	private float principle;
	private double timePeriod;
	private double rateOfIntrest;
	private double simpleIntrest;
	private double amount;
	public float getPrinciple() {
		return principle;
	}
	public void setPrinciple(float principle) {
		this.principle = principle;
	}
	public double getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(double timePeriod) {
		this.timePeriod = timePeriod;
	}
	public double getRateOfIntrest() {
		return rateOfIntrest;
	}
	public void setRateOfIntrest(double rateOfIntrest) {
		this.rateOfIntrest = rateOfIntrest;
	}
	public double getSimpleIntrest() {
		return simpleIntrest;
	}
	public void setSimpleIntrest(double simpleIntrest) {
		this.simpleIntrest = simpleIntrest;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
