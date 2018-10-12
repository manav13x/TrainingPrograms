package com.verizon.ljs.ui;

import java.util.Scanner;

public class CountString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 String input =  sc.nextLine();
		 int char_count = 0;
		 int word_count = 0;
		 int space_count = 0;
		 for (int i=0;i<input.length();i++)
		 {
			 if(input.charAt(i) == ' ')
			 {
				 space_count++;
			 }
		 }
		 
		 char_count = input.length();
		 //String words[] = input.split(" ");
		 //use this also to solve
		 word_count = space_count+1;
		 System.out.println(char_count + " "+space_count+" " +word_count);
	}

}
