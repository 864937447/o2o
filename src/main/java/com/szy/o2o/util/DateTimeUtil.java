/**
 * Project Name:cartoon_util
 * File Name:DataTimeUtil.java
 * Package Name:com.ydjy.cartoon.util
 * Date:2018年4月18日上午10:21:18
 * Copyright (c) 2018, 1055277354@qq.com All Rights Reserved.
 *
 */

 package com.szy.o2o.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * ClassName:DataTimeUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年4月18日 上午10:21:18 <br/>
 * @author Lizeguang
 * @version
 * @since JDK 1.8
 * @see
 */
 public class DateTimeUtil {  
	  
	 	public static final String STANDARD_FORMAT="yyyy-MM-dd HH:mm:ss";
	 	
	    private static Calendar calendar = Calendar.getInstance();  
	    /** 
	     * 将一个日期对象格式化为一个字符串。格式为：yyyy-MM-dd HH:mm:ss 
	     *  
	     * @param date 
	     *            要处理的日期 
	     * @return 处理后的日期（字符串） 
	     */  
	    public static String parseDateToString(Date date) {  
	        if (null == date) {  
	            return "-1";  
	        }  
	        return new SimpleDateFormat(STANDARD_FORMAT).format(date);  
	    }  
	  
	    /** 
	     * 将一个日期对象格式化为一个字符串。字符串格式由调用方法指定 
	     *  
	     * @param date 
	     *            要处理的日期 
	     * @param pattern 
	     *            日期格式的模式字符串 
	     * @return 处理后的日期（字符串） 
	     *  
	     *  
	     */  
	    public static String parseDateToString(final Date date, final String pattern) {  
	        if (null == date) {  
	            return "-1";  
	        }  
	        if (StringUtils.isEmpty(pattern)) {  
	            return parseDateToString(date);  
	        }  
	        return new SimpleDateFormat(pattern).format(date);  
	    }  
	  
	    /** 
	     * 将一个字符串解析为一个日期对象。字符串格式为：yyyy-MM-dd 
	     *  
	     * @param dateStr 
	     *            要解析的日期字符串 
	     * @return 日期对象 
	     *  
	     */  
	    public static Date parseStringToDate(final String dateStr) {  
	        if (StringUtils.isEmpty(dateStr)) {  
	            return null;  
	        }  
	        Date date = null;  
	        try {  
	            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        return date;  
	    }  
	  
	    /** 
	     * 将一个字符串解析为一个日期对象。字符串格式由调用方法指定 
	     *  
	     * @param dateStr 
	     *            要解析的日期字符串 
	     * @param pattern 
	     *            日期格式的模式字符串 
	     * @return 日期对象 
	     *  
	     *         不能被解析的日期格式的模式字符串 
	     */  
	    public static Date parseStringToDate(final String dateStr,  
	            final String pattern) {  
	        if (StringUtils.isEmpty(dateStr)) {  
	            return null;  
	        }  
	        if (StringUtils.isEmpty(pattern)) {  
	            return parseStringToDate(dateStr);  
	        }  
	        Date date = null;  
	        try {  
	            date = new SimpleDateFormat(pattern).parse(dateStr);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        return date;  
	    }  
	  
	    /** 
	     * 取指定日期的下一天 
	     *  
	     * @param dateStr 
	     *            指定的日期 
	     * @return 指定日期的后一天 
	     *  
	     */  
	    public static String getNextDay(final String dateStr) {  
	        if (StringUtils.isEmpty(dateStr)) {  
	            return "-1";  
	        }  
	        if (!isDateStr(dateStr,"yyyy-MM-dd")) {  
	            return "-1";  
	        }  
	        Date date = null;  
	        try {  
	            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        calendar.setTime(date);  
	        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);  
	        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());  
	    }  
	  
	    /** 
	     * 取指定日期的前一天 
	     *  
	     * @param dateStr 
	     *            指定的日期 
	     * @return 指定日期的前一天 
	     *  
	     */  
	    public static String getBeforeDay(final String dateStr) {  
	        if (StringUtils.isEmpty(dateStr)) {  
	            return "-1";  
	        }  
	        if (!isDateStr(dateStr,"yyyy-MM-dd")) {  
	            return "-1";  
	        }  
	        Date date = null;  
	        try {  
	            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        calendar.setTime(date);  
	        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);  
	        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());  
	    }  
	  
	    /** 
	     * 根据生日计算年龄（到当前日期） 
	     *  
	     * @param birthday 
	     *            出生日期 
	     * @return 年龄 
	     */  
	    public static int getAge(final Date birthday) {  
	        if (null == birthday) {  
	            return -1;  
	        }  
	        calendar = Calendar.getInstance();  
	        if (calendar.before(birthday)) {  
	            // 生日在当前如期的后面  
	            return -1;  
	        }  
	        // 获得当前的时间  
	        int currentYear = calendar.get(Calendar.YEAR);  
	        int currentMonth = calendar.get(Calendar.MONTH) + 1;  
	        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);  
	        calendar.setTime(birthday);  
	        // 获得生日的时间  
	        int birthdayYear = calendar.get(Calendar.YEAR);  
	        int birthdayMonth = calendar.get(Calendar.MONTH) + 1;  
	        int birthdayDay = calendar.get(Calendar.DAY_OF_MONTH);  
	  
	        int age = currentYear - birthdayYear;  
	        if (currentMonth <= birthdayMonth) {  
	            if (currentMonth == birthdayMonth) {  
	                if (currentDay < birthdayDay) {  
	                    age--;  
	                }  
	            }  
	        }  
	        return age;  
	    }  
	  
	    /** 
	     * 根据生日计算年龄（到指定日期） 
	     *  
	     * @param birthday 
	     * @param date 
	     * @return 
	     */  
	    public static int getAge(final Date birthday, final Date date) {  
	        calendar = Calendar.getInstance();  
	        if (null == birthday || null == date) {  
	            return -1;  
	        }  
	        if (date.before(birthday)) {  
	            return -1;  
	        }  
	        // 获得指定时间  
	        calendar.setTime(date);  
	        int year = calendar.get(Calendar.YEAR);  
	        int month = calendar.get(Calendar.MONTH) + 1;  
	        int day = calendar.get(Calendar.DAY_OF_MONTH);  
	        // 获得生日时间  
	        calendar.setTime(birthday);  
	        int birthdayYear = calendar.get(Calendar.YEAR);  
	        int birthdayMonth = calendar.get(Calendar.MONTH) + 1;  
	        int birthdayDay = calendar.get(Calendar.DAY_OF_MONTH);  
	        int age = year - birthdayYear;  
	        if (month <= birthdayMonth) {  
	            if (month == birthdayMonth) {  
	                if (day < birthdayDay) {  
	                    age--;  
	                }  
	            }  
	        }  
	        return age;  
	    }  
	  
	    /** 
	     * 判断指定字符串是否符合日期的格式 
	     *  
	     * @param dateStr 
	     * @return DateTimeUtil.isDateStr("1990-01-32 00:00:00") = false 
	     *         DateTimeUtil.isDateStr("1990-01 00:00") = false 
	     *         DateTimeUtil.isDateStr("1990-1-1 00:00:00") = true 
	     *         DateTimeUtil.isDateStr("1990-01-3") = true 
	     *         DateTimeUtil.isDateStr("1990-21-31 00:00:00") = false 
	     *         DateTimeUtil.isDateStr("1990年01月3日 00时00分00秒") = false 
	     */  
	    public static boolean isDateStr(final String dateStr,final String pattern) {  
	        SimpleDateFormat format = new SimpleDateFormat(pattern);  
	        format.setLenient(false);  
	        try {  
	            format.parse(dateStr);  
	        } catch (ParseException e) {  
	            return false;  
	        }  
	        return true;  
	    }  
	}  

	