package com.verizon.springCore.iocdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceEnhancedImpl implements IUserService {
@Autowired
	private IWelcomeStatementProvider wsProvider;
	
	
	public UserServiceEnhancedImpl() {
		super();
	}
	public UserServiceEnhancedImpl(IWelcomeStatementProvider wsProvider) {
		super();
		this.wsProvider = wsProvider;
	}


	public IWelcomeStatementProvider getWsProvider() {
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
