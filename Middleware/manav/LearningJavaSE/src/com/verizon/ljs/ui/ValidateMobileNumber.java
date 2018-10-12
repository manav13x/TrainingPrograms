package com.verizon.ljs.ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateMobileNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("mobile no");
		String mo = sc.next();
		String mobreg = "[1-9]\\d{9}";
		
		Pattern mobPattern = Pattern.compile(mobreg);
		Matcher mobMatcher = mobPattern.matcher(mo);
		if(mobMatcher.matches())
			System.out.println("valid");
		else
			System.out.println("invalid");
		
	}

}
