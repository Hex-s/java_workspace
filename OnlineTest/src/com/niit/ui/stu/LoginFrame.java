package com.niit.ui.stu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.niit.dao.impl.StudentDao;
import com.niit.dao.impl.TeacherDao;
import com.niit.entiry.Student;
import com.niit.entiry.Teacher;
import com.niit.ui.teacher.TeaMainFrame;



public class LoginFrame extends JFrame{
	
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblType;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnCancle;
	private StudentDao stuDao;
	private TeacherDao teaDao;
	private ButtonGroup group;
	private JRadioButton[] rboType;
	private String[] type;
	private JLabel lblTitle;
	
	private Student loginStu;
	private Teacher loginTea;
	
	public  LoginFrame(){
		stuDao = new StudentDao();
		teaDao = new TeacherDao();
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
		btnLogin.addActionListener(btnListener);
		btnCancle.addActionListener(btnListener);
		
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
				//�ж�����Ƿ�Ϊ��
				String result = "";
				for(JRadioButton rdo : rboType){
					if(rdo.isSelected()){
						result = rdo.getText();
						break;
					}
				}
				if(result.equals("")){
					JOptionPane.showMessageDialog(null, "��ѡ����ݣ�");
					return;
				}
				//�ж��û��Ƿ����
				int id = Integer.parseInt(txtName.getText().toString().trim());
				if(result.equals("ѧ��")){
					Student stu = stuDao.findStuByStuid(id);
					if(stu != null){
						//�ж������Ƿ���ȷ
						if(pwd.equals(stu.getPwd())){
							loginStu = stu;
							//��½�ɹ�������������
							StuMainFrame frm = new StuMainFrame(LoginFrame.this);
							frm.setVisible(true);
							//�رյ�½����
							LoginFrame.this.dispose();
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
				else{
					Teacher tea = teaDao.findTeacherBytId(id);
					if(tea != null){
						//�ж������Ƿ���ȷ
						if(pwd.equals(tea.getPwd())){
							loginTea = tea;
							//��½�ɹ�������������
							TeaMainFrame frm = new TeaMainFrame(LoginFrame.this);
							frm.setVisible(true);
							//�رյ�½����
							LoginFrame.this.dispose();
							
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
			}
			//ȡ��
			else{
				LoginFrame.this.dispose();
			}
			
		}
		
	}
	

	/**
	 * ��ʼ�����
	 */
	public void initComponent(){
		lblTitle  = new JLabel("���߿���ϵͳ");
		lblTitle.setFont(new Font("����", Font.PLAIN, 30));
//		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblName = new JLabel("�û���");
		lblPassword = new JLabel("����");
		lblType = new JLabel("���");
		txtName = new JTextField();
		txtPassword = new JPasswordField();
		btnLogin = new JButton("��¼");
		btnCancle = new JButton("ȡ��");
		type = new String[]{"ѧ��","��ʦ"};
		rboType = new JRadioButton[type.length];
		group = new ButtonGroup();
		
		//��������Ĵ�С��λ��
		lblTitle.setBounds(100, 20, 300, 40);
		lblName.setBounds(100, 80, 40, 20);
		lblPassword.setBounds(100, 120, 40, 20);
		lblType.setBounds(100, 160, 40, 20);
		txtName.setBounds(150, 80, 140, 20);
		txtPassword.setBounds(150, 120, 140, 20);
		for(int i = 0 , x = 150; i < type.length; i++ , x += 80){
			rboType[i] = new JRadioButton(type[i]);
			group.add(rboType[i]);
			rboType[i].setBounds(x, 160, 80, 20);
			this.add(rboType[i]);
		}
		btnLogin.setBounds(120, 220, 60, 20);
		btnCancle.setBounds(210, 220, 60, 20);
		
		this.add(lblTitle);
		this.add(lblName);
		this.add(lblPassword);
		this.add(lblType);
		this.add(txtName);
		this.add(txtPassword);
		this.add(btnLogin);
		this.add(btnCancle);	
	}

	/**
	 *  �����ʼ��
	 */
	private void initFrame(){
		this.setSize(400, 330);
		this.setLocationRelativeTo(null);
		//this.setBounds(400, 300, 400, 250);
		this.setTitle("��¼����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����Ϊnull����
		this.setLayout(null);
		this.setResizable(false);	
	}

	
	
	public Student getLoginStu() {
		return loginStu;
	}

	

	public Teacher getLoginTea() {
		return loginTea;
	}

	

}
