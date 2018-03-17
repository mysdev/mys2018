package com.jing.config.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jing.utils.ClassUtil;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class BeanValidator {

	@Autowired
	private Validator validator;

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	public static Map<String, String> gotErrorMessage(Integer index, String field, String message){
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("index", ""+index);
		ret.put("field", field);
		ret.put("message", message);
		return ret;
	}
	
	/** 
	* @Title: validateClassAuto 
	* @Description: 校验单个实体
	* @param object 待校验数据对象
	* @param isCheckNull 检查是否可以为空或null。	
	* @throws IllegalArgumentException
	* @throws IllegalAccessException
	* @throws NoSuchFieldException
	* @throws SecurityException  List<Map<String,String>>    返回类型 
	* @throws 
	*/
	public List<Map<String, String>> validateClassAuto(Object object, boolean isCheckNull,Class<?>...groups) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		List<Map<String, String>> errorMessages = Lists.newArrayList();
		if(null == object){
			return errorMessages;
		}
		if(object instanceof java.util.List){
			return this.validateListAuto((List)object,isCheckNull,groups);
		}
		List<String> objectown = ClassUtil.getClassFieldName(object, true);		
		for(String fieldName: objectown){
			//所有字段遍历
			Field filed = object.getClass().getDeclaredField(fieldName);
			filed.setAccessible(true);
			Object obj = filed.get(object); //数据值 
			Annotation[] annotArray = filed.getDeclaredAnnotations();
			boolean isNot = false;	//是否必须字段标识，识别依据带Not开头的注解
			for (Annotation annotation : annotArray) {
				if(annotation.annotationType().getSimpleName().startsWith("Not")){
					isNot = true;						
					break;
				}
			}
			if(isNot){
				//必填项
				if(isCheckNull || (!isCheckNull && obj!=null)){
					//NULL也必须校验
					Map<String, String> map = validateClassFiled(object, fieldName,groups);
					if (!map.isEmpty()) {
						errorMessages.add(map);
					}
				}
			}else{
				//非必填项---为空不检查，不为空的字符串且不是""时
				if(obj!=null && !obj.equals("")){
					Map<String, String> map = validateClassFiled(object, fieldName,groups);
					if (!map.isEmpty()) {
						errorMessages.add(map);
					}
				}
			}
		}
		return errorMessages;
	}
	
	
	/** 
	* @Title: validateListAuto 
	* @Description: 校验集合实体
	* @param object 待校验数据对象
	* @param isCheckNull 检查是否可以为空或null。	
	* @throws IllegalArgumentException
	* @throws IllegalAccessException
	* @throws NoSuchFieldException
	* @throws SecurityException  List<Map<String,String>>    返回类型 
	* @throws 
	*/
	private List<Map<String, String>> validateListAuto(List<Object> objects, boolean isCheckNull,Class<?>...groups) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		List<Map<String, String>> errorMessages = Lists.newArrayList();
		if(null == objects || objects.isEmpty()){
			return errorMessages;
		}
		int i = 0;
		for (Object object : objects) {
			i++;
			List<String> objectown = ClassUtil.getClassFieldName(object, true);		
			for(String fieldName: objectown){
				//所有字段遍历
				Field filed = object.getClass().getDeclaredField(fieldName);
				filed.setAccessible(true);
				Object obj = filed.get(object); //数据值 
				Annotation[] annotArray = filed.getDeclaredAnnotations();
				boolean isNot = false;	//是否必须字段标识，识别依据带Not开头的注解
				for (Annotation annotation : annotArray) {
					if(annotation.annotationType().getSimpleName().startsWith("Not")){
						isNot = true;						
						break;
					}
				}
				if(isNot){
					//必填项
					if(isCheckNull || (!isCheckNull && obj!=null)){
						//NULL也必须校验
						Map<String, String> map = validateClassFiled(object, fieldName,groups);
						if (!map.isEmpty()) {
							map.put("index", i+"");
							errorMessages.add(map);
						}
					}
				}else{
					//非必填项---为空不检查，不为空的字符串且不是""时
					if(obj!=null && !obj.equals("")){
						Map<String, String> map = validateClassFiled(object, fieldName,groups);
						if (!map.isEmpty()) {
							map.put("index", i+"");
							errorMessages.add(map);
						}
					}
				}
			}
			//要求获取所有错误信息，故注解此段20180115
//			if(!errorMessages.isEmpty()){
//				break;
//			}
		}
		return errorMessages;
	}
	
	
	/**
	 * 
	 * @Title: validateClass
	 * @Description: 对象属性有效性验证
	 * @param object
	 * @param fieldName
	 * @return Map<String,String>
	 * @author: li chao
	 */
	private Map<String, String> validateClassFiled(Object object, String fieldName,Class<?>...groups) {
		Map<String, String> map = Maps.newHashMap();
		Set constraintViolations = new LinkedHashSet();
		constraintViolations = getValidator().validateProperty(object, fieldName,groups);
		if (!constraintViolations.isEmpty()) {
			ArrayList<String> list = ValidatorExceptionHandler.extractPropertyAndMessage(constraintViolations);
			StringBuffer errormessage = new StringBuffer();
			for (String string : list) {
				errormessage.append(string).append(";");
				break;
			}
			map.put("field", fieldName);
			map.put("msg", errormessage.toString());
		}
		return map;
	}

	/**
	 * 
	* @Title: validateClass 
	* @Description: 对象属性有效性验证
	* @param object
	* @param fieldNames
	* @return Map<String,String>
	* @author: li chao
	 */
	public Map<String, String> validateClass(Object object, String... fieldNames){
		Map<String, String> errorMessages = Maps.newHashMap();
		if(null == object){
			return errorMessages;
		}
		if (fieldNames != null) {
			for (String fieldName : fieldNames){
				Set constraintViolations = new LinkedHashSet();
				constraintViolations = getValidator().validateProperty(object, fieldName);
				if (!constraintViolations.isEmpty()) {
					ArrayList<String> list = ValidatorExceptionHandler.extractPropertyAndMessage(constraintViolations);
					StringBuffer errormessage = new StringBuffer();
					for (String string : list) {
						errormessage.append(string).append(";");
					}
					errorMessages.put(fieldName, errormessage.toString());
				}
			}
		}
		return errorMessages;
	}
	
	
	/**
	 * 
	 * @Title: validateClassFiledList
	 * @Description: 对象属性有效性验证
	 * @param object
	 * @param fieldNameList 需验证的字段
	 * @param isCheckNull  是否验证null
	 * @return Map<String,String>
	 * @author: yin de
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public List<Map<String, String>> validateClassFiledList(Object object, String fieldNameList,boolean isCheckNull,Class<?>...groups) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		List<Map<String, String>> errorMessages = Lists.newArrayList();
		String[] fieldList = fieldNameList.split(",");
		for(String fieldName: fieldList){
			Field filed = object.getClass().getDeclaredField(fieldName);
			filed.setAccessible(true);
			Object obj = filed.get(object); 
		    if(isCheckNull){
			Map<String, String> map = validateClassFiled(object, fieldName,groups);
			if (!map.isEmpty()) {
				errorMessages.add(map);
			}
		    }else if(null!=obj){
		    	Map<String, String> map = validateClassFiled(object, fieldName,groups);
				if (!map.isEmpty()) {
					errorMessages.add(map);
				}
		    }
		}
		return errorMessages;
	}
}
