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
		//���ļ�ѡ�񴰿�
		//int choice = chooser.showDialog(null, "�ļ�ѡ��");
		//int choice = chooser.showOpenDialog(null);
		//����ѡ��ģʽ
		//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//�����ļ��Ĺ�����
		chooser.setFileFilter(new FileNameExtensionFilter("ͼƬ", "gif","jpg","bmp"));
		int choice = chooser.showSaveDialog(null);
		//�ж��Ƿ�����ѡ��ť
		if(choice == JFileChooser.APPROVE_OPTION){
			//��ȡѡ�е��ļ�
			File file = chooser.getSelectedFile();
			JOptionPane.showMessageDialog(null, file.getAbsolutePath());
		}
		
		
		

	}

}
