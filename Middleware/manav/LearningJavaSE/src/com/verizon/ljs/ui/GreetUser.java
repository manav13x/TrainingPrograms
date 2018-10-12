package com.verizon.ljs.ui;

import java.util.Scanner;
public class GreetUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine();
		String user2 = sc.next();
		System.out.println("Hello "+user +" "+user2);
	}

}
