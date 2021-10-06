package com.mb.mbdemo.application.model;

import java.util.Map;

public class DoorsModel {
	
	private Map<String, String> doorstatusfrontleft;
	private Map<String, String>  doorlockstatusfrontleft;
	private Map<String, String>  doorstatusfrontright;
	private Map<String, String>  doorlockstatusfrontright;
	private Map<String, String>  doorstatusrearleft;
	private Map<String, String>  doorlockstatusrearleft;
	private Map<String, String>  doorstatusrearright;
	private Map<String, String>  doorlockstatusrearright;
	private Map<String, String>  doorlockstatusdecklid;
	private Map<String, String>  doorlockstatusgas;
	private Map<String, String>  doorlockstatusvehicle;
	private String reason;
	private String code;
	public DoorsModel() {}
	public DoorsModel(Map<String, String> doorstatusfrontleft, Map<String, String> doorlockstatusfrontleft,
			Map<String, String> doorstatusfrontright, Map<String, String> doorlockstatusfrontright,
			Map<String, String> doorstatusrearleft, Map<String, String> doorlockstatusrearleft,
			Map<String, String> doorstatusrearright, Map<String, String> doorlockstatusrearright,
			Map<String, String> doorlockstatusdecklid, Map<String, String> doorlockstatusgas,
			Map<String, String> doorlockstatusvehicle,String reason, String code) {
		super();
		this.doorstatusfrontleft = doorstatusfrontleft;
		this.doorlockstatusfrontleft = doorlockstatusfrontleft;
		this.doorstatusfrontright = doorstatusfrontright;
		this.doorlockstatusfrontright = doorlockstatusfrontright;
		this.doorstatusrearleft = doorstatusrearleft;
		this.doorlockstatusrearleft = doorlockstatusrearleft;
		this.doorstatusrearright = doorstatusrearright;
		this.doorlockstatusrearright = doorlockstatusrearright;
		this.doorlockstatusdecklid = doorlockstatusdecklid;
		this.doorlockstatusgas = doorlockstatusgas;
		this.doorlockstatusvehicle = doorlockstatusvehicle;
		this.reason=reason;
		this.code=code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Map<String, String> getDoorstatusfrontleft() {
		return doorstatusfrontleft;
	}
	public void setDoorstatusfrontleft(Map<String, String> doorstatusfrontleft) {
		this.doorstatusfrontleft = doorstatusfrontleft;
	}
	public Map<String, String> getDoorlockstatusfrontleft() {
		return doorlockstatusfrontleft;
	}
	public void setDoorlockstatusfrontleft(Map<String, String> doorlockstatusfrontleft) {
		this.doorlockstatusfrontleft = doorlockstatusfrontleft;
	}
	public Map<String, String> getDoorstatusfrontright() {
		return doorstatusfrontright;
	}
	public void setDoorstatusfrontright(Map<String, String> doorstatusfrontright) {
		this.doorstatusfrontright = doorstatusfrontright;
	}
	public Map<String, String> getDoorlockstatusfrontright() {
		return doorlockstatusfrontright;
	}
	public void setDoorlockstatusfrontright(Map<String, String> doorlockstatusfrontright) {
		this.doorlockstatusfrontright = doorlockstatusfrontright;
	}
	public Map<String, String> getDoorstatusrearleft() {
		return doorstatusrearleft;
	}
	public void setDoorstatusrearleft(Map<String, String> doorstatusrearleft) {
		this.doorstatusrearleft = doorstatusrearleft;
	}
	public Map<String, String> getDoorlockstatusrearleft() {
		return doorlockstatusrearleft;
	}
	public void setDoorlockstatusrearleft(Map<String, String> doorlockstatusrearleft) {
		this.doorlockstatusrearleft = doorlockstatusrearleft;
	}
	public Map<String, String> getDoorstatusrearright() {
		return doorstatusrearright;
	}
	public void setDoorstatusrearright(Map<String, String> doorstatusrearright) {
		this.doorstatusrearright = doorstatusrearright;
	}
	public Map<String, String> getDoorlockstatusrearright() {
		return doorlockstatusrearright;
	}
	public void setDoorlockstatusrearright(Map<String, String> doorlockstatusrearright) {
		this.doorlockstatusrearright = doorlockstatusrearright;
	}
	public Map<String, String> getDoorlockstatusdecklid() {
		return doorlockstatusdecklid;
	}
	public void setDoorlockstatusdecklid(Map<String, String> doorlockstatusdecklid) {
		this.doorlockstatusdecklid = doorlockstatusdecklid;
	}
	public Map<String, String> getDoorlockstatusgas() {
		return doorlockstatusgas;
	}
	public void setDoorlockstatusgas(Map<String, String> doorlockstatusgas) {
		this.doorlockstatusgas = doorlockstatusgas;
	}
	public Map<String, String> getDoorlockstatusvehicle() {
		return doorlockstatusvehicle;
	}
	public void setDoorlockstatusvehicle(Map<String, String> doorlockstatusvehicle) {
		this.doorlockstatusvehicle = doorlockstatusvehicle;
	}
	 

}


 