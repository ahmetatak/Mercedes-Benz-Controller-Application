package com.mb.mbdemo.exLibrary;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.mb.mbdemo.application.model.AccessTokenModel;
import com.mb.mbdemo.application.model.DoorsLockStatuModel;
import com.mb.mbdemo.application.model.DoorsModel;
import com.mb.mbdemo.application.model.FuelModel;
import com.mb.mbdemo.application.model.LocationModel;
import com.mb.mbdemo.application.model.TiresModel;
import com.mb.mbdemo.application.model.VehicleModel;
import com.mb.mbdemo.application.model.VehiclesModel;

public class Connect<T> {
	private HttpHeaders headers = new HttpHeaders();
	private String url="https://api.mercedes-benz.com/experimental/connectedvehicle_tryout/v2/";
	private String service;
	private HttpMethod method=HttpMethod.GET;
	private MultiValueMap<String, String> param=new LinkedMultiValueMap<>();;
	private String data; 
	private String contentType="application/json";
	private String clientId="";
	private String secretKey="";
	private String tokenKey="";
	private String request;
	private String code;
	private int responseCode;
	private Class  dataClass;
	private JSONObject  jsonParam;
	
	public JSONObject getJsonParam() {
		return jsonParam;
	}

	public void setJsonParam(JSONObject jsonParam) {
		this.jsonParam = jsonParam;
	}

	private HttpStatus responseStatus;
	private  HttpEntity<MultiValueMap<String, String>> entity ;
	public Object getDataClass() {
		return dataClass;
	}

