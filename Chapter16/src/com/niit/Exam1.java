package com.niit;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�����ļ���ʽһ��  ������ʾҪ�����ļ��ľ���·��
		File file = new File("d:/image");
		//��ʽ���� ��һ��������ʾ���ļ����󣬵ڶ���������ʾҪ�����ļ������·��
		//File file = new File(new File("d:\\image"), "edit.gif");
		//��ʽ�� ��һ��������ʾ���ļ��ľ���·�����ڶ���������ʾҪ�����ļ������·��
		//File file = new File("d:/image", "edit.gif");
		
		//��ȡ�ļ����ļ���
		System.out.println(file.getName());
		//��ȡ�ļ��ľ���·��
		System.out.println(file.getAbsolutePath());
		//��ȡ���ļ���·��
		System.out.println(file.getParent());
		//��ȡ���ļ�����
		System.out.println(file.getParentFile().isDirectory());
		//��ȡ�ļ������̷��Ŀ��пռ�
		System.out.println(file.getFreeSpace());
		//��ȡ�ļ������̷����ܵĿռ��ֽ���
		System.out.println(file.getTotalSpace());
		//�ж��ļ��������Ƿ����ļ���
		System.out.println(file.isDirectory());
		//�ж��ļ��������Ƿ��ǵ����ļ�
		System.out.println(file.isFile());
		//��ȡ�ļ���ʵ�ʴ�С(�ļ���û��������С)
		System.out.println(file.length());
		//��ȡ�ļ�����޸ĵ�ʱ��
		//System.out.println(file.lastModified());
		long time = file.lastModified();
		Date date = new Date(time);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		//�Ƿ��ǿ�ִ��
		System.out.println(file.canExecute());
		//�Ƿ�ɶ�ȡ
		System.out.println(file.canRead());
		//�Ƿ��д���ж��ļ��Ƿ���ֻ���ģ�
		System.out.println(file.canWrite());
		//�����ļ��Ƿ��д
		file.setWritable(true);
		//�Ƿ��������ļ�
		System.out.println(file.isHidden());
		//�ж��ļ��Ƿ����
		if(file.exists()){
			System.out.println("�ļ�����");
		}
		else{
			System.out.println("�ļ�������");
		}
		
		//�ܹ���ȡ���ļ����ļ�����Ӧ�����ļ���
		
		//��ȡ�ļ������ļ������·��
//		String[] filePath = file.list();
//		for(String path : filePath){
//			System.out.println(path);
//		}
		//��ȡ�ļ��е��������ļ�
//		File[] childFiles = file.listFiles();
//		for(File childFile : childFiles){
//			System.out.println(childFile.getAbsolutePath());
//		}
		//��ȡ���е�Ӳ���̷�
		File[] disks = File.listRoots();
		for(File disk : disks){
			System.out.println(disk);
			System.out.println(disk.isDirectory());
		}
	}

}
