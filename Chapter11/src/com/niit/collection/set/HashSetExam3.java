package com.niit.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//����Set����
		Set<User> set = new HashSet<User>();
		User user1 = new User(1, "tom");
		User user2 = new User(2, "jack");
		User user3 = new User(3, "jerry");
		User user4 = new User(4, "tony");
		//set����ظ�Ԫ���ǻ����ڴ��ַ���ж�
		//�����Set����Ҫ������������߼�������ͬ�����ݣ��������ǲ�ͬ������ʱ���ͱ�����дҪ��Ӷ����hashCode������equals����
		User user5 = new User(2, "jack");
		
		set.add(user1);
		set.add(user2);
		set.add(user3);
		set.add(user4);
		set.add(user5);
		
		User u = null;
		//��������
//		for(User user : set){
//			//��ȡ���Ϊ2��User����
//			if(user.getUserId() == 2){
//				u = user;
//			}
//			//System.out.println(user.getUserId()+"\t"+user.getName());
//		}
		//����ȡ�ı��Ϊ2���û����������޸�
		//u.setName("lucy");
		//����޸ĺ���û�
		//set.add(u);
		
		for(User user : set){
			System.out.println(user.getUserId()+"\t"+user.getName());
		}
	}

}
