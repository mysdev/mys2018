package com.jing.core.service;

import java.util.List;
import java.util.Map;


import com.jing.core.model.entity.TypesBind;

/**
 * @ClassName: TypesBind
 * @Description: 类型消费绑定服务接口
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
public interface TypesBindService {

    /**
	 * @Title: addTypesBind
	 * @Description:添加类型消费绑定
	 * @param typesBind 实体
	 * @return Integer
	 */
	TypesBind addTypesBind(TypesBind typesBind);
	
	/**
	 * @Title modifyTypesBind
	 * @Description:修改类型消费绑定
	 * @param typesBind 实体
	 * @return Integer
	 */
	Integer modifyTypesBind(TypesBind typesBind);
	
	/**
	 * @Title: dropTypesBindByBindId
	 * @Description:删除类型消费绑定
	 * @param bindId 实体标识
	 * @return Integer
	 */
	Integer dropTypesBindByBindId(Integer bindId);
	
	/**
	 * @Title: queryTypesBindByBindId
	 * @Description:根据实体标识查询类型消费绑定
	 * @param bindId 实体标识
	 * @return TypesBind
	 */
	TypesBind queryTypesBindByBindId(Integer bindId);
	 
	/**
	 * @Title: queryTypesBindForPage
	 * @Description: 根据类型消费绑定属性与分页信息分页查询类型消费绑定信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param typesBind 实体
	 * @return List<TypesBind>
	 */
	Map<String, Object> queryTypesBindForPage(Integer pagenum, Integer pagesize, String sort, TypesBind typesBind);
	 
	 /**
	 * @Title: queryTypesBindByProperty
	 * @Description:根据属性查询类型消费绑定
	 * @return List<TypesBind>
	 */
	 List<TypesBind> queryTypesBindByProperty(Map<String, Object> map);	 
	 
}
