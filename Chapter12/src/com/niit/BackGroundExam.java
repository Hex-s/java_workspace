package com.niit;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackGroundExam extends JFrame {

	private JLabel lblImage;
	//JPanel��SWING�е��������
	private JPanel pnlContainer;
	private BackGroundExam frm;
	
	public BackGroundExam(){
		//��ʼ������
		setBounds(200, 200, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����ǰ���ʵ����������
		frm = this;
		
		//��������JPanel�����屳��ͼӦʹ��JPanel�����ƣ�������������������Panel�� 
		pnlContainer = new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				//����ͼƬ
				ImageIcon icon = new ImageIcon("image/back.jpg");
				g.drawImage(icon.getImage(), 0, 0, BackGroundExam.this.getWidth(), BackGroundExam.this.getHeight(), null);
			}
			
		};
		//pnlContainer.setBackground(Color.orange);
		//�������
		this.add(pnlContainer);
		
		//������   ����Ҫ��ĳ������и�д��������ЩӦ�ò���Ҫ����ʹ�ã�����ͨ�����������������Ĳ���
		//���������ܹ����ʵ�����������Ժͷ���
//		lblImage = new JLabel(){
//
//			/**
//			 * �ػ�����ķ���
//			 */
//			@Override
//			protected void paintComponent(Graphics g) {
//				//����ͼƬ
//				ImageIcon icon = new ImageIcon("image/back.jpg");
//				//g.drawImage(icon.getImage(), 0, 0, frm.getWidth(), frm.getHeight(), null);
//				g.drawImage(icon.getImage(), 0, 0, BackGroundExam.this.getWidth(), BackGroundExam.this.getHeight(), null);
//			}
//			//��������������������Ժͷ�����Ҳ�ܹ��Ը���ķ���������д
//			private int num;
////			public void method(){
////			}
//		};
//		this.add(lblImage);
	}
	
	public void method(){}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BackGroundExam frm = new BackGroundExam();
		frm.setVisible(true);
	}

}
