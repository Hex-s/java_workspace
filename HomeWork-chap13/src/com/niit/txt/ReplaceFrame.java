package com.niit.txt;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReplaceFrame extends JFrame{
	
	private TextFrame txtFrm;
	private JLabel lblFind;
	private JLabel lblReplace;
	private JTextField txtFind;
	private JTextField txtReplace;
	private JButton btnFindNext;
	private JButton btnReplace;
	private JButton btnReplaceAll;
	private JButton btnCancle;
	private JCheckBox chkCharacter;
	
	public ReplaceFrame(TextFrame txtFrm){
		//��ʼ������
		this.txtFrm = txtFrm;
		this.setSize(450, 200);
		this.setTitle("�滻");
		this.setLocationRelativeTo(txtFrm);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setAlwaysOnTop(true);
		
		//��ʼ�����
		lblFind = new JLabel("���ҵ����ݣ�");
		lblReplace = new JLabel("�滻Ϊ��");
		txtFind = new JTextField();
		txtReplace = new JTextField();
		btnFindNext = new JButton("������һ��");
		btnReplace = new JButton("�滻");
		btnReplaceAll = new JButton("ȫ���滻");
		btnCancle = new JButton("ȡ��");
		chkCharacter = new JCheckBox("���ִ�Сд");
		
		lblFind.setBounds(10, 10, 80, 20);
		lblReplace.setBounds(10, 40, 80, 20);
		txtFind.setBounds(100, 10, 200, 20);
		txtReplace.setBounds(100, 40, 200, 20);
		btnFindNext.setBounds(320, 10, 100, 20);
		btnReplace.setBounds(320, 40, 100, 20);
		btnReplaceAll.setBounds(320, 70, 100, 20);
		btnCancle.setBounds(320, 100, 100, 20);
		chkCharacter.setBounds(10, 100, 100, 20);
		btnFindNext.setEnabled(false);
		btnReplace.setEnabled(false);
		btnReplaceAll.setEnabled(false);
		
		this.add(lblFind);
		this.add(txtReplace);
		this.add(lblReplace);
		this.add(txtFind);
		this.add(btnFindNext);
		this.add(btnReplace);
		this.add(btnReplaceAll);
		this.add(btnCancle);
		this.add(chkCharacter);
	}

}
