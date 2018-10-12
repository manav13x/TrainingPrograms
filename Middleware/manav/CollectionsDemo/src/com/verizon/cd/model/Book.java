package com.verizon.cd.model;

import java.time.LocalDate;

public class Book implements Comparable<Book> {

	private int bcode;
	private LocalDate dateOfPublish;
	private String title;
	private double price;
	
	
	public Book() {
		//super();
	}
	public Book(int bcode, LocalDate dateOfPublish, String title, double price) {
		//super();
		this.bcode = bcode;
		this.dateOfPublish = dateOfPublish;
		this.title = title;
		this.price = price;
	}
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public LocalDate getDateOfPublish() {
		return dateOfPublish;
	}
	public void setDateOfPublish(LocalDate dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bcode=" + bcode + ", dateOfPublish=" + dateOfPublish + ", title=" + title + ", price=" + price
				+ "]";
	}
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		Integer bcode1 = this.bcode;
		Integer bcode2 =  o.bcode;
		return bcode1.compareTo(bcode2);
		//return 0;
	}
	
}
