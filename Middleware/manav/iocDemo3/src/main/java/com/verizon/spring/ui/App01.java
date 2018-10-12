package com.verizon.spring.ui;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.verizon.spring.service.IUserService;



public class App01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Resource beanDfRes =  new ClassPathResource("beandefinition01.xml");
		BeanFactory context = new XmlBeanFactory(beanDfRes);
		//Bean Factory is the Container that is spring context
		*/
		//We can do the same using  an application context
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beandefinition01.xml");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the userName");
		String username = scan.next();
		IUserService userService =(IUserService) context.getBean("udsBean");
		IUserService userService2 =(IUserService) context.getBean("upsBean");
		System.out.println(userService.welcomeUser(username));
		System.out.println(userService2.welcomeUser(username));
		scan.close();

	}

}
