package com.verizon.cd.model;
import java.time.LocalDate;
public class Shop implements Comparable<Shop> {

	
	private int itemCode;
	private String title;
	private double sellingPrice;
	private double costPrice;
	private LocalDate expiryDate;
	private double profit;
	
	
	
	
	public Shop() {
		super();
	}


	public Shop(int itemCode, String title, double sellingPrice, double costPrice, LocalDate expiryDate) {
		super();
		this.itemCode = itemCode;
		this.title = title;
		this.sellingPrice = sellingPrice;
		this.costPrice = costPrice;
		this.expiryDate = expiryDate;
	}
	public int getItemCode() {
		return itemCode;
	}


	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getSellingPrice() {
		return sellingPrice;
	}


	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}


	public double getCostPrice() {
		return costPrice;
	}


	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}


	public LocalDate getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}


	@Override
	public String toString() {
		return "Shop [itemCode=" + itemCode + ", title=" + title + ", sellingPrice=" + sellingPrice + ", costPrice="
				+ costPrice + ", expiryDate=" + expiryDate + ", profit=" + profit + "]";
	}


	@Override
	public int compareTo(Shop arg0) {
		// TODO Auto-generated method stub
		this.profit=this.sellingPrice-this.costPrice;
		arg0.profit=arg0.sellingPrice-arg0.costPrice;
		
		Double b1 = this.profit;
		Double b2 = arg0.profit;
		return b1.compareTo(b2);
	}

}
