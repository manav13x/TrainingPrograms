package com.verizon.sia.service;

import com.verizon.sia.exception.LoanValidationException;
import com.verizon.sia.model.Loan;

public interface ILoanService {

 boolean isValidLoan(Loan loan) throws LoanValidationException;
 	
 	double getSimpleIntrest(Loan loan);
 	double getAmount(Loan loan);
 
}
