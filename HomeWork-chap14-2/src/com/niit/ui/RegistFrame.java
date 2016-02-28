 package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.niit.bean.User;
import com.niit.dao.impl.UserDao;
import com.niit.data.Data;

public class RegistFrame extends JFrame {

	private JLabel[] lbls;
	private String[] lblArray;
	private JTextField txtName;
	private JPasswordField txtPwd;
	private JPasswordField txtConfirmPwd;
	private JButton btnRegist;
	private JButton btnClose;
	//�û����ݲ�������
	private UserDao userDao;
	private LoginFrame loginFrm;
	
	public RegistFrame(LoginFrame loginFrm){
		this.loginFrm = loginFrm;
		
		//�����ݿ�ʵ����
		userDao = new UserDao(loginFrm.getData());
		//��ʼ������
		initFrame();
		//��ʼ�����
		initComponent();
		//�󶨼�����
		bandListener();
		//���ô����Ĭ�ϻس���ť
		this.getRootPane().setDefaultButton(btnRegist);
	}
	/**
	 * �󶨼�����
	 */
	private void bandListener() {
		
		//��ť������
		ButtonListener btnListner = new ButtonListener();
		btnClose.addActionListener(btnListner);
		btnRegist.addActionListener(btnListner);
		
	}
	/**
	 * ��ʼ������
	 */
	private void initFrame(){
		//��������
		this.setTitle("�û�ע��");
		this.setLocationRelativeTo(null);
		this.setSize(400, 400);
		//�ղ���
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){ 
		//ʵ������ǩ
		lbls = new JLabel[3];
		lblArray = new String[]{"�û���","����","ȷ������"};
		for(int i = 0, y = 30; i < lbls.length; i++,y+=60){
			lbls[i] = new JLabel(lblArray[i]);
			//���ñ�ǩ�Ĵ�С�Ͷ�λ
			lbls[i].setBounds(50, y, 60, 20);
			this.add(lbls[i]);
		}
		//ʵ�����ı���
		txtName = new JTextField();
		txtName.setBounds(130, 30, 120, 20);
		this.add(txtName);
		//�����
		txtPwd = new JPasswordField();
		txtPwd.setBounds(130, 90, 120, 20);
		this.add(txtPwd);
		//ȷ������
		txtConfirmPwd = new JPasswordField();
		txtConfirmPwd.setBounds(130, 150, 120, 20);
		this.add(txtConfirmPwd);
		
		//��ť
		btnRegist = new JButton("ע��");
		btnClose = new JButton("�ر�");
		btnRegist.setBounds(100, 250, 70, 25);
		btnClose.setBounds(220, 250, 70, 25);
		this.add(btnRegist);
		this.add(btnClose);
		
	}
	
	/**
	 * ע��  ȡ�� ��ť
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean isSelected = false;
			Object obj = e.getSource();
			JButton btn = (JButton)obj;
			if(btn == btnClose){
				RegistFrame.this.dispose();
			}
			//ע�ᰴť
			if(btn == btnRegist){
				//��ȡ�ı�����������û���
				String userName = txtName.getText().trim();
				//��ȡ�ı��������������
				String pwd = txtPwd.getText().trim();
				//��ȡ�ı����������ȷ������
				String confirmpwd = txtConfirmPwd.getText().trim();
				//�ж��û����Ƿ�Ϊ��
				if(userName.equals("")){
					JOptionPane.showMessageDialog(null, "����д�û�����");
					txtName.requestFocus();
					return;
				}
				//�ж������Ƿ�Ϊ��
				if(pwd.equals("")){
					JOptionPane.showMessageDialog(null, "����д���룡");
					txtPwd.requestFocus();
					return;
				}
				//�ж�ȷ�������Ƿ�Ϊ��
				if(confirmpwd.equals("")){
					JOptionPane.showMessageDialog(null, "����дȷ������");
					txtConfirmPwd.requestFocus();
					return;
				}
				
				//�ж������ȷ�������Ƿ�һ��
				if(!pwd.equals(confirmpwd)){
					JOptionPane.showMessageDialog(null, "�����ȷ�����벻һ�£�");
					txtConfirmPwd.requestFocus();
					txtConfirmPwd.selectAll();
					return;
				}
				//�ж��û��Ƿ��Ѿ�����
				User user = userDao.findUserByName(txtName.getText().trim());
				if(user == null){
					//ʵ�����µ��û�
					User newUser = new User(userName, pwd, 0, false);
					//������û�
					userDao.add(newUser);
					JOptionPane.showMessageDialog(null, "ע��ɹ���");
					//ʵ������¼����
					loginFrm.setVisible(true);
					RegistFrame.this.dispose();
					
				}
				else{
					JOptionPane.showMessageDialog(null, "�û����Ѵ��ڣ�");
				}
			}
			//�رհ�ť
			else{
				loginFrm.setVisible(true);
				RegistFrame.this.dispose();
			}
		}
		
	}
	
	
}
