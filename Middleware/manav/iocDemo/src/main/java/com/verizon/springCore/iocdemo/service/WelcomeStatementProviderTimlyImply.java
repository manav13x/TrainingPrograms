package com.verizon.springCore.iocdemo.service;

import java.time.LocalDateTime;

public class WelcomeStatementProviderTimlyImply  implements IWelcomeStatementProvider{

	public String getWelcomeStatement() {
		// TODO Auto-generated method stub
		String statement = null;
		int hour = LocalDateTime.now().getHour();
		if(hour>=3 && hour <=11)
				statement  ="Good morning";
		else if(hour >11 && hour<18)
			statement  ="Good Noon";
		else
			statement  ="Good Evening";
		return statement;
	}

}
