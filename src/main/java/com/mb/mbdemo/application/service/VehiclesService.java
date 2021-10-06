package com.mb.mbdemo.application.service;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpMethod;

 
import com.mb.mbdemo.application.model.VehiclesModel;
import com.mb.mbdemo.exLibrary.Configration;
import com.mb.mbdemo.exLibrary.Connect;

public class VehiclesService {
 
	Configration cnf= new Configration();
	Connect cn= new Connect("");
	List<VehiclesModel>  vehicles;
	public List<VehiclesModel>  getVehicles(){
		return vehicles;
	}

	public void setVehicles (List<VehiclesModel>  vehicles) {
		this.vehicles = vehicles;
	}


	public VehiclesService(String token) {
 
		// String key=clientId+":"+clientSecret;
		 cn.setParam(cn.getParam());
		 cn.setMethod(HttpMethod.POST);
		cn.setUrl(cnf.API_URL+"/vehicles/");
		//cn.setAuthorization(Base64.getEncoder().encodeToString(key.getBytes()));
		//Already encoded to base64 
		cn.setAuthorizationPrefix("Bearer");
		cn.setContentType(cnf.CONTENTTYPE_JSON);
		cn.setAuthorization(token);
	
		cn.setDataClass( VehiclesModel.class);
		cn.prepareIt();
		this.setVehicles(cn.executeVehicles());
		
	  
	}

}
