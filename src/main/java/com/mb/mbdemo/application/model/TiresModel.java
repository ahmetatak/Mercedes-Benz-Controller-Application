package com.mb.mbdemo.application.model;

import java.util.Map;

public class TiresModel {
	
	private Map<String, String> tirepressurefrontleft;
	private Map<String, String> tirepressurefrontright;
	private Map<String, String> tirepressurerearleft;
	private Map<String, String> tirepressurerearright;
	private String code;
	private String reason;
	public Map<String, String> getTirepressurefrontleft() {
		return tirepressurefrontleft;
	}
	public void setTirepressurefrontleft(Map<String, String> tirepressurefrontleft) {
		this.tirepressurefrontleft = tirepressurefrontleft;
	}
	public Map<String, String> getTirepressurefrontright() {
		return tirepressurefrontright;
	}
	public void setTirepressurefrontright(Map<String, String> tirepressurefrontright) {
		this.tirepressurefrontright = tirepressurefrontright;
	}
	public Map<String, String> getTirepressurerearleft() {
		return tirepressurerearleft;
	}
	public void setTirepressurerearleft(Map<String, String> tirepressurerearleft) {
		this.tirepressurerearleft = tirepressurerearleft;
	}
	public Map<String, String> getTirepressurerearright() {
		return tirepressurerearright;
	}
	public void setTirepressurerearright(Map<String, String> tirepressurerearright) {
		this.tirepressurerearright = tirepressurerearright;
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
	public TiresModel() {
		
	}
	public TiresModel(Map<String, String> tirepressurefrontleft, Map<String, String> tirepressurefrontright,
			Map<String, String> tirepressurerearleft, Map<String, String> tirepressurerearright, String code,
			String reason) {
		super();
		this.tirepressurefrontleft = tirepressurefrontleft;
		this.tirepressurefrontright = tirepressurefrontright;
		this.tirepressurerearleft = tirepressurerearleft;
		this.tirepressurerearright = tirepressurerearright;
		this.code = code;
		this.reason = reason;
	}
	 

}
