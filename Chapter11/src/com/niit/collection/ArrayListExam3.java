package com.niit.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<User>();
		User user1 = new User(1001,"tom");
		User user2 = new User(1002,"jack");
		User user3 = new User(1003,"lucy");
		//���û�������뼯��
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		//�жϼ������Ƿ����lucy�û�
//		User newUser = new User("lucy");
		//ͨ��get������ȡ�ļ�����Ԫ�ض�������
//		User newUser = list.get(0);
//		newUser.setName("tony");
		
		//��������еķ������Զ������ͣ���ʹ��contains��indexOf�����жϵ�ʱ��һ��Ҫ��д�����equals����
//		if(list.contains(newUser)){
//			System.out.println("�������û�");
//		}
//		else{
//			System.out.println("���û�������");
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����Ҫ�������û���ţ�");
		int userId = sc.nextInt();
		//�����û���Ŵ����û�����
		User newUser = new User(userId);
		
		//�ж��û��Ƿ����
//		boolean hasUser = false;
//		for(User user : list){
//			if(user.getUserId() == userId){
//				hasUser = true;
//				break;
//			}
//		}
//		if(hasUser){
//			System.out.println("�û����ڣ�");
//		}
		
		if(list.contains(newUser)){
//			System.out.println("�������û�");
			//������ڴ�ӡ�û�������
			//System.out.println(list.get(list.indexOf(newUser)).getName());
			//���ݶ����������
			int index = list.indexOf(newUser);
			//����������ȡ����
			User user = list.get(index);
			System.out.println(user.getName());
			
		}
		else{
			System.out.println("���û�������");
		}
		
//		for(User user : list){
//			System.out.println(user.getName());
//		}
	}

}
