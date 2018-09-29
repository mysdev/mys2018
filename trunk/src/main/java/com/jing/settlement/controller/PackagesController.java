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
import com.jing.settlement.model.entity.Packages;
import com.jing.settlement.service.PackagesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>消费套餐 WEB接口<br>
 * <br>
 */
@Api("消费套餐")
@Controller
@RequestMapping("/settlement/packages")
public class PackagesController extends BaseController{

	@Autowired
	private PackagesService packagesService;
	
	@ApiOperation(value = "新增消费套餐", notes = "添加消费套餐")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Packages packages,@SessionAttr(Config.USER_INFO) User user) {
		packages.setCreatedBy(user.getUserId());
		packages.setCreatedDateNow();
		packages.setUpdatedBy(user.getUserId());
		packages.setUpdatedDateNow();
		packagesService.addPackages(packages);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改消费套餐", notes = "修改消费套餐")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Packages packages,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(packages==null || packages.getPackageId()==null || "".equals(packages.getPackageId())){
			throw new CustomException("缺失修改参数.");
		}
		packages.setUpdatedBy(user.getUserId());
		packages.setUpdatedDateNow();
		packagesService.updatePackages(packages);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除消费套餐", notes = "根据ID删除消费套餐")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		packagesService.deletePackagesById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询消费套餐", notes = "根据ID查询消费套餐")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(packagesService.getPackagesById(id));
	}
		
	@ApiOperation(value = "分页查询消费套餐", notes = "分页查询消费套餐")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return packagesService.findPackagesListPage(PageRequestUtils.getPageBean(request), map);
	}
}