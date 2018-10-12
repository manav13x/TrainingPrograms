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

public class App03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Resource beanDfRes =  new ClassPathResource("beandefinition01.xml");
		BeanFactory context = new XmlBeanFactory(beanDfRes);
		//Bean Factory is the Container that is spring context
		*/
		//We can do the same using  an application context
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beanDef03.xml");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the userName");
		String username = scan.next();//using parmed implementation
		
		//System.out.println("By Name Injection");
		//IUserService userService5 =(IUserService) context.getBean("uesBean");
		//System.out.println(userService5.welcomeUser(username));
		System.out.println("By Type Injection");
		IUserService userService6 =(IUserService) context.getBean("uesBean1");
		System.out.println(userService6.welcomeUser(username));
		scan.close();
	}

}
