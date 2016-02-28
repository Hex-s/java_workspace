package com.niit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Exam2 {
	/**
	 * ��ӡ��ʾ�����ļ���Ϣ
	 * @param file
	 */
	public void showAllFiles(File file){
		//�ж��ļ��Ƿ����
		if(file.exists()){
			//��ʾ�ļ�������
			System.out.println(file.getAbsolutePath());
			//�ж��ļ��Ƿ����ļ���
			if(file.isDirectory()){
				//��ȡ�ļ����е����ļ�
				File[] files = file.listFiles();
				//�ж����ļ��Ƿ����
				if(files != null){
					//�������ļ�
					for(File childFile : files){
						//�ݹ���ʾ���ļ�
						showAllFiles(childFile);
					}
				}
			}
		}
	}

	/**
	 * �����ļ�
	 * @param parentPath �ļ����ڵĸ��ļ�·��
	 * @param fileName ���ļ����ļ���
	 * @param flag �ļ����͵ı�ʶ��true��ʾ�ļ�  false��ʾ�½��ļ���
	 */
	public void createFile(String parentPath, String fileName, boolean flag){
		//���ݸ��ļ���·�������ļ������ƻ�ȡ�ļ�����
		File file = new File(parentPath, fileName);
		//�ж��ļ��Ƿ����
		if(!file.exists()){
			//����ļ�������
			//�ж��½��ļ�������
			if(flag){
				try {
					//�½��ļ�
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				//�½��ļ���
				file.mkdir();
			}	
		}	
	}
	/**
	 * ɾ���ļ�
	 * @param file ��ɾ�����ļ�
	 */
	public void deleteFile(File file){
		//�ж��ļ��Ƿ����
		if(file.exists()){
			//����ļ�����
			//�ж��ļ��Ƿ����ļ���
			if(file.isDirectory()){
				//������ļ��У���ȡ�ļ����е����ļ�
				File[] files = file.listFiles();
				//�ж��ļ������Ƿ�������ļ�
				if(files != null){
					//����������ļ����ݹ�ɾ���ļ�
					for(File childFile : files){
						deleteFile(childFile);
					}
				}
			}
			//�����ļ������Ͷ�Ӧɾ������
			file.delete();
		}
	}
	/**
	 * ������
	 * @param file ��Ҫ���������ļ�
	 * @param newFileName �ļ���������
	 */
	public void rename(File file, String newFileName){
		//�ж��ļ��Ƿ����
		if(file.exists()){
			//����ļ�����
			//������������ļ�����
			File newFile = new File(file.getParent(), newFileName);
			//�жϸ�������ļ��Ƿ����
			if(!newFile.exists()){
				//�����������ļ������ڵ�
				//������
				file.renameTo(newFile);
			}
			
		}
		
	}
	/**
	 * �����ļ�
	 * @param file ���Ƶ��ļ�
	 * @param targetPath �ļ����ƺ��Ŀ��·��
	 */
	public void copyFile(File file, String targetPath){
		//�ж�Ҫ���Ƶ��ļ��Ƿ����
		if(file.exists()){
			//����ļ����ڣ�����Ŀ��·����Ҫ���Ƶ��ļ��������ƺ�����ļ�����
			File newFile = new File(targetPath,file.getName());
			//�жϸ��ƺ�����ļ��Ƿ����
			if(newFile.exists()){
				//����ļ����ڣ�������ʾ�Ƿ�Ҫ����
				int choice = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫ�����ļ�?");
				if(choice == JOptionPane.YES_OPTION){
					//ɾ��ԭ�е��ļ�
					deleteFile(file);
					//�������е��ļ�
					copyFile(file, targetPath);
				}
			}
			//��������ڣ��жϸ��ļ����������ļ������ļ���
			else{
				if(file.isFile()){
					//������ļ���ʹ��IO�����ж�д
					try {
						FileInputStream input = new FileInputStream(file);
						FileOutputStream output = new FileOutputStream(newFile);
						int data;
						while((data = input.read()) != -1){
							output.write(data);
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
				else{
					//������ļ��У��������ļ����󴴽��ļ���
					newFile.mkdir();
					//��ȡ�ļ��е����ļ�
					File[] files = file.listFiles();
					//�ж����ļ��Ƿ����
					if(files != null){
						//�������ļ�
						for(File childFile : files){
							//�ݹ鸴�����ļ�
							copyFile(childFile, newFile.getAbsolutePath());
						}
					}
				}	
			}
		}
	}
	/**
	 * �����ļ�
	 * @param file ���е��ļ�
	 * @param targetPath �ļ����к��Ŀ��·��
	 */
	public void cutFile(File file, String targetPath){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam2 ex = new Exam2();
		//ex.showAllFiles(new File("d:/"));
		//������ʾ�����е������ļ�
//		File[] disks = File.listRoots();
//		for(File disk : disks){
//			ex.showAllFiles(disk);
//		}
		
		//�½��ļ�
		//ex.createFile("d:/", "a",false);
		
		//�ļ�������
		//ex.rename(new File("d:/hello"), "image");
		
		//ɾ���ļ�
		//ex.deleteFile(new File("d:/hello"));
		
		//�����ļ�
		ex.copyFile(new File("d:/hello"), "e:/");
	}

}
