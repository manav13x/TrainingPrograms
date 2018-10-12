package com.verizon.adb.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;
import com.verizon.adb.service.ContactServiceImpl;
import com.verizon.adb.service.IContactService;
import com.verizon.adb.ui.AddressBookHomeScreen;
@Configuration
@ComponentScan("com.verizon.adb")
public class ContactBookApp {

public static void main(String args[])
	{
	ApplicationContext context = new AnnotationConfigApplicationContext(ContactBookApp.class);
	 
	//= new AddressBookHomeScreen();
	AddressBookHomeScreen screen=(AddressBookHomeScreen)context.getBean("addressBookHomeScreen");
	screen.setVisible(true);
	}
}