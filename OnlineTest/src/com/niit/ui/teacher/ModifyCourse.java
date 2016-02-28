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
		this.setTitle("��ӿ�Ŀ");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//��ʼ�����
		initComponent();
		//�󶨼�����
		bindListener();
	}

	/**
	 * �󶨼�����
	 */
	private void bindListener() {
		ButtonListener btnListener = new ButtonListener();
		btnCancle.addActionListener(btnListener);
		btnConfirm.addActionListener(btnListener);
		
	}
	
	

	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn == btnConfirm){
				String courseName = course.getCourseName();
				//����Ŀ�Ŀ����
				String values = txtCourseName.getText().trim().toUpperCase();
				//��Ŀ����Ϊ��
				if(!values.equals("")){
					//�ж��Ƿ�Կ�Ŀ���������޸�
					if(values.equals(courseName)){
						JOptionPane.showMessageDialog(null, "��Ŀ��û�н����޸�");
					}
					else{
						//�ж��޸ĵĿ�Ŀ�Ƿ��Ѿ�����
						Course c = courseDao.findCourseByCourseName(values);
						if(c != null){
							JOptionPane.showMessageDialog(null, "��Ŀ�Ѵ��ڣ�");
							txtCourseName.requestFocus();
							txtCourseName.selectAll();
						}
						else{
							int choice = JOptionPane.showConfirmDialog(null, "ȷ���޸ĸÿ�Ŀ��","�޸Ŀ�Ŀ",JOptionPane.YES_NO_OPTION);
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
					JOptionPane.showMessageDialog(null, "��Ŀ������Ϊ�գ�");
					txtCourseName.requestFocus();
				}
			}
			else{
				ModifyCourse.this.dispose();
			}
			
		}
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		lblName = new JLabel("��Ŀ����");
		txtCourseName = new JTextField(course.getCourseName());
		btnCancle = new JButton("ȡ��");
		btnConfirm = new JButton("ȷ��");
		
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
