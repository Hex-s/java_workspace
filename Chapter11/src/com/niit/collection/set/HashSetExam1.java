package com.niit.collection.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Set集合是无序存储元素,不能存储重复的元素
		HashSet<String> set = new HashSet<String>();
		//添加元素
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("b");
		
		//显示集合的元素数量
		System.out.println(set.size());
		
		//由于Set集合不存在索引，因此没有基于索引的获取元素方法，也没有基于索引移除或修改元素的方法
		//遍历set集合只能通过迭代器或者增强for循环
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()){
			String s = ite.next();
			System.out.println(s);
		}
		
		
		
		
	}

}
