package com.verizon.jsep1.ui;

public class WelcomeCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length==0)
			System.out.println("NO arguments");
		
		else
		{
			for(int i=0 ; i< args.length;i++)
			{
				System.out.println("HEllo "+args[i]);
			}
		}
		System.out.println("Run using for each");
		for(String h : args)
		{
			System.out.println("hello "+h);
		}
		
	}

}
