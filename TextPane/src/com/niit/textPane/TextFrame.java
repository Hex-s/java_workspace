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
	//菜单条
	private JMenuBar menuBar;
	//菜单项
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuFormat;
	private JMenu menuSearch;
	private JMenu menuHelp;
	//文件 菜单子项
	private JMenuItem itemNew;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemSaveAs;
	private JMenuItem itemPageSet;
	private JMenuItem itemPrint;
	private JMenuItem itemExit;
	//编辑 菜单子项
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
	//格式 菜单子项
	private JCheckBoxMenuItem chkAutoWarpLine;
	private JMenuItem itemFont;
	//格式 菜单子项
	private JMenuItem itemState;
	//帮助 菜单子项
	private JMenuItem itemHelpTheme;
	private JMenuItem itemTxtInfo;
	
	//主体部分组件
	private JScrollPane splPnl;
	private JTextArea textValue;
	//记录文本域内容是否修改
	private boolean changed = false;
	//当前文件
	private File nowFile;
	//撤销
	private UndoManager manager;
	//右键菜单
	private JPopupMenu popMenu;
	private JMenuItem pitemUndo;
	private JMenuItem pitemCut;
	private JMenuItem pitemCopy;
	private JMenuItem pitemPaste;
	private JMenuItem pitemDelete;
	private JMenuItem pitemAll;
	
	/**
	 * 构造
	 */
	public TextFrame(){
		//初始化窗体
		initFrame();
		//初始化组件
		initComponent();
		//添加监听器
		bindListener();
		
	}
	
	/**
	 * 添加监听器
	 */
	private void bindListener(){
		ItemLintener itemListener = new ItemLintener();
		//为  字体  添加监听器
		itemFont.addActionListener(itemListener);
		//为  替换  添加监听器
		itemReplace.addActionListener(itemListener);
		//为  新建  添加监听器
		itemNew.addActionListener(itemListener);
		//为  打开 添加监听器
		itemOpen.addActionListener(itemListener);
		//为  保存  添加监听器
		itemSave.addActionListener(itemListener);
		//为  另存为  添加监听器
		itemSaveAs.addActionListener(itemListener);
		//为  退出  添加监听器
		itemExit.addActionListener(itemListener);
		//为  时间  添加监听器
		itemTime.addActionListener(itemListener);
		//为 文本域 添加监听器
		textValue.getDocument().addDocumentListener(new TextAreaListener());
		//为 文本域 添加监听器
		textValue.getDocument().addUndoableEditListener(manager);
		//为 撤销 添加监听器
		itemUndo.addActionListener(itemListener);
		//为 换行 添加监听器
		chkAutoWarpLine.addActionListener(new LineWrapListener());
		//为 复制 添加监听器
		itemCopy.addActionListener(itemListener);
		//为 剪切 添加监听器
		itemCut.addActionListener(itemListener);
		//为 粘贴 添加监听器
		itemPaste.addActionListener(itemListener);
		//为 删除 添加监听器
		itemDelete.addActionListener(itemListener);
		//为 全选 添加监听器
		itemAll.addActionListener(itemListener);
		//右键
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
	 * 自动换行
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
	 * 选项监听器
	 * @author Administrator
	 *
	 */
	private class ItemLintener implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem)e.getSource();
			//字体
			if(item == itemFont){
				FontFrame frm = new FontFrame(TextFrame.this);
				frm.setVisible(true);
			}
			//替代
			else if (item == itemReplace){
				ReplaceFrame frm = new ReplaceFrame(TextFrame.this);
				frm.setVisible(true);
			}
			//新建
			else if(item == itemNew){
				createNewText();
			}
			//打开
			else if(item == itemOpen){
				openText();
			}
			//保存
			else if(item == itemSave){
				savaText();
			}
			//另存为
			else if(item == itemSaveAs){
				saveAsText();
			}
			//退出
			else if(item == itemExit){
				if(changed){
					savaText();
				}
				TextFrame.this.dispose();
			}
			//时间
			else if(item == itemTime){
				Date date = new Date();
				String str = new SimpleDateFormat("hh:mm yyyy-MM-dd").format(date);
				textValue.append(str);
			}
			//撤销
			else if(item == itemUndo){
				if(manager.canUndo()){
					manager.undo();
				}
			}
			//剪切
			else if(item == itemCut){
				textValue.cut();
			}
			//粘贴
			else if(item == itemPaste){
				textValue.paste();
			}
			//复制
			else if(item == itemCopy){
				textValue.copy();
			}
			//删除
			else if(item == itemDelete){
				textValue.replaceSelection("");;
			}
			else if(item == itemAll){
				textValue.selectAll();
			}
			
		}
		
	}
	
	/**
	 * 打开
	 */
	private void openText(){
		//判断当前文本域是否经过修改
		//文件修改，保存当前文件
		//未经则关闭当前窗体，在新窗体中呈现选择文件的内容
		if(changed){
			int choice = JOptionPane.showConfirmDialog(null, "文件 "+TextFrame.this.getTitle()+" 的文字已经改变。想保存文件吗？","记事本",JOptionPane.YES_NO_CANCEL_OPTION);
			//保存
			if(choice == JOptionPane.YES_OPTION || choice == JOptionPane.NO_OPTION){
				
				changed = false;
				if(choice == JOptionPane.YES_OPTION){
					//保存
					savaText();
					//打开保存窗体
					openTextAction();
				}	
			}
		}
		else{
			//显示打开窗体
			openTextAction();
		}
		
	}
	/**
	 * 打开窗体
	 */
	private void openTextAction(){
		//打开文件选择器
		JFileChooser fileChooser = new JFileChooser();
		//设置文件过滤器
		fileChooser.setFileFilter(new FileNameExtensionFilter("记事本", "txt"));
		int choice1 = fileChooser.showOpenDialog(null);
		//判断是否点击了选择按钮
		if(choice1 == JFileChooser.APPROVE_OPTION){
			//获取选中的文件
			File file = fileChooser.getSelectedFile();
			//关闭当前窗体
			TextFrame.this.dispose();
			//新建窗体
			TextFrame frm = new TextFrame();
			frm.setVisible(true);
			
			frm.setTitle(file.getName());
			//设置当前文件
			frm.nowFile = file;
			System.out.println(frm.nowFile);
			
			//记录要打开记事本的内容
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
	 * 保存
	 */
	private void savaText(){
		
		if(nowFile == null){
			System.out.println("nowfile==null");
			saveAsText();
		}
		else{
			//源文件存在则在源文件中进行保存
			if(nowFile.exists()){
				if(changed == true){
					//将textFied中的内容写入到文件中
					textAreaToTxt(nowFile);
					System.out.println(nowFile);
					changed = false;
				}
			}
			//源文件不存在则进行另存为
			else{
				saveAsText();
			}
		}
	}
	
	/**
	 * 另存为
	 */
	private void saveAsText(){
		
		//打开文件选择器
		JFileChooser fileChooser = new JFileChooser();
		//设置文件过滤器
		fileChooser.setFileFilter(new FileNameExtensionFilter("记事本", "txt"));
		int choice = fileChooser.showSaveDialog(null);
		//判断是否点击了选择按钮
		if(choice == JFileChooser.APPROVE_OPTION){
			//获取当前的文件
			File file = fileChooser.getSelectedFile();
			if(file.exists()){
				JOptionPane.showMessageDialog(null, "文件名已存在！");
				saveAsText();
			}
			else{
				//将textFied中的内容写入到文件中
				textAreaToTxt(file);
				//设置文本标题
				TextFrame.this.setTitle(file.getName());
				nowFile = file;
				System.out.println(nowFile);
				changed = false;
			}
			
		}	
		
	}
	
	/**
	 * 将textFied中的内容写入到文件中
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
	 * 新建
	 */
	private void createNewText(){
		//判断当前文本域是否经过修改
		//未经修改，则关闭当前窗体，新建窗体
		if(changed == false){
			TextFrame.this.dispose();
			TextFrame frm = new TextFrame();
			frm.setTitle("无标题"+" - 记事本");
			frm.setVisible(true);
			changed = false;
		}
		//文本框内容经过修改
		else{
			int choice = JOptionPane.showConfirmDialog(null, "文件 "+TextFrame.this.getTitle()+" 的文字已经改变。想保存文件吗？","记事本",JOptionPane.YES_NO_CANCEL_OPTION);
			//保存
			if(choice == JOptionPane.YES_OPTION){
				changed = false;
				saveAsText();	
			}
			//不保存
			else if(choice == JOptionPane.NO_OPTION){
				TextFrame.this.dispose();
				TextFrame frm = new TextFrame();
				frm.setTitle("无标题"+" - 记事本");
				frm.setVisible(true);
			}
		}
	}
	
	/**
	 * 文本域监听器
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
	 * 初始化组件
	 */
	private void initComponent(){
		
		manager = new UndoManager();
		//实例化菜单条
		menuBar = new JMenuBar();
		//实例化菜单项
		menuFile = new JMenu("文件(F)");
		menuEdit = new JMenu("编辑(E)");
		menuFormat = new JMenu("格式(O)");
		menuHelp = new JMenu("帮助(H)");
		menuSearch = new JMenu("查看(V)");
		//实例化 文件 子菜单项
		itemNew = new JMenuItem("新建(N)");
		itemOpen = new JMenuItem("打开(O)");
		itemSave = new JMenuItem("保存(S)");
		itemSaveAs = new JMenuItem("另存为(A)");
		itemPageSet = new JMenuItem("页面设置(U)");
		itemPrint = new JMenuItem("打印(P)");
		itemExit = new JMenuItem("退出(X)");
		//实例化 编辑 子菜单项
		itemUndo = new JMenuItem("撤销(U)");
		itemCut = new JMenuItem("剪切(T)");
		itemCopy = new JMenuItem("复制(C)");
		itemPaste = new JMenuItem("粘贴(P)");
		itemDelete = new JMenuItem("删除(L)");
		itemFind = new JMenuItem("查找（F)");
		itemFindNext = new JMenuItem("查找下一个(N)");
		itemReplace = new JMenuItem("替换(R)");
		itemGetTo = new JMenuItem("转到(G)");
		itemAll = new JMenuItem("全选(A)");
		itemTime = new JMenuItem("时间/日期(D)");
		//实例化 格式 子菜单项
		chkAutoWarpLine = new JCheckBoxMenuItem("自动换行(W)");
		itemFont = new JMenuItem("字体(F)");
		//实例化 查看 子菜单项
		itemState = new JMenuItem("状态栏(S)");
		//实例化 帮助 子菜单项
		itemHelpTheme = new JMenuItem("帮助主题(H)");
		itemTxtInfo = new JMenuItem("关于记事本(A)");
		//实例化 主题不部分
		textValue = new JTextArea();
		splPnl = new JScrollPane(textValue,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//将menu加入menuBar中
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuFormat);
		menuBar.add(menuSearch);
		menuBar.add(menuHelp);
		//将  文件  子项加入文件菜单中
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemSaveAs);
		menuFile.addSeparator();
		menuFile.add(itemPageSet);
		menuFile.add(itemPrint);
		menuFile.addSeparator();
		menuFile.add(itemExit);
		//将  辑子  项加入编辑菜单中
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
		//将  格式  子项加入格式菜单中
		menuFormat.add(chkAutoWarpLine);
		menuFormat.add(itemFont);
		//将  查看  子项加入格式菜单中
		menuSearch.add(itemState);
		//将  帮助  子项加入格式菜单中
		menuHelp.add(itemHelpTheme);
		menuHelp.add(itemTxtInfo);
		
		//右键菜单
		popMenu = new JPopupMenu();
		pitemUndo = new JMenuItem("撤销(U)");
		pitemCut = new JMenuItem("剪切(T)");
		pitemCopy = new JMenuItem("复制(C)");
		pitemPaste = new JMenuItem("粘贴(P)");
		pitemDelete = new JMenuItem("删除(L)");
		pitemAll = new JMenuItem("全选(A)");
		popMenu.add(pitemUndo);
		popMenu.add(pitemCut);
		popMenu.add(pitemCopy);
		popMenu.add(pitemPaste);
		popMenu.add(pitemDelete);
		popMenu.addSeparator();
		popMenu.add(pitemAll);
		
		//将右键绑定在指定的组件上
		textValue.setComponentPopupMenu(popMenu);
		
		//为菜单添加快捷键
		menuFile.setMnemonic('f');
		menuEdit.setMnemonic('e');
		menuFormat.setMnemonic('o');
		menuSearch.setMnemonic('v');
		menuHelp.setMnemonic('h');
		//为菜单子项设置快捷键
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
//		//设置灰键
//		itemUndo.setEnabled(false);
//		itemCut.setEnabled(false);
//		itemCopy.setEnabled(false);;
//		itemDelete.setEnabled(false);;
//		itemFind.setEnabled(false);
//		itemFindNext.setEnabled(false);
//		itemGetTo.setEnabled(false);
//		itemState.setEnabled(false);
		
		//将menuBar加入到窗体中
		this.setJMenuBar(menuBar);
		this.add(splPnl);
	}
	/**
	 * 初始化窗体
	 */
	private void initFrame(){
		this.setSize(600,600);
		this.setTitle("新建 文本文档.txt");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	public JTextArea getTextValue() {
		return textValue;
	}
	

}
