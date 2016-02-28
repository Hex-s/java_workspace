package com.niit.collection.list;

import java.util.LinkedList;

public class LinkedListExam {

	/**
	 * LinkedList链表结构的集合
	 * 该集合在逻辑上是连续存储，但是在物理上是非连续存储，每个元素通过指针指向下一个元素，因此在进行增删改的时候有着更高的性能
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//添加元素到集合的头部
		list.addFirst("e");
		
		//删除最后的元素
		list.removeLast();
		
		//获取第一个元素
//		String s = list.getFirst();
//		System.out.println(s);
		
		//获取第一个元素
//		String s = list.peekFirst();
//		System.out.println(s);
		
		//弹出栈顶的元素,移除栈顶元素并获取
		String s = list.pop();
		System.out.println(s);
		
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}

}
