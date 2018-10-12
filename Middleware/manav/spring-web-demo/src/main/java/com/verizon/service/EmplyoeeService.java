package com.verizon.service;

import com.verizon.model.Emplyoee;

public interface EmplyoeeService {

	public double getHra(Emplyoee emp);
	public double getTa(Emplyoee emp);
	public double netPay(Emplyoee emp);
}
