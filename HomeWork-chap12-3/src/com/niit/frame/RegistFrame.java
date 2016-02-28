 package com.niit.frame;

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
	private ButtonGroup group;
	private JRadioButton[] rdoSex;
	private String[] sexArray;
	private JCheckBox[] chkHobby;
	private String[] hobbyArray;
	private JComboBox cboYear;
	private JComboBox cboMonth;
	private JComboBox cboDay;
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
		//�����������˵�������
		CboDaysListener cbodaysLintener = new CboDaysListener();
		cboMonth.addItemListener(cbodaysLintener);
		
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
		this.setLocation(400, 100);
		this.setSize(400, 500);
		//�ղ���
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){ 
		//ʵ������ǩ
		lbls = new JLabel[6];
		lblArray = new String[]{"�û���","����","ȷ������","�Ա�","��Ȥ����","��������"};
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
		//��ѡ��ť
		group = new ButtonGroup();
		rdoSex = new JRadioButton[2];
		sexArray = new String[]{"��","Ů"};
		for(int i = 0, x = 130; i < rdoSex.length; i++, x+=60){
			rdoSex[i] = new JRadioButton(sexArray[i]);
			//���ô�Сλ��
			rdoSex[i].setBounds(x, 210, 40, 20);
			//�������ť��
			group.add(rdoSex[i]);
			//���������
			this.add(rdoSex[i]);
		}
		//��ѡ��
		chkHobby = new JCheckBox[4];
		hobbyArray = new String[]{"��Ϸ","����","�˶�","˯��"};
		for(int i = 0, x = 130, y = 270; i < chkHobby.length; i++, x+=80){
			chkHobby[i] = new JCheckBox(hobbyArray[i]);
			//�ж��Ƿ��ǵ�������ѡ��
			if(i == 2){
				x = 130;
				y+=30;
			}
			chkHobby[i].setBounds(x, y, 60, 20);
			this.add(chkHobby[i]);
		}
		//�����б��
		cboYear = new JComboBox();
		cboMonth = new JComboBox();
		cboDay = new JComboBox();
		//������
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		for(int i = 1970; i <= year; i++){
			cboYear.addItem(i);
		}
		//����·�
		for(int i = 1; i <= 12; i++){
			cboMonth.addItem(i);
		}
		//�������
		for(int i = 1; i <= 31; i++){
			cboDay.addItem(i);
		}
		//���������յĴ�С��λ��
		cboYear.setBounds(130, 330, 60, 20);
		cboMonth.setBounds(210, 330, 40, 20);
		cboDay.setBounds(270, 330, 45, 20);
		this.add(cboYear);
		this.add(cboMonth);
		this.add(cboDay);
		
		//��ť
		btnRegist = new JButton("ע��");
		btnClose = new JButton("�ر�");
		btnRegist.setBounds(130, 400, 70, 25);
		btnClose.setBounds(220, 400, 70, 25);
		this.add(btnRegist);
		this.add(btnClose);
		
	}
	
	/**
	 * �����б��е�day
	 * @author Administrator
	 *
	 */
	private class CboDaysListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			//�ж�ѡ����
			if(e.getStateChange() == ItemEvent.SELECTED){
				//�����е��������
				cboDay.removeAllItems();
				//��ȡѡ�е���
				int year =(Integer) cboYear.getSelectedItem();
				//��ȡѡ�е���
				int month =(Integer)cboMonth.getSelectedItem();
//				System.out.println(year+" "+month);
				//�������
				int days = daysInMonth(year, month);
//				System.out.println(days+"��");
				for(int i = 1; i <= days; i++){
					cboDay.addItem(i);
				}
			}
		}
		
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
				//�ж��Ա�ѡ��ť�Ƿ�ѡ��
				for(int i = 0; i < rdoSex.length; i++){
					if(rdoSex[i].isSelected()){
						isSelected = true;
						break;
					}
				}
				if(isSelected == false){
					JOptionPane.showMessageDialog(null, "��ѡ���Ա�");
					return;
				}
				//�ж���Ȥ��ѡ���Ƿ�ѡ��
				isSelected = false;
				for(int i = 0; i < chkHobby.length; i++){
					if(chkHobby[i].isSelected()){
						isSelected = true;
					}
				}
				if(isSelected == false){
					JOptionPane.showMessageDialog(null, "��ѡ��������Ȥ���ã�");
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
		}
		
	}
	
	/**
	 * ��ȡ���굱�µ�����
	 * @param year
	 * @param month
	 * @return
	 */
	private int daysInMonth(int year,int month){
		int days = 0;
		switch(month){
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
				days = 29;
			}
			else{
				days = 28;
			}
			break;
		default:
			days = 31;	
		}
		return days;
	}
	
}
