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
import com.jing.settlement.model.entity.GoodsUnit;
import com.jing.settlement.service.GoodsUnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>商品单位 WEB接口<br>
 * <br>
 */
@Api("商品单位")
@Controller
@RequestMapping("/settlement/goodsUnit")
public class GoodsUnitController extends BaseController{

	@Autowired
	private GoodsUnitService goodsUnitService;
	
	@ApiOperation(value = "新增商品单位", notes = "添加商品单位")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(GoodsUnit goodsUnit,@SessionAttr(Config.USER_INFO) User user) {
		goodsUnit.setCreatedBy(user.getUserId());
		goodsUnit.setCreatedDateNow();
		goodsUnit.setUpdatedBy(user.getUserId());
		goodsUnit.setUpdatedDateNow();
		goodsUnitService.addGoodsUnit(goodsUnit);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改商品单位", notes = "修改商品单位")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(GoodsUnit goodsUnit,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(goodsUnit==null || goodsUnit.getUnitId()==null || "".equals(goodsUnit.getUnitId())){
			throw new CustomException("缺失修改参数.");
		}
		goodsUnit.setUpdatedBy(user.getUserId());
		goodsUnit.setUpdatedDateNow();
		goodsUnitService.updateGoodsUnit(goodsUnit);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除商品单位", notes = "根据ID删除商品单位")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		goodsUnitService.deleteGoodsUnitById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询商品单位", notes = "根据ID查询商品单位")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(goodsUnitService.getGoodsUnitById(id));
	}
		
	@ApiOperation(value = "分页查询商品单位", notes = "分页查询商品单位")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return goodsUnitService.findGoodsUnitListPage(PageRequestUtils.getPageBean(request), map);
	}
	
	@ApiOperation(value = "属性查询商品单位", notes = "属性查询商品单位")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Result list(HttpServletRequest request) {
		Map<String,Object> param=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return Result.getDefaultSuccMsgResult(goodsUnitService.findGoodsUnitList(param));
	}
}