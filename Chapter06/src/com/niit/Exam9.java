package com.niit;

public class Exam9 {

	public static void main(String[] args){
		//�����ַ���StringBuffer
		//String�ǲ��ɱ䳤�ȵ��ַ�����StringBuffer�ǿɱ䳤�ȵ��ַ���
		//��������Ҫ����ƴ���ַ����ĳ��ϣ��ʺ�ʹ��StringBuffer������
		
		//������ֵ��StringBuffer
		StringBuffer buffer = new StringBuffer();
		//StringBuffer��String�����໥ת��
		String str = "hello";
//		//��StringBufferת����String
//		str = buffer.toString();
//		System.out.println(str);
//		//��String���͹�����StringBuffer
		buffer = new StringBuffer(str);
		System.out.println(buffer);
		
		//ͨ��append׷���ַ�����ֵ
		buffer.append("niit");
		System.out.println(buffer);
		String str1 = buffer.substring(5);
		System.out.println(str1);
//		buffer.deleteCharAt(5);
//		buffer.delete(0, 5);
		buffer.setCharAt(5, 'm');
		System.out.println(buffer);
	}
}
