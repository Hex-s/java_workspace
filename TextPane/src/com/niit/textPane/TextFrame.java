package com.niit.textPane;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;

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
	private JMenuItem itemUndo;
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
	private JTextArea textValue;
	//��¼�ı��������Ƿ��޸�
	private boolean changed = false;
	//��ǰ�ļ�
	private File nowFile;
	//����
	private UndoManager manager;
	//�Ҽ��˵�
	private JPopupMenu popMenu;
	private JMenuItem pitemUndo;
	private JMenuItem pitemCut;
	private JMenuItem pitemCopy;
	private JMenuItem pitemPaste;
	private JMenuItem pitemDelete;
	private JMenuItem pitemAll;
	
	/**
	 * ����
	 */
	public TextFrame(){
		//��ʼ������
		initFrame();
		//��ʼ�����
		initComponent();
		//��Ӽ�����
		bindListener();
		
	}
	
	/**
	 * ��Ӽ�����
	 */
	private void bindListener(){
		ItemLintener itemListener = new ItemLintener();
		//Ϊ  ����  ��Ӽ�����
		itemFont.addActionListener(itemListener);
		//Ϊ  �滻  ��Ӽ�����
		itemReplace.addActionListener(itemListener);
		//Ϊ  �½�  ��Ӽ�����
		itemNew.addActionListener(itemListener);
		//Ϊ  �� ��Ӽ�����
		itemOpen.addActionListener(itemListener);
		//Ϊ  ����  ��Ӽ�����
		itemSave.addActionListener(itemListener);
		//Ϊ  ���Ϊ  ��Ӽ�����
		itemSaveAs.addActionListener(itemListener);
		//Ϊ  �˳�  ��Ӽ�����
		itemExit.addActionListener(itemListener);
		//Ϊ  ʱ��  ��Ӽ�����
		itemTime.addActionListener(itemListener);
		//Ϊ �ı��� ��Ӽ�����
		textValue.getDocument().addDocumentListener(new TextAreaListener());
		//Ϊ �ı��� ��Ӽ�����
		textValue.getDocument().addUndoableEditListener(manager);
		//Ϊ ���� ��Ӽ�����
		itemUndo.addActionListener(itemListener);
		//Ϊ ���� ��Ӽ�����
		chkAutoWarpLine.addActionListener(new LineWrapListener());
		//Ϊ ���� ��Ӽ�����
		itemCopy.addActionListener(itemListener);
		//Ϊ ���� ��Ӽ�����
		itemCut.addActionListener(itemListener);
		//Ϊ ճ�� ��Ӽ�����
		itemPaste.addActionListener(itemListener);
		//Ϊ ɾ�� ��Ӽ�����
		itemDelete.addActionListener(itemListener);
		//Ϊ ȫѡ ��Ӽ�����
		itemAll.addActionListener(itemListener);
		//�Ҽ�
		PopMenuListener popListener = new PopMenuListener();
//		popMenu.addUndoableEditListener(manager);
		pitemAll.addActionListener(popListener);
		pitemCopy.addActionListener(popListener);
		pitemCut.addActionListener(popListener);
		pitemDelete.addActionListener(popListener);
		pitemPaste.addActionListener(popListener);
		pitemUndo.addActionListener(popListener);
		
	}
	
	private class PopMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			if(item == pitemAll){
				textValue.selectAll();
			}
			else if (item == pitemCopy) {
				textValue.copy();
			}
			else if (item == pitemCut) {
				textValue.cut();
			}
			else if (item == pitemUndo) {
				if(manager.canUndo()){
					manager.undo();
				}
			}
			else if (item == pitemPaste) {
				textValue.paste();
			}
			else if (item == pitemDelete) {
				textValue.replaceSelection("");
			}
			
		}
		
	}
	
	/**
	 * �Զ�����
	 * @author Administrator
	 *
	 */
	private class LineWrapListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(chkAutoWarpLine.isSelected()){
				textValue.setLineWrap(true);
			}
			else{
				textValue.setLineWrap(false);
			}
		}
		
	}
	/**
	 * ѡ�������
	 * @author Administrator
	 *
	 */
	private class ItemLintener implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//����
			if(item == itemFont){
				FontFrame frm = new FontFrame(TextFrame.this);
				frm.setVisible(true);
			}
			//���
			else if (item == itemReplace){
				ReplaceFrame frm = new ReplaceFrame(TextFrame.this);
				frm.setVisible(true);
			}
			//�½�
			else if(item == itemNew){
				createNewText();
			}
			//��
			else if(item == itemOpen){
				openText();
			}
			//����
			else if(item == itemSave){
				savaText();
			}
			//���Ϊ
			else if(item == itemSaveAs){
				saveAsText();
			}
			//�˳�
			else if(item == itemExit){
				if(changed){
					savaText();
				}
				TextFrame.this.dispose();
			}
			//ʱ��
			else if(item == itemTime){
				Date date = new Date();
				String str = new SimpleDateFormat("hh:mm yyyy-MM-dd").format(date);
				textValue.append(str);
			}
			//����
			else if(item == itemUndo){
				if(manager.canUndo()){
					manager.undo();
				}
			}
			//����
			else if(item == itemCut){
				textValue.cut();
			}
			//ճ��
			else if(item == itemPaste){
				textValue.paste();
			}
			//����
			else if(item == itemCopy){
				textValue.copy();
			}
			//ɾ��
			else if(item == itemDelete){
				textValue.replaceSelection("");;
			}
			else if(item == itemAll){
				textValue.selectAll();
			}
			
		}
		
	}
	
	/**
	 * ��
	 */
	private void openText(){
		//�жϵ�ǰ�ı����Ƿ񾭹��޸�
		//�ļ��޸ģ����浱ǰ�ļ�
		//δ����رյ�ǰ���壬���´����г���ѡ���ļ�������
		if(changed){
			int choice = JOptionPane.showConfirmDialog(null, "�ļ� "+TextFrame.this.getTitle()+" �������Ѿ��ı䡣�뱣���ļ���","���±�",JOptionPane.YES_NO_CANCEL_OPTION);
			//����
			if(choice == JOptionPane.YES_OPTION || choice == JOptionPane.NO_OPTION){
				
				changed = false;
				if(choice == JOptionPane.YES_OPTION){
					//����
					savaText();
					//�򿪱��洰��
					openTextAction();
				}	
			}
		}
		else{
			//��ʾ�򿪴���
			openTextAction();
		}
		
	}
	/**
	 * �򿪴���
	 */
	private void openTextAction(){
		//���ļ�ѡ����
		JFileChooser fileChooser = new JFileChooser();
		//�����ļ�������
		fileChooser.setFileFilter(new FileNameExtensionFilter("���±�", "txt"));
		int choice1 = fileChooser.showOpenDialog(null);
		//�ж��Ƿ�����ѡ��ť
		if(choice1 == JFileChooser.APPROVE_OPTION){
			//��ȡѡ�е��ļ�
			File file = fileChooser.getSelectedFile();
			//�رյ�ǰ����
			TextFrame.this.dispose();
			//�½�����
			TextFrame frm = new TextFrame();
			frm.setVisible(true);
			
			frm.setTitle(file.getName());
			//���õ�ǰ�ļ�
			frm.nowFile = file;
			System.out.println(frm.nowFile);
			
			//��¼Ҫ�򿪼��±�������
			String str;
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				while ((str=reader.readLine()) != null) {
					frm.textValue.append(str);
					frm.textValue.append("\n");
				}
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ����
	 */
	private void savaText(){
		
		if(nowFile == null){
			System.out.println("nowfile==null");
			saveAsText();
		}
		else{
			//Դ�ļ���������Դ�ļ��н��б���
			if(nowFile.exists()){
				if(changed == true){
					//��textFied�е�����д�뵽�ļ���
					textAreaToTxt(nowFile);
					System.out.println(nowFile);
					changed = false;
				}
			}
			//Դ�ļ���������������Ϊ
			else{
				saveAsText();
			}
		}
	}
	
	/**
	 * ���Ϊ
	 */
	private void saveAsText(){
		
		//���ļ�ѡ����
		JFileChooser fileChooser = new JFileChooser();
		//�����ļ�������
		fileChooser.setFileFilter(new FileNameExtensionFilter("���±�", "txt"));
		int choice = fileChooser.showSaveDialog(null);
		//�ж��Ƿ�����ѡ��ť
		if(choice == JFileChooser.APPROVE_OPTION){
			//��ȡ��ǰ���ļ�
			File file = fileChooser.getSelectedFile();
			if(file.exists()){
				JOptionPane.showMessageDialog(null, "�ļ����Ѵ��ڣ�");
				saveAsText();
			}
			else{
				//��textFied�е�����д�뵽�ļ���
				textAreaToTxt(file);
				//�����ı�����
				TextFrame.this.setTitle(file.getName());
				nowFile = file;
				System.out.println(nowFile);
				changed = false;
			}
			
		}	
		
	}
	
	/**
	 * ��textFied�е�����д�뵽�ļ���
	 * @param file
	 */
	private void textAreaToTxt(File file){
		try
		{
			String str = textValue.getText().replace("\n", "\r\n");
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			writer.write(str);			
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �½�
	 */
	private void createNewText(){
		//�жϵ�ǰ�ı����Ƿ񾭹��޸�
		//δ���޸ģ���رյ�ǰ���壬�½�����
		if(changed == false){
			TextFrame.this.dispose();
			TextFrame frm = new TextFrame();
			frm.setTitle("�ޱ���"+" - ���±�");
			frm.setVisible(true);
			changed = false;
		}
		//�ı������ݾ����޸�
		else{
			int choice = JOptionPane.showConfirmDialog(null, "�ļ� "+TextFrame.this.getTitle()+" �������Ѿ��ı䡣�뱣���ļ���","���±�",JOptionPane.YES_NO_CANCEL_OPTION);
			//����
			if(choice == JOptionPane.YES_OPTION){
				changed = false;
				saveAsText();	
			}
			//������
			else if(choice == JOptionPane.NO_OPTION){
				TextFrame.this.dispose();
				TextFrame frm = new TextFrame();
				frm.setTitle("�ޱ���"+" - ���±�");
				frm.setVisible(true);
			}
		}
	}
	
	/**
	 * �ı��������
	 * @author Administrator
	 *
	 */
	private class TextAreaListener implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent e) {
			changed = true;
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			changed = true;
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			changed = true;
		}
		
		
		
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		
		manager = new UndoManager();
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
		itemUndo = new JMenuItem("����(U)");
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
		textValue = new JTextArea();
		splPnl = new JScrollPane(textValue,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
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
		menuEdit.add(itemUndo);
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
		
		//�Ҽ��˵�
		popMenu = new JPopupMenu();
		pitemUndo = new JMenuItem("����(U)");
		pitemCut = new JMenuItem("����(T)");
		pitemCopy = new JMenuItem("����(C)");
		pitemPaste = new JMenuItem("ճ��(P)");
		pitemDelete = new JMenuItem("ɾ��(L)");
		pitemAll = new JMenuItem("ȫѡ(A)");
		popMenu.add(pitemUndo);
		popMenu.add(pitemCut);
		popMenu.add(pitemCopy);
		popMenu.add(pitemPaste);
		popMenu.add(pitemDelete);
		popMenu.addSeparator();
		popMenu.add(pitemAll);
		
		//���Ҽ�����ָ���������
		textValue.setComponentPopupMenu(popMenu);
		
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
		itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
		itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
		itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
		itemGetTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
		itemAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		itemTime.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		itemFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
//		//���ûҼ�
//		itemUndo.setEnabled(false);
//		itemCut.setEnabled(false);
//		itemCopy.setEnabled(false);;
//		itemDelete.setEnabled(false);;
//		itemFind.setEnabled(false);
//		itemFindNext.setEnabled(false);
//		itemGetTo.setEnabled(false);
//		itemState.setEnabled(false);
		
		//��menuBar���뵽������
		this.setJMenuBar(menuBar);
		this.add(splPnl);
	}
	/**
	 * ��ʼ������
	 */
	private void initFrame(){
		this.setSize(600,600);
		this.setTitle("�½� �ı��ĵ�.txt");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public JTextArea getTextValue() {
		return textValue;
	}
	

}
