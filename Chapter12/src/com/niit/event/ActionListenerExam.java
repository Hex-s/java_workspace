package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionListenerExam extends JFrame {

	private JButton btnPress;
	private JButton btnBack;
	
	public ActionListenerExam(){
		this.setBounds(200, 200, 400, 200);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnPress = new JButton("press");
		btnBack = new JButton("back");
		this.add(btnPress);
		this.add(btnBack);
		//为btnPress绑定监听器
//		btnPress.addActionListener(new ActionListener() {
//			
//			/**
//			 * 按钮点击的事件
//			 */
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				//弹出对话框
//				JOptionPane.showMessageDialog(null, "点击了press");
//			}
//		});
//		
//		//为btnBack绑定监听器
//		btnBack.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, "点击了back");
//			}
//		});
		
		//实例化监听器
		ButtonListener btnListener = new ButtonListener();
		//绑定监听器
		btnPress.addActionListener(btnListener);
		btnBack.addActionListener(btnListener);
		
	}
	
	/**
	 * 使用内部类实现监听器
	 * 内部类可以访问外部类的属性和方法
	 * 内部类主要用于当前类有效又需要多次调用时重新构建的对象
	 * 内部类可以更好地对程序结构进行划分
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
//			//获取事件源
//			Object obj = e.getSource();
//			//将事件源拆箱成JButton类型
//			JButton btn = (JButton)obj;
//			JOptionPane.showMessageDialog(null, "点击了"+btn.getText()+"按钮");
			
			//内部类中可以通过事件源判断事件源的类型，根据不同的事件源类型实现不同的响应
			//获取事件源
			Object obj = e.getSource();
			//将事件源拆箱成JButton类型
			JButton btn = (JButton)obj;
			if(btn == btnPress){
				JOptionPane.showMessageDialog(null, "点击了"+btn.getText()+"按钮");
			}
			else if(btn == btnBack){
				JOptionPane.showMessageDialog(null, "点击了"+btn.getText()+"按钮");
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListenerExam frm = new ActionListenerExam();
		frm.setVisible(true);

	}

}
