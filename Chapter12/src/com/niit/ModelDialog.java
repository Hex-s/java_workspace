package com.niit;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class ModelDialog extends JFrame {
	
	private JDialog dialog;
	
	public ModelDialog(){
		
		this.setBounds(200, 200, 400, 400);
		
		//ʵ�����Ի���
		//��һ��������ʾ�Ի����ǳ������ĸ������еģ��ڶ���������ʾ�Ƿ����øöԻ���Ϊģʽ�Ի���
		//ģʽ�Ի�����ص㣺ʼ�ռ���Ի��򣬲��Ҳ��ܶ���������ʹ�����з��ʣ�ֱ���Ի��򱻹ر�
		dialog = new JDialog(this,true);
		dialog.setBounds(220, 220, 200, 200);
		//���ֶԻ���
		dialog.setVisible(true);
	}
	public static void main(String[] args) {
		ModelDialog frm = new ModelDialog();
		frm.setVisible(true);
	}

}
