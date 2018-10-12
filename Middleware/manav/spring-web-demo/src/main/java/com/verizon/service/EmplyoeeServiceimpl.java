package com.verizon.service;

import org.springframework.stereotype.Service;

import com.verizon.model.Emplyoee;
@Service
public class EmplyoeeServiceimpl implements EmplyoeeService {

	@Override
	public double getHra(Emplyoee emp) {
		// TODO Auto-generated method stub
		double hra;
		if(emp.getExperience()>3)
			hra = 0.20*emp.getBasic();
		else
			hra = 0.12*emp.getBasic();
		return hra;
	}

	@Override
	public double getTa(Emplyoee emp) {
		// TODO Auto-generated method stub
		double ta;
		if(emp.getExperience()>3)
			ta = 0.15*emp.getBasic();
		else
			ta =0.10*emp.getBasic();
		return ta;
	}

	@Override
	public double netPay(Emplyoee emp) {
		// TODO Auto-generated method stub
		return (emp.getBasic()+emp.getHra()+emp.getTa());
	}
	

}
