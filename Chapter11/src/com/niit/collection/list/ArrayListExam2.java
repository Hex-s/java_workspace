package com.niit.collection.list;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListExam2 {

	public static void main(String[] args) {
		//ArrayList list = new ArrayList();
		
		//ͨ������ǿ�����ϵİ�ȫ�ԣ�ͳһ���ϴ洢����������,�������ݵĲ������
//		ArrayList<User> list = new ArrayList<User>();
//		User user1 = new User("tom");
//		User user2 = new User("jack");
//		User user3 = new User("lucy");
//		//���û�������뼯��
//		list.add(user1);
//		list.add(user2);
//		list.add(user3);
//		//list.add("tony");
//		
//		//��������
//		for(User user : list){
//			//�����User����
//			//User user = (User)obj;
//			System.out.println(user.getName());
//		}
		
		//����ָ�������ͱ�����������������
		//ArrayList<Integer> list = new ArrayList<Integer>();
		
		//������Ҳ����ָ�������������ͣ��γ�Ƕ�׵ļ���
		//ArrayList<Collection<Integer>> list = new ArrayList<Collection<Integer>>();
		
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		//�����Ӽ���
		ArrayList<String> childList1 = new ArrayList<String>();
		childList1.add("a");
		childList1.add("b");
		
		ArrayList<String> childList2 = new ArrayList<String>();
		childList2.add("c");
		childList2.add("d");
		
		//���Ӽ��������������
		list.add(childList1);
		list.add(childList2);
		
		//��������
		//������������
		for(ArrayList<String> childList : list){
			//������ÿһ���Ӽ���
			for(String s : childList){
				System.out.print(s+"\t");
			}
			System.out.println();
		}
		
	}
}
