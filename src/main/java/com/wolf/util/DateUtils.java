package com.wolf.util;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtils {

	private final static String DATE_PATTERN = "yyyy-MM-dd";
	private final static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static String[] parsePatterns = { "yyyy-MM-dd",
			"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
			"yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		return getCurrentDate(DATE_PATTERN);
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTime(Date date) {
		return formatDate(date, DATETIME_PATTERN);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (null != pattern && pattern.length() > 0) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, DATE_PATTERN);
		}
		return formatDate;
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 * 
	 * @return
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 * 
	 * @return
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 * 
	 * @return
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 * 
	 * @return
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 * 
	 * @return
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

}
