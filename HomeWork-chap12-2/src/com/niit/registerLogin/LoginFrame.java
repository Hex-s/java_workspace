package com.niit.registerLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
	
	private JLabel[] lbls;
	private String[] lblArray;
	private JTextField txtName;
	private JTextField txtPwd;
	private JTextField txtCode;
	private JLabel lblcode;
	private JButton btnRigister;
	private JButton btnLogin;
	
	
	public LoginFrame(){
		//��������
		this.setTitle("�û���¼");
		this.setBounds(400, 100, 400, 400);
		//�ղ���
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		
	}

	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		//ʵ������ǩ
		lbls = new JLabel[3];
		lblArray = new String[]{"�û���","����","��֤��"};
		for(int i = 0,y = 30; i < lbls.length; i++,y+=60){
			lbls[i] = new JLabel(lblArray[i]);
			lbls[i].setBounds(50, y, 60, 20);
			this.add(lbls[i]);
		}
		//ʵ���������ı���
		txtName = new JTextField();
		txtName.setBounds(130, 30, 120, 20);
		this.add(txtName);
		//ʵ���������ı���
		txtPwd = new JTextField();
		txtPwd.setBounds(130, 90, 120, 20);
		this.add(txtPwd);
		//ʵ������֤���ı���
		txtCode = new JTextField();
		txtCode.setBounds(130, 150, 120, 20);
		this.add(txtCode);
		//ʵ������֤��
		lblcode = new JLabel(sysCode());
		lblcode.setBounds(260, 150, 50, 20);
		this.add(lblcode);
		
		//ʵ����ע�ᰴť
		btnRigister = new JButton("ע��");
		btnRigister.setBounds(100, 220, 70, 25);
		this.add(btnRigister);
		//ʵ������¼��ť
		btnLogin = new JButton("��¼");
		btnLogin.setBounds(200, 220, 70, 25);
		this.add(btnLogin);
		
		buttonListener btnListener = new buttonListener();  
		btnLogin.addActionListener(btnListener);
		btnRigister.addActionListener(btnListener);
		
	}
	
	public class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			JButton btn = (JButton)obj;
			if(btn == btnRigister){
//				LoginFrame.this.setVisible(false);
				LoginFrame.this.dispose();
				RegistFrame frm = new RegistFrame();
				frm.setVisible(true);

			}
			
		}
		
	}
	/**
	 * ����4λ��֤��ķ���
	 * @return
	 */
	public String sysCode(){
		String str = "";
		int random = 0;
		//�������һ��0-9������
		for(int i = 1; i <=4; i++){
			random = (int)(Math.random() * 10);
			str += random;
		}
		return str;
	}

}
