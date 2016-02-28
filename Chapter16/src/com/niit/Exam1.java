package com.niit;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建文件方式一：  参数表示要访问文件的绝对路径
		File file = new File("d:/image");
		//方式二： 第一个参数表示父文件对象，第二个参数表示要访问文件的相对路径
		//File file = new File(new File("d:\\image"), "edit.gif");
		//方式三 第一个参数表示父文件的绝对路径，第二个参数表示要访问文件的相对路径
		//File file = new File("d:/image", "edit.gif");
		
		//获取文件的文件名
		System.out.println(file.getName());
		//获取文件的绝对路径
		System.out.println(file.getAbsolutePath());
		//获取父文件的路径
		System.out.println(file.getParent());
		//获取父文件对象
		System.out.println(file.getParentFile().isDirectory());
		//获取文件所在盘符的空闲空间
		System.out.println(file.getFreeSpace());
		//获取文件所在盘符的总的空间字节数
		System.out.println(file.getTotalSpace());
		//判断文件的类型是否是文件夹
		System.out.println(file.isDirectory());
		//判断文件的类型是否是单个文件
		System.out.println(file.isFile());
		//获取文件的实际大小(文件夹没有容量大小)
		System.out.println(file.length());
		//获取文件最后修改的时间
		//System.out.println(file.lastModified());
		long time = file.lastModified();
		Date date = new Date(time);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		//是否是可执行
		System.out.println(file.canExecute());
		//是否可读取
		System.out.println(file.canRead());
		//是否可写（判断文件是否是只读的）
		System.out.println(file.canWrite());
		//设置文件是否可写
		file.setWritable(true);
		//是否是隐藏文件
		System.out.println(file.isHidden());
		//判断文件是否存在
		if(file.exists()){
			System.out.println("文件存在");
		}
		else{
			System.out.println("文件不存在");
		}
		
		//能够获取子文件的文件对象应该是文件夹
		
		//获取文件的子文件的相对路径
//		String[] filePath = file.list();
//		for(String path : filePath){
//			System.out.println(path);
//		}
		//获取文件中的所有子文件
//		File[] childFiles = file.listFiles();
//		for(File childFile : childFiles){
//			System.out.println(childFile.getAbsolutePath());
//		}
		//获取所有的硬盘盘符
		File[] disks = File.listRoots();
		for(File disk : disks){
			System.out.println(disk);
			System.out.println(disk.isDirectory());
		}
	}

}
