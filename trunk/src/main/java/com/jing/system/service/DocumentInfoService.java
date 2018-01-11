package com.jing.system.service;

import java.util.List;
import java.util.Map;


import com.jing.system.model.entity.DocumentInfo;

/**
 * @ClassName: DocumentInfo
 * @Description: 文档服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
public interface DocumentInfoService {

    /**
	 * @Title: addDocumentInfo
	 * @Description:添加文档
	 * @param documentInfo 实体
	 * @return Integer
	 */
	DocumentInfo addDocumentInfo(DocumentInfo documentInfo);
	
	/**
	 * @Title modifyDocumentInfo
	 * @Description:修改文档
	 * @param documentInfo 实体
	 * @return Integer
	 */
	Integer modifyDocumentInfo(DocumentInfo documentInfo);
	
	/**
	 * @Title: dropDocumentInfoByDocId
	 * @Description:删除文档
	 * @param docId 实体标识
	 * @return Integer
	 */
	Integer dropDocumentInfoByDocId(String docId);
	
	/**
	 * @Title: queryDocumentInfoByDocId
	 * @Description:根据实体标识查询文档
	 * @param docId 实体标识
	 * @return DocumentInfo
	 */
	DocumentInfo queryDocumentInfoByDocId(String docId);
	 
	/**
	 * @Title: queryDocumentInfoForPage
	 * @Description: 根据文档属性与分页信息分页查询文档信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param documentInfo 实体
	 * @return List<DocumentInfo>
	 */
	Map<String, Object> queryDocumentInfoForPage(Integer pagenum, Integer pagesize, String sort, DocumentInfo documentInfo);
	 
	 /**
	 * @Title: queryDocumentInfoByProperty
	 * @Description:根据属性查询文档
	 * @return List<DocumentInfo>
	 */
	 List<DocumentInfo> queryDocumentInfoByProperty(Map<String, Object> map);	 
	 
}
