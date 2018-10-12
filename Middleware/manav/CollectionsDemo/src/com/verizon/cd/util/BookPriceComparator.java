package com.verizon.cd.util;

import java.util.Comparator;

import com.verizon.cd.model.Book;

public class BookPriceComparator implements Comparator<Book> {
	
	private boolean isDescending = false;
	public BookPriceComparator(boolean isDescending){
		this.isDescending=isDescending;
	}
	
	
	@Override
	public int compare(Book arg0, Book arg1) {
		// TODO Auto-generated method stub
		//Double p1 = arg0.getPrice();
		//Double p2 = arg1.getPrice();
	Long p1 = (long)arg0.getBcode();
	Long p2 = (long)arg1.getBcode();
		return p1.compareTo(p2);
	}

}
