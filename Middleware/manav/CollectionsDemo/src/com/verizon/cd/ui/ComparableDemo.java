package com.verizon.cd.ui;

import java.time.LocalDate;

import com.verizon.cd.model.Book;

public class ComparableDemo {

	public static void main(String args[])
	{
		Integer iobj1 = 45;
		Integer iobj2 = 44;
		
		System.out.println(iobj1.compareTo(iobj2));
		System.out.println(iobj2.compareTo(iobj2));
		System.out.println(iobj2.compareTo(iobj1));
		
		String s1 = "Akshra";
		String s2 = "Nirakshara";
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s1));
		System.out.println(s2.compareTo(s1));
		
		Book b1 = new Book(2101,LocalDate.now(),"Harry potter chamber od secret",3952);
		Book b2 = new Book(1021,LocalDate.now(),"Harry potter chamber od secret2",2952);
		
		System.out.println(b1.compareTo(b2));
		System.out.println(b1.compareTo(b1));
		System.out.println(b2.compareTo(b1));
		
		
	}
}
