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

public class Login extends JFrame{
	
	private JLabel lblName;
	private JLabel lblPassword;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnRegist;
	private UserDao userDao;
	
	public  Login(){
		userDao = new UserDao();
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
		BtnListener  btnListener = new BtnListener();
		btnLogin.addActionListener(btnListener);
		btnRegist.addActionListener(btnListener);
	}

	/**
	 * ��ʼ�����
	 */
	public void initComponent(){
		lblName = new JLabel("�û���");
		lblPassword = new JLabel("����");
		txtName = new JTextField();
		txtPassword = new JPasswordField();
		btnLogin = new JButton("��¼");
		btnRegist = new JButton("ע��");
		//��������Ĵ�С��λ��
		lblName.setBounds(100, 40, 40, 20);
		lblPassword.setBounds(100, 80, 40, 20);
		txtName.setBounds(150, 40, 140, 20);
		txtPassword.setBounds(150, 80, 140, 20);
		btnLogin.setBounds(130, 140, 60, 20);
		btnRegist.setBounds(200, 140, 60, 20);
		
		this.add(lblName);
		this.add(lblPassword);
		this.add(txtName);
		this.add(txtPassword);
		this.add(btnLogin);
		this.add(btnRegist);	
	}

	/**
	 *  �����ʼ��
	 */
	private void initFrame(){
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		//this.setBounds(400, 300, 400, 250);
		this.setTitle("��¼����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����Ϊnull����
		this.setLayout(null);
		this.setResizable(false);	
	}
	
	
	/**
	 * ��ť������
	 */
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//��ȡ��ťԪ��
			JButton btn = (JButton)e.getSource();
			//��½
			if(btn == btnLogin){
				//�û���
				String userName = txtName.getText().trim();
				//����
				String pwd = txtPassword.getText().trim();
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
				//�ж��û��Ƿ����
				User user = userDao.findUserByName(userName);
				if(user != null){
					//�ж������Ƿ���ȷ
					if(pwd.equals(user.getUserPwd())){
						//��½�ɹ�������������
						MainFrame frm = new MainFrame(Login.this);
						frm.setVisible(true);
						//�رյ�½����
						Login.this.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "���벻��ȷ��");
						txtPassword.requestFocus();
						txtPassword.selectAll();
						return;
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "�û������ڣ�");
					txtName.requestFocus();
					txtName.selectAll();
					return;
				}
			}
			//ע��
			else{
				Register frm = new Register(Login.this);
				frm.setVisible(true);
				//���ص�½����
				Login.this.setVisible(false);
			}
			
		}
		
	}


	public UserDao getUserDao() {
		return userDao;
	}

	public JTextField getTxtName() {
		return txtName;
	}
	

}
