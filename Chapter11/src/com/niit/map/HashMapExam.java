package com.niit.map;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExam {

	public static void main(String[] args) {
		
		//创建map集合
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		//添加键值对元素
		map.put(1001, "tom");
		map.put(1002, "jack");
		map.put(1003, "tony");
		map.put(1004, "jerry");
		
		//根据键获取值
//		String value = map.get(1002);
//		System.out.println(value);
		
		//删除元素
		//map.remove(1001);
		
		//判断集合中是否包含某个键
		//System.out.println(map.containsKey(1006));
		//是否包含某个值
		//System.out.println(map.containsValue("tom"));
		
		//遍历集合方式一 根据键进行遍历
		for(Integer key : map.keySet()){
			//每次循环获取集合中的一个键，通过键获取值
			String value = map.get(key);
			System.out.println(key+" "+value);
		}
		
		//遍历集合方式二 根据所有的值进行遍历
//		for(String value : map.values()){
//			System.out.println(value);
//		}
		
		//遍历集合方式三 根据所有的键值对进行遍历
//		for(Entry<Integer, String> entry : map.entrySet()){
//			//通过Entry获取键和值
//			System.out.println(entry.getKey()+"\t"+entry.getValue());
//		}
		
		
		
		
	}
}
