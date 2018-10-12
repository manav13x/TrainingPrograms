package com.verizon.springCore.iocdemo.ui;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.verizon.springCore.iocdemo.config.AppConfig;
import com.verizon.springCore.iocdemo.service.IUserService;

public class App01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Resource beanDfRes =  new ClassPathResource("beandefinition01.xml");
		BeanFactory context = new XmlBeanFactory(beanDfRes);
		//Bean Factory is the Container that is spring context
		*/
		//We can do the same using  an application context
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the userName");
		String username = scan.next();
		IUserService userService =(IUserService) context.getBean("userServiceEnhancedImpl");
		System.out.println(userService.welcomeUser(username));
		System.out.println(context.getBean("today"));
		scan.close();
	}

}
