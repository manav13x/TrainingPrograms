package com.verizon.sia.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.verizon.sia.exception.LoanValidationException;
import com.verizon.sia.model.Loan;
import com.verizon.sia.service.ILoanService;
import com.verizon.sia.service.LoanServiceImpl;


public class UseLoan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner scan = new Scanner(System.in)){
			
			Loan user = new Loan();
			
			System.out.println("Princple ?");
			user.setPrinciple(scan.nextFloat());
			System.out.print("Rate oF Intrest");
		//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			user.setRateOfIntrest(scan.nextDouble());
			System.out.println("Enter time Duration");
			user.setTimePeriod(scan.nextDouble());
			
			ILoanService userService = new LoanServiceImpl();
			
			if(userService.isValidLoan(user)){
				user.setSimpleIntrest(userService.getSimpleIntrest(user));
				user.setAmount(userService.getAmount(user));
				
				System.out.println("intrest "+user.getSimpleIntrest());
				System.out.println("amount" +user.getAmount());
			}
			
		}catch(LoanValidationException e){
			e.printStackTrace();
			
		}
		
		
		
		
	}

}
