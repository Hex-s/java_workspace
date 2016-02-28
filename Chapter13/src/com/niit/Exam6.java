package com.niit;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Exam6 extends JFrame {

	private JSplitPane splPnl;
	private JScrollPane scrollPnlLeft;
	private JScrollPane scrollPnlRight;
	private JList listLeft;
	private JList listRight;
	private JButton btnToLeft;
	private JButton btnToRight;
	private DefaultListModel modelLeft;
	private DefaultListModel modelRight;
	private JTextField txtMsg;
	
	public Exam6(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//�����ʼ��
		initComponent();
		//�󶨼�����
		bindListener();
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		
		txtMsg = new JTextField();
		txtMsg.setBounds(50, 270, 100, 30);
		txtMsg.setText("font");
		//�����������
		scrollPnlLeft = new JScrollPane();
		scrollPnlRight = new JScrollPane();
		//�����ָ����
		splPnl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollPnlLeft,scrollPnlRight);
		splPnl.setBounds(50, 20, 300, 250);
		splPnl.setDividerSize(4);
		splPnl.setDividerLocation(148);
		splPnl.setEnabled(false);
		//������ť
		btnToLeft = new JButton("<<");
		btnToRight = new JButton(">>");
		btnToLeft.setBounds(110, 300, 80, 25);
		btnToRight.setBounds(210, 300, 80, 25);
		//�����б�ģ��
		modelLeft = new DefaultListModel();
		modelRight = new DefaultListModel();
		//�����б�
		listLeft = new JList(modelLeft);
		listRight = new JList(modelRight);
		//���б�ģ���������
//		modelLeft.addElement("A");
//		modelLeft.addElement("B");
//		modelLeft.addElement("C");
//		modelLeft.addElement("D");
//		modelLeft.addElement("E");
//		modelLeft.addElement("F");
//		modelLeft.addElement("G");
//		modelLeft.addElement("H");
		
		//��̬��ȡϵͳ����
		GraphicsEnvironment evironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = evironment.getAvailableFontFamilyNames();
		//����
		for(String font : fontNames){
			modelLeft.addElement(font);
		}
		
		listLeft.setSelectionBackground(Color.orange);
		listRight.setSelectionBackground(Color.orange);
		
		//���б�������������
		scrollPnlLeft.getViewport().add(listLeft);
		scrollPnlRight.getViewport().add(listRight);
		
		this.add(splPnl);
		this.add(btnToLeft);
		this.add(btnToRight);
		this.add(txtMsg);
	}
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//��ȡ�¼�Դ����
			JButton btn = (JButton)e.getSource();
			//�жϵ�ǰ����İ�ť
			//�����Ƶİ�ť
			if(btn == btnToLeft){
				moveIteam(listRight, modelLeft, modelRight);
			}
			//�����Ƶİ�ť
			else{
				moveIteam(listLeft, modelRight, modelLeft);
			}
		}
		
	}
	/**
	 * �б������
	 * @author Administrator
	 *
	 */
	private class ListListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//ͨ���¼�Դ�ж����õ��б�
			JList list = (JList)e.getSource();
			//JOptionPane.showMessageDialog(null, listLeft.getSelectedIndex());
			//ѡ�����б�
			if(list == listLeft){
				//�һ������Ƶİ�ť
				btnToLeft.setEnabled(false);
				//���������ư�ť
				btnToRight.setEnabled(true);
				//ȥ�����б��ѡ����
				listRight.setSelectedIndex(-1);
				//ȥ�����б�ѡ����ı���ɫ
				listRight.setSelectionBackground(Color.white);
				//�޸����б�ѡ����ı���ɫΪ������ɫ
				listLeft.setSelectionBackground(Color.orange);
				
				//��ȡѡ�����ֵ
				String fontName = listLeft.getSelectedValue().toString();
				//�����������
				Font font = new Font(fontName, Font.ITALIC|Font.BOLD, 20);
				//Ϊ�ı�����������
				txtMsg.setFont(font);
			}
			//ѡ�����б�
			else{
				//�һ������ư�ť
				btnToRight.setEnabled(false);
				//���������ư�ť
				btnToLeft.setEnabled(true);
				//ȥ�����б��ѡ����
				listLeft.setSelectedIndex(-1);
				//ȥ�����б��ѡ�����ɫ
				listLeft.setSelectionBackground(Color.white);
				//�޸����б��ѡ�����ɫ
				listRight.setSelectionBackground(Color.orange);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/**
	 * �ƶ��б�ѡ��
	 * @param list
	 * @param model1
	 * @param model2
	 */
	private void moveIteam(JList list, DefaultListModel model1, DefaultListModel model2){
		//��ȡ���б�ѡ�����ֵ
		Object[] value = list.getSelectedValues();
		//����ѡ�е�ֵ
		for(Object obj : value){
			//�����б��ȡ��ֵ��������б���
			model1.addElement(obj);
			//�����б��ȡֵɾ��
			model2.removeElement(obj);
		}
	}
	/**
	 * �󶨼�����
	 */
	private void bindListener(){
		ButtonListener btnListener = new ButtonListener();
		btnToLeft.addActionListener(btnListener);
		btnToRight.addActionListener(btnListener);
		ListListener listListener = new ListListener();
		listLeft.addMouseListener(listListener);
		listRight.addMouseListener(listListener);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam6 frm = new Exam6();
		frm.setVisible(true);
	}

}
