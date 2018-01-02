package com.jing.config.validation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 
 * @ClassName: ValidatorExceptionHandler
 * @Description: 参数验证错误信息处理
 * @author: lichao
 * @date: 2017年1月10日 上午10:28:53
 */
public class ValidatorExceptionHandler {

	/**
	 * 
	* @Title: extractPropertyAndMessage 
	* @Description: 转换ConstraintViolationException中的Set<ConstraintViolations>为Map<property, message>
	* @param parameterList 参数有序集合
	* @param e 验证异常信息
	* @return  Map<String,String>    返回类型 
	* @throws
	 */
	public static Map<String, String> extractPropertyAndMessage(ArrayList<String> parameterList,ConstraintViolationException e) {
		return extractPropertyAndMessage(parameterList,e.getConstraintViolations());
	}

	/**
	 * 
	* @Title: extractPropertyAndMessage 
	* @Description: 辅助方法, 转换Set<ConstraintViolation>为Map<property, message>.
	* @param parameterList
	* @param constraintViolations
	* @return  Map<String,String>    返回类型 
	* @throws
	 */
	public static Map<String, String> extractPropertyAndMessage(ArrayList<String> parameterList,Set<ConstraintViolation<?>> constraintViolations) {
		boolean booleanparameterList = null ==parameterList? true:false;
		Map<String, String> errorMessages = Maps.newHashMap();
		for (ConstraintViolation<?> violation : constraintViolations) {
			if(booleanparameterList){
				errorMessages.put(parameterList.get(parameterIndex(violation.getPropertyPath().toString())), violation.getMessage());
			}else{
				errorMessages.put(violation.getPropertyPath().toString(), violation.getMessage());
			}
		}
		return errorMessages;
	}
	
	
	
	protected static int parameterIndex(String propertyPath) {
		String[] s = propertyPath.split("\\.");
		int index = Integer.valueOf(s[1].substring(3, s[1].length()));
		return index;
	}
	
	
	/**
	 * 
	* @Title: extractPropertyAndMessage 
	* @Description: 把消息转换为list
	* @param constraintViolations
	* @return  ArrayList<String>    返回类型 
	* @throws
	 */
	public static ArrayList<String> extractPropertyAndMessage(Set<ConstraintViolation<?>> constraintViolations) {
	    ArrayList<String> errorMessages = Lists.newArrayList();
		for (ConstraintViolation<?> violation : constraintViolations) {
			errorMessages.add(violation.getMessage());
		}
		return errorMessages;
	}
}
