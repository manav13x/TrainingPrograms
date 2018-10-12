package com.verizon.springCore.iocdemo.service;

public class UserServiceParmedImpl implements IUserService {

	private String welcomeStatement;

	public UserServiceParmedImpl() {

	}

	public UserServiceParmedImpl(String welcomeStatement) {
		this.welcomeStatement = welcomeStatement;
	}
	
	
	
	
	
public String getWelcomeStatement() {
		return welcomeStatement;
	}

	public void setWelcomeStatement(String welcomeStatement) {
		this.welcomeStatement = welcomeStatement;
	}

	//the implemetation is achieved through constructor injection
	public String welcomeUser(String userName) {
		// TODO Auto-generated method stub

		return welcomeStatement + "!" + userName;
	}
	public void doOnStartUp(){
		System.out.println("i am init method");
	}
	public void doOnTearDown(){
		System.out.println("i am tear Down method");
	}
}
