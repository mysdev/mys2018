package com.jing.core.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.system.dept.entity.Dept;
import com.jing.system.dept.util.DeptMapper;
import com.jing.system.user.entity.User;
import com.jing.system.user.uitl.UserMapper;
import com.jing.utils.BaseEntity;
import com.jing.utils.ChineseToPinyin;

/**
 * @ClassName: Employee
 * @Description: 员工实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class Employee extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String empId;	//tb_employee:emp_id  员工标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String empName;	//tb_employee:emp_name  员工姓名  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String pinyin;	//tb_employee:pinyin  员工拼音  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String empNo;	//tb_employee:emp_no  员工工号  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private Integer userId;	//tb_employee:user_id  关联用户
	private User user;
	public User getUser() {
		if(getUserId()!=null) {
			return UserMapper.getObj(getUserId());
		}
		return user;
	}

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tb_employee:store_id  所属门店  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private Integer dptId;	//tb_employee:dpt_id  所属部门  '
	private Dept dept;
	public Dept getDept() {
		if(dptId != null) {
			return DeptMapper.getObj(dptId);
		}
		return dept;
	}

	private Date entryDate;	//tb_employee:entry_date  入职时间  

	private Date quitDate;	//tb_employee:quit_date  离职时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status=0;	//tb_employee:status  员工状态 0正常  

	private Integer isManager;	//tb_employee:is_manager  是否管理 0否  
	
	private String empCard; //员工号卡
	
	private Integer sex;
	


	/**
	* @DatabasetableColumnName: tb_employee:emp_id
	* @Description: 获取属性        员工标识
	* @return: String
	*/
	public String getEmpId(){
		return empId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:emp_id
	* @Description: 设置属性        员工标识
	* @return: String
	*/
	public void setEmpId(String empId){
		this.empId = empId;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:emp_name
	* @Description: 获取属性        员工姓名
	* @return: String
	*/
	public String getEmpName(){
		return empName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:emp_name
	* @Description: 设置属性        员工姓名
	* @return: String
	*/
	public void setEmpName(String empName){
		this.empName = empName;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:pinyin
	* @Description: 获取属性        员工拼音
	* @return: String
	*/
	public String getPinyin(){
		if(getEmpName()!=null && pinyin ==null) {
			return ChineseToPinyin.getPingYin(getEmpName(), "LOWERCASE");
		}
		return pinyin;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:pinyin
	* @Description: 设置属性        员工拼音
	* @return: String
	*/
	public void setPinyin(String pinyin){
		this.pinyin = pinyin;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:emp_no
	* @Description: 获取属性        员工工号
	* @return: String
	*/
	public String getEmpNo(){
		return empNo;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:emp_no
	* @Description: 设置属性        员工工号
	* @return: String
	*/
	public void setEmpNo(String empNo){
		this.empNo = empNo;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:user_id
	* @Description: 获取属性        关联用户
	* @return: String
	*/
	public Integer getUserId(){
		return userId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:user_id
	* @Description: 设置属性        关联用户
	* @return: String
	*/
	public void setUserId(Integer userId){
		this.userId = userId;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:store_id
	* @Description: 获取属性        所属门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:store_id
	* @Description: 设置属性        所属门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:dpt_id
	* @Description: 获取属性        所属部门
	* @return: String
	*/
	public Integer getDptId(){
		return dptId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:dpt_id
	* @Description: 设置属性        所属部门
	* @return: String
	*/
	public void setDptId(Integer dptId){
		this.dptId = dptId;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:entry_date
	* @Description: 获取属性        入职时间
	* @return: Date
	*/
	public Date getEntryDate(){
		return entryDate;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:entry_date
	* @Description: 设置属性        入职时间
	* @return: Date
	*/
	public void setEntryDate(Date entryDate){
		this.entryDate = entryDate;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:quit_date
	* @Description: 获取属性        离职时间
	* @return: Date
	*/
	public Date getQuitDate(){
		return quitDate;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:quit_date
	* @Description: 设置属性        离职时间
	* @return: Date
	*/
	public void setQuitDate(Date quitDate){
		this.quitDate = quitDate;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:status
	* @Description: 获取属性        员工状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:status
	* @Description: 设置属性        员工状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tb_employee:is_manager
	* @Description: 获取属性        是否管理 0否
	* @return: Integer
	*/
	public Integer getIsManager(){
		return isManager;	
	}
	
	/**
	* @DatabasetableColumnName: tb_employee:is_manager
	* @Description: 设置属性        是否管理 0否
	* @return: Integer
	*/
	public void setIsManager(Integer isManager){
		this.isManager = isManager;	
	}

	public String getEmpCard() {
		return empCard;
	}

	public void setEmpCard(String empCard) {
		this.empCard = empCard;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}	
	
	
	
	
}

