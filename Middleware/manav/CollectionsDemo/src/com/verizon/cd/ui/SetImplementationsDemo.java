package com.verizon.cd.ui;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetImplementationsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> s1= new HashSet<>();
		Set<String> s2= new LinkedHashSet<>();
		Set<String> s3= new TreeSet<>();
		
		s1.add("A");
		s1.add("Z");
		s1.add("Z");
		s1.add("C");
		
		s2.add("A");
		s2.add("S");
		s2.add("C");
		
		s3.add("D");
		s3.add("C");
		s3.add("B");
		
		for(String s : s1)
		{
			System.out.println(s);
		}
		for(String s : s2)
		{
			System.out.println(s);
		}
		for(String s : s3)
		{
			System.out.println(s);
		}
	}

}
