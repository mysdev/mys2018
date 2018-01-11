package com.jing.settlement.controller;

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
import com.jing.settlement.model.entity.GoodsMaterial;
import com.jing.settlement.service.GoodsMaterialService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: GoodsMaterialController
 * @Description: 基本原料HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@RestController
@Api(description="基本原料")
public class GoodsMaterialController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private GoodsMaterialService goodsMaterialService;

	
	@ApiOperation(value = "新增 添加基本原料信息", notes = "添加基本原料信息")
	@RequestMapping(value = "/goodsmaterial", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addGoodsMaterial(HttpServletResponse response,
			@ApiParam(value = "goodsMaterial") @RequestBody GoodsMaterial goodsMaterial) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goodsMaterial, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		goodsMaterial.setMaterialId(null);
		goodsMaterialService.addGoodsMaterial(goodsMaterial);
		return goodsMaterial;
	}
	
	
	@ApiOperation(value = "更新 根据基本原料标识更新基本原料信息", notes = "根据基本原料标识更新基本原料信息")
	@RequestMapping(value = "/goodsmaterial/{materialId:.+}", method = RequestMethod.PUT)
	public Object modifyGoodsMaterialById(HttpServletResponse response,
			@PathVariable Integer materialId,
			@ApiParam(value = "goodsMaterial", required = true) @RequestBody GoodsMaterial goodsMaterial
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(goodsMaterial, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		GoodsMaterial tempGoodsMaterial = goodsMaterialService.queryGoodsMaterialByMaterialId(materialId);
		goodsMaterial.setMaterialId(materialId);
		if(null == tempGoodsMaterial){
			throw new NotFoundException("基本原料");
		}
		return goodsMaterialService.modifyGoodsMaterial(goodsMaterial);
	}

	@ApiOperation(value = "删除 根据基本原料标识删除基本原料信息", notes = "根据基本原料标识删除基本原料信息")
	@RequestMapping(value = "/goodsmaterial/{materialId:.+}", method = RequestMethod.DELETE)
	public Object dropGoodsMaterialByMaterialId(HttpServletResponse response, @PathVariable Integer materialId) {
		GoodsMaterial goodsMaterial = goodsMaterialService.queryGoodsMaterialByMaterialId(materialId);
		if(null == goodsMaterial){
			throw new NotFoundException("基本原料");
		}
		return goodsMaterialService.dropGoodsMaterialByMaterialId(materialId);
	}
	
	@ApiOperation(value = "查询 根据基本原料标识查询基本原料信息", notes = "根据基本原料标识查询基本原料信息")
	@RequestMapping(value = "/goodsmaterial/{materialId:.+}", method = RequestMethod.GET)
	public Object queryGoodsMaterialById(HttpServletResponse response,
			@PathVariable Integer materialId) {
		GoodsMaterial goodsMaterial = goodsMaterialService.queryGoodsMaterialByMaterialId(materialId);
		if(null == goodsMaterial){
			throw new NotFoundException("基本原料");
		}
		return goodsMaterial;
	}
	
	@ApiOperation(value = "查询 根据基本原料属性查询基本原料信息列表", notes = "根据基本原料属性查询基本原料信息列表")
	@RequestMapping(value = "/goodsmaterial", method = RequestMethod.GET)
	public Object queryGoodsMaterialList(HttpServletResponse response,
			GoodsMaterial goodsMaterial) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return goodsMaterialService.queryGoodsMaterialByProperty(ClassUtil.transBean2Map(goodsMaterial, false));
	}
	
	@ApiOperation(value = "查询分页 根据基本原料属性分页查询基本原料信息列表", notes = "根据基本原料属性分页查询基本原料信息列表")
	@RequestMapping(value = "/goodsmaterials", method = RequestMethod.GET)
	public Object queryGoodsMaterialPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, GoodsMaterial goodsMaterial) {				
		return goodsMaterialService.queryGoodsMaterialForPage(pagenum, pagesize, sort, goodsMaterial);
	}

}
