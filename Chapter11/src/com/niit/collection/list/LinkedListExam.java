package com.niit.collection.list;

import java.util.LinkedList;

public class LinkedListExam {

	/**
	 * LinkedList����ṹ�ļ���
	 * �ü������߼����������洢���������������Ƿ������洢��ÿ��Ԫ��ͨ��ָ��ָ����һ��Ԫ�أ�����ڽ�����ɾ�ĵ�ʱ�����Ÿ��ߵ�����
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//���Ԫ�ص����ϵ�ͷ��
		list.addFirst("e");
		
		//ɾ������Ԫ��
		list.removeLast();
		
		//��ȡ��һ��Ԫ��
//		String s = list.getFirst();
//		System.out.println(s);
		
		//��ȡ��һ��Ԫ��
//		String s = list.peekFirst();
//		System.out.println(s);
		
		//����ջ����Ԫ��,�Ƴ�ջ��Ԫ�ز���ȡ
		String s = list.pop();
		System.out.println(s);
		
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}

}
