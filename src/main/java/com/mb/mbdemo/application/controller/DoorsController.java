package com.mb.mbdemo.application.controller;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;
 
import com.mb.mbdemo.application.model.DoorsModel;
import com.mb.mbdemo.application.model.VehiclesModel;
import com.mb.mbdemo.application.service.AuthorizationService;
import com.mb.mbdemo.application.service.DoorsService;
import com.mb.mbdemo.application.service.TiresService;
import com.mb.mbdemo.application.service.VehicleService;
import com.mb.mbdemo.application.service.VehiclesService;

@Controller
@CrossOrigin
public class DoorsController {
	private HttpSession session;
	List<DoorsModel>  doors;
	
	
	
 
	@RequestMapping("/doors/status/{id}")
	@ResponseBody
	 DoorsModel doorStatus(@RequestParam(name = "command", required = false) String command, @PathVariable("id") String vehicleID, Model model, HttpSession session) {
		
		DoorsModel statu = new DoorsModel();
		statu.setReason("access token is null"+"  mu  ?"+command);
		if(!(session.getAttribute("access_key")==null))
		{
		 
			
			 
			DoorsService ds= new DoorsService(session.getAttribute("access_key").toString(),vehicleID,command );
		 
		  
			
		 
		}else {
			statu.setCode("400");
			statu.setReason("access token is null");
			
		}
 
	
		return statu;
	}
	
	
	
		@RequestMapping("/doors/listen/{id}")
		 String doorListen(@PathVariable("id") String vehicleID, Model model, HttpSession session) {
			System.out.println("Vehicle ID :"+vehicleID);
			
			if(session.getAttribute("access_key")==null)

				return "redirect:/connect";
			else
			{
				DoorsService ds= new DoorsService(session.getAttribute("access_key").toString(),vehicleID);
				if(!(ds.getDoors().getCode()==null))
					return "redirect:/err/"+ds.getDoors().getCode();		

		   
		   //timestamps, we need to re format ad convert to date in back-end
 
		   model.addAttribute("Doors", ds.getDoors());
		   model.addAttribute("vehicleId", vehicleID);
		   model.addAttribute("pageTitle", "Door status");
				return "doors";
			}
		

		}
 
	@RequestMapping("/doors/{id}")
	 String doors(@PathVariable("id") String vehicleID, Model model, HttpSession session) {
		//System.out.println("Vehicle ID :"+vehicleID);
		
		if(session.getAttribute("access_key")==null)

			return "redirect:/connect";
		else
		{
			DoorsService ds= new DoorsService(session.getAttribute("access_key").toString(),vehicleID);
			if(!(ds.getDoors().getCode()==null))
				return "redirect:/err/"+ds.getDoors().getCode();
	   model.addAttribute("Doors", ds.getDoors());
	   model.addAttribute("vehicleId", vehicleID);
	   model.addAttribute("pageTitle", "Door status");
			return "doors";
		}
	

	}
	
	
	@RequestMapping("/doors")
	@ResponseBody
	 String doors(Model model, HttpSession session) {
 
 
		
		return "last";

	}
	
	 private String reFormatDateTime(String date,String format) {
		 if(format==null)
			 format="YYY-mm-dd hh:mm:ss";
		 SimpleDateFormat formatDate = new SimpleDateFormat(format); 
		 Date dt= new Date((long) Integer.parseInt(date)* 1000);
	 
		 return formatDate.format(dt);
	 }
	 
}
