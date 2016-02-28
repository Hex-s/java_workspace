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

public class ModifyCourse extends JFrame{
	
	private JTextField txtCourseName;
	private JButton btnConfirm;
	private JButton btnCancle;
	private JLabel lblName;
	
	private Course course;
	private CourseDao courseDao;
	
	private EditCourseFrame frm;
	
	public ModifyCourse(EditCourseFrame frm,Course c){
		this.course = c;
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
				String courseName = course.getCourseName();
				//输入的科目名称
				String values = txtCourseName.getText().trim().toUpperCase();
				//科目名不为空
				if(!values.equals("")){
					//判断是否对科目名进行了修改
					if(values.equals(courseName)){
						JOptionPane.showMessageDialog(null, "科目名没有进行修改");
					}
					else{
						//判断修改的科目是否已经存在
						Course c = courseDao.findCourseByCourseName(values);
						if(c != null){
							JOptionPane.showMessageDialog(null, "科目已存在！");
							txtCourseName.requestFocus();
							txtCourseName.selectAll();
						}
						else{
							int choice = JOptionPane.showConfirmDialog(null, "确认修改该科目？","修改科目",JOptionPane.YES_NO_OPTION);
							if(choice == JOptionPane.YES_OPTION){
								int courseId = course.getCourseId();
								courseDao.modifyCourse(courseId, values);
								ModifyCourse.this.dispose();
								frm.loadData();
							}
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "科目名不能为空！");
					txtCourseName.requestFocus();
				}
			}
			else{
				ModifyCourse.this.dispose();
			}
			
		}
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		lblName = new JLabel("科目名称");
		txtCourseName = new JTextField(course.getCourseName());
		btnCancle = new JButton("取消");
		btnConfirm = new JButton("确认");
		
		lblName.setBounds(40, 20, 60, 20);
		txtCourseName.setBounds(110, 20, 150, 20);
		txtCourseName.requestFocus();
		txtCourseName.selectAll();
		btnConfirm.setBounds(40, 70, 80, 30);
		btnCancle.setBounds(160, 70, 80, 30);
		
		this.add(lblName);
		this.add(txtCourseName);
		this.add(btnConfirm);
		this.add(btnCancle);
	}

}
