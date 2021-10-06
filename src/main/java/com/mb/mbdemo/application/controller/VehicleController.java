package com.mb.mbdemo.application.controller;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
 
import java.time.Instant;
import java.util.List;
 
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.mb.mbdemo.application.model.VehiclesModel;
import com.mb.mbdemo.application.service.AuthorizationService;
import com.mb.mbdemo.application.service.DoorsService;
import com.mb.mbdemo.application.service.TiresService;
import com.mb.mbdemo.application.service.VehicleService;
import com.mb.mbdemo.application.service.VehiclesService;

@Controller
public class VehicleController {

	List<VehiclesModel>  vehicles;
	@RequestMapping("/vehicles")
	 String vehicles(Model model, HttpSession session) {
		
		
		if(session.getAttribute("access_key")==null)

			return "redirect:/connect";
		else
		{
		/*	VehiclesModel vm1= new VehiclesModel();
			vm1.setId("1223344");
			vm1.setFinorvin("errr");
			VehiclesModel vm2= new VehiclesModel();
			vm2.setId("1223344");
			vm2.setFinorvin("errr");
			VehiclesModel vm3= new VehiclesModel();
			vm3.setId("1223344");
			vm3.setFinorvin("errr");
			*/
			VehiclesService vs= new VehiclesService(session.getAttribute("access_key").toString());
 
			List<VehiclesModel>  vehicles=vs.getVehicles();
/*			vehicles.add(vm1);
			vehicles.add(vm2);
			vehicles.add(vm3); */
			
	   model.addAttribute("Vehicles", vehicles);
	   model.addAttribute("pageTitle", "Vehicles");
			return "vehicles";
		}
	

	}
	
	
	@RequestMapping("/vehicle/{id}")
	 String vehicle(@PathVariable("id") String vehicleID, Model model, HttpSession session) {
		 
		if(session.getAttribute("access_key")==null)

		return "connect";
		else
		{
		/*	VehiclesModel vm1= new VehiclesModel();
			vm1.setId("1223344");
			vm1.setFinorvin("errr");
			VehiclesModel vm2= new VehiclesModel();
			vm2.setId("1223344");
			vm2.setFinorvin("errr");
			VehiclesModel vm3= new VehiclesModel();
			vm3.setId("1223344");
			vm3.setFinorvin("errr");
			*/
			VehicleService vs= new VehicleService(session.getAttribute("access_key").toString(),vehicleID);
			 
			if(!(vs.getVehicle().getCode()==null))
				return "redirect:/err/"+vs.getVehicle().getCode();
		
			  
 
	   model.addAttribute("Vehicle", vs.getVehicle());
 
	   model.addAttribute("vehicleId", vehicleID);
	   model.addAttribute("pageTitle", "Detail of the Vehicle");
			return "vehicle";
		}
	

	}
	
 private String reFormatDateTime(String date,String format) {
	 if(format==null)
		 format="YYY-mm-dd hh:mm:ss";
	 SimpleDateFormat formatDate = new SimpleDateFormat(format); 
	 Date dt= new Date((long) Integer.parseInt(date)* 1000);
 
	 return formatDate.format(dt);
 }
	 
}
