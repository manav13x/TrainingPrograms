package com.verizon.cd.ui;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import com.verizon.cd.model.Shop;
public class InsertShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Shop> list1 = new ArrayList<>();
		List<Shop> list2 = new Vector<>();
		List<Shop> list3 = new LinkedList<>();

		Shop s1 = new Shop(123,"Jeans",400,200,LocalDate.now());
		Shop s2 = new Shop(124,"Jeans1",700,300,LocalDate.now());
		Shop s3 = new Shop(125,"Jeans2",900,400,LocalDate.now());
		
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);

		list2.add(s1);
		list2.add(s2);
		list2.add(s3);

		list3.add(s1);
		list3.add(s2);
		list3.add(s3);

	}

}
