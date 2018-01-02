package com.jing.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;

/**
 * @ClassName: ClassUtil
 * @Description: 类实体操作
 * @author: Jinlong He
 * @date: 2017年4月11日 下午1:57:46
 */
public class ClassUtil {

	/**
	 * 获取类实例的属性值
	 * 
	 * @param clazz
	 *            类名
	 * @param includeParentClass
	 *            是否包括父类的属性值
	 * @return 类名.属性名=属性类型
	 * @author: li chao
	 */
	@SuppressWarnings("rawtypes")
	public static List<Field> getClassFields(Class clazz, boolean includeParentClass) {
		List<Field> list = new ArrayList<Field>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (!Modifier.isFinal(field.getModifiers()))
				list.add(field);
		}
		if (includeParentClass)
			getParentClassFields(list, clazz.getSuperclass());
		return list;
	}

	/**
	 * 获取类实例的父类的属性值
	 * 
	 * @param map
	 *            类实例的属性值Map
	 * @param clazz
	 *            类名
	 * @return 类名.属性名=属性类型
	 * @author: li chao
	 */
	@SuppressWarnings("rawtypes")
	private static List<Field> getParentClassFields(List<Field> list, Class clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (!Modifier.isFinal(field.getModifiers()))
				list.add(field);
			;
		}
		if (clazz.getSuperclass() == null) {
			return list;
		}
		getParentClassFields(list, clazz.getSuperclass());
		return list;
	}

	/**
	 * 获取类实例的方法
	 * 
	 * @param clazz
	 *            类名
	 * @param includeParentClass
	 *            是否包括父类的方法
	 * @return List
	 * @author: li chao
	 */
	@SuppressWarnings("rawtypes")
	public static List<Method> getMothds(Class clazz, boolean includeParentClass) {
		List<Method> list = new ArrayList<Method>();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			list.add(method);
		}
		if (includeParentClass) {
			getParentClassMothds(list, clazz.getSuperclass());
		}
		return list;
	}

	/**
	 * 获取类实例的父类的方法
	 * 
	 * @param list
	 *            类实例的方法List
	 * @param clazz
	 *            类名
	 * @return List
	 * @author: li chao
	 */
	@SuppressWarnings("rawtypes")
	private static List<Method> getParentClassMothds(List<Method> list, Class clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			list.add(method);
		}
		if (clazz.getSuperclass() == Object.class) {
			return list;
		}
		getParentClassMothds(list, clazz.getSuperclass());
		return list;
	}

	/**
	 * 
	 * @Title: isNull
	 * @Description: 判断对象是否Null
	 * @param obj
	 * @return boolean
	 * @author: li chao
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static boolean isNull(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class<? extends Object> clazz = obj.getClass();
		List<Field> fields = getClassFields(clazz, false);
		boolean isnull = true;
		for (Field field : fields) {
			field.setAccessible(true);
			Object obj1 = field.get(obj);
			if (null != obj1) {
				return false;
			}
		}
		return isnull;
	}

	/**
	 * 
	 * @Title: getClassFieldName
	 * @Description:获取属性值属性名称
	 * @param obj
	 * @param isNull
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 *             boolean
	 * @author: li chao
	 */
	public static List<String> getClassFieldName(Object obj, boolean isNull)
			throws IllegalArgumentException, IllegalAccessException {
		Class<? extends Object> clazz = obj.getClass();
		List<String> list = new ArrayList<String>();
		List<Field> fields = getClassFields(clazz, false);
		for (Field field : fields) {
			if (isNull) {
				list.add(field.getName());
			} else {
				field.setAccessible(true);
				Object obj1 = field.get(obj);
				if (obj1 != null) {
					list.add(field.getName());
				}
			}
		}
		return list;
	}
	
	
	/** 
	* @Title: beanIsNull 
	* @Description: 通过BEAN的getter方法来判断bean是否为空
	* @param bean
	* @return
	* @throws IllegalAccessException
	* @throws IllegalArgumentException
	* @throws InvocationTargetException
	* @throws IntrospectionException  boolean    返回类型 
	* @throws 
	* @author Jinlong He
	*/
	public static <T> boolean beanIsNull(T bean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException{
		if (bean == null) {
			return true;
		}
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (!key.equals("class")) {
				Method getter = property.getReadMethod();
				Object value = getter.invoke(bean);
				if(null != value ){
					return false;
				}
			}
		}		
		return true;		
	}
	

	/** 
	* @Title: transBean2Map 
	* @Description: 将BEAN通过getter暴露出的数据封装到MAP 
	* @param obj 
	* @param hasNull 空数据是否封装
	* @return
	* @throws IntrospectionException
	* @throws IllegalAccessException
	* @throws IllegalArgumentException
	* @throws InvocationTargetException  Map<String,Object>    返回类型 
	* @throws 
	* @author Jinlong He
	*/
	public static Map<String, Object> transBean2Map(Object bean, boolean hasNull)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (bean == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			// 过滤class属性
			if (!key.equals("class")) {
				// 得到property对应的getter方法
				Method getter = property.getReadMethod();
				Object value = getter.invoke(bean);
				if (value == null && !hasNull) {
					continue;
				}
				map.put(key, value);
			}
		}
		return map;
	}
	
	/** 
	* @Title: transMap2Bean 
	* @Description: 初始化类型实体，并通过setter从MAP中取值，最后返回其实体.注意Integer转Byte,Long转Integer等非法转换时的问题
	* @param map
	* @param class1
	* @return
	* @throws InstantiationException
	* @throws IllegalAccessException
	* @throws IntrospectionException  T    返回类型 
	* @throws 
	* @author Jinlong He
	*/
	public static <T> T transMap2Bean(Map<String, Object> map, Class<T> class1)
			throws InstantiationException, IllegalAccessException, IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(class1);
		T bean = class1.newInstance();
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (map.containsKey(key)) {
				Object value = map.get(key);
				Method setter = property.getWriteMethod();
				try {
					setter.invoke(bean, value);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					System.out.println("error: put"+value.getClass().getName()+" to "+setter.getParameterTypes()[0].getName());
				}
			}
		}
		return bean;
	}
	/**
	 * 
	* @Title: transList2Map 
	* @Description: 集合转map
	* @param list
	* @param hasNull
	* @return
	* @throws IntrospectionException
	* @throws IllegalAccessException
	* @throws IllegalArgumentException
	* @throws InvocationTargetException List<Map<String,Object>>
	* @author: li chao
	 */
	public static <T> List<Map<String, Object>> transList2Map(List<T> list, boolean hasNull)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (list == null) {
			return null;
		}
		List<Map<String, Object>> listtemp = Lists.newArrayList();
		for (Object object : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(object);
					if (value == null && !hasNull) {
						continue;
					}
					map.put(key, value);
				}
			}
			listtemp.add(map);
		}
		return listtemp;
	}
	
	/**
	 * 
	* @Title: underline2Camel 
	* @Description:  Map的下划线转驼峰
	* @param map
	* @param checknull true  false：过滤掉为null 或""
	* @return Map<String,Object>
	* @author: li chao
	 */
	public static Map<String, Object> underline2Camel(Map<String, Object> map,boolean checknull) {
		Map<String, Object> newMap = new HashMap<String, Object>();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			String newKey = underline2Camel(key);
			if(!checknull){
				if(null == map.get(key) || "".equals(map.get(key))){
					continue;
				}
				newMap.put(newKey, map.get(key));
			}else
				newMap.put(newKey, map.get(key));
		}
		return newMap;
	}
	

	/**
	 * Map的下划线转驼峰
	 * 
	 * @return
	 */
	public static List<Map<String, Object>> underline2Camel(List<Map<String, Object>> list,boolean checknull) {
		List<Map<String, Object>> newlsit = Lists.newArrayList();
		for (Map<String, Object> map : list) {
			newlsit.add(underline2Camel(map,checknull));
		}
		return newlsit;
	}

	/**
	 * 字符串的下划线转驼峰
	 * 
	 * @param underline
	 * @return
	 */
	public static String underline2Camel(String underline) {
		Pattern pattern = Pattern.compile("[_]\\w");
		String camel = underline.toLowerCase();
		Matcher matcher = pattern.matcher(camel);
		while (matcher.find()) {
			String w = matcher.group().trim();
			camel = camel.replace(w, w.toUpperCase().replace("_", ""));
		}
		return camel;
	}

	public static final char UNDERLINE = '_';

	
	/** 
	* @Title: camelToUnderline 
	* @Description: 驼峰格式转下划线 
	* @param param
	* @return  String    返回类型 
	* @throws 
	*/
	public static String camel2Underline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
}
