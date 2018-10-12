package com.verizon.springCore.iocdemo.ui;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.verizon.springCore.iocdemo.service.IUserService;
import com.verizon.springCore.iocdemo.service.UserServiceDefaultImpl;

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
		IUserService userService3 =(IUserService) context.getBean("uesBean");
		System.out.println("This statement is generated using injecting a object of bean using constructor or setter injection");
		System.out.println(userService3.welcomeUser(username));
		System.out.print("usinng  set");
		IUserService userService4 =(IUserService) context.getBean("umsBean");
		System.out.println(userService4.welcomeUser(username));
		scan.close();
	}

}
