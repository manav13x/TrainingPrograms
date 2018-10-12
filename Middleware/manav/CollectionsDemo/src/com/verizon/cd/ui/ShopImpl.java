package com.verizon.cd.ui;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.verizon.cd.model.Book;
import com.verizon.cd.model.Shop;
import com.verizon.cd.util.BookPriceComparator;
import com.verizon.cd.util.ShopPriceComparator;

public class ShopImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shop s1 = new Shop(125,"Jeans",900,200,LocalDate.now());
		Shop s2 = new Shop(124,"Jeans1",500,300,LocalDate.MAX);
		Shop s3 = new Shop(123,"Jeans2",500,400,LocalDate.MIN);
		
		Set<Shop> set1 = new HashSet<>();
		Set<Shop> set2 = new LinkedHashSet<>();
		Set<Shop> set3 = new TreeSet<>();
		
		set1.add(s1);
		set1.add(s2);
		set1.add(s3);
		
		set2.add(s1);
		set2.add(s2);
		set2.add(s3);
		
		set3.add(s1);
		set3.add(s2);
		set3.add(s3);
		
		for(Shop b:set3)
		{
			System.out.println(b);
		}
		
		System.out.println("--------------");
		
		Set<Shop> set5 = new TreeSet<>(new ShopPriceComparator());

		set5.add(s1);
		set5.add(s2);
		set5.add(s3);
		
		for(Shop b : set5)
		{
			System.out.println(b);
		}
		
	}

}
