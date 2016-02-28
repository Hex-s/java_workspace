package com.niit.collection.list;

import java.util.Iterator;
import java.util.Stack;

public class StackExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//栈结构的存储特点：先进后出
		Stack<String> stack = new Stack<String>();
		//压栈即将元素存入栈底
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		//查看栈顶的元素
//		String s = stack.peek();
//		System.out.println(s);
		
		//弹栈即将栈顶的元素移除
		String s = stack.pop();
		System.out.println(s);
		
		//使用迭代器迭代栈的元素
		Iterator<String> ite = stack.iterator();
		while(ite.hasNext()){
			String element = ite.next();
			System.out.println(element);
		}
	}

}
