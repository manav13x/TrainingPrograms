package com.verizon.service;

import com.verizon.model.Loan;

public interface IntrestCalculator {
	
	double getIntrest(Loan loan);
	double getPayableAmount(Loan loan);

}
