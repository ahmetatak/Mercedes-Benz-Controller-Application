package com.mb.mbdemo.application.model;

public class VehicleModel {
	
	private String id;
	private String licenseplate;
	private String salesdesignation;
	private String finorvin;
	private String nickname;
	private String modelyear;
	private String colorname;
	private String fueltype;
	private String powerhp;
	private String powerkw;
	private String numberofdoors;
	private String numberofseats;
	private String code;
	private String reason;
	public VehicleModel() {};
	public VehicleModel(String id, String licenseplate, String salesdesignation, String finorvin, String nickname,
			String modelyear, String colorname, String fueltype, String powerhp, String powerkw, String numberofdoors,
			String numberofseats, String code, String reason) {
		this.id = id;
		this.licenseplate = licenseplate;
		this.salesdesignation = salesdesignation;
		this.finorvin = finorvin;
		this.nickname = nickname;
		this.modelyear = modelyear;
		this.colorname = colorname;
		this.fueltype = fueltype;
		this.powerhp = powerhp;
		this.powerkw = powerkw;
		this.numberofdoors = numberofdoors;
		this.numberofseats = numberofseats;
		this.code=code;
		this.reason=reason;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public String getSalesdesignation() {
		return salesdesignation;
	}
	public void setSalesdesignation(String salesdesignation) {
		this.salesdesignation = salesdesignation;
	}
	public String getFinorvin() {
		return finorvin;
	}
	public void setFinorvin(String finorvin) {
		this.finorvin = finorvin;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getModelyear() {
		return modelyear;
	}
	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
	}
	public String getColorname() {
		return colorname;
	}
	public void setColorname(String colorname) {
		this.colorname = colorname;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public String getPowerhp() {
		return powerhp;
	}
	public void setPowerhp(String powerhp) {
		this.powerhp = powerhp;
	}
	public String getPowerkw() {
		return powerkw;
	}
	public void setPowerkw(String powerkw) {
		this.powerkw = powerkw;
	}
	public String getNumberofdoors() {
		return numberofdoors;
	}
	public void setNumberofdoors(String numberofdoors) {
		this.numberofdoors = numberofdoors;
	}
	public String getNumberofseats() {
		return numberofseats;
	}
	public void setNumberofseats(String numberofseats) {
		this.numberofseats = numberofseats;
	}
 
 
	
	
 
 
}
