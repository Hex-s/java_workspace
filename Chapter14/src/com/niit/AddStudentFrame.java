package com.niit;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.niit.bean.Student;
import com.niit.dao.StudentDao;
import com.niit.data.Data;

public class AddStudentFrame extends JFrame {
	private JButton btnSave;
	private StudentDao stuDao;
	//������
	private TableExam2 frm;
	
	public AddStudentFrame(Data data, TableExam2 frm){
		this.setBounds(300, 300, 200, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.frm = frm;
		stuDao = new StudentDao(data);
		btnSave = new JButton("����");
		this.add(btnSave);
		btnSave.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Student stu = new Student(1010, "john", 25, "��");
			//��������
			stuDao.addStudent(stu);
			//ˢ��������ı������
			frm.loadData();
			//�رյ�ǰ����
			AddStudentFrame.this.dispose();
		}
	}
}
