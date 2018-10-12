package com.verizon.cd.ui;

import java.time.LocalDate;
import java.util.*;
import java.util.Set;

import com.verizon.cd.model.Book;
import com.verizon.cd.util.BookPriceComparator;

public class SetImplementationDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Book> set1 = new HashSet<>();
		Set<Book> set2 = new LinkedHashSet<>();
		Set<Book> set3 = new TreeSet<>();
		Book b1 = new Book(101,LocalDate.now(),"Harry potter chamber od secret",8952);
		Book b2 = new Book(1021,LocalDate.now(),"Harry potter chamber od secret2",2952);
		Book b3 = new Book(1024,LocalDate.now(),"Harry potter chamber od secret3",9952);
		
		Set<Book> set4 = new TreeSet<>(new BookPriceComparator(false));
		set4.add(b1);
		set4.add(b2);
		set4.add(b3);
		
		for(Book b:set4)
		{
			System.out.println(b);
		}
		
		System.out.println("new");
		Set<Book> set5 = new TreeSet<>(new BookPriceComparator(true));
		set5.add(b1);
		set5.add(b2);
		set5.add(b3);
		for(Book b:set5)
		{
			System.out.println(b);
		}
	}

}
