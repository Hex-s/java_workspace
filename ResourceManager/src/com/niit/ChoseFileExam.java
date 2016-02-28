package com.niit;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChoseFileExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		JFileChooser chooser = new JFileChooser();
		//打开文件选择窗口
		//int choice = chooser.showDialog(null, "文件选择");
		//int choice = chooser.showOpenDialog(null);
		//设置选择模式
		//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//设置文件的过滤器
		chooser.setFileFilter(new FileNameExtensionFilter("图片", "gif","jpg","bmp"));
		int choice = chooser.showSaveDialog(null);
		//判断是否点击了选择按钮
		if(choice == JFileChooser.APPROVE_OPTION){
			//获取选中的文件
			File file = chooser.getSelectedFile();
			JOptionPane.showMessageDialog(null, file.getAbsolutePath());
		}
		
		
		

	}

}
