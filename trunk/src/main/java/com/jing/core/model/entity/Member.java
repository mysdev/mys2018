package com.jing.core.model.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.jing.utils.BaseEntity;

/**
 * @ClassName: Member
 * @Description: 会员实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public class Member extends BaseEntity {
	private static final long serialVersionUID = 1L;
	

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String memberId;	//tb_member:member_id  会员标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String memberName;	//tb_member:member_name  会员名称  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String pinyin;	//tb_member:pinyin  拼音  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer status=0;	//tb_member:status  状态 0正常  

	private Integer rfm;	//tb_member:rfm  会员成长值  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer levelId;	//tb_member:level_id  会员等级  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String memberCard;	//tb_member:member_card  卡号  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String memberPassword;	//tb_member:member_password  会员密码  

	private Integer integral=0;	//tb_member:integral  积分  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private java.math.BigDecimal balance;	//tb_member:balance  余额  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	@Pattern(regexp="1[34578]\\d{9}", message="{validator.phone.message}")
	private String mobile;	//tb_member:mobile  手机号  

	@Length(min=0, max=64, message="{org.hibernate.validator.constraints.Length.message}")
	private String mail;	//tb_member:mail  邮箱地址  

	private Date birthday;	//tb_member:birthday  生日  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String storeId;	//tb_member:store_id  开卡门店  

	private java.math.BigDecimal totalFee;	//tb_member:total_fee  总花费  

	private Integer sex;	//tb_member:sex  性别 0男1女  

	@Length(min=0, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String address;	//tb_member:address  住址  

	private Integer cardType;	//tb_member:card_type  证件类型 0身份证  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String cardNo;	//tb_member:card_no  证件号码  


	/**
	* @DatabasetableColumnName: tb_member:member_id
	* @Description: 获取属性        会员标识
	* @return: String
	*/
	public String getMemberId(){
		return memberId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:member_id
	* @Description: 设置属性        会员标识
	* @return: String
	*/
	public void setMemberId(String memberId){
		this.memberId = memberId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:member_name
	* @Description: 获取属性        会员名称
	* @return: String
	*/
	public String getMemberName(){
		return memberName;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:member_name
	* @Description: 设置属性        会员名称
	* @return: String
	*/
	public void setMemberName(String memberName){
		this.memberName = memberName;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:pinyin
	* @Description: 获取属性        拼音
	* @return: String
	*/
	public String getPinyin(){
		return pinyin;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:pinyin
	* @Description: 设置属性        拼音
	* @return: String
	*/
	public void setPinyin(String pinyin){
		this.pinyin = pinyin;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:status
	* @Description: 获取属性        状态 0正常
	* @return: Integer
	*/
	public Integer getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:status
	* @Description: 设置属性        状态 0正常
	* @return: Integer
	*/
	public void setStatus(Integer status){
		this.status = status;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:rfm
	* @Description: 获取属性        会员成长值
	* @return: Integer
	*/
	public Integer getRfm(){
		return rfm;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:rfm
	* @Description: 设置属性        会员成长值
	* @return: Integer
	*/
	public void setRfm(Integer rfm){
		this.rfm = rfm;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:level_id
	* @Description: 获取属性        会员等级
	* @return: Integer
	*/
	public Integer getLevelId(){
		return levelId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:level_id
	* @Description: 设置属性        会员等级
	* @return: Integer
	*/
	public void setLevelId(Integer levelId){
		this.levelId = levelId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:member_card
	* @Description: 获取属性        卡号
	* @return: String
	*/
	public String getMemberCard(){
		return memberCard;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:member_card
	* @Description: 设置属性        卡号
	* @return: String
	*/
	public void setMemberCard(String memberCard){
		this.memberCard = memberCard;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:member_password
	* @Description: 获取属性        会员密码
	* @return: String
	*/
	public String getMemberPassword(){
		return memberPassword;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:member_password
	* @Description: 设置属性        会员密码
	* @return: String
	*/
	public void setMemberPassword(String memberPassword){
		this.memberPassword = memberPassword;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:integral
	* @Description: 获取属性        积分
	* @return: Integer
	*/
	public Integer getIntegral(){
		return integral;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:integral
	* @Description: 设置属性        积分
	* @return: Integer
	*/
	public void setIntegral(Integer integral){
		this.integral = integral;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:balance
	* @Description: 获取属性        余额
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getBalance(){
		return balance;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:balance
	* @Description: 设置属性        余额
	* @return: java.math.BigDecimal
	*/
	public void setBalance(java.math.BigDecimal balance){
		this.balance = balance;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:mobile
	* @Description: 获取属性        手机号
	* @return: String
	*/
	public String getMobile(){
		return mobile;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:mobile
	* @Description: 设置属性        手机号
	* @return: String
	*/
	public void setMobile(String mobile){
		this.mobile = mobile;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:mail
	* @Description: 获取属性        邮箱地址
	* @return: String
	*/
	public String getMail(){
		return mail;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:mail
	* @Description: 设置属性        邮箱地址
	* @return: String
	*/
	public void setMail(String mail){
		this.mail = mail;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:birthday
	* @Description: 获取属性        生日
	* @return: Date
	*/
	public Date getBirthday(){
		return birthday;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:birthday
	* @Description: 设置属性        生日
	* @return: Date
	*/
	public void setBirthday(Date birthday){
		this.birthday = birthday;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:store_id
	* @Description: 获取属性        开卡门店
	* @return: String
	*/
	public String getStoreId(){
		return storeId;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:store_id
	* @Description: 设置属性        开卡门店
	* @return: String
	*/
	public void setStoreId(String storeId){
		this.storeId = storeId;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:total_fee
	* @Description: 获取属性        总花费
	* @return: java.math.BigDecimal
	*/
	public java.math.BigDecimal getTotalFee(){
		return totalFee;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:total_fee
	* @Description: 设置属性        总花费
	* @return: java.math.BigDecimal
	*/
	public void setTotalFee(java.math.BigDecimal totalFee){
		this.totalFee = totalFee;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:sex
	* @Description: 获取属性        性别 0男1女
	* @return: Integer
	*/
	public Integer getSex(){
		return sex;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:sex
	* @Description: 设置属性        性别 0男1女
	* @return: Integer
	*/
	public void setSex(Integer sex){
		this.sex = sex;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:address
	* @Description: 获取属性        住址
	* @return: String
	*/
	public String getAddress(){
		return address;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:address
	* @Description: 设置属性        住址
	* @return: String
	*/
	public void setAddress(String address){
		this.address = address;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:card_type
	* @Description: 获取属性        证件类型 0身份证
	* @return: Integer
	*/
	public Integer getCardType(){
		return cardType;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:card_type
	* @Description: 设置属性        证件类型 0身份证
	* @return: Integer
	*/
	public void setCardType(Integer cardType){
		this.cardType = cardType;	
	}	
	/**
	* @DatabasetableColumnName: tb_member:card_no
	* @Description: 获取属性        证件号码
	* @return: String
	*/
	public String getCardNo(){
		return cardNo;	
	}
	
	/**
	* @DatabasetableColumnName: tb_member:card_no
	* @Description: 设置属性        证件号码
	* @return: String
	*/
	public void setCardNo(String cardNo){
		this.cardNo = cardNo;	
	}	
	
	
	
	
}

