package com.verizon.service;

import org.springframework.stereotype.Service;

import com.verizon.model.Loan;

@Service
public class IntrestCalculatorImpl implements IntrestCalculator {

	@Override
	public double getIntrest(Loan loan) {
		// TODO Auto-generated method stub
		
		return (loan.getPrincipal()*loan.getRateOfIntrest()*loan.getTimePeriod())/100;
	}

	@Override
	public double getPayableAmount(Loan loan) {
		// TODO Auto-generated method stub
		return loan.getPrincipal()+loan.getSimpleIntrest();
	}

}
