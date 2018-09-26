package com.jing.settlement.controller;

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
import com.jing.settlement.model.entity.GoodsMaterial;
import com.jing.settlement.service.GoodsMaterialService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>基本原料 WEB接口<br>
 * <br>
 */
@Api("基本原料")
@Controller
@RequestMapping("/settlement/goodsMaterial")
public class GoodsMaterialController extends BaseController{

	@Autowired
	private GoodsMaterialService goodsMaterialService;
	
	@ApiOperation(value = "新增基本原料", notes = "添加基本原料")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(GoodsMaterial goodsMaterial,@SessionAttr(Config.USER_INFO) User user) {
		goodsMaterial.setCreatedBy(user.getUserId());
		goodsMaterial.setCreatedDateNow();
		goodsMaterial.setUpdatedBy(user.getUserId());
		goodsMaterial.setUpdatedDateNow();
		goodsMaterialService.addGoodsMaterial(goodsMaterial);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改基本原料", notes = "修改基本原料")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(GoodsMaterial goodsMaterial,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(goodsMaterial==null || goodsMaterial.getMaterialId()==null || "".equals(goodsMaterial.getMaterialId())){
			throw new CustomException("缺失修改参数.");
		}
		goodsMaterial.setUpdatedBy(user.getUserId());
		goodsMaterial.setUpdatedDateNow();
		goodsMaterialService.updateGoodsMaterial(goodsMaterial);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除基本原料", notes = "根据ID删除基本原料")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		goodsMaterialService.deleteGoodsMaterialById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询基本原料", notes = "根据ID查询基本原料")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(goodsMaterialService.getGoodsMaterialById(id));
	}
		
	@ApiOperation(value = "分页查询基本原料", notes = "分页查询基本原料")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return goodsMaterialService.findGoodsMaterialListPage(PageRequestUtils.getPageBean(request), map);
	}
}