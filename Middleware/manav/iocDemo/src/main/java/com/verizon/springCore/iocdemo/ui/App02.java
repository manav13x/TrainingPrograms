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
import com.verizon.springCore.iocdemo.service.UserServiceParmedImpl;

public class App02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Resource beanDfRes =  new ClassPathResource("beandefinition01.xml");
		BeanFactory context = new XmlBeanFactory(beanDfRes);
		//Bean Factory is the Container that is spring context
		*/
		//We can do the same using  an application context
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beanDef02.xml");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the userName");
		String username = scan.next();//using parmed implementation
		UserServiceParmedImpl userService =(UserServiceParmedImpl) context.getBean("upsBean");
		System.out.println(userService.welcomeUser(username));
		userService.setWelcomeStatement("helo");
		System.out.println(userService.welcomeUser(username));
		UserServiceParmedImpl userService2 =(UserServiceParmedImpl) context.getBean("upsBean");
		System.out.println(userService2.welcomeUser(username));
		
		//here eventhough the state has been changed same copy is provided since state is
		//Singleton or protype depending on the scope in beannDef02.xml
		//for other scope to work in web context...not application context
		IUserService userService3 =(IUserService) context.getBean("uesBean");
		System.out.println(userService3.welcomeUser(username));
		
		System.out.println("mulitple");
		IUserService userService4 =(IUserService) context.getBean("umsBean");
		System.out.println(userService4.welcomeUser(username));
		scan.close();
	}

}
