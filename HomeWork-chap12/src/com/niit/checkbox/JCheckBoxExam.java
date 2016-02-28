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
		//���ô����С
		setSize(400, 400);
		//���ô������
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��岼��
		setLayout(new FlowLayout());
		
		chkHobby = new JCheckBox[4];
		hobbyArray = new String[]{"Game","Music","Sprort","Sleep"};
		//ѭ��������ѡ��
		for(int i = 0; i < chkHobby.length; i++){
			//ʵ������ѡ��
			chkHobby[i] = new JCheckBox(hobbyArray[i]);
			//���������
			this.add(chkHobby[i]);
		}	
		//����Ĭ��ѡ����
		chkHobby[0].setSelected(true);
		chkHobby[2].setSelected(true);
		
		System.out.println("ѡ���");
		
		/**************************ͨ��ѭ���ж��Ƿ�ѡ��******************************/
//		for(int i = 0; i < chkHobby.length; i++){
//			if(chkHobby[i].isSelected()){
//				System.out.println(chkHobby[i].getText());
//			}
//		}
		
		/*****************ͨ�����������е�������ж��Ƿ�ѡ��*********************/
		System.out.println("ѡ���");
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
