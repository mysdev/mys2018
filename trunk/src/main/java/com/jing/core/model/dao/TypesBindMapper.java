package com.jing.core.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.core.model.entity.TypesBind;

/**
 * @ClassName: TypesBindMapper
 * @Description: 类型消费绑定映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时02分
 */
@Mapper
public interface TypesBindMapper {

	/**
	 * @Title: addTypesBind
	 * @Description:添加类型消费绑定
	 * @param typesBind 实体
	 * @return Integer
	 */
	Integer addTypesBind(TypesBind typesBind);
	
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
	 * @param pageBounds 分页信息
	 * @param typesBind 实体
	 * @return List<TypesBind>
	 */
	List<TypesBind> queryTypesBindForPage(PageBounds pageBounds, @Param("typesBind") TypesBind typesBind);
	 
	 /**
	  * @Title: queryTypesBindByProperty
	  * @Description:根据属性查询类型消费绑定
	  * @return List<TypesBind>
	  */
	 List<TypesBind> queryTypesBindByProperty(@Param("typesBind") Map<String, Object> map);
	 
	 
	 
}
