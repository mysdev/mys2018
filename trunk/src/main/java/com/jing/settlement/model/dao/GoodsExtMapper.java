package com.jing.settlement.model.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.utils.paginator.domain.PageBounds;
import com.jing.settlement.model.entity.GoodsExt;

/**
 * @ClassName: GoodsExtMapper
 * @Description: 商品服务扩展映射
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Mapper
public interface GoodsExtMapper {

	/**
	 * @Title: addGoodsExt
	 * @Description:添加商品服务扩展
	 * @param goodsExt 实体
	 * @return Integer
	 */
	Integer addGoodsExt(GoodsExt goodsExt);
	
	/**
	 * @Title modifyGoodsExt
	 * @Description:修改商品服务扩展
	 * @param goodsExt 实体
	 * @return Integer
	 */
	Integer modifyGoodsExt(GoodsExt goodsExt);
	
	/**
	 * @Title: dropGoodsExtByGoodsId
	 * @Description:删除商品服务扩展
	 * @param goodsId 实体标识
	 * @return Integer
	 */
	Integer dropGoodsExtByGoodsId(String goodsId);
	
	/**
	 * @Title: queryGoodsExtByGoodsId
	 * @Description:根据实体标识查询商品服务扩展
	 * @param goodsId 实体标识
	 * @return GoodsExt
	 */
	GoodsExt queryGoodsExtByGoodsId(String goodsId);
	 
	/**
	 * @Title: queryGoodsExtForPage
	 * @Description: 根据商品服务扩展属性与分页信息分页查询商品服务扩展信息
	 * @param pageBounds 分页信息
	 * @param goodsExt 实体
	 * @return List<GoodsExt>
	 */
	List<GoodsExt> queryGoodsExtForPage(PageBounds pageBounds, @Param("goodsExt") GoodsExt goodsExt);
	 
	 /**
	  * @Title: queryGoodsExtByProperty
	  * @Description:根据属性查询商品服务扩展
	  * @return List<GoodsExt>
	  */
	 List<GoodsExt> queryGoodsExtByProperty(@Param("goodsExt") Map<String, Object> map);
	 
	 
	 
}
