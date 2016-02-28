package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ItemListenerExam extends JFrame{
	
	private JComboBox cboProject;
	private JComboBox cboCourse;
	//ʹ�ö�ά�����������еĿγ�
	private String[][] courseArray;
	
	public ItemListenerExam(){
		this.setBounds(200, 200, 400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		cboProject = new JComboBox();
		cboProject.addItem("--ѡ���Ŀ--");
		cboProject.addItem("Java");
		cboProject.addItem("C#");
		cboProject.addItem("script");
		
		cboCourse = new JComboBox();
		cboCourse.addItem("--��ѡ��--");
		
		//�Կγ�������г�ʼ��
		courseArray = new String[3][];
		courseArray[0] = new String[]{"coreJava","JSP","JDBC","servlet"};
		courseArray[1] = new String[]{"winforms","ASP.net","ADO.net"};
		courseArray[2] = new String[]{"JavaScript","JScript","PHP"};
	
		
		this.add(cboProject);
		this.add(cboCourse);
		
		//�󶨼�����
		cboProject.addItemListener(new ComboBoxListener());
	}
	
	/**
	 * �����б�������
	 * @author Administrator
	 *
	 */
	private class ComboBoxListener implements ItemListener{

		/**
		 * ѡ��״̬����¼�
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {	
			//�ж�ѡ������״̬���
			if(e.getStateChange() == ItemEvent.SELECTED){
				//�ж��Ƿ�����Ч��ѡ����
				if(cboProject.getSelectedIndex() > 0){
					//��տγ��б��ѡ��
					cboCourse.removeAllItems();
					cboCourse.addItem("--��ѡ��--");
					//��ȡ��Ŀ�б��ѡ����
					//String project = cboProject.getSelectedItem().toString();
					//��ȡѡ���������
					int index = cboProject.getSelectedIndex();
					//���ݿ�Ŀ���жϽ���Ӧ�Ŀγ�������γ��б�
					for(int i = 0; i < courseArray[index-1].length; i++){
						cboCourse.addItem(courseArray[index-1][i]);
					}
				}
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemListenerExam frm = new ItemListenerExam();
		frm.setVisible(true);

	}

}
