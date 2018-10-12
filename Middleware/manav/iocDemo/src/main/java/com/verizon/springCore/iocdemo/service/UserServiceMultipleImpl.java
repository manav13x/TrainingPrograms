package com.verizon.springCore.iocdemo.service;

import java.util.Set;

public class UserServiceMultipleImpl implements IUserService{

	private Set<String> welcomeStatements;
	public UserServiceMultipleImpl(){
		
	}
	
	public Set<String> getWelcomeStatements() {
		return welcomeStatements;
	}

	public void setWelcomeStatements(Set<String> welcomeStatements) {
		this.welcomeStatements = welcomeStatements;
	}

	public String welcomeUser(String userName) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (String w : welcomeStatements)
		{
			sb.append("\n"+w+" "+userName);
			
		}
		return sb.toString();
	}

}
