package com.verizon.service;

public class SimpleWelcomeServiceImpl implements WelcomeService {

	private String greeting;
	public SimpleWelcomeServiceImpl()
	{
		//leftblank intentionally
	}
	
	public SimpleWelcomeServiceImpl(String greeting)
	{
		this.greeting=greeting;
	}
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String greatUser(String UserName) {
		// TODO Auto-generated method stub
		return greeting +" "+UserName;
	}

}
