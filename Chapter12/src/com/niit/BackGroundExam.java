package com.niit;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackGroundExam extends JFrame {

	private JLabel lblImage;
	//JPanel是SWING中的面板容器
	private JPanel pnlContainer;
	private BackGroundExam frm;
	
	public BackGroundExam(){
		//初始化窗体
		setBounds(200, 200, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//将当前类的实例赋予属性
		frm = this;
		
		//匿名构建JPanel，窗体背景图应使用JPanel来绘制，其他组件都将添加至该Panel中 
		pnlContainer = new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				//构建图片
				ImageIcon icon = new ImageIcon("image/back.jpg");
				g.drawImage(icon.getImage(), 0, 0, BackGroundExam.this.getWidth(), BackGroundExam.this.getHeight(), null);
			}
			
		};
		//pnlContainer.setBackground(Color.orange);
		//添加容器
		this.add(pnlContainer);
		
		//匿名类   当需要对某个类进行改写，并且这些应用不需要反复使用，可以通过构建匿名类进行类的补充
		//匿名类中能够访问到容器类的属性和方法
//		lblImage = new JLabel(){
//
//			/**
//			 * 重绘组件的方法
//			 */
//			@Override
//			protected void paintComponent(Graphics g) {
//				//构建图片
//				ImageIcon icon = new ImageIcon("image/back.jpg");
//				//g.drawImage(icon.getImage(), 0, 0, frm.getWidth(), frm.getHeight(), null);
//				g.drawImage(icon.getImage(), 0, 0, BackGroundExam.this.getWidth(), BackGroundExam.this.getHeight(), null);
//			}
//			//可以在匿名类中添加属性和方法，也能够对父类的方法进行重写
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
