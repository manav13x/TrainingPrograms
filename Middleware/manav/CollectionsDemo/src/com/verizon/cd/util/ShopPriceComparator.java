package com.verizon.cd.util;
import java.time.LocalDate;
import java.util.Comparator;

import com.verizon.cd.model.Book;
import com.verizon.cd.model.Shop;
public class ShopPriceComparator implements Comparator<Shop> {

	@Override
	public int compare(Shop arg0, Shop arg1) {
		// TODO Auto-generated method stub
		LocalDate d1 =  arg0.getExpiryDate();
		LocalDate d2 =  arg1.getExpiryDate();
		return d1.compareTo(d2);
	}

	
}
