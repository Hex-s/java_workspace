package com.niit.calculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	
	private JLabel[] lbls;
	private String[] lblArray;
	private JPanel pnlTitle;
	private JPanel pnlResult;
	private JTextField txtResult;
	private JPanel pnlLeft;
	private JPanel pnlRight;
	private JButton[] btnMC;
	private String[] mcArray;
	private JPanel pnlspace;
	private JPanel pnlRightTop;
	private JPanel pnlRightButom;
	private JButton[] btnBack;
	private String[] backArray;
	private String[] numArray;
	private JButton[] btnNum;

	public Calculator(){
		//窗体设置
		this.setTitle("计算器");
		this.setBounds(200, 200, 455, 270);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		
	}
	
	private void initComponent() {
		pnlTitle = new JPanel();
		lbls = new JLabel[3];
		pnlResult = new JPanel();
		txtResult = new JTextField("0.");
		pnlLeft = new JPanel();
		pnlspace = new JPanel();
		btnMC = new JButton[4];
		pnlRight = new JPanel();
		pnlRightTop = new JPanel();
		pnlRightButom = new JPanel();
		btnBack = new JButton[3];
		btnNum = new JButton[20];
		
		//编辑(E)","查看(V)","帮助(H)
		pnlTitle.setBounds(0, 0, 455, 25);
		pnlTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 2));
		this.add(pnlTitle);
		lblArray = new String[]{"编辑(E)","查看(V)","帮助(H)"};
		for(int i = 0 ; i < lbls.length; i++ ){
			lbls[i] = new JLabel(lblArray[i]);
			pnlTitle.add(lbls[i]);
		}
		
		//计算结果域
		pnlResult.setBounds(15, 20, 400, 30);
		txtResult.setColumns(36);
		txtResult.setHorizontalAlignment(JTextField.RIGHT);
		pnlResult.add(txtResult);
		this.add(pnlResult);
		
		//左边区域
		pnlLeft.setBounds(10 ,55 , 65,200);
		pnlLeft.setLayout(null);
		this.add(pnlLeft);
		//左1 3D凹陷区域
		pnlspace.setBounds(5, 0, 55, 30);
		pnlLeft.add(pnlspace);
		//初始化存放MC ME MS M+的按钮数组
		mcArray = new String[]{"MC","MR","MS","M+"};
		for(int i = 0 , y = 35; i < btnMC.length; i++ , y+=35){
			btnMC[i] = new JButton(mcArray[i]);
			btnMC[i].setBounds(5, y, 55, 30);
			pnlLeft.add(btnMC[i]);
		}
		
		//右边区域
		pnlRight.setBounds(55, 55, 400, 200);
		pnlRight.setLayout(null);
		this.add(pnlRight);
		
		//右上区域
		pnlRightTop.setBounds(15 , 0, 400, 30);
		pnlRight.add(pnlRightTop);
		pnlRightTop.setLayout(null);
		//初始化存放Backspace CE C的按钮数组
		backArray = new String[]{"Backspace ","CE","C"};
		for(int i = 0 , x = 10; i < btnBack.length; i++ , x+=115){
			btnBack[i] = new JButton(backArray[i]);
			btnBack[i].setBounds(x, 0, 106, 30);
			btnBack[i].setForeground(Color.red);
			pnlRightTop.add(btnBack[i]);
		}
		
		//右下区域
		pnlRightButom.setBounds(15, 35, 400, 170);
		pnlRight.add(pnlRightButom);
		pnlRightButom.setLayout(null);
		
		//初始化存放B1-9+sqlt...的按钮数组
		numArray = new String[]{"7","8","9","/","sqrt","4","5","6","*","%","1","2","3","-","1/x","0",".","+/-","+","="};
		for(int i = 0 ,x = 10, y = 0; i < btnNum.length ;i++ ,x+=70){
			btnNum[i] = new JButton(numArray[i]);
			if(i == 5 || i == 10 || i == 15){
				x = 10;
				y += 35;
			}
			btnNum[i].setBounds(x, y, 60, 30);
			String str = numArray[i];
			if(str == "/" || str == "*" || str == "-" || str == "+" || str == "="){
				btnNum[i].setForeground(Color.red);
			}
			else{
				btnNum[i].setForeground(Color.blue);
			}
			pnlRightButom.add(btnNum[i]);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		cal.setVisible(true);
		
	}

}
