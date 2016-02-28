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
	private JTextArea textArea;
	
	public TextFrame(){
		//初始化窗体
		initFrame();
		//初始化组件
		initComponent();
		//添加监听器
		addLintener();
		
	}
	
	/**
	 * 添加监听器
	 */
	private void addLintener(){
		//为  字体  添加监听器
		itemFont.addActionListener(new FontLintener());
		//为  替换  添加监听器
		itemReplace.addActionListener(new ReplaceListenet());
	}
	
	/**
	 * 字体监听器
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
	 * 监听器
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
	 * 初始化组件
	 */
	private void initComponent(){
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
		itemBackout = new JMenuItem("撤销(U)");
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
		textArea = new JTextArea();
		splPnl = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
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
		//将  格式  子项加入格式菜单中
		menuFormat.add(chkAutoWarpLine);
		menuFormat.add(itemFont);
		//将  查看  子项加入格式菜单中
		menuSearch.add(itemState);
		//将  帮助  子项加入格式菜单中
		menuHelp.add(itemHelpTheme);
		menuHelp.add(itemTxtInfo);
		
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
		itemBackout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
		itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
		itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
		itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
		itemGetTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
		itemAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		
		//设置灰键
		itemBackout.setEnabled(false);
		itemCut.setEnabled(false);
		itemCopy.setEnabled(false);;
		itemDelete.setEnabled(false);;
		itemFind.setEnabled(false);
		itemFindNext.setEnabled(false);
		itemGetTo.setEnabled(false);
		itemState.setEnabled(false);
		
		//将menuBar加入到窗体中
		this.setJMenuBar(menuBar);
		this.add(splPnl);
	}
	/**
	 * 初始化窗体
	 */
	private void initFrame(){
		this.setSize(600,600);
		this.setTitle("记事本");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
