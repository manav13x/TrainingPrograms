package com.verizon.cd.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.verizon.cd.model.Book;

import java.util.*;

public class InsertBook {

	public static void main(String args[])
	{
		List<Book> list1 = new ArrayList<>();
		List<Book> list2 = new Vector<>();
		List<Book> list3 = new LinkedList<>();
		
		Book b1 = new Book(2101,LocalDate.now(),"Harry potter chamber od secret",3952);
		Book b2 = new Book(1021,LocalDate.now(),"Harry potter chamber od secret2",2952);
		Book b3 = new Book(2104,LocalDate.now(),"Harry potter chamber od secret",3952);
		Book b4 = new Book(1024,LocalDate.now(),"Harry potter chamber od secret2",2952);
		
		list1.add(b1);
		list1.add(b2);
		list1.add(b3);
		list1.add(b4);
		
		
		list2.add(b1);
		list2.add(b2);
		list2.add(b3);
		list2.add(b4);
		
		
		list3.add(b1);
		list3.add(b2);
		list3.add(b3);
		list3.add(b4);
		
		for(Book b : list1)
		{
			System.out.println(b);
		}
		System.out.println();
		for(Book b : list2)
		{
			System.out.println(b);
		}
		System.out.println();
		for(Book b : list3)
		{
			System.out.println(b);
		}
	
	}
	
	
}
