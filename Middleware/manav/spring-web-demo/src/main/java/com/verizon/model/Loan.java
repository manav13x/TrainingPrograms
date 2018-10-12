package com.verizon.model;

public class Loan {
	private double principal;
	private double timePeriod;
	private double rateOfIntrest;
	private double simpleIntrest;
	private double repayableAmount;
	public Loan(){
		
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
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
	public double getRepayableAmount() {
		return repayableAmount;
	}
	public void setRepayableAmount(double repayableAmount) {
		this.repayableAmount = repayableAmount;
	}

}
