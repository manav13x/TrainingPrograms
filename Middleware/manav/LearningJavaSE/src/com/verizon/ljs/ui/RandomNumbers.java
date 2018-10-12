package com.verizon.ljs.ui;

import java.util.Random;

public class RandomNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("With default random constructor");
		
		Random r1 = new Random();
		
		for(int i=0;i<=5;i++){
			System.out.println(r1.nextInt(100));
		}
		
	System.out.println("With SEEDED random constructor");
		
		Random r2 = new Random(10);
		
		for(int i=0;i<=5;i++){
			System.out.println(r2.nextInt(100));
		}
		
			
	}

}
