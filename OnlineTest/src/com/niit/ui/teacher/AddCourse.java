package com.niit.ui.teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.CourseDao;
import com.niit.entiry.Course;

public class AddCourse extends JFrame{
	
	private JTextField txtCourseName;
	private JButton btnConfirm;
	private JButton btnCancle;
	private JLabel lblName;
	
	private CourseDao courseDao;
	
	private EditCourseFrame frm;
	
	public AddCourse(EditCourseFrame frm){
		this.frm = frm;
		courseDao = new CourseDao();
		this.setBounds(350, 250, 300, 200);
		this.setTitle("添加科目");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//初始化组件
		initComponent();
		//绑定监听器
		bindListener();
	}

	/**
	 * 绑定监听器
	 */
	private void bindListener() {
		ButtonListener btnListener = new ButtonListener();
		btnCancle.addActionListener(btnListener);
		btnConfirm.addActionListener(btnListener);
		
	}

	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn == btnConfirm){
				//获取填入的科目名
				String values = (txtCourseName.getText().trim()).toUpperCase();
				if(!values.equals("")){
					//获取该名称的科目
					Course c = courseDao.findCourseByCourseName(values);
					//科目已经存在，即说明该科目的状态为0，就爱那个状态修改为1
					int choice = JOptionPane.showConfirmDialog(null, "确认添加该科目？","添加科目",JOptionPane.YES_NO_OPTION);
					if(choice == JOptionPane.YES_OPTION){
						//科目已经存在
						if(c != null){
							//科目状态为之前删除过 即关闭状态
							if(c.getCourseState() == 0){
								//将关闭的课程重新打开
								courseDao.modifyCourseState(c.getCourseId());
								AddCourse.this.dispose();
								//重新加载表格数据
								frm.loadData();
							}
							else{
								JOptionPane.showMessageDialog(null, "科目已存在！");
								txtCourseName.requestFocus();
								txtCourseName.selectAll();
							}
						}
						//科目不存在，直接加入数据库
						else{
							courseDao.addCourse(values.trim());
							AddCourse.this.dispose();
							//重新加载表格数据
							frm.loadData();
						}
						
						
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "科目名不能为空！");
					txtCourseName.requestFocus();
				}
			
			}
			else{
				AddCourse.this.dispose();
			}
			
		}
		
	}
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		lblName = new JLabel("科目名称");
		txtCourseName = new JTextField();
		btnCancle = new JButton("取消");
		btnConfirm = new JButton("确认");
		
		lblName.setBounds(40, 20, 60, 20);
		txtCourseName.setBounds(110, 20, 150, 20);
		btnConfirm.setBounds(40, 70, 80, 30);
		btnCancle.setBounds(160, 70, 80, 30);
		
		this.add(lblName);
		this.add(txtCourseName);
		this.add(btnConfirm);
		this.add(btnCancle);
	}
}
