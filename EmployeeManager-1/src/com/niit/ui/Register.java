package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.niit.dao.impl.UserDao;
import com.niit.entity.User;

public class Register extends JFrame {
	
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblConfirmpwd;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmpwd;
	private JButton btnCancle;
	private JButton btnRegist;
	private UserDao userDao;
	private Login logFrm;
	
	public Register(Login logFrm){
		this.logFrm = logFrm;
		userDao =logFrm.getUserDao();
		//�����ʼ��
		initFrame();
		//�����ʼ��
		initComponent();
		//�󶨼�����
		bindListener();
	}
	/**
	 * �󶨼�����
	 */
	private void bindListener() {
		BtnListener btnListener = new BtnListener();
		btnRegist.addActionListener(btnListener);
		btnCancle.addActionListener(btnListener);
		
	}
	
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn == btnRegist){
				//�û���
				String userName = txtName.getText().trim();
				//����
				String pwd = txtPassword.getText().trim();
				//ȷ������
				String confirmPwd = txtConfirmpwd.getText().trim();
				//�ж��û����Ƿ�Ϊ��
				if(userName.equals("")){
					JOptionPane.showMessageDialog(null, "����д�û�����");
					txtName.requestFocus();
					return;
				}
				//�ж������Ƿ�Ϊ��
				if(pwd.equals("")){
					JOptionPane.showMessageDialog(null, "����д���룡");
					txtPassword.requestFocus();
					return;
				}
				//�ж�ȷ�������Ƿ�Ϊ��
				if(confirmPwd.equals("")){
					JOptionPane.showMessageDialog(null, "����дȷ�����룡");
					txtConfirmpwd.requestFocus();
					return;
				}
				//�ж������ȷ�������Ƿ�һ��
				if(pwd.equals(confirmPwd)){
					User user  = userDao.findUserByName(txtName.getText().trim());
					//�û��Ѵ���
					if(user != null){
						JOptionPane.showMessageDialog(null, "�û����Ѵ��ڣ�");
						txtName.requestFocus();
						txtName.selectAll();
					}
					else{
						User newUser = new User(txtName.getText().trim(),txtPassword.getText().trim());
						boolean flag = userDao.saveUser(newUser);
						if(flag){
							JOptionPane.showMessageDialog(null, "ע��ɹ���");
							Register.this.dispose();
							logFrm.setVisible(true);
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "������ȷ�����벻һ�£�");
					txtPassword.requestFocus();
					txtPassword.selectAll();
				}
			}
			else{
				Register.this.dispose();
				logFrm.setVisible(true);
			}
			
		}
		
	}
	/**
	 * �����ʼ��
	 */
	private void initComponent() {
		lblName = new JLabel("�û���");
		lblPassword = new JLabel("����");
		lblConfirmpwd = new JLabel("ȷ������");
		txtName = new JTextField();
		txtPassword = new JPasswordField();
		txtConfirmpwd = new JPasswordField();
		btnCancle = new JButton("ȡ��");
		btnRegist = new JButton("ע��");
		//��������Ĵ�С��λ��
		lblName.setBounds(80, 40, 60, 20);
		lblPassword.setBounds(80, 80,60, 20);
		lblConfirmpwd.setBounds(80, 120, 60, 20);
		txtName.setBounds(150, 40, 140, 20);
		txtPassword.setBounds(150, 80, 140, 20);
		txtConfirmpwd.setBounds(150, 120, 140, 20);
		btnRegist.setBounds(130, 170, 60, 20);
		btnCancle.setBounds(200, 170, 60, 20);
		
		this.add(lblName);
		this.add(lblPassword);
		this.add(lblConfirmpwd);
		this.add(txtName);
		this.add(txtPassword);
		this.add(txtConfirmpwd);
		this.add(btnCancle);
		this.add(btnRegist);	
		
	}
	/**
	 * �����ʼ��
	 */
	private void initFrame() {
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		//this.setBounds(400, 300, 400, 250);
		this.setTitle("ע�����");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//����Ϊnull����
		this.setLayout(null);
		this.setResizable(false);	
	}

}
