package com.wolf.util;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtils {

	private final static String DATE_PATTERN ="yyyy-MM-dd";
	private final static String DATETIME_PATTERN ="yyyy-MM-dd HH:mm:ss";
	private static String[] parsePatterns = { "yyyy-MM-dd",
		"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd",
		"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
		"yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM" };
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * @param pattern
	 * @return
	 */
	public static String getDate(String pattern){
		return DateFormatUtils.format(new Date(), pattern);
	}
	
}
