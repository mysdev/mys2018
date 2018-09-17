package com.jing.settlement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jing.settlement.model.dao.GoodsExtMapper;
import com.jing.settlement.model.entity.GoodsExt;
import com.jing.settlement.service.GoodsExtService;
import com.jing.utils.Constant;
import com.jing.utils.paginator.domain.PageBounds;
import com.jing.utils.paginator.domain.PageList;
import com.jing.utils.paginator.domain.PageService;

/**
 * @ClassName: GoodsExt
 * @Description: 商品服务扩展服务实现类
 * @author: Jinlong He
 * @email: mailto:jinlong_he@126.com
 * @date: 2018年01月11日 15时03分
 */
@Service("goodsExtService")
@Transactional(readOnly=true)
public class  GoodsExtServiceImpl implements GoodsExtService {	
//	private static final Logger logger = LoggerFactory.getLogger(GoodsExtServiceImpl.class);
	
	@Autowired
    private GoodsExtMapper goodsExtMapper;   
    
	@Autowired
	private PageService pageService; // 分页器
	
	
	/**
	 * @Title: addGoodsExt
	 * @Description:添加商品服务扩展
	 * @param goodsExt 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public GoodsExt addGoodsExt(GoodsExt goodsExt){
		goodsExt.setGoodsId(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		int ret = goodsExtMapper.addGoodsExt(goodsExt);
		if(ret>0){
			return goodsExt;
		}
		return null;
	}
	
	/**
	 * @Title modifyGoodsExt
	 * @Description:修改商品服务扩展
	 * @param goodsExt 实体
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer modifyGoodsExt(GoodsExt goodsExt){
		return goodsExtMapper.modifyGoodsExt(goodsExt);
	}
	
	/**
	 * @Title: dropGoodsExtByGoodsId
	 * @Description:删除商品服务扩展
	 * @param goodsId 实体标识
	 * @return Integer
	 */
	@Override
	@Transactional(readOnly = false)
	public Integer dropGoodsExtByGoodsId(String goodsId){
		return goodsExtMapper.dropGoodsExtByGoodsId(goodsId);
	}
	
	/**
	 * @Title: queryGoodsExtByGoodsId
	 * @Description:根据实体标识查询商品服务扩展
	 * @param goodsId 实体标识
	 * @return GoodsExt
	 */
	@Override
	public GoodsExt queryGoodsExtByGoodsId(String goodsId){
		return goodsExtMapper.queryGoodsExtByGoodsId(goodsId);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 
	/**
	 * @Title: queryGoodsExtForPage
	 * @Description: 根据商品服务扩展属性与分页信息分页查询商品服务扩展信息
	 * @param pagenum 页 
	 * @param pagesize 页大小 
	 * @param sort 排序
	 * @param goodsExt 实体
	 * @return List<GoodsExt>
	 */
	@Override
	public Map<String, Object> queryGoodsExtForPage(Integer pagenum, Integer pagesize, String sort, GoodsExt goodsExt){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		PageBounds pageBounds = pageService.getPageBounds(pagenum, pagesize, null, true, false);
		pageBounds.setOrdersByJson(sort, GoodsExt.class);
		List<GoodsExt> entityList = goodsExtMapper.queryGoodsExtForPage(pageBounds, goodsExt);
		if(null!=sort && sort.length()>0){
			pageBounds.setOrdersByJson(sort, GoodsExt.class);
		}
		if (!entityList.isEmpty()) {
			PageList<GoodsExt> pagelist = (PageList<GoodsExt>) entityList;
			returnMap.put(Constant.PAGELIST, entityList);
			returnMap.put(Constant.PAGINATOR, pagelist.getPaginator());
		}
		return returnMap;
	}
	 
	/**
	 * @Title: queryGoodsExtByProperty
	 * @Description:根据属性查询商品服务扩展
	 * @return List<GoodsExt>
	 */
	@Override
	public List<GoodsExt> queryGoodsExtByProperty(Map<String, Object> map){
		return goodsExtMapper.queryGoodsExtByProperty(map);
	}


}
