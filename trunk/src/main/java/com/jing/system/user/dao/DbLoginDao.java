package com.jing.system.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jing.system.user.entity.User;

@Mapper
public interface DbLoginDao {

	User login(@Param("userName") String userName, @Param("password") String password);
	
	User getUserDetailByName(@Param("userName") String userName);
}
