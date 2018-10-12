package com.verizon.adb.ui;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.verizon.adb.exception.SubjectException;
import com.verizon.adb.model.Subject;
import com.verizon.adb.service.ContactServiceImpl;
import com.verizon.adb.service.IContactService;
import com.verizon.adb.util.BookIdComparator;
import com.verizon.adb.util.DurationSubjectComparator;
import com.verizon.adb.util.TitleSubjectComparator;

public class SubjectApp {

	static Scanner scan;
	static IContactService contactService;
	public static void main(String[] args) throws SubjectException {
		
		scan = new Scanner(System.in);
		contactService = new ContactServiceImpl();
		
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
			case DELETE:doDelete();break;
			case SEARCH:doSearch();break;
			case SORTEDID:doSortedId();break;
			case SORTEDDUR:doSortedDur();break;
			case SORTEDTITLE:doSortedTit();break;
			case QUIT:
				System.out.println("End");break;
			}
			
		}
		scan.close();
	}

	public static void doSortedId() throws SubjectException{
		
		List<Subject> subjectList = contactService.orderById();
		//Collections.sort(subjectList, new BookIdComparator());
		for(Subject ss : subjectList)
		{
			System.out.println(ss);
		}
	}
public static void doSortedDur() throws SubjectException{
		List<Subject> subjectList = contactService.orderByDuration();
		//Collections.sort(subjectList, new DurationSubjectComparator());
	for(Subject ss : subjectList)
	{
		System.out.println(ss);
	}
	}
public static void doSortedTit() throws SubjectException{
	List<Subject> subjectList = contactService.orderBySubtitle();
	//Collections.sort(subjectList, new TitleSubjectComparator());
	for(Subject ss : subjectList)
	{
		System.out.println(ss);
	}
}
	public static void doAdd(){
		Subject s = new Subject();
		System.out.println("Enter Subject Id");
		s.setSubjectId(scan.nextLong());
		System.out.print("Get Title");
		s.setSubtitle(scan.next());
		System.out.print("Duration");
		s.setDurationInHours(scan.nextInt());
		try{
			contactService.add(s);
			System.out.println("Added");
		}catch(SubjectException e){
			System.out.println("Err"+e.getMessage());
		}
	}
	public static void doSearch(){
	//	Contact c = new Contact();
		System.out.print("Enter Book ID :  ");
		long bid = scan.nextLong();
		try{
			Subject s = contactService.findByBid(bid);
		if(s!=null)
			System.out.println(s);
			//contactService.add(c);
		}catch(SubjectException e){
			System.out.println("Err"+e.getMessage());
		}
	}
	public static void doDelete(){
		System.out.print("Enter Subject Id");
		long bid = scan.nextLong();
		try{
			boolean isDeleted = contactService.deleteContact(bid);
			if(isDeleted)
				System.out.println("Record Deleted");
			else
				System.out.println("Not Found");
		}catch(SubjectException e)
		{
			System.out.println("Err "+e.getMessage());
		}
	}/*
	public static void doList(){
		try{
			List<Contact> contactList = contactService.getAllCOntacts();
			
			
				for(Contact c:contactList)			
					System.out.println(c);	
				}catch(AddressBookException e){
					System.out.println("Err: "+e.getMessage());	
			
		}
	}*/
		
}
