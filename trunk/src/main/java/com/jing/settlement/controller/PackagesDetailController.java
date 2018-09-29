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
import com.jing.settlement.model.entity.PackagesDetail;
import com.jing.settlement.service.PackagesDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 * <b>功能：</b>消费套餐详情 WEB接口<br>
 * <br>
 */
@Api("消费套餐详情")
@Controller
@RequestMapping("/settlement/packagesDetail")
public class PackagesDetailController extends BaseController{

	@Autowired
	private PackagesDetailService packagesDetailService;
	
	@ApiOperation(value = "新增消费套餐详情", notes = "添加消费套餐详情")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(PackagesDetail packagesDetail,@SessionAttr(Config.USER_INFO) User user) {
		packagesDetail.setCreatedBy(user.getUserId());
		packagesDetail.setCreatedDateNow();
		packagesDetail.setUpdatedBy(user.getUserId());
		packagesDetail.setUpdatedDateNow();
		packagesDetailService.addPackagesDetail(packagesDetail);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "修改消费套餐详情", notes = "修改消费套餐详情")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(PackagesDetail packagesDetail,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(packagesDetail==null || packagesDetail.getDetailId()==null || "".equals(packagesDetail.getDetailId())){
			throw new CustomException("缺失修改参数.");
		}
		packagesDetail.setUpdatedBy(user.getUserId());
		packagesDetail.setUpdatedDateNow();
		packagesDetailService.updatePackagesDetail(packagesDetail);
		return Result.getDefaultSuccMsgResult();
	}

	@ApiOperation(value = "删除 根据ID删除消费套餐详情", notes = "根据ID删除消费套餐详情")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		packagesDetailService.deletePackagesDetailById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	@ApiOperation(value = "根据ID查询消费套餐详情", notes = "根据ID查询消费套餐详情")
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@ApiParam("id") @PathVariable("id") Integer id){
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(packagesDetailService.getPackagesDetailById(id));
	}
		
	@ApiOperation(value = "分页查询消费套餐详情", notes = "分页查询消费套餐详情")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return packagesDetailService.findPackagesDetailListPage(PageRequestUtils.getPageBean(request), map);
	}
}