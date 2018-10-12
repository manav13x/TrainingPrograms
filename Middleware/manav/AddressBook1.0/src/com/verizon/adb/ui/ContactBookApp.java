package com.verizon.adb.ui;

import java.util.List;
import java.util.Scanner;

import com.verizon.adb.dao.ContactDaoJDBCImpl;
import com.verizon.adb.dao.ContactFileBasedDao;
import com.verizon.adb.exception.AddressBookException;
import com.verizon.adb.model.Contact;
import com.verizon.adb.service.ContactServiceImpl;
import com.verizon.adb.service.IContactService;

public class ContactBookApp {

	static Scanner scan;
	static IContactService contactService;
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		contactService = new ContactServiceImpl(new ContactFileBasedDao());
		//contactService = new ContactServiceImpl(new ContactDaoJDBCImpl());
		
		Menu choice = null;
		while(Menu.QUIT!=choice){
			System.out.println("ChoiceID\t Operatiopn");
			System.out.println("---------------------");
			for(Menu m : Menu.values())
			{
				System.out.println(m.ordinal()+"\t"+m);
			}
			System.out.print("Choice");
			int ch =  scan.nextInt();
			
			choice = Menu.values()[ch];
			switch(choice){
			case ADD:doAdd();break;
			case UPDATE:doUpdate();break;
			case SEARCH:doSearch();break;
			case DELETE:doDelete();break;
			case LIST:doList();break;
			case QUIT:
				System.out.println("End");break;
			}
			
		}
		scan.close();
	}

	public static void doAdd(){
		Contact c = new Contact();
		System.out.println("Mobile no");
		c.setMobileNumber(scan.next());
		System.out.print("Name");
		c.setName(scan.next());
		System.out.print("Email");
		c.setEmail(scan.next());
		try{
			contactService.add(c);
			System.out.println("Added");
		}catch(AddressBookException e){
			System.out.println("Err"+e.getMessage());
		}
	}
	public static void doUpdate(){
		Contact c = new Contact();
		System.out.println("New Mobile no");
		c.setMobileNumber(scan.next());
		System.out.print("New Name");
		c.setName(scan.next());
		System.out.print("New Email");
		c.setEmail(scan.next());
		try{
			contactService.update(c);
			System.out.println("Updated");
		}catch(AddressBookException e){
			System.out.println("Err"+e.getMessage());
		}
	}
	public static void doSearch(){
	//	Contact c = new Contact();
		System.out.print("Mobile No :  ");
		String mno = scan.next();
		try{
			Contact c = contactService.findByMobileNumber(mno);
		if(c!=null)
			System.out.println(c);
			//contactService.add(c);
		}catch(AddressBookException e){
			System.out.println("Err"+e.getMessage());
		}
	}
	public static void doDelete(){
		System.out.print("Mobile No");
		String mno = scan.next();
		try{
			boolean isDeleted = contactService.deleteContact(mno);
			if(isDeleted)
				System.out.println("Record Deleted");
			else
				System.out.println("Not Found");
		}catch(AddressBookException e)
		{
			System.out.println("Err "+e.getMessage());
		}
	}
	public static void doList(){
		try{
			List<Contact> contactList = contactService.getAllCOntacts();
			
			
				for(Contact c:contactList)			
					System.out.println(c);	
				}catch(AddressBookException e){
					System.out.println("Err: "+e.getMessage());	
			
		}
	}
		
}
