package com.mb.mbdemo.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mb.mbdemo.application.service.FuelService;
import com.mb.mbdemo.application.service.LocationService;
import com.mb.mbdemo.application.service.TiresService;

@Controller
public class LocationController {
 
	@RequestMapping("/location/{id}")
	 
	 String location(@PathVariable("id") String vehicleID, Model model, HttpSession session) {
	 
		   LocationService ls=new LocationService(session.getAttribute("access_key").toString(),vehicleID);
	 
		model.addAttribute("pageTitle", "Tires");
		if(!(ls.getLocation().getCode()==null))
			return "redirect:/err/"+ls.getLocation().getCode();		
		  model.addAttribute("Location", ls.getLocation());
		return "location";
 
	}
	

	
 
}
