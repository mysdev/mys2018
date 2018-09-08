package com.jing.system.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.system.model.dao.DictionaryMapper;
import com.jing.system.model.entity.Dictionary;
import com.jing.system.model.entity.DictionaryGroup;
import com.jing.system.service.DictionaryGroupService;
import com.jing.system.service.DictionaryService;
import com.jing.system.util.SystemConfigMapper;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Dictionary
 * @Description: 字典值服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时04分
 */
@Service("dictionaryService")
@Transactional(readOnly = true)
public class DictionaryServiceImpl implements DictionaryService {
	private static final Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);

	@Autowired
	private DictionaryMapper dictionaryMapper;
	@Autowired
	private DictionaryGroupService dictionaryGroupService;

	@Autowired
	private PageService pageService; // 分页器

	/**
	 * @Title: addDictionary
	 * @Description:添加字典值
	 * @param dictionary
	 *            实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Dictionary addDictionary(Dictionary dictionary) {
		int ret = dictionaryMapper.addDictionary(dictionary);
		if (ret > 0) {
			com.jing.system.util.DictionaryMapper.setValue(dictionary);
			return dictionary;
		}
		return null;
	}

	/**
	 * @Title modifyDictionary
	 * @Description:修改字典值
	 * @param dictionary
	 *            实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyDictionary(Dictionary dictionary) {
		com.jing.system.util.DictionaryMapper.setValue(dictionary);
		return dictionaryMapper.modifyDictionary(dictionary);
	}

	/**
	 * @Title: dropDictionaryById
	 * @Description:删除字典值
	 * @param id
	 *            实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropDictionaryById(Integer id) {
		return dictionaryMapper.dropDictionaryById(id);
	}

	/**
	 * @Title: queryDictionaryById
	 * @Description:根据实体标识查询字典值
	 * @param id
	 *            实体标识
	 * @return Dictionary
	 */
	@Override
	public Dictionary queryDictionaryById(Integer id) {
		return dictionaryMapper.queryDictionaryById(id);
	}

	/**
	 * @Title: queryDictionaryForPage
	 * @Description: 根据字典值属性与分页信息分页查询字典值信息
	 * @param pagenum
	 *            页
	 * @param pagesize
	 *            页大小
	 * @param sort
	 *            排序
	 * @param dictionary
	 *            实体
	 * @return List<Dictionary>
	 */
	@Override
	public Map<String, Object> queryDictionaryForPage(Integer pagenum, Integer pagesize, String sort,
			Dictionary dictionary) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Dictionary.class);
		List<Dictionary> entityList = dictionaryMapper.queryDictionaryForPage(pageBounds, dictionary);
		if (null != sort && sort.length() > 0) {
			pageBounds.setOrdersByJson(sort, Dictionary.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Dictionary> pagelist = (PageList<Dictionary>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}

	/**
	 * @Title: queryDictionaryByProperty
	 * @Description:根据属性查询字典值
	 * @return List<Dictionary>
	 */
	@Override
	public List<Dictionary> queryDictionaryByProperty(Map<String, Object> map) {
		return dictionaryMapper.queryDictionaryByProperty(map);
	}

	public List<Dictionary> queryDictionaryByGroupCode(String groupCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupCode", groupCode);
		return this.queryDictionaryByProperty(map);
	}

	@SuppressWarnings("resource")
	@Override
	public void refreshDictionaryFile() throws IOException {
		String mapJakcson = com.jing.system.util.DictionaryMapper.getJsonString();
		String data = "var dictionaryObj=" + mapJakcson;
		File file = new File(SystemConfigMapper.getValue("dictionary.file.url"));
		PrintStream ps = new PrintStream(new FileOutputStream(file), false, "UTF-8");
		ps.println(data);// 往文件里写入字符串
	}

}
