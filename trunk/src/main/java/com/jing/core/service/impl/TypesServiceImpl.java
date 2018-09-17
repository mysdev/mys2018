package com.jing.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.core.model.dao.TypesMapper;
import com.jing.core.model.entity.Types;
import com.jing.core.service.TypesService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: Types
 * @Description: 类型配置服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Service("typesService")
@Transactional(readOnly=true)
public class  TypesServiceImpl implements TypesService {	
//	private static final Logger logger = LoggerFactory.getLogger(TypesServiceImpl.class);
	
	@Autowired
    private TypesMapper typesMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addTypes
	 * @Description:添加类型配置
	 * @param types 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Types addTypes(Types types){
		int ret = typesMapper.addTypes(types);
		if(ret>0){
			return types;
		}
		return null;
	}
	
	/**
	 * @Title modifyTypes
	 * @Description:修改类型配置
	 * @param types 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyTypes(Types types){
		return typesMapper.modifyTypes(types);
	}
	
	/**
	 * @Title: dropTypesByTypeId
	 * @Description:删除类型配置
	 * @param typeId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropTypesByTypeId(Integer typeId){
		return typesMapper.dropTypesByTypeId(typeId);
	}
	
	/**
	 * @Title: queryTypesByTypeId
	 * @Description:根据实体标识查询类型配置
	 * @param typeId 实体标识
	 * @return Types
	 */
	@Override
	public Types queryTypesByTypeId(Integer typeId){
		return typesMapper.queryTypesByTypeId(typeId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryTypesForPage
	 * @Description: 根据类型配置属性与分页信息分页查询类型配置信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param types 实体
	 * @return List<Types>
	 */
	@Override
	public Map<String, Object> queryTypesForPage(Integer pagenum, Integer pagesize, String sort, Types types){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, Types.class);
		List<Types> entityList = typesMapper.queryTypesForPage(pageBounds, types);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, Types.class);
		}
		if (!entityList.isEmpty()) {
			PageList<Types> pagelist = (PageList<Types>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryTypesByProperty
	 * @Description:根据属性查询类型配置
	 * @return List<Types>
	 */
	@Override
	public List<Types> queryTypesByProperty(Map<String, Object> map){
		return typesMapper.queryTypesByProperty(map);
	}


}
