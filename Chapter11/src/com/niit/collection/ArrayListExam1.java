package com.niit.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExam1 {

	/**
	 * ArrayList动态数组
	 * 执行查询有着非常高的性能
	 * 执行新增和删除性能较差
	 * @param args
	 */
	public static void main(String[] args) {
		
		//创建ArrayList集合
		ArrayList list = new ArrayList();
		//添加元素
		list.add("tom");
		list.add("jack");
		list.add("tony");
		list.add("marry");
		list.add("jerry");
		
//		for(int i = 0; i <=10 ; i++){
//			list.add(i+"");
//		}
		
		
		//集合可以存储各种数据类型
//		list.add(19);
//		list.add(true);
		
		//根据指定索引位置添加元素
//		list.add(2, "zack");
		//批量添加集合
//		ArrayList newList = new ArrayList();
//		newList.add("a");
//		newList.add("b");
//		newList.add("c");
//		list.addAll(newList);
		
		//移除集合中的所有元素
//		list.clear();
		
		//显示集合的元素数量
		System.out.println(list.size());
		
		//获取指定元素的索引位置
//		int index = list.indexOf("jack");
//		System.out.println(index);
		
		//判断集合中是否存在john
//		if(list.indexOf("john") != -1){
//			System.out.println("包含该元素");
//		}
//		else{
//			System.out.println("该元素不存在");
//		}	
//		if(list.contains("jerry")){
//			System.out.println("包含该元素");
//		}
//		else{
//			System.out.println("该元素不存在");
//		}
		
		//判断集合是否有元素
//		System.out.println(list.isEmpty());
		
		//根据索引移除集合中的元素，返回被移除的元素
//		Object obj = list.remove(3);
//		System.out.println("被删除的元素是："+obj);
		
		//根据元素进行删除，返回成功与否的标识
//		System.out.println(list.remove("tony"));
		
		//批量删除元素
		//list.removeAll(newList);
		
		//指定索引位置修改集合中元素的值
//		list.set(3, "lucy");
		
		
		//打印集合的每一个元素方式一，根据下标获取元素
//		for(int i = 0; i < list.size(); i++){
//			//根据索引获取元素
//			System.out.println(list.get(i));
//		}
		
		//方式二 根据迭代器获取元素
		//获取迭代器
		//Iterator ite = list.iterator();
		//遍历访问迭代器
		//hasNext方法表示判断迭代器中是否还有下一个元素
//		while(ite.hasNext()){
//			//获取下一个元素
//			Object obj = ite.next();
//			System.out.println(obj);
//		}
		
		//方式三 增强for循环,该循环只能以只读的方式遍历集合或数组
//		for(Object obj : list){
//			//增强for循环时不能对被遍历的集合或数组进行增删改的动作，否则将出现线程异常
//			//list.add("a");
//			System.out.println(obj);
//		}
		//遍历数组
//		String[] array = new String[]{"java","oracle","jsp"};
//		for(String str : array){
//			System.out.println(str);
//		}
	}

}
