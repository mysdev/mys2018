package com.jing.system.permission.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.system.permission.entity.Resources;
import com.jing.system.permission.entity.VResources;
import com.jing.system.permission.service.ResourcesService;
import com.jing.utils.BaseController;

import io.swagger.annotations.Api;

/**
 * <br>
 * <b>功能：</b>系统资源（菜单、按钮） WEB接口<br>
 * <br>
 */
@Api("系统资源")
@Controller
@RequestMapping("/sys/permission/resources")
public class ResourcesController extends BaseController{

	@Autowired
	private ResourcesService resourcesService;
	
	/**
	 * 查询权限资源树[同步的一次性查询]
	 */
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public @ResponseBody Result tree(Resources resources)throws CustomException  {
		List<Resources> list = resourcesService.getResourcesList();
		Resources res = new Resources();
		res.setResId(0);
		res.setResName("系统根节点");
		list.add(res);
		return Result.getDefaultSuccMsgResult(list);
	}
	
	/**
	 * 查询权限资源树[同步的一次性查询]
	 */
	@RequestMapping(value = "/listWithRole", method = RequestMethod.GET)
	public @ResponseBody Result tree(@RequestParam("roleId")String roleId)throws CustomException  { 
		List<VResources> list = resourcesService.getVResourcesList(roleId); 
		VResources res = new VResources();
		res.setResId(0);
		res.setResName("系统根节点");
		list.add(res);
		return Result.getDefaultSuccMsgResult(list);
	}
	
	/**
	 * 新增保存
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Resources resources)throws CustomException  {
		resourcesService.addResources(resources);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Resources resources)throws CustomException{
		if(resources==null || resources.getResId()==null ){
			throw new CustomException("缺失修改参数.");
		}
		resourcesService.updateResources(resources);
		return Result.getDefaultSuccMsgResult();
	}

	
	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result delete(@PathVariable("id") int id)throws CustomException {
		resourcesService.deleteResourcesById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{resId}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable("resId") int id)throws CustomException {
		return Result.getDefaultSuccMsgResult(resourcesService.getResourcesById(id));
	}
	
	
	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return resourcesService.findResourcesListPage(PageRequestUtils.getPageBean(request), map);
	}
}