package com.niit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ʹ���ַ�����ȡ�ı��ļ�
		//�ַ������ܶ�ͼƬ��Ӱ����Ƶ�ȵ��ֽڹ��ɵ��ļ����ж�ȡ
//		try {
//			//�����ַ�������
//			InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("d:/a.jpg")));
//			//�����ַ������
//			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("d:/b.jpg")));
//			int data;
//			while((data = reader.read()) != -1){
//				//System.out.println(data);
//				writer.write(data);
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//�����ַ���
		//InputerStreamReader���ֽ���ͨ���ַ���������
//		try {
//			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/ѭ����ϰ.txt"))));
//			//readLine��ʾ��ȡ�ļ��е�һ���ı���Ϣ
//			//System.out.println(reader.readLine());
//			String str;
//			while((str = reader.readLine()) != null){
//				System.out.println(str);
//			}
//			reader.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//ʹ�û����ַ������д���ļ���Ϣ
//		try {
//			//ͨ����������ļ�׷�����ݣ���Ҫ�ڹ����ֽ�����ʱ����ӵڶ�������������ʾ�Ƿ���ԭ�ļ���׷������
//			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("d:/a.txt"),true)));
//			writer.write("hello");
//			//����һ�����з�
//			//writer.newLine();
//			//ͨ�����е�ת���ʵ��
//			writer.write("\r\n");
//			writer.write("niit\r\n");
//			writer.flush();
//			writer.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
