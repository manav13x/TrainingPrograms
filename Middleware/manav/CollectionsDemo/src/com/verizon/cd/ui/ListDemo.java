package com.verizon.cd.ui;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

public class ListDemo {

	public static void main(String args[])
	{
		List<Double> list1 = new ArrayList<>();
		List<Double> list2 = new Vector<>();
		List<Double> list3 = new LinkedList<>();
		
		
		fillAndPrint(list1);
		fillAndPrint(list2);
		fillAndPrint(list3);
		
	}
	
	public static void fillAndPrint(List<Double> list){		
		final int MAX_COUNT = 10000;
		LocalDateTime start  = LocalDateTime.now();

		for(int i=0;i<MAX_COUNT;i++)
		{
			list.add(Math.random());
		}
		
		System.out.println(list);
		 LocalDateTime endTime= LocalDateTime.now();
		Duration execTime =  Duration.between(start,endTime);
		System.out.println(execTime);
	}
}
