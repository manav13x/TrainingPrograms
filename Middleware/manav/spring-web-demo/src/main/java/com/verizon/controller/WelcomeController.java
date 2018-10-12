package com.verizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.verizon.service.WelcomeService;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	
	@Autowired
	private WelcomeService welSer;
	@GetMapping
	public String defaultWelcomeAction(){
		return "welcomeFormPage";
	}
	@PostMapping
	public ModelAndView submitWelcomeFormAction(@RequestParam("unm")String userName){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcomeUserPage");
		mv.addObject("welcomeStatement",welSer.getWelcomeStatement(userName)+" Welcome Aboard!");
		return mv;
	}
}
