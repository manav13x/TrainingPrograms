package com.verizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.model.Loan;
import com.verizon.service.IntrestCalculator;
import com.verizon.service.WelcomeService;

@Controller
@RequestMapping("/intrest")
public class IntrestController {
	
	@Autowired
	private IntrestCalculator intCal;
	@GetMapping
	public String defaultIntrestAction(){
		return "intrestFormPage";
	}
	@PostMapping
	public ModelAndView submitIntrestFormAction(
			@ModelAttribute Loan loan
			){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("intrestUserPage");
		loan.setSimpleIntrest(intCal.getIntrest(loan));
		loan.setRepayableAmount(intCal.getPayableAmount(loan));
		mv.addObject("intrestStatement",loan);
		return mv;
	}
}