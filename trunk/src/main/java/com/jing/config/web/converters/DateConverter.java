package com.jing.config.web.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jing.config.web.exception.CustomException;

/**
 * 参数封装类 支持: 1)yyyy-MM-dd 2)yyyy-MM-dd HH:mm 3)yyyy-MM-dd HH:mm:ss
 * 
 * @author LIFENG
 */
@Component
public class DateConverter implements Converter<String, Date> {
	private Log logger = LogFactory.getLog(this.getClass());

	@Override
	public Date convert(String source) {
		logger.debug("日期转换");
		// 实现将字符串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
		String format = "yyyy-MM-dd";
		if (source == null || "".equals(source)) {
			return null;
		} else if (source.trim().length() == 16) {
			format = "yyyy-MM-dd HH:mm";
		} else if (source.trim().length() == 19) {
			format = "yyyy-MM-dd HH:mm";
		} else if (source.trim().length() == 10) {
			format = "yyyy-MM-dd";
		} else {
			throw new CustomException("request中含有非法日期格式.");
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(source.trim());
		} catch (ParseException e) {
			logger.error("从请求参数中获取日期错误", e);
			throw new CustomException("request中含有非法日期格式.");
		}
	}

}
