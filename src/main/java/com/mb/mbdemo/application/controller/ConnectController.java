package com.mb.mbdemo.application.controller;
import java.util.Base64;

import com.mb.mbdemo.application.model.AccessTokenModel;
import com.mb.mbdemo.application.service.AuthorizationService;
import com.mb.mbdemo.exLibrary.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mb.mbdemo.exLibrary.Connect;

@Controller
public class ConnectController {
/*	private String clientSecret="";
	
	private  String clientId="22f769d5-ff00-45d0-848d-1e5a6cfdfd94";
	private String redirectTo="http://localhost:8080/connect/generateOuth/";
	private String scope="mb:vehicle:status:general mb:user:pool:reader offline_access";
	private String uri= "https://id.mercedes-benz.com/as/authorization.oauth2?response_type=code&client_id="+this.clientId+"&redirect_uri="+this.redirectTo+"&scope="+this.scope+"&state=HELLO_WORLD";
	*/
 
	Configration cnf= new Configration();
 
	@RequestMapping("/connect")
 
	public String to(Model model, @RequestParam(name = "action", required = false) String action) { 

		if(!(action==null))
		{
			//if the client click the button than redirect to Mercedes service for authorization.
		
			return "redirect:"+cnf.URL_AUTHORIZATION+"?response_type=code&client_id="+cnf.CLIENT_ID+"&redirect_uri="+cnf.REDIRECT_TO+"&scope="+cnf.SCOPE+"&state="+cnf.STATE;
		}else
		
			model.addAttribute("pageTitle", "Connect to MB");

		return "connect";
	
	}


	@RequestMapping("/connect/generateOuth")
 
	public String mbResponded(@RequestParam(name = "code", required = false) String code, HttpServletResponse httpResponse,HttpSession session) { 

		if(!(code==null))
		{
			/*let's add some parameters which is requaired to connect the API*/
	 
 
			AuthorizationService as= new AuthorizationService(code);
			if(!(as.getToken().getCode()==null))
				return "redirect:/err/"+as.getToken().getCode();
			 
				session.setAttribute("access_key", as.getToken().getAccess_token() );
				session.setAttribute("reflesh_token",  as.getToken().getRefresh_token());
				session.setAttribute("token_type",  as.getToken().getToken_type());
				session.setAttribute("token_expire_in",  as.getToken().getExpires_in());
			   //System.out.println("Token : " +  as.getToken().getAccess_token());

		 
			return "redirect:/vehicles";
		 
		}else
		
		return "home";
	}
 
	@RequestMapping("/connect/cut")
	 
	public String mbCut(@RequestParam(name = "code", required = false) String code, HttpServletResponse httpResponse,HttpSession session) { 

		
		if(!(session.getAttribute("access_key")==null))
			session.removeAttribute("access_key");
 
		 
			return "redirect:/";
		 
	  
	}
	 
}
