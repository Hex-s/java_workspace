package com.niit.checkbox;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JCheckBoxExam extends JFrame {
	
	private JCheckBox[] chkHobby;
	private String[] hobbyArray;
	
	
	
	public JCheckBoxExam(){
		//设置窗体大小
		setSize(400, 400);
		//设置窗体居中
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗体布局
		setLayout(new FlowLayout());
		
		chkHobby = new JCheckBox[4];
		hobbyArray = new String[]{"Game","Music","Sprort","Sleep"};
		//循环构建复选框
		for(int i = 0; i < chkHobby.length; i++){
			//实例化复选框
			chkHobby[i] = new JCheckBox(hobbyArray[i]);
			//添加至窗体
			this.add(chkHobby[i]);
		}	
		//设置默认选中项
		chkHobby[0].setSelected(true);
		chkHobby[2].setSelected(true);
		
		System.out.println("选中项：");
		
		/**************************通过循环判断是否选中******************************/
//		for(int i = 0; i < chkHobby.length; i++){
//			if(chkHobby[i].isSelected()){
//				System.out.println(chkHobby[i].getText());
//			}
//		}
		
		/*****************通过遍历容器中的组件来判断是否选中*********************/
		System.out.println("选中项：");
		for(Component com: this.getContentPane().getComponents()){
			if(com instanceof JCheckBox){
				JCheckBox chk = (JCheckBox)com;
				if(chk.isSelected()){
					System.out.println(chk.getText());
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JCheckBoxExam  chk = new JCheckBoxExam();
		chk.setVisible(true);
	}
}
