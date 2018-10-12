package com.verizon.gua.ui;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.verizon.gua.exception.UserValidationException;
import com.verizon.gua.model.Gender;
import com.verizon.gua.model.User;
import com.verizon.gua.service.IUserService;
import com.verizon.gua.service.UserServiceImpl;

import sun.util.resources.LocaleData;
public class UseGreatApp {

	public static void main(String args[])
	{
		
		try(Scanner scan = new Scanner(System.in)){
			
			User user = new User();
			
			System.out.println("UserName ?");
			user.setUsrName(scan.next());
			System.out.print("Date of Birth(dd-MM-YYYY)");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			user.setDatOfBirth(LocalDate.parse(scan.next(),dtf));
			System.out.println("Gender MALE | FEMALE");
			user.setGender(Gender.valueOf(scan.next().toUpperCase()));
			
			
			IUserService userService = new UserServiceImpl();
			
			if(userService.isValidUser(user)){
				user.setAge(userService.getAge(user.getDatOfBirth()));
				user.setTitle(userService.getTitle(user));
				System.out.println(userService.getTimlyGreeting()+
						""+ user.getTitle()+user.getUsrName());
			}
			
		}catch(UserValidationException e){
			e.printStackTrace();
			
		}
		
	}
}
