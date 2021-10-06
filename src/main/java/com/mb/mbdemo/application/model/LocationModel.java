package com.mb.mbdemo.application.model;

import java.util.Map;

public class LocationModel {
	private Map<String, String> longitude;
	private Map<String, String> latitude;
	private Map<String, String> heading;
 
	private String code;
	private String reason;
	public LocationModel() {
		
	}
	public LocationModel(Map<String, String> longitude, Map<String, String> latitude, Map<String, String> heading,
			String code, String reason) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.heading = heading;
		this.code = code;
		this.reason = reason;
	}
	public Map<String, String> getLongitude() {
		return longitude;
	}
	public void setLongitude(Map<String, String> longitude) {
		this.longitude = longitude;
	}
	public Map<String, String> getLatitude() {
		return latitude;
	}
	public void setLatitude(Map<String, String> latitude) {
		this.latitude = latitude;
	}
	public Map<String, String> getHeading() {
		return heading;
	}
	public void setHeading(Map<String, String> heading) {
		this.heading = heading;
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
 
}
