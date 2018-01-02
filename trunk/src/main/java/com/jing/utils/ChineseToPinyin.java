/**    
 * @Title: ChineseToPinyin.java  
 * @Package com.jing.common.util  
 * @Description: 汉字转拼音_工具类
 * @author li chao
 * @date 2016年4月15日 下午3:53:13  
 * @version V  
 */
package com.jing.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 *   
 * 
 * @ClassName: ChineseToPinyin  
 * @Description: 汉字转拼音_工具类
 * @author li chao
 * @date 2016年4月15日 下午3:53:13       
 */
public class ChineseToPinyin {
	/**
	 * 
	* @Title: getPingYin  
	* @Description: 获取汉字全拼 
	* @param  src
	* @param  casetype
  
	* @Author li chao
	* @return String    返回类型  
	* @throws  
	 */
	public static String getPingYin(String src,String casetype) {

		char[] t1 = null;
		t1 = src.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		if(casetype.endsWith("UPPERCASE")){
			t3.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		}
		if(casetype.endsWith("LOWERCASE")){
			t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		}
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// 判断是否为汉字字符
				if (java.lang.Character.toString(t1[i]).matches(
						"[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4 += t2[0];
				} else
					t4 += java.lang.Character.toString(t1[i]);
			}
		} catch (BadHanyuPinyinOutputFormatCombination e1) {
			e1.printStackTrace();
		}
		return t4;
	}
	
	/**
	 * 
	* @Title: getPingYinHeadUpper  
	* @Description: 获取汉字全拼首字母大写 
	* @param  src
  
	* @Author li chao
	* @return String    返回类型  
	* @throws  
	 */
	public static String getPingYinHeadUpper(String src) {

		char[] t1 = null;
		t1 = src.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// 判断是否为汉字字符
				if (java.lang.Character.toString(t1[i]).matches(
						"[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4 +=  t2[0].toUpperCase().charAt(0)+t2[0].substring(1);
				} else
					t4 += java.lang.Character.toString(t1[i]);
			}
		} catch (BadHanyuPinyinOutputFormatCombination e1) {
			e1.printStackTrace();
		}
		return t4;
	}

	/**
	 * 
	* @Title: getPinYinHeadChar  
	* @Description: 获取汉字首字母 
	* @param  str
	* @param  casetype
  
	* @Author li chao
	* @return String    返回类型  
	* @throws  
	 */
	public static String getPinYinHeadChar(String str,String casetype) {
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

		if(casetype.endsWith("UPPERCASE")){
			t3.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		}
		if(casetype.endsWith("LOWERCASE")){
			t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		}
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);

		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			String[] pinyinArray;
			try {
				pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word,t3);
				if (pinyinArray != null) {
					convert += pinyinArray[0].charAt(0);
				} else {
					convert += word;
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
			
		}
		return convert;
	}
}
