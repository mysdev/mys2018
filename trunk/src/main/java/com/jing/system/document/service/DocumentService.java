package com.jing.system.document.service;

import java.util.List;
import java.util.Map;

import com.jing.config.web.page.PageInfo;
import com.jing.system.document.entity.Document;

public interface DocumentService {
	
	/**
	 * 保存临时附件到正式附件(异步操作)
	 * @param idstr
	 */
	void saveDocumentToData(String idstr,String resId);
	
	/**
	* 添加 附件
	*/
	Document addDocument(Document document);
	
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
	PageInfo findDocumentListPage(PageInfo page, Map<String, Object> param);
	

	/**
	 * 根据属性查询附件
	 * @param param
	 * @return
	 */
	List<Document> findDocumentList(Map<String, Object> param);
	
	/**
	 * 根据外键查询附件
	 * @param param
	 * @return
	 */
	List<Document> findDocumentListByRes(String resId);
}