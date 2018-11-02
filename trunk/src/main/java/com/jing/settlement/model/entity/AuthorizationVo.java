package com.jing.settlement.model.entity;

public class AuthorizationVo extends Authorization{

	private static final long serialVersionUID = 1L;
	private String customName;
	private String typesName;
	private String deviceName;
	
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getTypesName() {
		return typesName;
	}
	public void setTypesName(String typesName) {
		this.typesName = typesName;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	
	
}
