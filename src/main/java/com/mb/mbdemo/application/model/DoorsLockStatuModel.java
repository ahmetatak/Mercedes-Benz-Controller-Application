package com.mb.mbdemo.application.model;

public class DoorsLockStatuModel {

	private String status;
	private String code;
	private String reason;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public DoorsLockStatuModel(String status, String code, String reason) {
		super();
		this.status = status;
		this.code = code;
		this.reason = reason;
	}
	
	public DoorsLockStatuModel() {

	}
}
