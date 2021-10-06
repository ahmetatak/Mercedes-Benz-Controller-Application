package com.mb.mbdemo.application.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomErrorController  implements ErrorController {
	private String message;
	@RequestMapping("/err")
	 String err(Model model, @RequestParam(name = "code", required = false) String code) {
		
	if(code==null)
		code="500";
	 
		String errorMessage="Sorry, We got Some errors!";
		model.addAttribute("errorTitle","Error Found!");
		model.addAttribute("errorCode",code);
		model.addAttribute("errorMessage",errorMessage);
		model.addAttribute("pageTitle", "Error Found!");
		return "error";

	}
 
	@RequestMapping("/err/{id}")
	 String errcode(@PathVariable("id") String code, Model model) {
		
	if(code==null)
		code="500";
	codeConvertToMessage(code);
		String errorMessage="Sorry, We got Some errors!";
		model.addAttribute("errorTitle","Error Found!");
		model.addAttribute("errorCode",code);
		model.addAttribute("errorMessage",this.message);
		model.addAttribute("pageTitle", "Error Found!");
		return "error";

	}
 

	
	private void codeConvertToMessage(String code) {
		switch (code) {
	    case "400":
	    	this.message="There are some errors Bad request!";
	    			  break;
	    case "401":
	    	this.message="Invalid or missing authorization in header.";
	    			  break;
	    case "403":
	    	this.message="Insufficient permission.";
	    			  break;
	    case "404":
	    	this.message="Resource not found. The requested vehicle can not be found.";
	    			  break;
	    case "408":
	    	this.message="Car is not available because the simulator is not connected.";
	    			  break;
 
	    default:
	        this.message = "system does not response right now";
	}
		 
		 }
		
		
	   @GetMapping("/error")
	    public String handleError(HttpServletRequest request, Model model) {
	       
	         
	        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	         
	        if (status != null) {
	            Integer statusCode = Integer.valueOf(status.toString());
	             
	            if (statusCode == HttpStatus.NOT_FOUND.value()) {
	                // handle HTTP 404 Not Found error
	            
	                this.message="404 Page not found  :(";
	                 
	            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
	                // handle HTTP 403 Forbidden error
	            	 this.message="403 Forbidden error  Application does not wok :(";
	                 
	            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	                // handle HTTP 500 Internal Server error
	            	 this.message="500 HTTP 500 Internal Server error :(";
	                 
	            }
	        }
	         
			String errorMessage="Sorry, We got Some errors!";
			model.addAttribute("errorTitle","Error Found!");
			model.addAttribute("errorCode",status);
			model.addAttribute("errorMessage",this.message);
			model.addAttribute("pageTitle", "Error Found!");
			return "error";
	    }
	   
	   
	   public String getErrorPath() {
	        return "/error";
	    }
	  
}
