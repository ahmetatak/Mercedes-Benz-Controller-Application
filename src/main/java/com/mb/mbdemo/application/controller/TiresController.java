package com.mb.mbdemo.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mb.mbdemo.application.service.TiresService;

@Controller
public class TiresController {
 
	@RequestMapping("/tires/{id}")
	 
	 String tires(@PathVariable("id") String vehicleID, Model model, HttpSession session) {
	 
		   TiresService ts=new TiresService(session.getAttribute("access_key").toString(),vehicleID);
		   //timestamps format is not in milliseconds so we need to re format and convert to date in back-end
	 
		   //timestamps format is not in milliseconds so we need to re format ad convert to date in back-end
		model.addAttribute("pageTitle", "Tires");
		
		if(!(ts.getTires().getCode()==null))
			return "redirect:/err/"+ts.getTires().getCode();		

		  model.addAttribute("Tires", ts.getTires());
 
		  
		return "tires";
 
	}
	

	
 
}
