package com.jing.system.dept.entity;

import java.util.Date;

import com.jing.utils.BaseEntity;

/**
 * 部门职工 实体类
 * 
 * @author codeing gen
 */
public class DeptStaff extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Integer dsid; // 主键
	private Integer deptCode; // 部门编码
	private String image; // 照片
	private String name; // 姓名
	private String sex; // 性别
	private Date birthday; // 出生年月
	private String phone; // 电话
	private String addr; // 地址
	private String email; // 邮箱
	private String post; // 职务
	private String deptName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDsid() {
		return this.dsid;
	}

	public Integer getDeptCode() {
		return this.deptCode;
	}

	public String getImage() {
		return this.image;
	}

	public String getName() {
		return this.name;
	}

	public String getSex() {
		return this.sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddr() {
		return this.addr;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPost() {
		return this.post;
	}

	public void setDsid(Integer dsid) {
		this.dsid = dsid;
	}

	public void setDeptCode(Integer deptCode) {
		this.deptCode = deptCode;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPost(String post) {
		this.post = post;
	}

}