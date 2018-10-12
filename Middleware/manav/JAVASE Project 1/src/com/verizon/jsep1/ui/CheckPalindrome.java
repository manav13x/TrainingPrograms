package com.verizon.jsep1.ui;
import java.util.Scanner;
public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =  new Scanner(System.in);
		
		System.out.println("Enter some string");
		String str = sc.next();
		
		String rev =  "";
		
		char chars[] = str.toCharArray();
		/*
		for(int i=chars.length-1;i>=0;i--)
		{
			rev+=chars[i];
		}
		*/
		
		StringBuilder sb =new StringBuilder();
		for(int i=chars.length-1;i>=0;i--)
		{
			sb.append(chars[i]);
		}
		rev = new String(sb);
		System.out.println("Reverse "+rev);
		
		if(rev.equalsIgnoreCase(str))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
		
	}

}
