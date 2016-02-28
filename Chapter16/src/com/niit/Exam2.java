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
	 * 打印显示所有文件信息
	 * @param file
	 */
	public void showAllFiles(File file){
		//判断文件是否存在
		if(file.exists()){
			//显示文件的名称
			System.out.println(file.getAbsolutePath());
			//判断文件是否是文件夹
			if(file.isDirectory()){
				//获取文件夹中的子文件
				File[] files = file.listFiles();
				//判断子文件是否存在
				if(files != null){
					//遍历子文件
					for(File childFile : files){
						//递归显示子文件
						showAllFiles(childFile);
					}
				}
			}
		}
	}

	/**
	 * 创建文件
	 * @param parentPath 文件所在的父文件路径
	 * @param fileName 新文件的文件名
	 * @param flag 文件类型的标识，true表示文件  false表示新建文件夹
	 */
	public void createFile(String parentPath, String fileName, boolean flag){
		//根据父文件的路径和新文件的名称获取文件对象
		File file = new File(parentPath, fileName);
		//判断文件是否存在
		if(!file.exists()){
			//如果文件不存在
			//判断新建文件的类型
			if(flag){
				try {
					//新建文件
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				//新建文件夹
				file.mkdir();
			}	
		}	
	}
	/**
	 * 删除文件
	 * @param file 被删除的文件
	 */
	public void deleteFile(File file){
		//判断文件是否存在
		if(file.exists()){
			//如果文件存在
			//判断文件是否是文件夹
			if(file.isDirectory()){
				//如果是文件夹，获取文件夹中的子文件
				File[] files = file.listFiles();
				//判断文件夹中是否包含子文件
				if(files != null){
					//如果包含子文件，递归删除文件
					for(File childFile : files){
						deleteFile(childFile);
					}
				}
			}
			//无论文件是类型都应删除自身
			file.delete();
		}
	}
	/**
	 * 重命名
	 * @param file 需要重命名的文件
	 * @param newFileName 文件的新名称
	 */
	public void rename(File file, String newFileName){
		//判断文件是否存在
		if(file.exists()){
			//如果文件存在
			//创建更名后的文件对象
			File newFile = new File(file.getParent(), newFileName);
			//判断改名后的文件是否存在
			if(!newFile.exists()){
				//如果改名后的文件不存在的
				//重命名
				file.renameTo(newFile);
			}
			
		}
		
	}
	/**
	 * 拷贝文件
	 * @param file 复制的文件
	 * @param targetPath 文件复制后的目标路径
	 */
	public void copyFile(File file, String targetPath){
		//判断要复制的文件是否存在
		if(file.exists()){
			//如果文件存在，根据目标路径和要复制的文件创建复制后的新文件对象
			File newFile = new File(targetPath,file.getName());
			//判断复制后的新文件是否存在
			if(newFile.exists()){
				//如果文件存在，给出提示是否要覆盖
				int choice = JOptionPane.showConfirmDialog(null, "是否确定要覆盖文件?");
				if(choice == JOptionPane.YES_OPTION){
					//删除原有的文件
					deleteFile(file);
					//复制现有的文件
					copyFile(file, targetPath);
				}
			}
			//如果不存在，判断该文件的类型是文件还是文件夹
			else{
				if(file.isFile()){
					//如果是文件，使用IO流进行读写
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
					//如果是文件夹，根据新文件对象创建文件夹
					newFile.mkdir();
					//获取文件夹的子文件
					File[] files = file.listFiles();
					//判断子文件是否存在
					if(files != null){
						//遍历子文件
						for(File childFile : files){
							//递归复制子文件
							copyFile(childFile, newFile.getAbsolutePath());
						}
					}
				}	
			}
		}
	}
	/**
	 * 剪切文件
	 * @param file 剪切的文件
	 * @param targetPath 文件剪切后的目标路径
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
		//遍历显示电脑中的所有文件
//		File[] disks = File.listRoots();
//		for(File disk : disks){
//			ex.showAllFiles(disk);
//		}
		
		//新建文件
		//ex.createFile("d:/", "a",false);
		
		//文件重命名
		//ex.rename(new File("d:/hello"), "image");
		
		//删除文件
		//ex.deleteFile(new File("d:/hello"));
		
		//复制文件
		ex.copyFile(new File("d:/hello"), "e:/");
	}

}
