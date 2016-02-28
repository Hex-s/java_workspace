package com.niit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * JList列表的使用
 * @author Administrator
 *
 */
public class Exam5 extends JFrame{

	//列表
	private JList list;
	//滚动面板
	private JScrollPane scrollPnl;
	//文本框
	private JTextField txtValue;
	private JButton btnPress;
	
	public Exam5(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//实例化按钮
		btnPress = new JButton("press");
		btnPress.setBounds(50, 150, 100, 25);
		
		//实例化文本框
		txtValue = new JTextField();
		txtValue.setBounds(50, 25, 100, 25);
		
		//实例化滚动面板
		scrollPnl = new JScrollPane();
		scrollPnl.setBounds(50, 50, 100, 100);
		
		//实例化列表
		//空参构造需要设置列表的模型对象
		//list = new JList();
		//String[] array = new String[]{"Java","Html","Javascript","Oracle","JSP","AJAX","Struts"};
		//通过数组构建列表
		//JList本身不能对其中的数据进行相应的增删改的操作，需要依赖于模型对象
		//list = new JList(array);
		//通过索引设置默认的选中项
		//list.setSelectedIndex(1);
		//设置选中的模式
		//list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		//通过模型构建列表
		DefaultListModel model = new DefaultListModel();
		//添加选项
		model.addElement("A");
		model.addElement("B");
		model.addElement("C");
		model.addElement("D");
		//创建列表
		list = new JList(model);
		//空参构建可以设置模型
		//list.setModel(model);
		
		//获取指定元素的索引位置
		System.out.println(model.indexOf("D"));
		//根据索引删除元素
		//model.remove(1);
		//根据选项内容删除元素
		model.removeElement("B");
		System.out.println(model.indexOf("D"));
		//修改指定索引的选项
		model.set(1, "E");
		//移除所有元素
		//model.removeAllElements();
		
		
		//绑定监听器
		list.addListSelectionListener(new ListListener());
		btnPress.addActionListener(new ButtonListener());
		
		//将列表添加至滚动面板中
		scrollPnl.getViewport().add(list);
		this.add(scrollPnl);
		this.add(txtValue);
		this.add(btnPress);
	}
	/**
	 * 列表选项监听器
	 * @author Administrator
	 *
	 */
	private class ListListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			//获取选中的值
			//JOptionPane.showMessageDialog(null, list.getSelectedValue());
			StringBuffer str = new StringBuffer();
			for(Object obj : list.getSelectedValues()){
				str.append(obj);
			}
			txtValue.setText(str.toString());
		}
		
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//获取选中的值
			JOptionPane.showMessageDialog(null, list.getSelectedValues());
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam5 frm = new Exam5();
		frm.setVisible(true);
	}

}
