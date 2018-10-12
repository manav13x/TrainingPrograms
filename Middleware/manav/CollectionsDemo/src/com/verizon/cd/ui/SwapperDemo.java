package com.verizon.cd.ui;

import java.time.LocalDate;

import com.verizon.cd.model.Book;
import com.verizon.cd.service.Swapper;

public class SwapperDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			char c1='$',c2='#';
			Swapper<Character> cswap = new Swapper<>();
			cswap.doSwap(c1,c2);
			
			int x=34,y=45;
			
			Swapper<Integer> iswap = new Swapper<>();
			iswap.doSwap(x,y);
			
			String s1="hellow",s2="worls";
			
			Swapper<String> sswap = new Swapper<>();
			sswap.doSwap(s1,s2);
			
			Book b1 = new Book(101,LocalDate.now(),"Harry potter chamber od secret",952);
			Book b2 = new Book(1021,LocalDate.now(),"Harry potter chamber od secret2",2952);
			
			Swapper<Book> bswap = new Swapper<>();
			bswap.doSwap(b1,b2);
			
	}

}
