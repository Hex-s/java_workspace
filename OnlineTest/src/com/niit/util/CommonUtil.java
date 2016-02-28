package com.niit.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class CommonUtil {

	/**
	 * 判断数值是否是浮点数
	 * @param num
	 * @return
	 */
	public static boolean isDouble(BigDecimal num){
		return num.toString().indexOf(".") != -1;
	}
	
	/**
	 * 获取指定的日期
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Calendar getCalendar(int year, int month, int day,int h,int m,int mn){
		Calendar date = Calendar.getInstance();
		date.set(year, month-1, day, h, m, mn);
		return date;
	}
	
	/**
	 * 获取格式化后的时间
	 * @param calendar
	 * @return
	 */
	public static String formatDate(Calendar calendar){
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return formater.format(calendar.getTime());
	}
	
	public static String formatTImestamp(Timestamp ts){
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return formater.format(ts.getTime());
	}
}
