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
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 * �˵�����ʹ��
 * @author Administrator
 *
 */
public class Exam2 extends JFrame {
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
	
	//������
	private JToolBar toolBar;
	
	public Exam2(){
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
		
		//�󶨼�����
		MenuItemListener listener = new MenuItemListener();
		itemNew.addActionListener(listener);
		itemOpen.addActionListener(listener);
		itemSave.addActionListener(listener);
		
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
		
		
		//ʵ����������
		toolBar = new JToolBar();
		//ʵ������ť
		//��������һ���Ű�ť��Ҳ���Դ�������������ťһ��ֻ��ʾͼƬ
		btnNew = new JButton(new ImageIcon("image/newStu.gif"));
		btnOpen = new JButton(new ImageIcon("image/question.gif"));
		toolBar.add(btnNew);
		toolBar.add(btnOpen);
		
		//��ӹ�����
		this.add(toolBar,BorderLayout.NORTH);
	}
	private class MenuItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			JOptionPane.showMessageDialog(null, item.getText());
		}
		
	}
	public static void main(String[] args) {
		Exam2 frm = new Exam2();
		frm.setVisible(true);
	}
}
