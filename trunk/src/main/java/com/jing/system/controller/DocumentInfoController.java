package com.jing.system.controller;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import com.jing.config.validation.BeanValidator;
import com.jing.system.model.entity.DocumentInfo;
import com.jing.system.service.DocumentInfoService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: DocumentInfoController
 * @Description: 文档HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description="文档")
public class DocumentInfoController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private DocumentInfoService documentInfoService;

	
	@ApiOperation(value = "新增 添加文档信息", notes = "添加文档信息")
	@RequestMapping(value = "/documentinfo", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addDocumentInfo(HttpServletResponse response,
			@ApiParam(value = "documentInfo") @RequestBody DocumentInfo documentInfo) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(documentInfo, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		documentInfo.setDocId(null);
		documentInfoService.addDocumentInfo(documentInfo);
		return documentInfo;
	}
	
	
	@ApiOperation(value = "更新 根据文档标识更新文档信息", notes = "根据文档标识更新文档信息")
	@RequestMapping(value = "/documentinfo/{docId:.+}", method = RequestMethod.PUT)
	public Object modifyDocumentInfoById(HttpServletResponse response,
			@PathVariable String docId,
			@ApiParam(value = "documentInfo", required = true) @RequestBody DocumentInfo documentInfo
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(documentInfo, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		DocumentInfo tempDocumentInfo = documentInfoService.queryDocumentInfoByDocId(docId);
		documentInfo.setDocId(docId);
		if(null == tempDocumentInfo){
			throw new NotFoundException("文档");
		}
		return documentInfoService.modifyDocumentInfo(documentInfo);
	}

	@ApiOperation(value = "删除 根据文档标识删除文档信息", notes = "根据文档标识删除文档信息")
	@RequestMapping(value = "/documentinfo/{docId:.+}", method = RequestMethod.DELETE)
	public Object dropDocumentInfoByDocId(HttpServletResponse response, @PathVariable String docId) {
		DocumentInfo documentInfo = documentInfoService.queryDocumentInfoByDocId(docId);
		if(null == documentInfo){
			throw new NotFoundException("文档");
		}
		return documentInfoService.dropDocumentInfoByDocId(docId);
	}
	
	@ApiOperation(value = "查询 根据文档标识查询文档信息", notes = "根据文档标识查询文档信息")
	@RequestMapping(value = "/documentinfo/{docId:.+}", method = RequestMethod.GET)
	public Object queryDocumentInfoById(HttpServletResponse response,
			@PathVariable String docId) {
		DocumentInfo documentInfo = documentInfoService.queryDocumentInfoByDocId(docId);
		if(null == documentInfo){
			throw new NotFoundException("文档");
		}
		return documentInfo;
	}
	
	@ApiOperation(value = "查询 根据文档属性查询文档信息列表", notes = "根据文档属性查询文档信息列表")
	@RequestMapping(value = "/documentinfo", method = RequestMethod.GET)
	public Object queryDocumentInfoList(HttpServletResponse response,
			DocumentInfo documentInfo) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return documentInfoService.queryDocumentInfoByProperty(ClassUtil.transBean2Map(documentInfo, false));
	}
	
	@ApiOperation(value = "查询分页 根据文档属性分页查询文档信息列表", notes = "根据文档属性分页查询文档信息列表")
	@RequestMapping(value = "/documentinfos", method = RequestMethod.GET)
	public Object queryDocumentInfoPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, DocumentInfo documentInfo) {				
		return documentInfoService.queryDocumentInfoForPage(pagenum, pagesize, sort, documentInfo);
	}

}
