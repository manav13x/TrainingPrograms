package com.verizon.ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.verizon.service.WelcomeService;
//import com.verizon.service.SimpleWelcomeServiceImpl;
import org.springframework.core.*;

public class App01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beandefinition01.xml");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the user name");
		
		String username = sc.next();
		
		WelcomeService us = (WelcomeService) ctx.getBean("wel01");
		System.out.println(us.greatUser(username));
		
		
	}

}