	public void setDataClass(Class accessToken) {
		this.dataClass = accessToken;
		 
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	
	private String authorizationPrefix="Bearer";
	
	private String authorization="";
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	private String protocol="https";
	
	public Connect(String service) {
		this.service=service;
	}
	
	public Connect(String service,HttpMethod method) {
		this.service=service;
	}
	
	public  void execute()
	{
		
	 this.headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
 
	 this.headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
 
	  
	 HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(this.param,this.headers);

	// send POST request

	try{
		ResponseEntity<String> response = this.restTemplate.postForEntity(this.url+this.service, entity,String.class);
		if (response.getStatusCode() == HttpStatus.OK) {
		   
	 
		} 
		} catch (HttpClientErrorException e){
		 this.errorHandler(e);
		}
 
	}
	
	
	private String errorHandler(HttpClientErrorException e) {
		System.out.println("RETURNED WITH ERROR ! ERROR CODE :"+e.getRawStatusCode());
		System.out.println("ERROR MESSAGE :"+e.getResponseBodyAsString());
		 return "";
		
	}
	public void prepareIt() {

	 this.headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 this.headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));	  
	 this.entity = new HttpEntity<>(this.param,this.headers);
	// System.out.println(this.getUrl());
	// send POST request
		
	}
	public AccessTokenModel  executeAccessToken()
	{
		ResponseEntity<AccessTokenModel> response = null;

	try{
	  response = this.restTemplate.postForEntity(this.url+this.service, entity,AccessTokenModel.class);
		if (response.getStatusCode() == HttpStatus.OK && !(response.getBody()==null)) {
		  //  System.out.println("Login Successful : " +response.getBody().getRefresh_token());
		    return response.getBody();
		} 
		} catch (HttpClientErrorException e){
			this.errorHandler(e);
			AccessTokenModel gt= new AccessTokenModel();
			gt.setCode(""+e.getRawStatusCode());
			return gt;
			
		}
	if(response==null)
		return new AccessTokenModel();
	else
	return response.getBody();
	}
	
	public List<VehiclesModel> executeVehicles()
	{
		List<VehiclesModel> response = null;

	try{
	 // response = this.restTemplate.exchange(this.url+this.service,HttpMethod.GET, entity,VehiclesModel.class);
		
		ResponseEntity<List<VehiclesModel>> responseEntity  = this.restTemplate.exchange(this.url+this.service,HttpMethod.GET, entity,
			    new ParameterizedTypeReference<List<VehiclesModel>>() {});
response  = responseEntity.getBody();
	 
		
	   // System.out.println("LOL  "+response.get(0).getFinorvin());
		if (responseEntity.getStatusCode()== HttpStatus.OK) {
		  // System.out.println("Login Successful");
		    return response;
		} 
		} catch (HttpClientErrorException e){
			this.errorHandler(e);
		}
 
	return response;
	}
	public VehicleModel  executeVehicle()
	{
		ResponseEntity<VehicleModel> response = null;

	try{

	  response = this.restTemplate.exchange(this.url+this.service,HttpMethod.GET, entity,VehicleModel.class);
		if (response.getStatusCode() == HttpStatus.OK && !(response.getBody()==null)) {
			
			 
 		    return  response.getBody();
		} 
		} catch (HttpClientErrorException e){
			this.errorHandler(e);
		}
	if(response==null)
		return new VehicleModel();
	else
	return response.getBody();
	}
	
	public DoorsModel  executeDoors()
	{
		ResponseEntity<DoorsModel> response = null;

	try{

	  response = this.restTemplate.exchange(this.url+this.service,HttpMethod.GET, entity,DoorsModel.class);
		if (response.getStatusCode() == HttpStatus.OK && !(response.getBody()==null)) {
			//front
			response.getBody().getDoorstatusfrontleft().replace("timestamp", this.reFormatDateTime(response.getBody().getDoorstatusfrontleft().get("timestamp"),null));
			response.getBody().getDoorlockstatusfrontleft().replace("timestamp", this.reFormatDateTime(response.getBody().getDoorlockstatusfrontleft().get("timestamp"),null));
			response.getBody().getDoorstatusfrontright().replace("timestamp", this.reFormatDateTime(response.getBody().getDoorstatusfrontright().get("timestamp"),null));
			response.getBody().getDoorlockstatusfrontright().replace("timestamp", this.reFormatDateTime(response.getBody().getDoorlockstatusfrontright().get("timestamp"),null));

			   		//rare
			response.getBody().getDoorstatusrearleft().replace("timestamp", this.reFormatDateTime(response.getBody().getDoorstatusrearleft().get("timestamp"),null));
			response.getBody().getDoorlockstatusrearleft().replace("timestamp", this.reFormatDateTime(response.getBody().getDoorlockstatusrearleft().get("timestamp"),null));
			response.getBody().getDoorstatusrearright().replace("timestamp", this.reFormatDateTime(response.getBody().getDoorstatusrearright().get("timestamp"),null));
			response.getBody().getDoorlockstatusrearright().replace("timestamp", this.reFormatDateTime(response.getBody().getDoorlockstatusrearright().get("timestamp"),null));

 		    return  response.getBody();
		} 
		} catch (HttpClientErrorException e){
			this.errorHandler(e);
		}
	if(response==null)
		return new DoorsModel();
	else
	return response.getBody();
	}
	
	public TiresModel  executeTires()
	{
		ResponseEntity<TiresModel> response = null;

	try{

	  response = this.restTemplate.exchange(this.url+this.service,HttpMethod.GET, entity,TiresModel.class);
		if (response.getStatusCode() == HttpStatus.OK && !(response.getBody()==null)) {
			
			//front
			response.getBody().getTirepressurefrontleft().replace("timestamp", this.reFormatDateTime(response.getBody().getTirepressurefrontleft().get("timestamp"),null));
			response.getBody().getTirepressurefrontright().replace("timestamp", this.reFormatDateTime(response.getBody().getTirepressurefrontright().get("timestamp"),null));
	 
			   		//rare
			response.getBody().getTirepressurerearleft().replace("timestamp", this.reFormatDateTime(response.getBody().getTirepressurerearleft().get("timestamp"),null));
			response.getBody().getTirepressurerearright().replace("timestamp", this.reFormatDateTime(response.getBody().getTirepressurerearright().get("timestamp"),null));
 		    return  response.getBody();
		} 
		} catch (HttpClientErrorException e){
			this.errorHandler(e);
		}
	if(response==null)
		return new TiresModel();
	else
	return response.getBody();
	}
	
	
	public FuelModel  executeFuel()
	{
		ResponseEntity<FuelModel> response = null;

	try{

	  response = this.restTemplate.exchange(this.url+this.service,HttpMethod.GET, entity,FuelModel.class);
		if (response.getStatusCode() == HttpStatus.OK && !(response.getBody()==null)) {
			
			//front
			response.getBody().getFuellevelpercent().replace("timestamp", this.reFormatDateTime(response.getBody().getFuellevelpercent().get("timestamp"),null));
 
 		    return  response.getBody();
		} 
		} catch (HttpClientErrorException e){
			this.errorHandler(e);
		}
	if(response==null)
		return new FuelModel();
	else
	return response.getBody();
	}
	
	public LocationModel  executeLocation()
	{
		ResponseEntity<LocationModel> response = null;

	try{

	  response = this.restTemplate.exchange(this.url+this.service,HttpMethod.GET, entity,LocationModel.class);
		if (response.getStatusCode() == HttpStatus.OK && !(response.getBody()==null)) {
			
			//front
			response.getBody().getLatitude().replace("timestamp", this.reFormatDateTime(response.getBody().getLatitude().get("timestamp"),null));
			response.getBody().getLongitude().replace("timestamp", this.reFormatDateTime(response.getBody().getLongitude().get("timestamp"),null));
			response.getBody().getHeading().replace("timestamp", this.reFormatDateTime(response.getBody().getHeading().get("timestamp"),null));
			

 		    return  response.getBody();
		} 
		} catch (HttpClientErrorException e){
			this.errorHandler(e);
		}
	if(response==null)
		return new LocationModel();
	else
	return response.getBody();
	}
	
	
	public DoorsLockStatuModel  executeDoorsLockStatu()
	{	ResponseEntity<String> response = null;
		//ResponseEntity<DoorsLockStatuModel> response = null;
		
		
		
	 this.headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
 
	 this.headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
 
 
	 
	 HttpEntity<String> entity = new HttpEntity<String>(this.getJsonParam().toString(),this.headers);

	// send POST request
 	try{
 response = this.restTemplate.postForEntity(this.url+this.service, entity,String.class);
		if (response.getStatusCode() == HttpStatus.OK) {
		 
 	 
		} 
		} catch (HttpClientErrorException e){
			this.errorHandler(e);
		}
	return new DoorsLockStatuModel();
	}
	
	


 
	
	
	
	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		
		this.url = url;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public MultiValueMap<String, String> getParam() {
		return param;
	}

	public void setParam(MultiValueMap<String, String> param) {
		this.param = param;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getTokenKey() {
		return tokenKey;
	}

	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAuthorizationPrefix() {
		return authorizationPrefix;
	}
	
	public void setAuthorizationPrefix(String authorizationPrefix) {
		this.authorizationPrefix = authorizationPrefix;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
		this.headers.add("authorization", this.getAuthorizationPrefix()+" "+this.authorization);
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	 private String reFormatDateTime(String date,String format) {
		 if(format==null)
			 format="YYY-mm-dd hh:mm:ss";
		 SimpleDateFormat formatDate = new SimpleDateFormat(format); 
		 Date dt= new Date((long) Integer.parseInt(date)* 1000);
	 
		 return formatDate.format(dt);
	 }

}
