package com.verizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.model.Book;
import com.verizon.model.Emplyoee;
import com.verizon.model.Loan;
import com.verizon.service.EmplyoeeService;
import com.verizon.service.IntrestCalculator;
@Controller
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	private EmplyoeeService empCal;
	@GetMapping
	public ModelAndView defaultEmplyoeeAction(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("emplyoeeFormPage");
		mv.addObject("emp",new Emplyoee());
		mv.addObject("possibDept", new String[]{"CIVIL","MECH","BIO","ECE","CSE"});
		mv.addObject("possibGen", new String[]{"Gent","Lady"});
		return mv;
	}
	@PostMapping
	public ModelAndView submitEmplyoeeFormAction(
			@ModelAttribute Emplyoee emp
			){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("emplyoeeUserPage");
		emp.setTa(empCal.getTa(emp));
		emp.setHra(empCal.getHra(emp));
		emp.setNetPay(empCal.netPay(emp));
		mv.addObject("emp",emp);
		return mv;

}
}
