package com.niit.txt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class TextFrame extends JFrame{
	//�˵���
	private JMenuBar menuBar;
	//�˵���
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuFormat;
	private JMenu menuSearch;
	private JMenu menuHelp;
	//�ļ� �˵�����
	private JMenuItem itemNew;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemSaveAs;
	private JMenuItem itemPageSet;
	private JMenuItem itemPrint;
	private JMenuItem itemExit;
	//�༭ �˵�����
	private JMenuItem itemBackout;
	private JMenuItem itemCut;
	private JMenuItem itemCopy;
	private JMenuItem itemPaste;
	private JMenuItem itemDelete;
	private JMenuItem itemFind;
	private JMenuItem itemFindNext;
	private JMenuItem itemReplace;
	private JMenuItem itemGetTo;
	private JMenuItem itemAll;
	private JMenuItem itemTime;
	//��ʽ �˵�����
	private JCheckBoxMenuItem chkAutoWarpLine;
	private JMenuItem itemFont;
	//��ʽ �˵�����
	private JMenuItem itemState;
	//���� �˵�����
	private JMenuItem itemHelpTheme;
	private JMenuItem itemTxtInfo;
	
	//���岿�����
	private JScrollPane splPnl;
	private JTextArea textArea;
	
	public TextFrame(){
		//��ʼ������
		initFrame();
		//��ʼ�����
		initComponent();
		//��Ӽ�����
		addLintener();
		
	}
	
	/**
	 * ��Ӽ�����
	 */
	private void addLintener(){
		//Ϊ  ����  ��Ӽ�����
		itemFont.addActionListener(new FontLintener());
		//Ϊ  �滻  ��Ӽ�����
		itemReplace.addActionListener(new ReplaceListenet());
	}
	
	/**
	 * ���������
	 * @author Administrator
	 *
	 */
	private class FontLintener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			FontFrame frm = new FontFrame(TextFrame.this);
			frm.setVisible(true);
		}
		
	}
	
	/**
	 * ������
	 * @author Administrator
	 *
	 */
	private class ReplaceListenet implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ReplaceFrame frm = new ReplaceFrame(TextFrame.this);
			frm.setVisible(true);
		}
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		//ʵ�����˵���
		menuBar = new JMenuBar();
		//ʵ�����˵���
		menuFile = new JMenu("�ļ�(F)");
		menuEdit = new JMenu("�༭(E)");
		menuFormat = new JMenu("��ʽ(O)");
		menuHelp = new JMenu("����(H)");
		menuSearch = new JMenu("�鿴(V)");
		//ʵ���� �ļ� �Ӳ˵���
		itemNew = new JMenuItem("�½�(N)");
		itemOpen = new JMenuItem("��(O)");
		itemSave = new JMenuItem("����(S)");
		itemSaveAs = new JMenuItem("���Ϊ(A)");
		itemPageSet = new JMenuItem("ҳ������(U)");
		itemPrint = new JMenuItem("��ӡ(P)");
		itemExit = new JMenuItem("�˳�(X)");
		//ʵ���� �༭ �Ӳ˵���
		itemBackout = new JMenuItem("����(U)");
		itemCut = new JMenuItem("����(T)");
		itemCopy = new JMenuItem("����(C)");
		itemPaste = new JMenuItem("ճ��(P)");
		itemDelete = new JMenuItem("ɾ��(L)");
		itemFind = new JMenuItem("���ң�F)");
		itemFindNext = new JMenuItem("������һ��(N)");
		itemReplace = new JMenuItem("�滻(R)");
		itemGetTo = new JMenuItem("ת��(G)");
		itemAll = new JMenuItem("ȫѡ(A)");
		itemTime = new JMenuItem("ʱ��/����(D)");
		//ʵ���� ��ʽ �Ӳ˵���
		chkAutoWarpLine = new JCheckBoxMenuItem("�Զ�����(W)");
		itemFont = new JMenuItem("����(F)");
		//ʵ���� �鿴 �Ӳ˵���
		itemState = new JMenuItem("״̬��(S)");
		//ʵ���� ���� �Ӳ˵���
		itemHelpTheme = new JMenuItem("��������(H)");
		itemTxtInfo = new JMenuItem("���ڼ��±�(A)");
		//ʵ���� ���ⲻ����
		textArea = new JTextArea();
		splPnl = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//��menu����menuBar��
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuFormat);
		menuBar.add(menuSearch);
		menuBar.add(menuHelp);
		//��  �ļ�  ��������ļ��˵���
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemSaveAs);
		menuFile.addSeparator();
		menuFile.add(itemPageSet);
		menuFile.add(itemPrint);
		menuFile.addSeparator();
		menuFile.add(itemExit);
		//��  ����  �����༭�˵���
		menuEdit.add(itemBackout);
		menuEdit.addSeparator();
		menuEdit.add(itemCut);
		menuEdit.add(itemCopy);
		menuEdit.add(itemPaste);
		menuEdit.add(itemDelete);
		menuEdit.addSeparator();
		menuEdit.add(itemFind);
		menuEdit.add(itemFindNext);
		menuEdit.add(itemReplace);
		menuEdit.add(itemGetTo);
		menuEdit.addSeparator();
		menuEdit.add(itemAll);
		menuEdit.add(itemTime);
		//��  ��ʽ  ��������ʽ�˵���
		menuFormat.add(chkAutoWarpLine);
		menuFormat.add(itemFont);
		//��  �鿴  ��������ʽ�˵���
		menuSearch.add(itemState);
		//��  ����  ��������ʽ�˵���
		menuHelp.add(itemHelpTheme);
		menuHelp.add(itemTxtInfo);
		
		//Ϊ�˵���ӿ�ݼ�
		menuFile.setMnemonic('f');
		menuEdit.setMnemonic('e');
		menuFormat.setMnemonic('o');
		menuSearch.setMnemonic('v');
		menuHelp.setMnemonic('h');
		//Ϊ�˵��������ÿ�ݼ�
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		itemBackout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
		itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
		itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
		itemGetTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
		itemAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		
		//���ûҼ�
		itemBackout.setEnabled(false);
		itemCut.setEnabled(false);
		itemCopy.setEnabled(false);;
		itemDelete.setEnabled(false);;
		itemFind.setEnabled(false);
		itemFindNext.setEnabled(false);
		itemGetTo.setEnabled(false);
		itemState.setEnabled(false);
		
		//��menuBar���뵽������
		this.setJMenuBar(menuBar);
		this.add(splPnl);
	}
	/**
	 * ��ʼ������
	 */
	private void initFrame(){
		this.setSize(600,600);
		this.setTitle("���±�");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
