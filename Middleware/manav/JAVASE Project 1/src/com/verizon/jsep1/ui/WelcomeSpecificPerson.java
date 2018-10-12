package com.verizon.jsep1.ui;

import java.util.Scanner;

public class WelcomeSpecificPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name  = sc.nextLine();
		System.out.println("Enter ur age");
		int age = sc.nextInt();
		
		System.out.println("Name is "+name+ " age "+age);
		
		
	}

}
