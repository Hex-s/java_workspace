package com.niit.collection.list;

import java.util.Iterator;
import java.util.Stack;

public class StackExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ջ�ṹ�Ĵ洢�ص㣺�Ƚ����
		Stack<String> stack = new Stack<String>();
		//ѹջ����Ԫ�ش���ջ��
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		//�鿴ջ����Ԫ��
//		String s = stack.peek();
//		System.out.println(s);
		
		//��ջ����ջ����Ԫ���Ƴ�
		String s = stack.pop();
		System.out.println(s);
		
		//ʹ�õ���������ջ��Ԫ��
		Iterator<String> ite = stack.iterator();
		while(ite.hasNext()){
			String element = ite.next();
			System.out.println(element);
		}
	}

}
