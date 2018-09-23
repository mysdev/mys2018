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
import com.jing.core.model.entity.Strap;
import com.jing.core.service.StrapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>手牌 WEB接口<br>
 * <br>
 */
@Api("手牌")
@Controller
@RequestMapping("/core/strap")
public class StrapController extends BaseController{

	@Autowired
	private StrapService strapService;
	
	@ApiOperation(value = "新增手牌", notes = "添加手牌")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Strap strap,@SessionAttr(Config.USER_INFO) User user) {
		strap.setCreatedBy(user.getUserId());
		strap.setCreatedDateNow();
		strap.setUpdatedBy(user.getUserId());
		strap.setUpdatedDateNow();
		strapService.addStrap(strap);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改手牌", notes = "修改手牌")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Strap strap,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(strap==null || strap.getStrapId()==null || "".equals(strap.getStrapId())){
			throw new CustomException("缺失修改参数.");
		}
		strap.setUpdatedBy(user.getUserId());
		strap.setUpdatedDateNow();
		strapService.updateStrap(strap);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除手牌", notes = "根据ID删除手牌")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		strapService.deleteStrapById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询手牌", notes = "根据ID查询手牌")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(strapService.getStrapById(id));
	}
		
	@ApiOperation(value = "分页查询手牌", notes = "分页查询手牌")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return strapService.findStrapListPage(PageRequestUtils.getPageBean(request), map);
	}
}