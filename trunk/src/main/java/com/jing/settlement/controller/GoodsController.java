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
import com.jing.settlement.model.entity.Goods;
import com.jing.settlement.service.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>商品服务 WEB接口<br>
 * <br>
 */
@Api("商品服务")
@Controller
@RequestMapping("/settlement/goods")
public class GoodsController extends BaseController{

	@Autowired
	private GoodsService goodsService;
	
	@ApiOperation(value = "新增商品服务", notes = "添加商品服务")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Goods goods,@SessionAttr(Config.USER_INFO) User user) {
		goods.setCreatedBy(user.getUserId());
		goods.setCreatedDateNow();
		goods.setUpdatedBy(user.getUserId());
		goods.setUpdatedDateNow();
		goodsService.addGoods(goods);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改商品服务", notes = "修改商品服务")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Goods goods,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(goods==null || goods.getGoodsId()==null || "".equals(goods.getGoodsId())){
			throw new CustomException("缺失修改参数.");
		}
		goods.setUpdatedBy(user.getUserId());
		goods.setUpdatedDateNow();
		goodsService.updateGoods(goods);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除商品服务", notes = "根据ID删除商品服务")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		goodsService.deleteGoodsById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询商品服务", notes = "根据ID查询商品服务")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") String id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(goodsService.getGoodsById(id));
	}
		
	@ApiOperation(value = "分页查询商品服务", notes = "分页查询商品服务")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return goodsService.findGoodsListPage(PageRequestUtils.getPageBean(request), map);
	}
}