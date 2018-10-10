package com.jing.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.core.model.entity.Types;
import com.jing.core.service.TypesService;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.utils.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>类型配置 WEB接口<br>
 * <br>
 */
@Api("类型配置")
@Controller
@RequestMapping("/core/types")
public class TypesController extends BaseController{

	@Autowired
	private TypesService typesService;
	
	@ApiOperation(value = "新增类型配置", notes = "添加类型配置")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Types types,@SessionAttr(Config.USER_INFO) User user) {
		types.setCreatedBy(user.getUserId());
		types.setCreatedDateNow();
		types.setUpdatedBy(user.getUserId());
		types.setUpdatedDateNow();
		typesService.addTypes(types);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改类型配置", notes = "修改类型配置")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Types types,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(types==null || types.getTypeId()==null || "".equals(types.getTypeId())){
			throw new CustomException("缺失修改参数.");
		}
		types.setUpdatedBy(user.getUserId());
		types.setUpdatedDateNow();
		typesService.updateTypes(types);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除类型配置", notes = "根据ID删除类型配置")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		typesService.deleteTypesById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询类型配置", notes = "根据ID查询类型配置")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(typesService.getTypesById(id));
	}
		
	@ApiOperation(value = "分页查询类型配置", notes = "分页查询类型配置")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return typesService.findTypesListPage(PageRequestUtils.getPageBean(request), map);
	}
	
	@ApiOperation(value = "查询类型体系", notes = "查询类型体系")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Result all(){
		return Result.getDefaultSuccMsgResult(typesService.findTypesList(new HashMap<>()));
	}
}