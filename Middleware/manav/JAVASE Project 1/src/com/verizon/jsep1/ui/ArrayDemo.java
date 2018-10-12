package com.verizon.jsep1.ui;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		int count,sum=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		System.out.println("ENter the size of array");
		count = sc.nextInt();
		System.out.println("Enter the elements in array");
		int arr[] = new int[count];
		for(int i=0 ;i<count;i++)
		{
			arr[i] = sc.nextInt();	
			
		}
		
		for(int n : arr)
		{
			sum+=n;
			if(min>n) min= n;
			if(max<n) max= n;
		}
		
		System.out.println("Min "+ min);
		System.out.println("Max "+ max);
		System.out.println("Sum "+ sum);
		for(String s : args)
		{
			
		}
	}

}
