package com.niit.collection.set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetExam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����������������ظ����������ݣ�Ҫ����������е��ظ������޳��������ձ���һ��������û���ظ�����������
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		list.add("b");
		
		//����HashSet����
		HashSet<String> set = new HashSet<String>();
		//����ArrayList������ÿһ��Ԫ�ش���HashSet��
		for(String s : list){
			set.add(s);
		}
		//����HashSet����
		for(String s : set){
			System.out.println(s);
		}

	}

}
