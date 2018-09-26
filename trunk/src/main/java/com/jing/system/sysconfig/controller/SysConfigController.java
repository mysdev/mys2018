package com.jing.system.sysconfig.controller;

import java.util.Date;
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
import com.jing.system.login.session.Config;
import com.jing.system.login.session.SessionAttr;
import com.jing.system.sysconfig.SysConfigMapper;
import com.jing.system.sysconfig.entity.SysConfig;
import com.jing.system.sysconfig.service.SysConfigService;
import com.jing.system.user.entity.User;
import com.jing.utils.BaseController;

import io.swagger.annotations.Api;

/**
 * <br>
 * <b>功能：</b>系统参数 WEB接口<br>
 * <br>
 */
@Api("系统配置")
@Controller
@RequestMapping("/sys/sysConfig")
public class SysConfigController extends BaseController{

	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 新增保存
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(SysConfig sysConfig,@SessionAttr(Config.USER_INFO) User user)throws CustomException  {
		sysConfig.setCreatedBy(user.getUserId());
		sysConfig.setUpdatedBy(user.getUserId());
		sysConfig.setCreatedDate(new Date());
		sysConfig.setUpdatedDate(new Date());
		sysConfigService.addSysConfig(sysConfig);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(SysConfig sysConfig,@SessionAttr(Config.USER_INFO) User user)throws CustomException{
		if(sysConfig==null || sysConfig.getPid()==null ){
			throw new CustomException("缺失修改参数.");
		}
		sysConfig.setCreatedBy(user.getUserId());
		sysConfig.setUpdatedBy(user.getUserId());
		sysConfig.setCreatedDate(new Date());
		sysConfig.setUpdatedDate(new Date());
		sysConfigService.updateSysConfig(sysConfig);
		return Result.getDefaultSuccMsgResult();
	}

	
	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") String id)throws CustomException {
		if(id==null || "".equals(id)){
			throw new CustomException("缺失删除参数.");
		}
		sysConfigService.deleteSysConfigById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("id") String id)throws CustomException {
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(sysConfigService.getSysConfigById(id));
	}
	
	/**
	 * Code查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cache/{pcode}", method = RequestMethod.GET)
	public @ResponseBody Result get2(@PathVariable("pcode") String pcode)throws CustomException {
		if(pcode==null || "".equals(pcode)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(SysConfigMapper.getValue(pcode));
	}
	
	
	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return sysConfigService.findSysConfigListPage(PageRequestUtils.getPageBean(request), map);
	}
}