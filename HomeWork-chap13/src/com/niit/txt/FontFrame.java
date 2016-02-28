package com.niit.txt;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class FontFrame extends JFrame{
	
	private TextFrame txtFrm;
	private JLabel lblFont;
	private JLabel lblCharacter;
	private JLabel lblSize;
	private JTextField txtFont;
	private JTextField txtCharacter;
	private JTextField txtSize;
	private JScrollPane splFont;
	private JScrollPane splCharacter;
	private JScrollPane splSize;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JPanel pnlExample;
	private JLabel lblContainer;
	private JLabel lblR;
	private JComboBox cboR;
	private String[] rArray;
	private JList lsFont;
	private JList lsCharacter;
	private JList lsSize;
	private String[] fontArray;
	private String[] characterArray;
	private String[] sizeArray;
	
	public FontFrame(TextFrame txtFrm){
		this.txtFrm = txtFrm;
		//初始化窗体
		initFrame(txtFrm);
		//初始化组件
		initComponent();
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		//实例化标题
		lblFont = new JLabel("字体(F):");
		lblCharacter = new JLabel("字形(Y)");
		lblSize = new JLabel("大小(S)");
		//实例化字体文本框
		txtFont = new JTextField("Fixedsys");
		txtFont.selectAll();
		txtCharacter = new JTextField("常规");
		txtSize = new JTextField("小五");
		
		btnConfirm = new JButton("确认");
		btnCancel = new JButton("取消");
		
		fontArray = new String[]{"Fixedsys","隶书","幼圆","楷体"};
		characterArray = new String[]{"常规","斜体","粗体","粗斜体"};
		sizeArray = new String[]{"8","9","10","12"};
		
		lsFont = new JList(fontArray);
		lsCharacter = new JList(characterArray);
		lsSize = new JList(sizeArray);
		
		pnlExample = new JPanel();
		pnlExample.setLayout(null);
		lblContainer = new JLabel("微软中文软体");
		lblContainer.setFont(new Font("Fixedsys", Font.PLAIN, 20));
		lblContainer.setHorizontalAlignment(JLabel.CENTER);
		lblContainer.setBorder(BorderFactory.createLoweredBevelBorder());
		pnlExample.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray),"示例"));
		lblContainer.setBounds(10, 20, 170, 50);
		pnlExample.add(lblContainer);
		
		 
		lblR = new JLabel("字符集(R)");
		
		cboR = new JComboBox();
		rArray = new String[]{"CHINESE_GB2312"};
		for(int i = 0; i < rArray.length; i++){
			cboR.addItem(rArray[i]);
		}
		
		lblFont.setBounds(10, 10, 150, 15);
		lblCharacter.setBounds(170, 10, 100, 20);
		lblSize.setBounds(280, 10, 100, 15);
		
		txtFont.setBounds(10, 28, 150, 20);
		txtCharacter.setBounds(170, 28, 100, 20);
		txtSize.setBounds(280, 28, 80, 20);
		
		splFont = new JScrollPane(lsFont,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		splCharacter = new JScrollPane(lsCharacter,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		splSize = new JScrollPane(lsSize,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		splFont.setBounds(10, 48, 150, 100);
		splCharacter.setBounds(170, 48, 100, 100);
		splSize.setBounds(280, 48, 80, 100);
		
		
		btnConfirm.setBounds(390, 25, 70, 25);
		btnCancel.setBounds(390, 55, 70, 25);
		
		pnlExample.setBounds(170, 155, 190, 80);
		
		lblR.setBounds(170, 250, 190, 15);
		
		cboR.setBounds(170, 265, 190, 20);
		
		this.add(lblFont);
		this.add(lblCharacter);
		this.add(lblSize);
		this.add(txtFont);
		this.add(txtCharacter);
		this.add(txtSize);
		this.add(splFont);
		this.add(splCharacter);
		this.add(splSize);
		this.add(btnConfirm);
		this.add(btnCancel);
		this.add(pnlExample);
		this.add(lblR);
		this.add(cboR);
	}
	/**
	 * 初始化窗体
	 */
	private void initFrame(TextFrame txtFrm){
		this.setSize(500,350);
		this.setTitle("字体");
		this.setLayout(null);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(txtFrm);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}
