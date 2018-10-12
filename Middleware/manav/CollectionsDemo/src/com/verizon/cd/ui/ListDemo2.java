package com.verizon.cd.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.time.Month;
import com.verizon.cd.model.Book;

public class ListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Book> books = Arrays.asList(new Book[] {
				new Book(104,LocalDate.now(),"Harry potter chamber od secret2",2952),
			    new Book(105,LocalDate.now(),"Harry potter chamber od secret",952),
			    new Book(106,LocalDate.now(),"Harry potter chamber od secret2",2952),
				new Book(101,LocalDate.now(),"Harry potter chamber od secret",952),
			    new Book(102,LocalDate.now(),"Harry potter chamber od secret2",2952),
			    new Book(103,LocalDate.now(),"Harry potter chamber od secret",952),
			    
		});
	
		for(Book b : books)
		{
			System.out.println(b);
		}
		
		System.out.println("-------------");
		Collections.sort(books);
		for(Book b : books)
		{
			System.out.println(b);
		}
		System.out.println("-------------");
		Collections.shuffle(books);
		for(Book b : books)
		{
			System.out.println(b);
		}
		
	}

}
