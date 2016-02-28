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
 * 菜单条的使用
 * @author Administrator
 *
 */
public class NotePad extends JFrame {
	//菜单条
	private JMenuBar menuBar;
	//菜单项
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuFormat;
	private JMenu menuSearch;
	private JMenu menuHelp;
	//菜单子项
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
	
	//工具条
	//private JToolBar toolBar;
	
	public NotePad(){
		this.setBounds(200, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//实例化菜单条
		menuBar = new JMenuBar();
		//实例化菜单项
		menuFile = new JMenu("文件");
		menuEdit = new JMenu("编辑");
		menuFormat = new JMenu("格式");
		menuSearch = new JMenu("查找");
		menuHelp = new JMenu("帮助");
		menuPageSet = new JMenu("页面设置");
		//实例化菜单子项
		itemExit = new JMenuItem("退出");
		itemNew = new JMenuItem("新建");
		itemOpen = new JMenuItem("打开");
		itemSave = new JMenuItem("保存");
		itemSaveAs = new JMenuItem("另存为");
		itemChangePage = new JMenuItem("纸张大小");
		itemType = new JMenuItem("打印");
		itemView = new JMenuItem("预览");
		itemUndo = new JMenuItem("撤销");
		//将菜单项添加至菜单条
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuFormat);
		menuBar.add(menuSearch);
		menuBar.add(menuHelp);
		//将菜单子项分别添加至各个菜单项中
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemSaveAs);
		//添加分割线
		menuFile.addSeparator();
		menuFile.add(menuPageSet);
		menuFile.add(itemExit);
		menuPageSet.add(itemChangePage);
		menuPageSet.add(itemView);
		menuPageSet.add(itemType);
		menuFile.add(itemUndo);
		
		//绑定监听器
		MenuItemListener listener = new MenuItemListener();
		itemNew.addActionListener(listener);
		itemOpen.addActionListener(listener);
		itemSave.addActionListener(listener);
		itemUndo.addActionListener(listener);
		
		//为菜单子项设置快捷键
		itemNew.setAccelerator(KeyStroke.getKeyStroke('n'));
		itemOpen.setAccelerator(KeyStroke.getKeyStroke('o'));
		//设置组合键
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.ALT_MASK));
		
		//为菜单项设置快捷键，必须结合ALT使用
		menuFile.setMnemonic('f');
		
		//添加选择框
		chkAutoWarpLine = new JCheckBox("自动换行");
		itemChk = new JCheckBoxMenuItem("自动换行");
		menuFormat.add(itemChk);
		
		//灰化菜单子项
		itemExit.setEnabled(false);
		//隐藏菜单
		//itemExit.setVisible(false);
		
		//将菜单条添加至窗体
		//this.add(menuBar,BorderLayout.NORTH);
		//设置菜单条
		this.setJMenuBar(menuBar);
		
		//创建撤销对象
		manager = new UndoManager();
		//创建文本域
		txtValue = new JTextArea();
		//创建滚动面板
		scrollTxt = new JScrollPane(txtValue);
		//添加滚动面板
		this.add(scrollTxt);
//		//设置是否自动换行
//		txtValue.setLineWrap(true);
		
//		//对选中内容进行复制
//		txtValue.copy();
//		//剪切
//		txtValue.cut();
//		//黏贴
//		txtValue.paste();
//		//删除
//		txtValue.replaceSelection("");
		//添加文本域的监听器
		txtValue.getDocument().addDocumentListener(new TextListener());
		//添加撤销监听器
		txtValue.getDocument().addUndoableEditListener(manager);
		
		txtValue.setText("hello niit");
		//获取文本域中所有的内容
		//第一个参数表示获取文本的起始索引，第二个参数表示文本的长度
		try {
			txtValue.getText(0, txtValue.getText().length());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取选中文本所在的索引值
		//int index = txtValue.getText().indexOf(txtValue.getSelectedText());
		//设置选中文本的起始索引
		txtValue.setSelectionStart(1);
		//设置选中文本的结束索引
		txtValue.setSelectionEnd(5);
		
		
		//实例化工具条
		//toolBar = new JToolBar();
		//实例化按钮
		//工具条中一般存放按钮，也可以存放其他组件，按钮一般只显示图片
//		btnNew = new JButton(new ImageIcon("image/newStu.gif"));
//		btnOpen = new JButton(new ImageIcon("image/question.gif"));
//		toolBar.add(btnNew);
//		toolBar.add(btnOpen);
		
		//添加工具条
//		this.add(toolBar,BorderLayout.NORTH);
	}
	
	private class TextListener implements DocumentListener{

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("文本内容被变更");
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("新增了文本内容");
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("删除了文本内容");
			
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
