package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.niit.bean.User;
import com.niit.dao.impl.UserDao;
import com.niit.data.Data;
import com.niit.util.CommonUtil;

public class LoginFrame extends JFrame {
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblCheckCode;
	private JLabel lblCode;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JTextField txtCheckCode;
	private JButton btnLogin;
	private JButton btnRegist;
	private String code;
	//�û����ݲ�������
	private UserDao userDao;
	
	public LoginFrame(){
		//�����ݿ�ʵ����
		Data data = new Data();
		userDao = new UserDao(data);
		//�����ʼ��
		initFrame();
		//�����ʼ��
		initComponent();
		//�󶨼�����
		bandListener();
		//���ô����Ĭ�ϻس���ť
		this.getRootPane().setDefaultButton(btnLogin);
	}
	public JTextField getTxtName() {
		return txtName;
	}
	/**
	 * �󶨼������ķ���
	 */
	private void bandListener(){
		btnLogin.addActionListener(new ButtonClickListener());
	}
	/**
	 *  �����ʼ��
	 */
	private void initFrame(){
		this.setBounds(400, 300, 400, 250);
		this.setTitle("��¼����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����Ϊnull����
		this.setLayout(null);
		this.setResizable(false);	
	}
	/**
	 * ��ʼ�����
	 */
	public void initComponent(){
		lblName = new JLabel("�û���");
		lblPassword = new JLabel("����");
		lblCheckCode = new JLabel("��֤��");
		//������֤��
		code = createCode();
		lblCode = new JLabel(code);
		txtName = new JTextField();
		txtPassword = new JPasswordField();
		txtCheckCode = new JTextField();
		btnLogin = new JButton("��¼");
		btnRegist = new JButton("ע��");
		//��������Ĵ�С��λ��
		lblName.setBounds(100, 40, 40, 20);
		lblPassword.setBounds(100, 80, 40, 20);
		lblCheckCode.setBounds(100, 120, 40, 20);
		txtName.setBounds(150, 40, 140, 20);
		txtPassword.setBounds(150, 80, 140, 20);
		txtCheckCode.setBounds(150, 120, 90, 20);
		lblCode.setBounds(255, 120, 30, 20);
		btnLogin.setBounds(140, 160, 60, 20);
		btnRegist.setBounds(210, 160, 60, 20);
		
		this.add(lblName);
		this.add(lblPassword);
		this.add(lblCheckCode);
		this.add(txtName);
		this.add(txtPassword);
		this.add(txtCheckCode);
		this.add(lblCode);
		this.add(btnLogin);
		this.add(btnRegist);	
	}
	/**
	 * ������֤��
	 * @return
	 */
	private String createCode(){
		Random random = new Random();
		String code = "";
		for(int i = 1; i <= 4; i++){
			int n = random.nextInt(10);
			code += n + "";
		}
		return code;
	}
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//��ȡ�ı���������û���
			String userName = txtName.getText().trim();
			//��ȡ��������������
			String password = txtPassword.getText().trim();
			//�ж��û����Ƿ�Ϊ��
			if(userName.equals("")){
				JOptionPane.showMessageDialog(null, "����д�û�����");
				//�۽��ı���
				txtName.requestFocus();
				return;
			}
			//�ж������Ƿ�Ϊ��
			if(password.equals("")){
				JOptionPane.showMessageDialog(null, "����д���룡");
				//�۽������
				txtPassword.requestFocus();
				return;
			}
			//�ж��û����Ƿ���ȷ
			User user = userDao.findUserByName(userName);
			if(user != null){
				//�ж�����
				if(user.getPassword().equals(password)){
					//����䴫�����ݷ�ʽһ��ͨ����̬��������
					//���û��������ھ�̬������
					//CommonUtil.loginName = userName;
					//���ݴ��ݷ�ʽ����ͨ���������ݣ�������󴫵ݿ��Ի�ȡ�������Ϣ
					//ʵ����������
					MainFrame mainFrm = new MainFrame(LoginFrame.this);
					//����
					mainFrm.setVisible(true);
					//�رյ�ǰ����
					LoginFrame.this.dispose();
					
				}
				else{
					JOptionPane.showMessageDialog(null, "�������");
					txtPassword.requestFocus();
					txtPassword.selectAll();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "�û��������ڣ�");
				//�۽�
				txtName.requestFocus();
				//ѡ�е�ǰ�ı�
				txtName.selectAll();
			}
		}
	}
	
	public static void main(String[] args) {
		LoginFrame frm = new LoginFrame();
		frm.setVisible(true);
	}
}
