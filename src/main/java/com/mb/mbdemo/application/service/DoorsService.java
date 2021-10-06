package com.mb.mbdemo.application.service;

 
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

import com.mb.mbdemo.application.model.DoorsLockStatuModel;
import com.mb.mbdemo.application.model.DoorsModel;
import com.mb.mbdemo.application.model.VehicleModel;
import com.mb.mbdemo.exLibrary.Configration;
import com.mb.mbdemo.exLibrary.Connect;

public class DoorsService {
 
	Configration cnf= new Configration();
	Connect cn= new Connect("");
	DoorsModel doors;
	DoorsLockStatuModel doorLockStatu;
	public DoorsLockStatuModel getDoorLockStatu() {
		return doorLockStatu;
	}

	public void setDoorLockStatu(DoorsLockStatuModel doorLockStatu) {
		this.doorLockStatu = doorLockStatu;
	}

	public DoorsModel getDoors(){
		return doors;
	}

	public void setDoors (DoorsModel doors) {
		this.doors = doors;
	}


	public DoorsService(String token, String id) {
		
 
		// String key=clientId+":"+clientSecret;
		 cn.setParam(cn.getParam());
		 cn.setMethod(HttpMethod.POST);
		cn.setUrl(cnf.API_URL+"/vehicles/"+id+"/doors");
		//cn.setAuthorization(Base64.getEncoder().encodeToString(key.getBytes()));
		//Already encoded to base64 
		cn.setAuthorizationPrefix("Bearer");
		cn.setContentType(cnf.CONTENTTYPE_JSON);
		cn.setAuthorization(token);
		cn.setDataClass( VehicleModel.class);
		cn.prepareIt();
		this.setDoors(cn.executeDoors());
		
	  
	}
	public DoorsService(String token, String id,String command) {
		JSONObject js= new JSONObject();
		
		 js.put("command", command);
		 cn.setJsonParam(js);
		 cn.setMethod(HttpMethod.POST);
		cn.setUrl(cnf.API_URL+"/vehicles/"+id+"/doors");
		//cn.setAuthorization(Base64.getEncoder().encodeToString(key.getBytes()));
		//Already encoded to base64 
		cn.setAuthorizationPrefix("Bearer");
		cn.setContentType(cnf.CONTENTTYPE_JSON);
		cn.setAuthorization(token);
		cn.setDataClass( VehicleModel.class);
		cn.prepareIt();
		this.setDoorLockStatu(cn.executeDoorsLockStatu());
		
	  
	}

}
