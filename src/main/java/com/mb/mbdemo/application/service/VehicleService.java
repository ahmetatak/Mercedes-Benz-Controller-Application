package com.mb.mbdemo.application.service;

 
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpMethod;

 
import com.mb.mbdemo.application.model.VehicleModel;
import com.mb.mbdemo.exLibrary.Configration;
import com.mb.mbdemo.exLibrary.Connect;

public class VehicleService {
	HttpSession session;
 
	Configration cnf= new Configration();
	Connect cn= new Connect("");
	VehicleModel vehicle;
	public VehicleModel getVehicle(){
		return vehicle;
	}

	public void setVehicle (VehicleModel vehicles) {
		this.vehicle = vehicles;
	}


	public VehicleService(String token, String id) {
 
		// String key=clientId+":"+clientSecret;
		
		 cn.setParam(cn.getParam());
		 cn.setMethod(HttpMethod.POST);
		cn.setUrl(cnf.API_URL+"/vehicles/"+id);
		//cn.setAuthorization(Base64.getEncoder().encodeToString(key.getBytes()));
		//Already encoded to base64 
		cn.setAuthorizationPrefix("Bearer");
		cn.setContentType(cnf.CONTENTTYPE_JSON);
		cn.setAuthorization(token);
		cn.setDataClass( VehicleModel.class);
		cn.prepareIt();
		this.setVehicle(cn.executeVehicle());
		
	  
	}

}
