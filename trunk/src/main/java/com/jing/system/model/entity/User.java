package com.jing.system.model.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: User
 * @Description: 用户实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	private Integer userId;	//ts_user:user_id  用户标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String userName;	//ts_user:user_name  用户姓名  

	private Integer teamId;	//ts_user:team_id  用户组  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String nickName;	//ts_user:nick_name  呢称  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	@Pattern(regexp="1[34578]\\d{9}", message="{validator.phone.message}")
	private String mobile;	//ts_user:mobile  手机号  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	@Email(message="{org.hibernate.validator.constraints.Email.message}")
	private String email;	//ts_user:email  邮件地址  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String password;	//ts_user:password  密码  

	private Date repasswordDate;	//ts_user:repassword_date  下次修改密码时间  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status;	//ts_user:status  状态 0正常  

	
	private List<UserRole> userRoleList;

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	/**
	* @DatabasetableColumnName: ts_user:user_id
	* @Description: 获取属性        用户标识
	* @return: Integer
	*/
	public Integer getUserId(){
		return userId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:user_id
	* @Description: 设置属性        用户标识
	* @return: Integer
	*/
	public void setUserId(Integer userId){
		this.userId = userId;	
	}	
	/**
	* @DatabasetableColumnName: ts_user:user_name
	* @Description: 获取属性        用户姓名
	* @return: String
	*/
	public String getUserName(){
		return userName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:user_name
	* @Description: 设置属性        用户姓名
	* @return: String
	*/
	public void setUserName(String userName){
		this.userName = userName;	
	}	
	/**
	* @DatabasetableColumnName: ts_user:team_id
	* @Description: 获取属性        用户组
	* @return: Integer
	*/
	public Integer getTeamId(){
		return teamId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:team_id
	* @Description: 设置属性        用户组
	* @return: Integer
	*/
	public void setTeamId(Integer teamId){
		this.teamId = teamId;	
	}	
	/**
	* @DatabasetableColumnName: ts_user:nick_name
	* @Description: 获取属性        呢称
	* @return: String
	*/
	public String getNickName(){
		return nickName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:nick_name
	* @Description: 设置属性        呢称
	* @return: String
	*/
	public void setNickName(String nickName){
		this.nickName = nickName;	
	}	
	/**
	* @DatabasetableColumnName: ts_user:mobile
	* @Description: 获取属性        手机号
	* @return: String
	*/
	public String getMobile(){
		return mobile;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:mobile
	* @Description: 设置属性        手机号
	* @return: String
	*/
	public void setMobile(String mobile){
		this.mobile = mobile;	
	}	
	/**
	* @DatabasetableColumnName: ts_user:email
	* @Description: 获取属性        邮件地址
	* @return: String
	*/
	public String getEmail(){
		return email;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:email
	* @Description: 设置属性        邮件地址
	* @return: String
	*/
	public void setEmail(String email){
		this.email = email;	
	}	
	/**
	* @DatabasetableColumnName: ts_user:password
	* @Description: 获取属性        密码
	* @return: String
	*/
	public String getPassword(){
		return password;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:password
	* @Description: 设置属性        密码
	* @return: String
	*/
	public void setPassword(String password){
		this.password = password;	
	}	
	/**
	* @DatabasetableColumnName: ts_user:repassword_date
	* @Description: 获取属性        下次修改密码时间
	* @return: Date
	*/
	public Date getRepasswordDate(){
		return repasswordDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:repassword_date
	* @Description: 设置属性        下次修改密码时间
	* @return: Date
	*/
	public void setRepasswordDate(Date repasswordDate){
		this.repasswordDate = repasswordDate;	
	}	
	/**
	* @DatabasetableColumnName: ts_user:status
	* @Description: 获取属性        状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: ts_user:status
	* @Description: 设置属性        状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	
	
	
	
}

