package com.mb.mbdemo.application.model;

import java.util.Map;

public class FuelModel {
	private Map<String, String> fuellevelpercent;
	private String code;
	private String reason;
	public Map<String, String> getFuellevelpercent() {
		return fuellevelpercent;
	}
	public void setFuellevelpercent(Map<String, String> fuellevelpercent) {
		this.fuellevelpercent = fuellevelpercent;
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
	public FuelModel() {
		
	}
	public FuelModel(Map<String, String> fuellevelpercent, String code, String reason) {
		super();
		this.fuellevelpercent = fuellevelpercent;
		this.code = code;
		this.reason = reason;
	}

}
