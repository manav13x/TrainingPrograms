package com.verizon.ljs.ui;

import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;  

public class RandomGenerate {

	public static void main(String args[])
	{
		LocalDateTime t1= LocalDateTime.now();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the len");
		int len  = sc .nextInt();
		int nums[] = new int[len];
		for(int i=0;i<len;i++)
		{
			nums[i] = (int)(Math.random()*100);
		}
		
		System.out.println("The no are");
		
		for(int num : nums)
		{
			System.out.println(num);
		}
		
		int max=-1,min=101,s=0;
		for(int i : nums)
		{
			if(i>max)
				max=i;
			if(i<min)
				min=i;
			s+=i;
		}
		
		System.out.println(s+" "+min+" "+max);
		LocalDateTime t2= LocalDateTime.now(); 
		Duration d = Duration.between(t1, t2);
		System.out.println(d);
	}
}
