package com.niit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * JList�б��ʹ��
 * @author Administrator
 *
 */
public class Exam5 extends JFrame{

	//�б�
	private JList list;
	//�������
	private JScrollPane scrollPnl;
	//�ı���
	private JTextField txtValue;
	private JButton btnPress;
	
	public Exam5(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//ʵ������ť
		btnPress = new JButton("press");
		btnPress.setBounds(50, 150, 100, 25);
		
		//ʵ�����ı���
		txtValue = new JTextField();
		txtValue.setBounds(50, 25, 100, 25);
		
		//ʵ�����������
		scrollPnl = new JScrollPane();
		scrollPnl.setBounds(50, 50, 100, 100);
		
		//ʵ�����б�
		//�ղι�����Ҫ�����б��ģ�Ͷ���
		//list = new JList();
		//String[] array = new String[]{"Java","Html","Javascript","Oracle","JSP","AJAX","Struts"};
		//ͨ�����鹹���б�
		//JList�����ܶ����е����ݽ�����Ӧ����ɾ�ĵĲ�������Ҫ������ģ�Ͷ���
		//list = new JList(array);
		//ͨ����������Ĭ�ϵ�ѡ����
		//list.setSelectedIndex(1);
		//����ѡ�е�ģʽ
		//list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		//ͨ��ģ�͹����б�
		DefaultListModel model = new DefaultListModel();
		//���ѡ��
		model.addElement("A");
		model.addElement("B");
		model.addElement("C");
		model.addElement("D");
		//�����б�
		list = new JList(model);
		//�ղι�����������ģ��
		//list.setModel(model);
		
		//��ȡָ��Ԫ�ص�����λ��
		System.out.println(model.indexOf("D"));
		//��������ɾ��Ԫ��
		//model.remove(1);
		//����ѡ������ɾ��Ԫ��
		model.removeElement("B");
		System.out.println(model.indexOf("D"));
		//�޸�ָ��������ѡ��
		model.set(1, "E");
		//�Ƴ�����Ԫ��
		//model.removeAllElements();
		
		
		//�󶨼�����
		list.addListSelectionListener(new ListListener());
		btnPress.addActionListener(new ButtonListener());
		
		//���б���������������
		scrollPnl.getViewport().add(list);
		this.add(scrollPnl);
		this.add(txtValue);
		this.add(btnPress);
	}
	/**
	 * �б�ѡ�������
	 * @author Administrator
	 *
	 */
	private class ListListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			//��ȡѡ�е�ֵ
			//JOptionPane.showMessageDialog(null, list.getSelectedValue());
			StringBuffer str = new StringBuffer();
			for(Object obj : list.getSelectedValues()){
				str.append(obj);
			}
			txtValue.setText(str.toString());
		}
		
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//��ȡѡ�е�ֵ
			JOptionPane.showMessageDialog(null, list.getSelectedValues());
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam5 frm = new Exam5();
		frm.setVisible(true);
	}

}
