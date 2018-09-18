package com.jing.system.user.entity;

/**
 * 用户表
 * 
 * @author LIFENG
 *
 */
public class UserDetail extends User {
	private static final long serialVersionUID = 1L;
	
	private String phone;//电话
	private String image;//照片
	private String addr;//地址
	private String email;//电邮
	
	private String remediation;//政治面貌
	private String scope;//管理范围
	private Integer familyNumber;//管理户数


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemediation() {
		return remediation;
	}

	public void setRemediation(String remediation) {
		this.remediation = remediation;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Integer getFamilyNumber() {
		return familyNumber;
	}

	public void setFamilyNumber(Integer familyNumber) {
		this.familyNumber = familyNumber;
	}
}
