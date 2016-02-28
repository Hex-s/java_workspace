package com.niit.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
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
	
	/**
	 * ���ص�һ��
	 */
	public static void hidenFirstColum(JTable tab, int column){
		//���ص�һ��
		TableColumn firstColumn = tab.getColumnModel().getColumn(column);
		firstColumn.setMinWidth(0);
		firstColumn.setMaxWidth(0);
		firstColumn.setPreferredWidth(0);
	}
	
	/**
	 * ��ȡ���굱�µ�����
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
