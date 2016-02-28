package com.niit.map;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExam {

	public static void main(String[] args) {
		
		//����map����
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		//��Ӽ�ֵ��Ԫ��
		map.put(1001, "tom");
		map.put(1002, "jack");
		map.put(1003, "tony");
		map.put(1004, "jerry");
		
		//���ݼ���ȡֵ
//		String value = map.get(1002);
//		System.out.println(value);
		
		//ɾ��Ԫ��
		//map.remove(1001);
		
		//�жϼ������Ƿ����ĳ����
		//System.out.println(map.containsKey(1006));
		//�Ƿ����ĳ��ֵ
		//System.out.println(map.containsValue("tom"));
		
		//�������Ϸ�ʽһ ���ݼ����б���
		for(Integer key : map.keySet()){
			//ÿ��ѭ����ȡ�����е�һ������ͨ������ȡֵ
			String value = map.get(key);
			System.out.println(key+" "+value);
		}
		
		//�������Ϸ�ʽ�� �������е�ֵ���б���
//		for(String value : map.values()){
//			System.out.println(value);
//		}
		
		//�������Ϸ�ʽ�� �������еļ�ֵ�Խ��б���
//		for(Entry<Integer, String> entry : map.entrySet()){
//			//ͨ��Entry��ȡ����ֵ
//			System.out.println(entry.getKey()+"\t"+entry.getValue());
//		}
		
		
		
		
	}
}
