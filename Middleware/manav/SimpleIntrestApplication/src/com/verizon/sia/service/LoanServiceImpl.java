package com.verizon.sia.service;

import com.verizon.sia.exception.LoanValidationException;
import com.verizon.sia.model.Loan;

public class LoanServiceImpl implements ILoanService {

	
	private boolean isValidPrinciple(double p){
		return p>0;
	}
	private boolean isValidTimePeriod(double t){
		return t>0;
	}
	private  boolean isValidRateOfIntrest(double roi){
		return roi>=0 && roi<=20;
	}
	@Override
	public boolean isValidLoan(Loan loan) throws LoanValidationException {
		// TODO Auto-generated method stub
		boolean isValid=true;
		
		StringBuilder errs = new StringBuilder();
		if(!isValidPrinciple(loan.getPrinciple()))
		{
			isValid=false;
			errs.append("\n Principle can only be a  Poasitive");
		}
		if(!isValidTimePeriod(loan.getTimePeriod()))
		{
			isValid=false;
			errs.append("\n time period can only be a  Poasitive");
		}
		if(!isValidRateOfIntrest(loan.getRateOfIntrest()))
		{
			isValid=false;
			errs.append("\n Rate of intrest can only be a  >0 and <20");
		}
		
		if(!isValid){
			throw new LoanValidationException(errs.toString());
		}
		return isValid;
	}

	@Override
	public double getSimpleIntrest(Loan loan) {
		// TODO Auto-generated method stub
		return (loan.getPrinciple()*loan.getTimePeriod()*loan.getRateOfIntrest())/100;
	}

	@Override
	public double getAmount(Loan loan) {
		// TODO Auto-generated method stub
		
		return loan.getSimpleIntrest()+loan.getPrinciple();
	}

}
