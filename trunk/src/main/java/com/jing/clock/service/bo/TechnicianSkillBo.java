/**  
 * Copyright © 2018公司名字. All rights reserved.
 * @Title: TechnicianSkillBo.java
 * @Prject: mys
 * @Package: com.jing.clock.service.bo.impl
 * @Description: TODO
 * @author: Jinlong He
 * @mail: hejinlong01@hnjing.com
 * @date: 2018年2月24日 下午4:51:22
 * @version: V1.0  
 */
package com.jing.clock.service.bo;

import com.jing.clock.model.entity.TechnicianSkill;

/**
 * @ClassName: TechnicianSkillBo
 * @Description: 技师技能
 * @author: Jinlong He
 * @date: 2018年2月24日 下午4:51:22
 */
public class TechnicianSkillBo extends TechnicianSkill{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;
	private String technicianName;
	private String skillName;
	
	/**
	 * @return the technicianName
	 */
	public String getTechnicianName() {
		return technicianName;
	}
	/**
	 * @param technicianName the technicianName to set
	 */
	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}
	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}
	/**
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
