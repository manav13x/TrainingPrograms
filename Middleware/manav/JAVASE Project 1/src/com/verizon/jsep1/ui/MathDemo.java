package com.verizon.jsep1.ui;

import java.util.Scanner;
public class MathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a decimerl no");
		
		double num = sc.nextDouble();
		
		System.out.println("Rounded Value "+Math.round(num));
		System.out.println("Ceil Value "+Math.ceil(num));
		System.out.println("Floor Value "+Math.floor(num));
		System.out.println("Expo Value "+Math.exp(num));
		System.out.println("powered twice Value "+Math.pow(num,2));
		System.out.println("squared Value "+Math.sqrt(num));
	}

}
