package com.verizon.spring.service;

public class UserParmed implements IUserService {
	
	
	private String welcomeStatement;
	public String welcomeUser(String userName)
	{
		return welcomeStatement + "!" + userName;
	}
	public UserParmed(){}
	public UserParmed(String welcomeStatement) {
		super();
		this.welcomeStatement = welcomeStatement;
	}
	public String getWelcomeStatement() {
		return welcomeStatement;
	}
	public void setWelcomeStatement(String welcomeStatement) {
		this.welcomeStatement = welcomeStatement;
	}
	

}