package com.jing.system.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.system.model.entity.DocumentInfo;

/**
 * @ClassName: DocumentInfoMapper
 * @Description: 文档映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Mapper
public interface DocumentInfoMapper {

	/**
	 * @Title: addDocumentInfo
	 * @Description:添加文档
	 * @param documentInfo 实体
	 * @return Integer
	 */
	Integer addDocumentInfo(DocumentInfo documentInfo);
	
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
	 * @param pageBounds 分页信息
	 * @param documentInfo 实体
	 * @return List<DocumentInfo>
	 */
	List<DocumentInfo> queryDocumentInfoForPage(PageBounds pageBounds, @Param("documentInfo") DocumentInfo documentInfo);
	 
	 /**
	  * @Title: queryDocumentInfoByProperty
	  * @Description:根据属性查询文档
	  * @return List<DocumentInfo>
	  */
	 List<DocumentInfo> queryDocumentInfoByProperty(@Param("documentInfo") Map<String, Object> map);
	 
	 /**
	 * @Title: clearTableData
	 * @Description: 清空表信息
	 * @return 
	 */
	 void clearTableData();
	 
	 
}
