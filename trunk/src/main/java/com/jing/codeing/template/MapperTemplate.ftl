<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packge}.dao.${className}Dao">

	<!-- Result Map -->
	<resultMap id="${className}ResultMap" type="${packge}.entity.${className}">
#foreach( $col in $!{columns} ) 
#if($!col.cid == $!primaryKey.cid)
		<id column="${col.columnName}" property="${col.filedName}" />
#else
		<result column="${col.columnName}" property="${col.filedName}" />
#end
#end
	</resultMap>
	
	<sql id="query_tables_Property" >
		<where>
#foreach( $col in $!{columns} ) 
			<if test="param.${col.filedName} != null and param.${col.filedName} != ''">
				and ${col.columnName} = #{param.${col.filedName}}
			</if>
#end
		</where>
	</sql>

	<!-- 添加 ${comment} -->
	<insert id="add${className}" parameterType="${packge}.entity.${className}">
#if($!primaryKey.filedType == "Integer")
		<selectKey keyProperty="${primaryKey.filedName}" order="AFTER" resultType="java.lang.Integer">
			SELECT LAST_INSERT_ID()
		</selectKey>
#end
		INSERT INTO ${tableName} (#foreach( $col in $!{columns} )#if($!col.cid != $!primaryKey.cid),#end${col.columnName} #end) 
		values
		(#foreach( $col in $!{columns} )
#if($!col.cid != $!primaryKey.cid),#end#{${col.filedName}}#end)
	</insert>

	<!-- 修改${comment} -->
	<update id="update${className}" parameterType="${packge}.entity.${className}">
		UPDATE ${tableName}
		<set> 
#foreach( $col in $!{columns} )
#if(${col.filedName} != ${primaryKey.filedName})
			<if test="${col.columnName} != null" >
				${col.columnName} = #{${col.filedName}},
			</if>
#end
#end
		</set>
		WHERE	${primaryKey.columnName} = #{${primaryKey.filedName}}
	</update>
	
	<!-- 根据ID删除${comment} -->
	<delete id="delete${className}ById"  parameterType="${primaryKey.filedType}">
		DELETE FROM ${tableName} WHERE ${primaryKey.columnName} = #{value}
	</delete>
	
	<!-- 根据ID查询${comment} -->
	<select id="get${className}ById" resultMap="${className}ResultMap" parameterType="${primaryKey.filedType}">
		SELECT * FROM ${tableName} WHERE ${primaryKey.columnName} = #{value}
	</select>
	
	<select id="find${className}ListPage" resultMap="${className}ResultMap">
		SELECT * FROM ${tableName}
		<include refid="query_tables_Property" />
	</select>
	
#if($!foreignKey)
	<delete id="delete${className}By${foreignKey.method}Id" parameterType="${foreignKey.filedType}">
		DELETE FROM ${tableName} WHERE ${foreignKey.columnName} = #{value}
	</delete>
	
	<select id="find${className}ListBy${foreignKey.method}Id" resultMap="${className}ResultMap" parameterType="${foreignKey.filedType}">
		SELECT * FROM ${tableName} WHERE ${foreignKey.columnName} = #{value}
	</select>
#end
	<select id="find${className}List" resultMap="${className}ResultMap">
		SELECT * FROM ${tableName}
		<include refid="query_tables_Property" />
	</select>
	
</mapper>