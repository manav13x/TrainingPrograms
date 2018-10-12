package com.verizon.oopd.ui;

import com.verizon.oopd.model.ComplexNumber;

public class ComplexNumberDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ComplexNumber z1 = new ComplexNumber();
		ComplexNumber z2 = new ComplexNumber(12,-3);
		ComplexNumber z3 = new ComplexNumber(z2);

		System.out.println(z1.getReal()+" \t" +z1.getImaginery());
		System.out.println(z2.getReal()+" \t" +z2.getImaginery());
		System.out.println(z3.getReal()+" \t" +z3.getImaginery());
		System.out.println(z1);
		System.out.println(z2);
		System.out.println(z3);
	}

}
