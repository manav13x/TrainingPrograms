package com.verizon.springCore.iocdemo.service;

public class UserServiceEnhancedImpl implements IUserService {

	private IWelcomeStatementProvider wsProvider;
	
	
	public UserServiceEnhancedImpl() {
		super();
	}
	public UserServiceEnhancedImpl(IWelcomeStatementProvider wsProvider) {
		super();
		this.wsProvider = wsProvider;//constructor for constructor based dependency injection
	}


	public IWelcomeStatementProvider getWsProvider() {//getter and setter for getter setter based dependency injection
		return wsProvider;
	}
	public void setWsProvider(IWelcomeStatementProvider wsProvider) {
		this.wsProvider = wsProvider;
	}
	public String welcomeUser(String userName) {
		// TODO Auto-generated method stub
		return wsProvider.getWelcomeStatement()+ " "+userName;
	}

}
