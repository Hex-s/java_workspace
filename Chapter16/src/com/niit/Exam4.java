package com.niit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ʹ���������������ͼƬ
//		try {
//			//������������ȡͼƬ
//			FileInputStream input = new FileInputStream(new File("d:/image/back.jpg"));
//			//���������д��ͼƬ����Ϣ
//			FileOutputStream output = new FileOutputStream(new File("d:/a.jpg"));
//			int data;
//			//ѭ����ȡͼƬ�е�ÿ���ֽ�
//			while((data = input.read()) != -1){
//				//����ȡ��ÿ���ֽ�ͨ�������д�뵽��һ���ļ���
//				output.write(data);
//			}
//			input.close();
//			output.flush();
//			output.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//ʹ�û���������ͼƬ
		//�����ֽڻ���������,�������������ֽ�������
//		try {
//			BufferedInputStream buffInput = new BufferedInputStream(new FileInputStream(new File("d:/image/back.jpg")));
//			//�����ֽڻ��������
//			BufferedOutputStream buffOutput = new BufferedOutputStream(new FileOutputStream(new File("d:/a.jpg")));
//			//��ȡ������������
//			int data;
//			while((data = buffInput.read()) != -1){
//				buffOutput.write(data);
//			}
//			buffInput.close();
//			buffOutput.flush();
//			buffOutput.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//ʹ���ֽ���ʵ�ֻ��幦��
		//���´���ʵ�������ļ��Ļ���
//		try {
//			FileInputStream input = new FileInputStream(new File("d:/image/back.jpg"));
//			FileOutputStream output = new FileOutputStream(new File("d:/a.jpg"));
//			//��������
//			byte[] data = new byte[100000];
//			//ͨ������������ȡ����Ϣд�뻺������
//			input.read(data);
//			//����ȡ����Ϣͨ����������
//			output.write(data);
//			input.close();
//			output.flush();
//			output.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//�����ļ�Ӧ���ļ���ȡ��ĳһ�����ݽ��л��壬Ȼ���ٴӻ����������Ϣ��ͬʱ������ȡ��һ��д����������
		try {
			FileInputStream input = new FileInputStream(new File("d:/image/back.jpg"));
			FileOutputStream output = new FileOutputStream(new File("d:/a.jpg"));
			//������������
			byte[] data = new byte[1024];
			//��ȡ�����ݳ���
			int len;
			while((len = input.read(data)) != -1){
				//�Ի�������ݽ������
				output.write(data, 0, len);
			}
			input.close();
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
