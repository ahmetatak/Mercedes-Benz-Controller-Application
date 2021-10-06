package com.mb.mbdemo.application.model;

public class VehiclesModel {
	
	private String id;
	private String licenseplate;
	private String finorvin;
	
	public VehiclesModel() {
 
	}
	public VehiclesModel(String id, String licenseplate, String finorvin) {
		this.id=id;
		this.licenseplate=licenseplate;
		this.finorvin=finorvin;
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLicenseplate() {
		return licenseplate;
	}


	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}


	public String getFinorvin() {
		return finorvin;
	}


	public void setFinorvin(String finorvin) {
		this.finorvin = finorvin;
	}
 
}
