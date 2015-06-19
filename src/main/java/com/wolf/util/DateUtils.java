package com.wolf.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtils {

	private final static String DATE_PATTERN = "yyyy-MM-dd";
	private final static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public final static DateFormat YYYY_MM_DD_MM_HH_SS = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public final static DateFormat YYYYMMDD_MM_HH_SS = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	public final static DateFormat YYYY_MM_DD = new SimpleDateFormat(
			"yyyy-MM-dd");
	public final static DateFormat YYYYMMDDMMHHSSSSS = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");
	public final static DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	public static final DateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

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
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
		ParsePosition pos = new ParsePosition(0);// 从第一个字符开始解析
		Date strtodate = YYYY_MM_DD.parse(strDate, pos);
		return strtodate;
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

	/**
	 * 获取相对当前日期过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date pastDate) {
		long times = (new Date().getTime() - pastDate.getTime());
		return times / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60
				* 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "."
				+ sss;
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 判断是否润年 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
	 * 4.能被4整除同时能被100整除则不是闰年
	 * 
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate) {
		Date date = strToDate(ddate);
		GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		if ((year % 400) == 0) {
			return true;
		} else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.strToDate(YYYY_MM_DD.format(new Date())));
	}
}
