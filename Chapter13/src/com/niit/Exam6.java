package com.niit;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Exam6 extends JFrame {

	private JSplitPane splPnl;
	private JScrollPane scrollPnlLeft;
	private JScrollPane scrollPnlRight;
	private JList listLeft;
	private JList listRight;
	private JButton btnToLeft;
	private JButton btnToRight;
	private DefaultListModel modelLeft;
	private DefaultListModel modelRight;
	private JTextField txtMsg;
	
	public Exam6(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//组件初始化
		initComponent();
		//绑定监听器
		bindListener();
	}
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		
		txtMsg = new JTextField();
		txtMsg.setBounds(50, 270, 100, 30);
		txtMsg.setText("font");
		//构建滚动面板
		scrollPnlLeft = new JScrollPane();
		scrollPnlRight = new JScrollPane();
		//构建分割面板
		splPnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPnlLeft,scrollPnlRight);
		splPnl.setBounds(50, 20, 300, 250);
		splPnl.setDividerSize(4);
		splPnl.setDividerLocation(148);
		splPnl.setEnabled(false);
		//构建按钮
		btnToLeft = new JButton("<<");
		btnToRight = new JButton(">>");
		btnToLeft.setBounds(110, 300, 80, 25);
		btnToRight.setBounds(210, 300, 80, 25);
		//创建列表模型
		modelLeft = new DefaultListModel();
		modelRight = new DefaultListModel();
		//创建列表
		listLeft = new JList(modelLeft);
		listRight = new JList(modelRight);
		//做列表模型添加数据
//		modelLeft.addElement("A");
//		modelLeft.addElement("B");
//		modelLeft.addElement("C");
//		modelLeft.addElement("D");
//		modelLeft.addElement("E");
//		modelLeft.addElement("F");
//		modelLeft.addElement("G");
//		modelLeft.addElement("H");
		
		//动态获取系统字体
		GraphicsEnvironment evironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = evironment.getAvailableFontFamilyNames();
		//遍历
		for(String font : fontNames){
			modelLeft.addElement(font);
		}
		
		listLeft.setSelectionBackground(Color.orange);
		listRight.setSelectionBackground(Color.orange);
		
		//将列表添加至滚动面板
		scrollPnlLeft.getViewport().add(listLeft);
		scrollPnlRight.getViewport().add(listRight);
		
		this.add(splPnl);
		this.add(btnToLeft);
		this.add(btnToRight);
		this.add(txtMsg);
	}
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//获取事件源对象
			JButton btn = (JButton)e.getSource();
			//判断当前点击的按钮
			//往左移的按钮
			if(btn == btnToLeft){
				moveIteam(listRight, modelLeft, modelRight);
			}
			//往右移的按钮
			else{
				moveIteam(listLeft, modelRight, modelLeft);
			}
		}
		
	}
	/**
	 * 列表监听器
	 * @author Administrator
	 *
	 */
	private class ListListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//通过事件源判断作用的列表
			JList list = (JList)e.getSource();
			//JOptionPane.showMessageDialog(null, listLeft.getSelectedIndex());
			//选中左列表
			if(list == listLeft){
				//灰化往左移的按钮
				btnToLeft.setEnabled(false);
				//启用往右移按钮
				btnToRight.setEnabled(true);
				//去除有列表的选中项
				listRight.setSelectedIndex(-1);
				//去除右列表选择项的背景色
				listRight.setSelectionBackground(Color.white);
				//修改左列表选择项的背景色为正常颜色
				listLeft.setSelectionBackground(Color.orange);
				
				//获取选中项的值
				String fontName = listLeft.getSelectedValue().toString();
				//构建字体对象
				Font font = new Font(fontName, Font.ITALIC|Font.BOLD, 20);
				//为文本框设置字体
				txtMsg.setFont(font);
			}
			//选中右列表
			else{
				//灰化往右移按钮
				btnToRight.setEnabled(false);
				//启用往左移按钮
				btnToLeft.setEnabled(true);
				//去除左列表的选中项
				listLeft.setSelectedIndex(-1);
				//去除左列表的选中项背景色
				listLeft.setSelectionBackground(Color.white);
				//修改右列表的选择项背景色
				listRight.setSelectionBackground(Color.orange);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/**
	 * 移动列表选项
	 * @param list
	 * @param model1
	 * @param model2
	 */
	private void moveIteam(JList list, DefaultListModel model1, DefaultListModel model2){
		//获取左列表选中项的值
		Object[] value = list.getSelectedValues();
		//遍历选中的值
		for(Object obj : value){
			//将左列表获取的值添加至右列表中
			model1.addElement(obj);
			//将左列表获取值删除
			model2.removeElement(obj);
		}
	}
	/**
	 * 绑定监听器
	 */
	private void bindListener(){
		ButtonListener btnListener = new ButtonListener();
		btnToLeft.addActionListener(btnListener);
		btnToRight.addActionListener(btnListener);
		ListListener listListener = new ListListener();
		listLeft.addMouseListener(listListener);
		listRight.addMouseListener(listListener);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam6 frm = new Exam6();
		frm.setVisible(true);
	}

}
