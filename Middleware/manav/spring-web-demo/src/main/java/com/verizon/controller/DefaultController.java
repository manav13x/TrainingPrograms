package com.verizon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    @RequestMapping(value = {"","/","/home"},method=RequestMethod.GET)//map to  a particular request
	public String defaultAction(){
		return "home";
	}
    @RequestMapping(value="/aboutUs",method = RequestMethod.GET)
    public ModelAndView aboutUsAction(){
    		ModelAndView mv = new ModelAndView();
    		mv.setViewName("aboutPage");
    		
    		mv.addObject("webmaster","manav Kumar");
    		mv.addObject("devTeam",new String[] {"Amit","Noushin"});
    		mv.addObject("adminMailId","vamsy.kiran@iiht.com");
    		return mv;
    	} 
    }
	
	//need to infrom to what kind of request this action responds
