package com.jing.core.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Department
 * @Description: 部门实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class Department extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer dptId;	//tb_department:dpt_id  部门标识  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tb_department:store_id  归属门店  

	private Integer treamId;	//tb_department:tream_id  系统用户组  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String dptName;	//tb_department:dpt_name  部门名称  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String dptNo;	//tb_department:dpt_no  部门编码  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//tb_department:status  状态 0正常  

	private Integer parentId;	//tb_department:parent_id  父级部门  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String dutyName;	//tb_department:duty_name  联络人  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	@Pattern(regexp="1[34578]\\d{9}", message="{validator.phone.message}")
	private String dutyMobile;	//tb_department:duty_mobile  联络人电话  


	/**
	* @DatabasetableColumnName: tb_department:dpt_id
	* @Description: 获取属性        部门标识
	* @return: Integer
	*/
	public Integer getDptId(){
		return dptId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:dpt_id
	* @Description: 设置属性        部门标识
	* @return: Integer
	*/
	public void setDptId(Integer dptId){
		this.dptId = dptId;	
	}	
	/**
	* @DatabasetableColumnName: tb_department:store_id
	* @Description: 获取属性        归属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:store_id
	* @Description: 设置属性        归属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_department:tream_id
	* @Description: 获取属性        系统用户组
	* @return: Integer
	*/
	public Integer getTreamId(){
		return treamId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:tream_id
	* @Description: 设置属性        系统用户组
	* @return: Integer
	*/
	public void setTreamId(Integer treamId){
		this.treamId = treamId;	
	}	
	/**
	* @DatabasetableColumnName: tb_department:dpt_name
	* @Description: 获取属性        部门名称
	* @return: String
	*/
	public String getDptName(){
		return dptName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:dpt_name
	* @Description: 设置属性        部门名称
	* @return: String
	*/
	public void setDptName(String dptName){
		this.dptName = dptName;	
	}	
	/**
	* @DatabasetableColumnName: tb_department:dpt_no
	* @Description: 获取属性        部门编码
	* @return: String
	*/
	public String getDptNo(){
		return dptNo;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:dpt_no
	* @Description: 设置属性        部门编码
	* @return: String
	*/
	public void setDptNo(String dptNo){
		this.dptNo = dptNo;	
	}	
	/**
	* @DatabasetableColumnName: tb_department:status
	* @Description: 获取属性        状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:status
	* @Description: 设置属性        状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tb_department:parent_id
	* @Description: 获取属性        父级部门
	* @return: Integer
	*/
	public Integer getParentId(){
		return parentId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:parent_id
	* @Description: 设置属性        父级部门
	* @return: Integer
	*/
	public void setParentId(Integer parentId){
		this.parentId = parentId;	
	}	
	/**
	* @DatabasetableColumnName: tb_department:duty_name
	* @Description: 获取属性        联络人
	* @return: String
	*/
	public String getDutyName(){
		return dutyName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:duty_name
	* @Description: 设置属性        联络人
	* @return: String
	*/
	public void setDutyName(String dutyName){
		this.dutyName = dutyName;	
	}	
	/**
	* @DatabasetableColumnName: tb_department:duty_mobile
	* @Description: 获取属性        联络人电话
	* @return: String
	*/
	public String getDutyMobile(){
		return dutyMobile;	
	}
	
	/**
	* @DatabasetableColumnName: tb_department:duty_mobile
	* @Description: 设置属性        联络人电话
	* @return: String
	*/
	public void setDutyMobile(String dutyMobile){
		this.dutyMobile = dutyMobile;	
	}	
	
	
	
	
}

