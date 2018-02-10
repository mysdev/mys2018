package com.jing.core.controller;

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
import com.jing.core.model.entity.Strap;
import com.jing.core.service.StrapService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: StrapController
 * @Description: 手牌HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@RestController
@Api(description="手牌", tags={"CoreStrap"})
public class StrapController{

	@Autowired
	BeanValidator beanValidator;
	
	@Autowired
	private StrapService strapService;

	
	@ApiOperation(value = "新增 添加手牌信息", notes = "添加手牌信息")
	@RequestMapping(value = "/strap", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addStrap(HttpServletResponse response,
			@ApiParam(value = "strap") @RequestBody Strap strap) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(strap, true);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		strap.setStrapId(null);
		strapService.addStrap(strap);
		return strap;
	}
	
	
	@ApiOperation(value = "更新 根据手牌标识更新手牌信息", notes = "根据手牌标识更新手牌信息")
	@RequestMapping(value = "/strap/{strapId:.+}", method = RequestMethod.PUT)
	public Object modifyStrapById(HttpServletResponse response,
			@PathVariable String strapId,
			@ApiParam(value = "strap", required = true) @RequestBody Strap strap
			) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(strap, false);
		if(!errors.isEmpty()){
			throw new ParameterException(errors);
		}
		Strap tempStrap = strapService.queryStrapByStrapId(strapId);
		strap.setStrapId(strapId);
		if(null == tempStrap){
			throw new NotFoundException("手牌");
		}
		return strapService.modifyStrap(strap);
	}

	@ApiOperation(value = "删除 根据手牌标识删除手牌信息", notes = "根据手牌标识删除手牌信息")
	@RequestMapping(value = "/strap/{strapId:.+}", method = RequestMethod.DELETE)
	public Object dropStrapByStrapId(HttpServletResponse response, @PathVariable String strapId) {
		Strap strap = strapService.queryStrapByStrapId(strapId);
		if(null == strap){
			throw new NotFoundException("手牌");
		}
		return strapService.dropStrapByStrapId(strapId);
	}
	
	@ApiOperation(value = "查询 根据手牌标识查询手牌信息", notes = "根据手牌标识查询手牌信息")
	@RequestMapping(value = "/strap/{strapId:.+}", method = RequestMethod.GET)
	public Object queryStrapById(HttpServletResponse response,
			@PathVariable String strapId) {
		Strap strap = strapService.queryStrapByStrapId(strapId);
		if(null == strap){
			throw new NotFoundException("手牌");
		}
		return strap;
	}
	
	@ApiOperation(value = "查询 根据手牌属性查询手牌信息列表", notes = "根据手牌属性查询手牌信息列表")
	@RequestMapping(value = "/strap", method = RequestMethod.GET)
	public Object queryStrapList(HttpServletResponse response,
			Strap strap) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		return strapService.queryStrapByProperty(ClassUtil.transBean2Map(strap, false));
	}
	
	@ApiOperation(value = "查询分页 根据手牌属性分页查询手牌信息列表", notes = "根据手牌属性分页查询手牌信息列表")
	@RequestMapping(value = "/straps", method = RequestMethod.GET)
	public Object queryStrapPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize, 
			@RequestParam(value = "sort", required = false) String sort, Strap strap) {				
		return strapService.queryStrapForPage(pagenum, pagesize, sort, strap);
	}

}
