package com.jing.system.document.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.document.entity.Document;

@Mapper
public interface DocumentDao {

	/**
	* 添加 附件
	*/
	void addDocument(Document document);
	
	/**
	* 修改 附件
	*/
	void updateDocument(Document document);
	
	/**
	*根据ID删除记录
	*/
	void deleteDocumentById(String id);	
	
	/**
	 * 根据RES删除记录
	 */
	void deleteDocumentByRes(String res);	
	
	/**
	*根据ID查询记录
	*/
	Document getDocumentById(String id);
	
	/**
	* 分页查询
	*/
	List<Document> findDocumentListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询附件
	 * @param param
	 * @return
	 */
	List<Document> findDocumentList(@Param("param") Map<String, Object> param);	
}