package com.niit.textPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CharacterFrame extends JFrame{

	private JTextArea txtCharacter;
	private JTextArea txtFormat;
	private JTextArea txtSize;
	private JLabel lblCharacter;
	private JLabel lblFormat;
	private JLabel lblSize;
	private JButton btnConfirm;
	private JButton btnCancle;
	private JScrollPane splCharacter;
	private JScrollPane splFormat;
	private JScrollPane splSize;
	private JLabel lblExample;
	private JPanel pnlExample;
	private JLabel lblCharacterList;
	private JComboBox cboCharacterList;
	private JList listCharchter;
	private JList listFormat;
	private JList  listSize;
	private String[] strCh;
	private String[] strFor;
	private String[] strSize;
	private String strChap = "����";
	private int formatNum = Font.PLAIN;
	private int size = 10;
	private TextFrame txtFrm;
	
	
	public CharacterFrame(TextFrame txtFrm){
		this.setBounds(200, 200, 500, 500);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.txtFrm = txtFrm;
		this.setLayout(null);
		//ʵ����

		//��ȡ����
		GraphicsEnvironment evironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		strCh = evironment.getAvailableFontFamilyNames();
//		for(String font : fontNames){
//			modelLeft.addElement(font);
//		}
		
//		strCh = new String[]{"����","����","����","���Ĳ���","��Բ","����"};
		strFor = new String[]{"����","б��","����","��б��"};
		strSize = new String[]{"8","9","10","11","12","13","14","15","16","17","18","19","20"};
		listCharchter = new JList(strCh);
		listFormat = new JList(strFor);
		listSize = new JList(strSize);
		lblCharacter = new JLabel("����");
		lblFormat = new JLabel("����");
		lblSize = new JLabel("��С");
		txtCharacter = new JTextArea();
		txtFormat = new JTextArea();
		txtSize = new JTextArea();
		btnCancle = new JButton("ȡ��");
		btnConfirm = new JButton("ȷ��");
		splCharacter = new JScrollPane(listCharchter);
		splFormat = new JScrollPane(listFormat);
		splSize = new JScrollPane(listSize);
		lblExample = new JLabel("  EXAMPLE");
		pnlExample = new JPanel();
		cboCharacterList = new JComboBox();
		lblCharacterList = new JLabel("�ַ���");
		pnlExample.setLayout(null);
		
		
		lblCharacter.setBounds(20, 20, 130, 20);
		lblFormat.setBounds(170, 20, 100, 20);
		lblSize.setBounds(290, 20, 60, 20);
		
		txtCharacter.setBounds(20, 43, 130, 20);
		txtFormat.setBounds(170, 43, 100, 20);
		txtSize.setBounds(290, 43, 80, 20);
		
		btnConfirm.setBounds(400, 43, 60, 25);
		btnCancle.setBounds(400, 80, 60, 25);
		
		splCharacter.setBounds(20, 65, 130, 130);
		splFormat.setBounds(170, 65, 100, 130);
		splSize.setBounds(290, 65, 80, 130);
		
		pnlExample.setBounds(170, 200, 230, 80);
		pnlExample.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray), "ʾ��"));
		
		lblExample.setBounds(20, 20, 200, 40);
		lblExample.setBorder(BorderFactory.createLoweredBevelBorder());
		
		lblCharacterList.setBounds(170, 300, 230, 25);
		cboCharacterList.setBounds(170, 330, 230, 25);
		
		//�󶨼���
		listListener listener = new listListener();
		listCharchter.addListSelectionListener(listener);
		listFormat.addListSelectionListener(listener);
		listSize.addListSelectionListener(listener);
	
		//������
		
		this.add(lblCharacter);
		this.add(lblFormat);
		this.add(lblSize);
		this.add(txtCharacter);
		this.add(txtFormat);
		this.add(txtSize);
		this.add(btnCancle);
		this.add(btnConfirm);
		this.add(splCharacter);
		this.add(splFormat);
		this.add(splSize);
		this.add(pnlExample);
		pnlExample.add(lblExample);
		//this.add(lblExample);
		this.add(lblCharacterList);
		this.add(cboCharacterList);
		bindListener();
	}
	
	private class listListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			
			
			if(e.getSource() == listCharchter){
				txtCharacter.setText(listCharchter.getSelectedValue().toString());
				strChap = listCharchter.getSelectedValue().toString();
			}
			else if(e.getSource() == listFormat){
				
				txtFormat.setText(listFormat.getSelectedValue().toString());
				
				String format = listFormat.getSelectedValue().toString();
				if(format.equals("����")){
					formatNum = Font.PLAIN;
				}
				else if(format.equals("б��")){
					formatNum = Font.ITALIC;
				}
				else if(format.equals("��б��")){
					formatNum = Font.BOLD|Font.ITALIC;
				}
				else if(format.equals("����")){
					formatNum = Font.BOLD;
				}
			}
			else if(e.getSource() == listSize){
				txtSize.setText(listSize.getSelectedValue().toString());
				String str = listSize.getSelectedValue().toString();
				size = Integer.parseInt(str);
			}

			Font font = new Font(strChap,formatNum ,size );
			lblExample.setFont(font);
		}
	}
		
	private class btnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnConfirm){
				
				Font font = new Font(strChap,formatNum ,size );
				txtFrm.getTextValue().setFont(font);
				CharacterFrame.this.dispose();
			}
			else if(e.getSource() == btnCancle){
				CharacterFrame.this.dispose();
			}
		}
		
	}
		
		private void bindListener(){
			btnConfirm.addActionListener(new btnListener());
			btnCancle.addActionListener(new btnListener());
		}
		
	

}
