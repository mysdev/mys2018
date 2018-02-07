/**  
 * Copyright © 2018公司名字. All rights reserved.
 * @Title: AttendanceDiaryBo.java
 * @Prject: mys
 * @Package: com.jing.attendance.service.bo
 * @Description: TODO
 * @author: Jinlong He
 * @mail: hejinlong01@hnjing.com
 * @date: 2018年2月7日 下午11:21:09
 * @version: V1.0  
 */
package com.jing.attendance.service.bo;

import com.jing.attendance.model.entity.AttendanceDiary;

/**
 * @ClassName: AttendanceDiaryBo
 * @Description: 考勤详情，当前时间与应到、应退的时间差-分钟
 * @author: Jinlong He
 * @date: 2018年2月7日 下午11:21:09
 */
public class AttendanceDiaryBo extends AttendanceDiary{
	
	private Integer signCount;
	private Integer outCount;
	/**
	 * @return the signCount
	 */
	public Integer getSignCount() {
		return signCount;
	}
	/**
	 * @param signCount the signCount to set
	 */
	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}
	/**
	 * @return the outCount
	 */
	public Integer getOutCount() {
		return outCount;
	}
	/**
	 * @param outCount the outCount to set
	 */
	public void setOutCount(Integer outCount) {
		this.outCount = outCount;
	}

}
