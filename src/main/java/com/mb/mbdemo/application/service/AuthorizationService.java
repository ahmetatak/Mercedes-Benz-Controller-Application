package com.mb.mbdemo.application.service;

import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.mb.mbdemo.application.model.AccessTokenModel;
import com.mb.mbdemo.exLibrary.Configration;
import com.mb.mbdemo.exLibrary.Connect;

public class AuthorizationService {
	Configration cnf= new Configration();
	Connect cn= new Connect("");
	AccessTokenModel token= new AccessTokenModel();
	public AccessTokenModel getToken() {
		return token;
	}

	public void setToken(AccessTokenModel token) {
		this.token = token;
	}


	public AuthorizationService(String code) {
		cn.getParam().add("grant_type", "authorization_code");
		cn.getParam().add("code", code);
		cn.getParam().add("redirect_uri", cnf.REDIRECT_TO);
		// String key=clientId+":"+clientSecret;
	 
		 cn.setParam(cn.getParam());
		 cn.setMethod(HttpMethod.POST);
		cn.setUrl(cnf.URL_OAUTH);
		//cn.setAuthorization(Base64.getEncoder().encodeToString(key.getBytes()));
		//Already encoded to base64 
		cn.setAuthorizationPrefix("Basic");
		cn.setContentType(cnf.CONTENTTYPE_FORM);
		cn.setAuthorization(cnf.AUTHORIZATION);
	
		cn.setDataClass( AccessTokenModel.class);
		cn.prepareIt();
		this.setToken(cn.executeAccessToken());
	}

}
