package com.niit;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.peer.MenuPeer;
import java.security.KeyStore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;

/**
 * �˵�����ʹ��
 * @author Administrator
 *
 */
public class NotePad extends JFrame {
	//�˵���
	private JMenuBar menuBar;
	//�˵���
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuFormat;
	private JMenu menuSearch;
	private JMenu menuHelp;
	//�˵�����
	private JMenuItem itemNew;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemSaveAs;
	private JMenu menuPageSet;
	private JMenuItem itemExit;
	private JMenuItem itemType;
	private JMenuItem itemView;
	private JMenuItem itemChangePage;
	private JCheckBox chkAutoWarpLine;
	private JCheckBoxMenuItem itemChk;
	private JButton btnNew;
	private JButton btnOpen;
	private JMenuItem itemUndo;
	
	private JTextArea txtValue;
	private JScrollPane scrollTxt;
	private UndoManager manager;
	
	//������
	//private JToolBar toolBar;
	
	public NotePad(){
		this.setBounds(200, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ʵ�����˵���
		menuBar = new JMenuBar();
		//ʵ�����˵���
		menuFile = new JMenu("�ļ�");
		menuEdit = new JMenu("�༭");
		menuFormat = new JMenu("��ʽ");
		menuSearch = new JMenu("����");
		menuHelp = new JMenu("����");
		menuPageSet = new JMenu("ҳ������");
		//ʵ�����˵�����
		itemExit = new JMenuItem("�˳�");
		itemNew = new JMenuItem("�½�");
		itemOpen = new JMenuItem("��");
		itemSave = new JMenuItem("����");
		itemSaveAs = new JMenuItem("���Ϊ");
		itemChangePage = new JMenuItem("ֽ�Ŵ�С");
		itemType = new JMenuItem("��ӡ");
		itemView = new JMenuItem("Ԥ��");
		itemUndo = new JMenuItem("����");
		//���˵���������˵���
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuFormat);
		menuBar.add(menuSearch);
		menuBar.add(menuHelp);
		//���˵�����ֱ�����������˵�����
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemSaveAs);
		//��ӷָ���
		menuFile.addSeparator();
		menuFile.add(menuPageSet);
		menuFile.add(itemExit);
		menuPageSet.add(itemChangePage);
		menuPageSet.add(itemView);
		menuPageSet.add(itemType);
		menuFile.add(itemUndo);
		
		//�󶨼�����
		MenuItemListener listener = new MenuItemListener();
		itemNew.addActionListener(listener);
		itemOpen.addActionListener(listener);
		itemSave.addActionListener(listener);
		itemUndo.addActionListener(listener);
		
		//Ϊ�˵��������ÿ�ݼ�
		itemNew.setAccelerator(KeyStroke.getKeyStroke('n'));
		itemOpen.setAccelerator(KeyStroke.getKeyStroke('o'));
		//������ϼ�
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.ALT_MASK));
		
		//Ϊ�˵������ÿ�ݼ���������ALTʹ��
		menuFile.setMnemonic('f');
		
		//���ѡ���
		chkAutoWarpLine = new JCheckBox("�Զ�����");
		itemChk = new JCheckBoxMenuItem("�Զ�����");
		menuFormat.add(itemChk);
		
		//�һ��˵�����
		itemExit.setEnabled(false);
		//���ز˵�
		//itemExit.setVisible(false);
		
		//���˵������������
		//this.add(menuBar,BorderLayout.NORTH);
		//���ò˵���
		this.setJMenuBar(menuBar);
		
		//������������
		manager = new UndoManager();
		//�����ı���
		txtValue = new JTextArea();
		//�����������
		scrollTxt = new JScrollPane(txtValue);
		//��ӹ������
		this.add(scrollTxt);
//		//�����Ƿ��Զ�����
//		txtValue.setLineWrap(true);
		
//		//��ѡ�����ݽ��и���
//		txtValue.copy();
//		//����
//		txtValue.cut();
//		//���
//		txtValue.paste();
//		//ɾ��
//		txtValue.replaceSelection("");
		//����ı���ļ�����
		txtValue.getDocument().addDocumentListener(new TextListener());
		//��ӳ���������
		txtValue.getDocument().addUndoableEditListener(manager);
		
		txtValue.setText("hello niit");
		//��ȡ�ı��������е�����
		//��һ��������ʾ��ȡ�ı�����ʼ�������ڶ���������ʾ�ı��ĳ���
		try {
			txtValue.getText(0, txtValue.getText().length());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡѡ���ı����ڵ�����ֵ
		//int index = txtValue.getText().indexOf(txtValue.getSelectedText());
		//����ѡ���ı�����ʼ����
		txtValue.setSelectionStart(1);
		//����ѡ���ı��Ľ�������
		txtValue.setSelectionEnd(5);
		
		
		//ʵ����������
		//toolBar = new JToolBar();
		//ʵ������ť
		//��������һ���Ű�ť��Ҳ���Դ�������������ťһ��ֻ��ʾͼƬ
//		btnNew = new JButton(new ImageIcon("image/newStu.gif"));
//		btnOpen = new JButton(new ImageIcon("image/question.gif"));
//		toolBar.add(btnNew);
//		toolBar.add(btnOpen);
		
		//��ӹ�����
//		this.add(toolBar,BorderLayout.NORTH);
	}
	
	private class TextListener implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("�ı����ݱ����");
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("�������ı�����");
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("ɾ�����ı�����");
			
		}
		
	}
	private class MenuItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//JOptionPane.showMessageDialog(null, item.getText());
			if(item == itemUndo){
				if(manager.canUndo()){
					manager.undo();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		NotePad frm = new NotePad();
		frm.setVisible(true);
	}
}
