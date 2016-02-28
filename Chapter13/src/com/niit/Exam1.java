package com.niit;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Exam1 extends JFrame {

	private JButton btnPress;
	
	public Exam1(){
		this.setBounds(20, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		btnPress = new JButton("show dialog");
		this.add(btnPress);
		btnPress.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			/*******************弹出消息对话框*********************/
			//第一个参数表示对话框居中呈现的相对于容器
			//JOptionPane.showMessageDialog(Exam1.this, "消息内容");
			//每个对话框都有若干重载方法，这些重载方法主要用于设置对话框的更多属性
			//第三个参数表示标题的信息，第四个参数表示消息的类型，第五个参数用来自定义图标
			//JOptionPane.showMessageDialog(null, "消息内容", "标题", JOptionPane.WARNING_MESSAGE, new ImageIcon("image/edit.gif"));
			
			/*******************弹出确认对话框*********************/
			//确认对话框需要通过返回值判断点击的按钮
//			int choice = JOptionPane.showConfirmDialog(null, "是否确认要删除信息");
//			//判断点击的按钮选项
//			if(choice == JOptionPane.YES_OPTION){
//				System.out.println("选择了是");
//			}
//			else if(choice == JOptionPane.NO_OPTION){
//				System.out.println("选择了否");
//			}
//			else{
//				System.out.println("选择了取消");
//			}
			//第三个参数表示按钮的类型
			//JOptionPane.showConfirmDialog(null, "是否确认要删除", "提示信息", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			
			/*******************弹出输入对话框*********************/
			//通过方法的返回值获取输入的内容,选择取消返回值为null
//			String value = JOptionPane.showInputDialog("消息内容");
//			System.out.println(value);
//			JOptionPane.showInputDialog("请输入内容", "默认值");
			//创建数组
//			String[] options = new String[]{"A","B","C","D"};
			//传入7个参数则将变为下拉列表对话框，返回值为Object,即选中的项
			//第六个参数表示下拉列表框的所有选项，第七个参数表示下拉列表框中的默认选中项
//			Object obj = JOptionPane.showInputDialog(null, "消息内容", "标题信息", JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			
			/*******************自定义对话框*********************/
			String[] options = new String[]{"忽略","覆盖","重试"};
			int choice = JOptionPane.showOptionDialog(null, "信息内容", "标题信息", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
//			//通过选择按钮的索引来判断选项
//			if(choice == 0){
//				System.out.println("忽略");
//			}
//			else if(choice == 1){
//				System.out.println("覆盖");
//			}
//			else{
//				System.out.println("重试");
//			}
		
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 frm = new Exam1();
		frm.setVisible(true);

	}

}
