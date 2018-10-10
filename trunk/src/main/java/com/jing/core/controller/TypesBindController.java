package com.jing.core.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.utils.BaseController;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.user.entity.User;
import com.jing.core.model.entity.TypesBind;
import com.jing.core.service.TypesBindService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>类型消费绑定 WEB接口<br>
 * <br>
 */
@Api("类型消费绑定")
@Controller
@RequestMapping("/core/types/bind")
public class TypesBindController extends BaseController{

	@Autowired
	private TypesBindService typesBindService;
	
	@ApiOperation(value = "新增类型消费绑定", notes = "添加类型消费绑定")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(TypesBind typesBind,@SessionAttr(Config.USER_INFO) User user) {
		typesBind.setCreatedBy(user.getUserId());
		typesBind.setCreatedDateNow();
		typesBind.setUpdatedBy(user.getUserId());
		typesBind.setUpdatedDateNow();
		typesBindService.addTypesBind(typesBind);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改类型消费绑定", notes = "修改类型消费绑定")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(TypesBind typesBind,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(typesBind==null || typesBind.getBindId()==null || "".equals(typesBind.getBindId())){
			throw new CustomException("缺失修改参数.");
		}
		typesBind.setUpdatedBy(user.getUserId());
		typesBind.setUpdatedDateNow();
		typesBindService.updateTypesBind(typesBind);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除类型消费绑定", notes = "根据ID删除类型消费绑定")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		typesBindService.deleteTypesBindById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询类型消费绑定", notes = "根据ID查询类型消费绑定")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(typesBindService.getTypesBindById(id));
	}
		
	@ApiOperation(value = "分页查询类型消费绑定", notes = "分页查询类型消费绑定")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return typesBindService.findTypesBindListPage(PageRequestUtils.getPageBean(request), map);
	}
}