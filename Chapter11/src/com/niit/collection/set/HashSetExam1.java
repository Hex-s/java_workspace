package com.niit.collection.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Set����������洢Ԫ��,���ܴ洢�ظ���Ԫ��
		HashSet<String> set = new HashSet<String>();
		//���Ԫ��
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("b");
		
		//��ʾ���ϵ�Ԫ������
		System.out.println(set.size());
		
		//����Set���ϲ��������������û�л��������Ļ�ȡԪ�ط�����Ҳû�л��������Ƴ����޸�Ԫ�صķ���
		//����set����ֻ��ͨ��������������ǿforѭ��
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()){
			String s = ite.next();
			System.out.println(s);
		}
		
		
		
		
	}

}
