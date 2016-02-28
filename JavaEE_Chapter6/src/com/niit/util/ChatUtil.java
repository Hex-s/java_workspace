package com.niit.util;
/**
 * 聊天工具类
 * @author Administrator
 *
 */
public class ChatUtil {

		/**
		 * 转换动作表情为字符串
		 * @param action
		 * @return
		 */
		public static String changeAction(int action){
			String str = "";
			switch(action){
			case 1:
				str = "打了一拳";
				break;
			case 2:
				str = "献了一个吻";
				break;
			case 3:
				str = "献了一束鲜花";
				break;
			}
			return str;
		}
		/**
		 * 转换颜色为字符串
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
