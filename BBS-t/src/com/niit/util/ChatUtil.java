package com.niit.util;
/**
 * ���칤����
 * @author Administrator
 *
 */
public class ChatUtil {

		/**
		 * ת����������Ϊ�ַ���
		 * @param action
		 * @return
		 */
		public static String changeAction(int action){
			String str = "";
			switch(action){
			case 1:
				str = "����һȭ";
				break;
			case 2:
				str = "����һ����";
				break;
			case 3:
				str = "����һ���ʻ�";
				break;
			}
			return str;
		}
		/**
		 * ת����ɫΪ�ַ���
		 * @param color
		 * @return
		 */
		public static String changeColor(int color){
			String str = "";
			switch(color){
			case 1:
				str = "black";
				break;
			case 2:
				str = "red";
				break;
			case 3:
				str = "blue";
				break;
			case 4:
				str = "green";
				break;
			}
			return str;
		}
}
