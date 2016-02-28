package com.niit.homework;

import java.util.Scanner;

public class HomeWork2 {
	/**
	 * 键盘接受一个小写字符串，多个单词使用#分开，
	 * 编写一个方法，能将该规则类型的字符串变为Camel命名法的变量名
	 * @param name
	 * @return
	 */
	public String camel(String name){
		String nameCamel = "";
		//字符串根据“#”划分
		String[] array = name.split("#");
		char c;
		String str;
		//将字符串的首字母变成大写
		for(int i = 1 ; i <array.length; i++){
			c = array[i].charAt(0);
			str = ""+c;
		    str = str.toUpperCase();
		    array[i] =  str + array[i].substring(1);;
		}
		for(int i = 0; i < array.length; i++){
			nameCamel  += array[i];
		}
		return nameCamel;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HomeWork2 hw = new HomeWork2();
		System.out.print("请输入您要转换的字符串：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("result:"+hw.camel(name));
	}

}
