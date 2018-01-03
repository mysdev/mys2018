package com.jing.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;
import java.util.UUID;


import com.jing.system.model.entity.DocumentInfo;
import com.jing.system.model.dao.DocumentInfoMapper;
import com.jing.system.service.DocumentInfoService;

/**
 * @ClassName: DocumentInfo
 * @Description: 文档服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月03日 16时26分
 */
@Service("documentInfoService")
@Transactional(readOnly=true)
public class  DocumentInfoServiceImpl implements DocumentInfoService {

	@Autowired
    private DocumentInfoMapper documentInfoMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addDocumentInfo
	 * @Description:添加文档
	 * @param documentInfo 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public DocumentInfo addDocumentInfo(DocumentInfo documentInfo){
		documentInfo.setDocId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = documentInfoMapper.addDocumentInfo(documentInfo);
		if(ret>0){
			return documentInfo;
		}
		return null;
	}
	
	/**
	 * @Title modifyDocumentInfo
	 * @Description:修改文档
	 * @param documentInfo 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyDocumentInfo(DocumentInfo documentInfo){
		return documentInfoMapper.modifyDocumentInfo(documentInfo);
	}
	
	/**
	 * @Title: dropDocumentInfoByDocId
	 * @Description:删除文档
	 * @param docId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropDocumentInfoByDocId(String docId){
		return documentInfoMapper.dropDocumentInfoByDocId(docId);
	}
	
	/**
	 * @Title: queryDocumentInfoByDocId
	 * @Description:根据实体标识查询文档
	 * @param docId 实体标识
	 * @return DocumentInfo
	 */
	@Override
	public DocumentInfo queryDocumentInfoByDocId(String docId){
		return documentInfoMapper.queryDocumentInfoByDocId(docId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryDocumentInfoForPage
	 * @Description: 根据文档属性与分页信息分页查询文档信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param documentInfo 实体
	 * @return List<DocumentInfo>
	 */
	@Override
	public Map<String, Object> queryDocumentInfoForPage(Integer pagenum, Integer pagesize, String sort, DocumentInfo documentInfo){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, DocumentInfo.class);
		List<DocumentInfo> entityList = documentInfoMapper.queryDocumentInfoForPage(pageBounds, documentInfo);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, DocumentInfo.class);
		}
		if (!entityList.isEmpty()) {
			PageList<DocumentInfo> pagelist = (PageList<DocumentInfo>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryDocumentInfoByProperty
	 * @Description:根据属性查询文档
	 * @return List<DocumentInfo>
	 */
	@Override
	public List<DocumentInfo> queryDocumentInfoByProperty(Map<String, Object> map){
		return documentInfoMapper.queryDocumentInfoByProperty(map);
	}


}
