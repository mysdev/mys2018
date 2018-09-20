package com.jing.codeing.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.codeing.entity.Columns;
import com.jing.codeing.service.ColumnsService;
import com.jing.config.web.Result;
import com.jing.config.web.exception.CustomException;
import com.jing.config.web.page.PageInfo;
import com.jing.config.web.page.PageRequestUtils;
import com.jing.utils.BaseController;

/**
 * 
 * <br>
 * <b>功能：</b>TablesController<br>
 * <br>
 */
@Controller
@RequestMapping("/codeing/columns")
public class ColumnsController extends BaseController {

	@Autowired(required=false)
	private ColumnsService columnsService;

	/**
	 * 新增保存
	 * 
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody Result add(Columns culums)throws CustomException  {
			columnsService.addColumns(culums);
			return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Columns culums)throws CustomException{
			columnsService.updateColumns(culums);
			return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result deleteColumnsById(@PathVariable("id") String id)throws CustomException {
			columnsService.deleteColumnsById(id);
			return Result.getDefaultSuccMsgResult();
	}

	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result getColumnsById(@PathVariable("id") String id)throws CustomException {
			return Result.getDefaultSuccMsgResult(columnsService.getColumnsById(id));
	}
	
	
	/**
	 * 分页查询
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public @ResponseBody PageInfo findTablesPage(HttpServletRequest request) throws Exception {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return columnsService.findColumnsPageList(map, PageRequestUtils.getPageBean(request));
	}

	/**
	 * 属性查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Result findColumnsByProperty(HttpServletRequest request)throws CustomException {
			Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
			return Result.getDefaultSuccMsgResult(columnsService.findColumnsByProperty(map));
	}
}
