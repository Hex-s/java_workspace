package com.niit.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * �����࣬�ṩ�˺���Ŀҵ�����޹صĳ��÷�����������Ӧ�߱�һ����ͨ����
 * @author Administrator
 *
 */
public class CommonUtil {
	//��̬���Ժͷ�����פ�ڴ棬����Ҫ�����ʵ�������Ѿ��������ڴ��У���˿���ֱ��ͨ������.������(������)����
	static int brandId;
	static int typeId;
	static int carId;
	static int userId;
	
	/**
	 * ��ȡ�û����
	 * @return
	 */
	public static int getUserId(){
		userId++;
		return userId;
	}
	/**
	 * ��ȡƷ�Ʊ�ŵķ���
	 * @return
	 */
	public static int getBrandId(){
		brandId++;
		return brandId;
	}
	/**
	 * ��ȡ���ͱ�ŵķ���
	 * @return
	 */
	public static int getTypeId(){
		typeId++;
		return typeId;
	}
	/**
	 * ��ȡ������ŵķ���
	 * @return
	 */
	public static int getCarId(){
		carId++;
		return carId;
	}
	/**
	 * ��ȡָ��������
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
	 * ��ȡ��ʽ�����ʱ��
	 * @param calendar
	 * @return
	 */
	public static String formatDate(Calendar calendar){
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		return formater.format(calendar.getTime());
	}
}
