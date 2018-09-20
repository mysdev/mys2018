package com.jing.codeing.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.codeing.entity.Tables;
import com.jing.codeing.service.TablesService;
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
@RequestMapping("/codeing/tables")
public class TablesController extends BaseController {

	@Autowired(required = false)
	private TablesService tablesService;

	/**
	 * 新增保存
	 * 
	 * @return
	 * @throws CustomException 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Result add(Tables tables) throws CustomException {
		tablesService.addTables(tables);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 新增保存[读取数据库物理表结构，然后 添加表格]
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add/{tableName}", method = RequestMethod.POST)
	public @ResponseBody Result add(@PathVariable("tableName") String tableName) throws CustomException {
		tablesService.addTables(tableName);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 修改保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Result update(Tables tables) {
		tablesService.updateTables(tables);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Result deleteTablesById(@PathVariable("id") String id) {
		tablesService.deleteTablesById(id);
		return Result.getDefaultSuccMsgResult();
	}

	/**
	 * ID查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public @ResponseBody Result getTablesById(@PathVariable("id") String id) {
		return Result.getDefaultSuccMsgResult(tablesService.getTablesById(id));
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
		return tablesService.findTablesPage(PageRequestUtils.getPageBean(request), map);
	}

	/**
	 * 属性查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody Result findTablesByProperty(HttpServletRequest request) {
		Map<String, Object> map = PageRequestUtils.getStringMapFromStringsMap(request.getParameterMap());
		return Result.getDefaultSuccMsgResult(tablesService.findTablesByProperty(map));
	}

}
