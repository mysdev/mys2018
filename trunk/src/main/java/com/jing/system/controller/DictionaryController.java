package com.jing.system.controller;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jing.config.validation.BeanValidator;
import com.jing.config.web.exception.NotFoundException;
import com.jing.config.web.exception.ParameterException;
import com.jing.system.model.entity.Dictionary;
import com.jing.system.service.DictionaryService;
import com.jing.utils.ClassUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: DictionaryController
 * @Description: 字典值HTTP接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@RestController
@Api(description = "字典值", tags={"SystemDictionary"})
public class DictionaryController {

	@Autowired
	BeanValidator beanValidator;

	@Autowired
	private DictionaryService dictionaryService;

	@ApiOperation(value = "新增 添加字典值信息", notes = "添加字典值信息")
	@RequestMapping(value = "/dictionary", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public Object addDictionary(HttpServletResponse response,
			@ApiParam(value = "dictionary") @RequestBody Dictionary dictionary)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(dictionary, true);
		if (!errors.isEmpty()) {
			throw new ParameterException(errors);
		}
		dictionary.setId(null);
		dictionaryService.addDictionary(dictionary);
		return dictionary;
	}

	@ApiOperation(value = "更新 根据字典值标识更新字典值信息", notes = "根据字典值标识更新字典值信息")
	@RequestMapping(value = "/dictionary/{id:.+}", method = RequestMethod.PUT)
	public Object modifyDictionaryById(HttpServletResponse response, @PathVariable Integer id,
			@ApiParam(value = "dictionary", required = true) @RequestBody Dictionary dictionary)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Map<String, String>> errors = beanValidator.validateClassAuto(dictionary, false);
		if (!errors.isEmpty()) {
			throw new ParameterException(errors);
		}
		Dictionary tempDictionary = dictionaryService.queryDictionaryById(id);
		dictionary.setId(id);
		if (null == tempDictionary) {
			throw new NotFoundException("字典值");
		}
		return dictionaryService.modifyDictionary(dictionary);
	}

	@ApiOperation(value = "删除 根据字典值标识删除字典值信息", notes = "根据字典值标识删除字典值信息")
	@RequestMapping(value = "/dictionary/{id:.+}", method = RequestMethod.DELETE)
	public Object dropDictionaryById(HttpServletResponse response, @PathVariable Integer id) {
		Dictionary dictionary = dictionaryService.queryDictionaryById(id);
		if (null == dictionary) {
			throw new NotFoundException("字典值");
		}
		return dictionaryService.dropDictionaryById(id);
	}

	@ApiOperation(value = "查询 根据字典值标识查询字典值信息", notes = "根据字典值标识查询字典值信息")
	@RequestMapping(value = "/dictionary/{id:.+}", method = RequestMethod.GET)
	public Object queryDictionaryById(HttpServletResponse response, @PathVariable Integer id) {
		Dictionary dictionary = dictionaryService.queryDictionaryById(id);
		if (null == dictionary) {
			throw new NotFoundException("字典值");
		}
		return dictionary;
	}

	@ApiOperation(value = "查询 根据字典值属性查询字典值信息列表", notes = "根据字典值属性查询字典值信息列表")
	@RequestMapping(value = "/dictionary", method = RequestMethod.GET)
	public Object queryDictionaryList(HttpServletResponse response, Dictionary dictionary)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return dictionaryService.queryDictionaryByProperty(ClassUtil.transBean2Map(dictionary, false));
	}

	@ApiOperation(value = "查询分页 根据字典值属性分页查询字典值信息列表", notes = "根据字典值属性分页查询字典值信息列表")
	@RequestMapping(value = "/dictionarys", method = RequestMethod.GET)
	public Object queryDictionaryPage(HttpServletResponse response,
			@RequestParam(value = "pageNo", required = false) Integer pagenum,
			@RequestParam(value = "pageSize", required = false) Integer pagesize,
			@RequestParam(value = "sort", required = false) String sort, Dictionary dictionary) {
		return dictionaryService.queryDictionaryForPage(pagenum, pagesize, sort, dictionary);
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value = "刷新数据字典缓存js文件", notes = "刷新数据字典缓存js文件")
	@RequestMapping(value = "/dictionary/refresh", method = RequestMethod.GET)
	public Object refreshDictionaryFile() throws IOException {
		dictionaryService.refreshDictionaryFile();
		return true;
	}
}
