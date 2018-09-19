package com.jing.system.hodiday.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.config.web.page.PageInfo;
import com.jing.system.hodiday.entity.Hodiday;

@Mapper
public interface HodidayDao {

	/**
	* 添加 节假日
	*/
	void addHodiday(Hodiday hodiday);
	
	/**
	* 修改 节假日
	*/
	void updateHodiday(Hodiday hodiday);
	
	/**
	*根据ID删除记录
	*/
	void deleteHodidayById(String id);	
	
	/**
	*根据ID查询记录
	*/
	Hodiday getHodidayById(String id);
	
	/**
	* 分页查询
	*/
	List<Hodiday> findHodidayListPage(@Param("page") PageInfo page, @Param("param") Map<String, Object> param);
	
	
	/**
	 * 根据属性查询节假日
	 * @param param
	 * @return
	 */
	List<Hodiday> findHodidayList(@Param("param") Map<String, Object> param);	
}