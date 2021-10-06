package com.mb.mbdemo.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/")
	 String index(Model model, HttpSession session) {
	 
		model.addAttribute("pageTitle", "Home Page");
		
		//if(!(session.getAttribute("access_key")==null))
		//System.out.println("access key: "+session.getAttribute("access_key"));
		return "home";
 
	}
	

	
 
}
