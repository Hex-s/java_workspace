package com.niit.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExam1 {

	/**
	 * ArrayList��̬����
	 * ִ�в�ѯ���ŷǳ��ߵ�����
	 * ִ��������ɾ�����ܽϲ�
	 * @param args
	 */
	public static void main(String[] args) {
		
		//����ArrayList����
		ArrayList list = new ArrayList();
		//���Ԫ��
		list.add("tom");
		list.add("jack");
		list.add("tony");
		list.add("marry");
		list.add("jerry");
		
//		for(int i = 0; i <=10 ; i++){
//			list.add(i+"");
//		}
		
		
		//���Ͽ��Դ洢������������
//		list.add(19);
//		list.add(true);
		
		//����ָ������λ�����Ԫ��
//		list.add(2, "zack");
		//������Ӽ���
//		ArrayList newList = new ArrayList();
//		newList.add("a");
//		newList.add("b");
//		newList.add("c");
//		list.addAll(newList);
		
		//�Ƴ������е�����Ԫ��
//		list.clear();
		
		//��ʾ���ϵ�Ԫ������
		System.out.println(list.size());
		
		//��ȡָ��Ԫ�ص�����λ��
//		int index = list.indexOf("jack");
//		System.out.println(index);
		
		//�жϼ������Ƿ����john
//		if(list.indexOf("john") != -1){
//			System.out.println("������Ԫ��");
//		}
//		else{
//			System.out.println("��Ԫ�ز�����");
//		}	
//		if(list.contains("jerry")){
//			System.out.println("������Ԫ��");
//		}
//		else{
//			System.out.println("��Ԫ�ز�����");
//		}
		
		//�жϼ����Ƿ���Ԫ��
//		System.out.println(list.isEmpty());
		
		//���������Ƴ������е�Ԫ�أ����ر��Ƴ���Ԫ��
//		Object obj = list.remove(3);
//		System.out.println("��ɾ����Ԫ���ǣ�"+obj);
		
		//����Ԫ�ؽ���ɾ�������سɹ����ı�ʶ
//		System.out.println(list.remove("tony"));
		
		//����ɾ��Ԫ��
		//list.removeAll(newList);
		
		//ָ������λ���޸ļ�����Ԫ�ص�ֵ
//		list.set(3, "lucy");
		
		
		//��ӡ���ϵ�ÿһ��Ԫ�ط�ʽһ�������±��ȡԪ��
//		for(int i = 0; i < list.size(); i++){
//			//����������ȡԪ��
//			System.out.println(list.get(i));
//		}
		
		//��ʽ�� ���ݵ�������ȡԪ��
		//��ȡ������
		//Iterator ite = list.iterator();
		//�������ʵ�����
		//hasNext������ʾ�жϵ��������Ƿ�����һ��Ԫ��
//		while(ite.hasNext()){
//			//��ȡ��һ��Ԫ��
//			Object obj = ite.next();
//			System.out.println(obj);
//		}
		
		//��ʽ�� ��ǿforѭ��,��ѭ��ֻ����ֻ���ķ�ʽ�������ϻ�����
//		for(Object obj : list){
//			//��ǿforѭ��ʱ���ܶԱ������ļ��ϻ����������ɾ�ĵĶ��������򽫳����߳��쳣
//			//list.add("a");
//			System.out.println(obj);
//		}
		//��������
//		String[] array = new String[]{"java","oracle","jsp"};
//		for(String str : array){
//			System.out.println(str);
//		}
	}

}
