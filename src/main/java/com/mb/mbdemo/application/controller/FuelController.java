package com.mb.mbdemo.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mb.mbdemo.application.service.FuelService;
import com.mb.mbdemo.application.service.TiresService;

@Controller
public class FuelController {
 
	@RequestMapping("/fuel/{id}")
	 
	 String fuel(@PathVariable("id") String vehicleID, Model model, HttpSession session) {
	 
		   FuelService fs=new FuelService(session.getAttribute("access_key").toString(),vehicleID);
		   //timestamps format is not in milliseconds so we need to re format and convert to date in back-end
				 
		   //timestamps format is not in milliseconds so we need to re format ad convert to date in back-end
		model.addAttribute("pageTitle", "Tires");
		if(!(fs.getFuel().getCode()==null))
			return "redirect:/err/"+fs.getFuel().getCode();		
		  model.addAttribute("Fuel", fs.getFuel());
		return "fuel";
 
	}
	

	
 
}
