package com.jing.system.hodiday.controller;

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
import com.jing.system.hodiday.entity.Hodiday;
import com.jing.system.hodiday.service.HodidayService;
import com.jing.utils.BaseController;

/**
 * <br>
 * <b>功能：</b>节假日 WEB接口<br>
 * <br>
 */
@Controller
@RequestMapping("/sys/hodiday")
public class HodidayController extends BaseController{

	@Autowired
	private HodidayService hodidayService;
	
	/**
	 * 新增保存
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Hodiday hodiday)throws CustomException  {
		hodidayService.addHodiday(hodiday);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Hodiday hodiday)throws CustomException{
		if(hodiday==null || hodiday.getHid()==null || "".equals(hodiday.getHid())){
			throw new CustomException("缺失修改参数.");
		}
		hodidayService.updateHodiday(hodiday);
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
		hodidayService.deleteHodidayById(id);
		return Result.getDefaultSuccMsgResult();
	}
	
	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result get(@PathVariable String id)throws CustomException {
		if(id==null || "".equals(id)){
			throw new CustomException("缺失查询参数.");
		}
		return Result.getDefaultSuccMsgResult(hodidayService.getHodidayById(id));
	}
	
	
	/**
	 * 分页查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findPage(HttpServletRequest request)throws Exception {
		Map<String,Object> map=PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return hodidayService.findHodidayListPage(PageRequestUtils.getPageBean(request), map);
	}
}