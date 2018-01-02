package com.jing.system.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;


/**
 * @ClassName: DocumentInfo
 * @Description: 文档实体类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
public class DocumentInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String docId;	//ts_document_info:doc_id  文档标识  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String docName;	//ts_document_info:doc_name  文档名称  

	@Length(min=0, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String actualName;	//ts_document_info:actual_name  真实名称  

	@Length(min=0, max=16, message="{org.hibernate.validator.constraints.Length.message}")
	private String suffixName;	//ts_document_info:suffix_name  文档类型  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=8, message="{org.hibernate.validator.constraints.Length.message}")
	private String fileSize;	//ts_document_info:file_size  文档大小  

	@NotBlank(message = "{org.hibernate.validator.constraints.NotBlank.message}")
	@Length(min=1, max=128, message="{org.hibernate.validator.constraints.Length.message}")
	private String status;	//ts_document_info:status  状态 0正常  

	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	private Integer url;	//ts_document_info:url  地址  

	@Length(min=0, max=256, message="{org.hibernate.validator.constraints.Length.message}")
	private String note;	//ts_document_info:note  说明  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String createdBy;	//ts_document_info:created_by  创建人员  

	private Date createdDate;	//ts_document_info:created_date  创建时间  

	@Length(min=0, max=32, message="{org.hibernate.validator.constraints.Length.message}")
	private String updatedBy;	//ts_document_info:updated_by  修订人员  

	private Date updatedDate;	//ts_document_info:updated_date  修订时间  

	/**
	* @DatabasetableColumnName: ts_document_info:doc_id
	* @Description: 获取属性        文档标识
	* @return: String
	*/
	public String getDocId(){
		return docId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:doc_id
	* @Description: 设置属性        文档标识
	* @return: String
	*/
	public void setDocId(String docId){
		this.docId = docId;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:doc_name
	* @Description: 获取属性        文档名称
	* @return: String
	*/
	public String getDocName(){
		return docName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:doc_name
	* @Description: 设置属性        文档名称
	* @return: String
	*/
	public void setDocName(String docName){
		this.docName = docName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:actual_name
	* @Description: 获取属性        真实名称
	* @return: String
	*/
	public String getActualName(){
		return actualName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:actual_name
	* @Description: 设置属性        真实名称
	* @return: String
	*/
	public void setActualName(String actualName){
		this.actualName = actualName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:suffix_name
	* @Description: 获取属性        文档类型
	* @return: String
	*/
	public String getSuffixName(){
		return suffixName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:suffix_name
	* @Description: 设置属性        文档类型
	* @return: String
	*/
	public void setSuffixName(String suffixName){
		this.suffixName = suffixName;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:file_size
	* @Description: 获取属性        文档大小
	* @return: String
	*/
	public String getFileSize(){
		return fileSize;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:file_size
	* @Description: 设置属性        文档大小
	* @return: String
	*/
	public void setFileSize(String fileSize){
		this.fileSize = fileSize;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:status
	* @Description: 获取属性        状态 0正常
	* @return: String
	*/
	public String getStatus(){
		return status;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:status
	* @Description: 设置属性        状态 0正常
	* @return: String
	*/
	public void setStatus(String status){
		this.status = status;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:url
	* @Description: 获取属性        地址
	* @return: Integer
	*/
	public Integer getUrl(){
		return url;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:url
	* @Description: 设置属性        地址
	* @return: Integer
	*/
	public void setUrl(Integer url){
		this.url = url;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:note
	* @Description: 获取属性        说明
	* @return: String
	*/
	public String getNote(){
		return note;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:note
	* @Description: 设置属性        说明
	* @return: String
	*/
	public void setNote(String note){
		this.note = note;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:created_by
	* @Description: 获取属性        创建人员
	* @return: String
	*/
	public String getCreatedBy(){
		return createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:created_by
	* @Description: 设置属性        创建人员
	* @return: String
	*/
	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:created_date
	* @Description: 获取属性        创建时间
	* @return: Date
	*/
	public Date getCreatedDate(){
		return createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:created_date
	* @Description: 设置属性        创建时间
	* @return: Date
	*/
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:updated_by
	* @Description: 获取属性        修订人员
	* @return: String
	*/
	public String getUpdatedBy(){
		return updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:updated_by
	* @Description: 设置属性        修订人员
	* @return: String
	*/
	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:updated_date
	* @Description: 获取属性        修订时间
	* @return: Date
	*/
	public Date getUpdatedDate(){
		return updatedDate;	
	}
	
	/**
	* @DatabasetableColumnName: ts_document_info:updated_date
	* @Description: 设置属性        修订时间
	* @return: Date
	*/
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;	
	}
	
	
	
	
	
}

