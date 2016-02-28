package com.niit.collection.set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetExam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//现有数组存在若干重复的姓名数据，要求将这个数组中的重复数据剔除掉，最终保留一份完整的没有重复姓名的名单
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		list.add("b");
		
		//创建HashSet集合
		HashSet<String> set = new HashSet<String>();
		//遍历ArrayList，并将每一个元素存入HashSet中
		for(String s : list){
			set.add(s);
		}
		//遍历HashSet集合
		for(String s : set){
			System.out.println(s);
		}

	}

}
