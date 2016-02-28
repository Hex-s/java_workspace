package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ItemListenerExam extends JFrame{
	
	private JComboBox cboProject;
	private JComboBox cboCourse;
	//使用二维数组描述所有的课程
	private String[][] courseArray;
	
	public ItemListenerExam(){
		this.setBounds(200, 200, 400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		cboProject = new JComboBox();
		cboProject.addItem("--选择科目--");
		cboProject.addItem("Java");
		cboProject.addItem("C#");
		cboProject.addItem("script");
		
		cboCourse = new JComboBox();
		cboCourse.addItem("--请选择--");
		
		//对课程数组进行初始化
		courseArray = new String[3][];
		courseArray[0] = new String[]{"coreJava","JSP","JDBC","servlet"};
		courseArray[1] = new String[]{"winforms","ASP.net","ADO.net"};
		courseArray[2] = new String[]{"JavaScript","JScript","PHP"};
	
		
		this.add(cboProject);
		this.add(cboCourse);
		
		//绑定监听器
		cboProject.addItemListener(new ComboBoxListener());
	}
	
	/**
	 * 下拉列表框监听器
	 * @author Administrator
	 *
	 */
	private class ComboBoxListener implements ItemListener{

		/**
		 * 选项状态变更事件
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {	
			//判断选项变更的状态情况
			if(e.getStateChange() == ItemEvent.SELECTED){
				//判断是否是有效的选择项
				if(cboProject.getSelectedIndex() > 0){
					//清空课程列表的选项
					cboCourse.removeAllItems();
					cboCourse.addItem("--请选择--");
					//获取科目列表的选中项
					//String project = cboProject.getSelectedItem().toString();
					//获取选中项的索引
					int index = cboProject.getSelectedIndex();
					//根据科目项判断将对应的课程添加至课程列表
					for(int i = 0; i < courseArray[index-1].length; i++){
						cboCourse.addItem(courseArray[index-1][i]);
					}
				}
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemListenerExam frm = new ItemListenerExam();
		frm.setVisible(true);

	}

}
