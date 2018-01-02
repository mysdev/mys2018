package com.jing.system.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;


import com.jing.system.model.entity.Dictionary;
import com.jing.system.model.dao.DictionaryMapper;
import com.jing.system.service.DictionaryService;

/**
 * @ClassName: Dictionary
 * @Description: 字典值服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月02日 11时16分
 */
@Service("dictionaryService")
@Transactional(readOnly=true)
public class  DictionaryServiceImpl implements DictionaryService {

	@Autowired
    private DictionaryMapper dictionaryMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addDictionary
	 * @Description:添加字典值
	 * @param dictionary 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Dictionary addDictionary(Dictionary dictionary){
		int ret = dictionaryMapper.addDictionary(dictionary);
		if(ret>0){
			return dictionary;
		}
		return null;
	}
	
	/**
	 * @Title modifyDictionary
	 * @Description:修改字典值
	 * @param dictionary 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyDictionary(Dictionary dictionary){
		return dictionaryMapper.modifyDictionary(dictionary);
	}
	
	/**
	 * @Title: dropDictionaryById
	 * @Description:删除字典值
	 * @param id 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropDictionaryById(Integer id){
		return dictionaryMapper.dropDictionaryById(id);
	}
	
	/**
	 * @Title: queryDictionaryById
	 * @Description:根据实体标识查询字典值
	 * @param id 实体标识
	 * @return Dictionary
	 */
	@Override
	public Dictionary queryDictionaryById(Integer id){
		return dictionaryMapper.queryDictionaryById(id);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryDictionaryForPage
	 * @Description: 根据字典值属性与分页信息分页查询字典值信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param dictionary 实体
	 * @return List<Dictionary>
	 */
	@Override
	public Map<String, Object> queryDictionaryForPage(Integer pagenum, Integer pagesize, String sort, Dictionary dictionary){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Dictionary.class);
		List<Dictionary> entityList = dictionaryMapper.queryDictionaryForPage(pageBounds, dictionary);
		if(null!=sort && sort.length()>0){
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
	public List<Dictionary> queryDictionaryByProperty(Map<String, Object> map){
		return dictionaryMapper.queryDictionaryByProperty(map);
	}


}
