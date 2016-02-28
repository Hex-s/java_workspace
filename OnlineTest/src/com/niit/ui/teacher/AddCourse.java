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
				//��ȡ����Ŀ�Ŀ��
				String values = (txtCourseName.getText().trim()).toUpperCase();
				if(!values.equals("")){
					//��ȡ�����ƵĿ�Ŀ
					Course c = courseDao.findCourseByCourseName(values);
					//��Ŀ�Ѿ����ڣ���˵���ÿ�Ŀ��״̬Ϊ0���Ͱ��Ǹ�״̬�޸�Ϊ1
					int choice = JOptionPane.showConfirmDialog(null, "ȷ����Ӹÿ�Ŀ��","��ӿ�Ŀ",JOptionPane.YES_NO_OPTION);
					if(choice == JOptionPane.YES_OPTION){
						//��Ŀ�Ѿ�����
						if(c != null){
							//��Ŀ״̬Ϊ֮ǰɾ���� ���ر�״̬
							if(c.getCourseState() == 0){
								//���رյĿγ����´�
								courseDao.modifyCourseState(c.getCourseId());
								AddCourse.this.dispose();
								//���¼��ر������
								frm.loadData();
							}
							else{
								JOptionPane.showMessageDialog(null, "��Ŀ�Ѵ��ڣ�");
								txtCourseName.requestFocus();
								txtCourseName.selectAll();
							}
						}
						//��Ŀ�����ڣ�ֱ�Ӽ������ݿ�
						else{
							courseDao.addCourse(values.trim());
							AddCourse.this.dispose();
							//���¼��ر������
							frm.loadData();
						}
						
						
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "��Ŀ������Ϊ�գ�");
					txtCourseName.requestFocus();
				}
			
			}
			else{
				AddCourse.this.dispose();
			}
			
		}
		
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		lblName = new JLabel("��Ŀ����");
		txtCourseName = new JTextField();
		btnCancle = new JButton("ȡ��");
		btnConfirm = new JButton("ȷ��");
		
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
