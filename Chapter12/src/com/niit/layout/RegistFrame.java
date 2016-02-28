package com.niit.layout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
	
	public RegistFrame(){
		//��������
		this.setTitle("�û�ע��");
		this.setLocation(400, 100);
		this.setSize(400, 500);
		//�ղ���
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
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
		for(int i = 1970; i <= 2050; i++){
			cboYear.addItem(i);
		}
		//����·�
		for(int i = 1; i <= 12; i++){
			cboMonth.addItem(i);
		}
		//�������
		for(int i = 1; i <= 30; i++){
			cboDay.addItem(i);
		}
		//���������յĴ�С��λ��
		cboYear.setBounds(130, 330, 60, 20);
		cboMonth.setBounds(210, 330, 40, 20);
		cboDay.setBounds(270, 330, 40, 20);
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
	
}
