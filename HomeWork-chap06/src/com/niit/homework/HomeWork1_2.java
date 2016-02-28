package com.niit.homework;

import java.util.Scanner;

public class HomeWork1_2 {
	
	/**
	 * 在源字符串中搜索某个字符串，获取该字符串出现的次数
	 * @param sourceStr 源字符串
	 * @param searchStr 搜索的字符串
	 * @return 返回搜索的字符串在源字符串中的次数
	 */
	public int strCount(String sourceStr,String searchStr){
		//搜索的字符串出现的次数
		int count = 0;
		//搜索的字符串出现时的索引位置
		int index = 0;
		//搜索的字符串的长度
		int length = searchStr.length();
		//判断搜索的字符串在源字符串中是否存在
		while(true){
			index = sourceStr.indexOf(searchStr,index);
			//当搜索的字符串在源字符串中存在时
			if(index != -1){
				//出现的次数+1
				count++;
				System.out.println(searchStr+"在"+sourceStr+"中第"+count+"次出现是在索引"+index+"的位置");
				index += length;;
			}
			else{
				break;
			}
		}
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入源字符串：");
		String sourceStr = sc.next();
		System.out.print("请输入要搜索的字符串：");
		String searchStr = sc.next();
		HomeWork1_2 hw = new HomeWork1_2();
		int count = hw.strCount(sourceStr, searchStr);
		System.out.println(searchStr+"在"+sourceStr+"中一共出现了"+count+"次");
	}

}
