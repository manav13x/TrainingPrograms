package com.verizon.oopd.model;

public class ComplexNumber {

	private int real;
	private int imaginery;
	
	public ComplexNumber()
	{
		
	}

	@Override
	public String toString() {
		
		StringBuilder sb =new StringBuilder();
		sb.append(real);
		sb.append(imaginery<0?"-i":"+i");
		sb.append(imaginery>=0?imaginery:-imaginery);
		return sb.toString();
	}

	public ComplexNumber(int real, int imaginery) {
		super();
		this.real = real;
		this.imaginery = imaginery;
	}
	public ComplexNumber(ComplexNumber z)
	{
		this.real=z.real;
		this.imaginery=z.imaginery;
	}

	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginery() {
		return imaginery;
	}

	public void setImaginery(int imaginery) {
		this.imaginery = imaginery;
	}

}
