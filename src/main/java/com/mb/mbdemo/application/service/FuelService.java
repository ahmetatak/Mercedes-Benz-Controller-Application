package com.mb.mbdemo.application.service;

 
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

import com.mb.mbdemo.application.model.DoorsLockStatuModel;
import com.mb.mbdemo.application.model.DoorsModel;
import com.mb.mbdemo.application.model.FuelModel;
import com.mb.mbdemo.application.model.TiresModel;
import com.mb.mbdemo.application.model.VehicleModel;
import com.mb.mbdemo.exLibrary.Configration;
import com.mb.mbdemo.exLibrary.Connect;

public class FuelService {
 
	Configration cnf= new Configration();
	Connect cn= new Connect("");
	FuelModel fuel;
 
 


	public FuelModel getFuel() {
		return fuel;
	}




	public void setFuel(FuelModel fuel) {
		this.fuel = fuel;
	}




	public FuelService(String token, String id) {
		
 
		// String key=clientId+":"+clientSecret;
		 cn.setParam(cn.getParam());
		 cn.setMethod(HttpMethod.POST);
		cn.setUrl(cnf.API_URL+"/vehicles/"+id+"/fuel");
		//cn.setAuthorization(Base64.getEncoder().encodeToString(key.getBytes()));
		//Already encoded to base64 
		cn.setAuthorizationPrefix("Bearer");
		cn.setContentType(cnf.CONTENTTYPE_JSON);
		cn.setAuthorization(token);
		cn.setDataClass( VehicleModel.class);
		cn.prepareIt();
		this.setFuel(cn.executeFuel());
		
	  
	}
 

}
