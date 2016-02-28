package com.niit.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
/**
 * 工具类，提供了和项目业务功能无关的常用方法，工具类应具备一定的通用性
 * @author Administrator
 *
 */
public class CommonUtil {
	//静态属性和方法常驻内存，不需要类进行实例化就已经存在于内存中，因此可以直接通过类名.属性名(方法名)访问
	static int brandId;
	static int typeId;
	static int carId;
	static int userId;
	
	/**
	 * 获取用户编号
	 * @return
	 */
	public static int getUserId(){
		userId++;
		return userId;
	}
	/**
	 * 获取品牌编号的方法
	 * @return
	 */
	public static int getBrandId(){
		brandId++;
		return brandId;
	}
	/**
	 * 获取车型编号的方法
	 * @return
	 */
	public static int getTypeId(){
		typeId++;
		return typeId;
	}
	/**
	 * 获取汽车编号的方法
	 * @return
	 */
	public static int getCarId(){
		carId++;
		return carId;
	}
	/**
	 * 获取指定的日期
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Calendar getCalendar(int year, int month, int day){
		Calendar date = Calendar.getInstance();
		date.set(year, month-1, day, 0, 0, 0);
		return date;
	}
	/**
	 * 获取格式化后的时间
	 * @param calendar
	 * @return
	 */
	public static String formatDate(Calendar calendar){
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		return formater.format(calendar.getTime());
	}
	
	/**
	 * 隐藏第一列
	 */
	public static void hidenFirstColum(JTable tab, int column){
		//隐藏第一列
		TableColumn firstColumn = tab.getColumnModel().getColumn(column);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	
	/**
	 * 获取当年当月的天数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysInMonth(int year,int month){
		int days = 0;
		switch(month){
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
				days = 29;
			}
			else{
				days = 28;
			}
			break;
		default:
			days = 31;	
		}
		return days;
	}
}
