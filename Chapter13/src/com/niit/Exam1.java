package com.niit;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Exam1 extends JFrame {

	private JButton btnPress;
	
	public Exam1(){
		this.setBounds(20, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		btnPress = new JButton("show dialog");
		this.add(btnPress);
		btnPress.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			/*******************������Ϣ�Ի���*********************/
			//��һ��������ʾ�Ի�����г��ֵ����������
			//JOptionPane.showMessageDialog(Exam1.this, "��Ϣ����");
			//ÿ���Ի������������ط�������Щ���ط�����Ҫ�������öԻ���ĸ�������
			//������������ʾ�������Ϣ�����ĸ�������ʾ��Ϣ�����ͣ���������������Զ���ͼ��
			//JOptionPane.showMessageDialog(null, "��Ϣ����", "����", JOptionPane.WARNING_MESSAGE, new ImageIcon("image/edit.gif"));
			
			/*******************����ȷ�϶Ի���*********************/
			//ȷ�϶Ի�����Ҫͨ������ֵ�жϵ���İ�ť
//			int choice = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫɾ����Ϣ");
//			//�жϵ���İ�ťѡ��
//			if(choice == JOptionPane.YES_OPTION){
//				System.out.println("ѡ������");
//			}
//			else if(choice == JOptionPane.NO_OPTION){
//				System.out.println("ѡ���˷�");
//			}
//			else{
//				System.out.println("ѡ����ȡ��");
//			}
			//������������ʾ��ť������
			//JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ��Ҫɾ��", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			
			/*******************��������Ի���*********************/
			//ͨ�������ķ���ֵ��ȡ���������,ѡ��ȡ������ֵΪnull
//			String value = JOptionPane.showInputDialog("��Ϣ����");
//			System.out.println(value);
//			JOptionPane.showInputDialog("����������", "Ĭ��ֵ");
			//��������
//			String[] options = new String[]{"A","B","C","D"};
			//����7�������򽫱�Ϊ�����б�Ի��򣬷���ֵΪObject,��ѡ�е���
			//������������ʾ�����б�������ѡ����߸�������ʾ�����б���е�Ĭ��ѡ����
//			Object obj = JOptionPane.showInputDialog(null, "��Ϣ����", "������Ϣ", JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			
			/*******************�Զ���Ի���*********************/
			String[] options = new String[]{"����","����","����"};
			int choice = JOptionPane.showOptionDialog(null, "��Ϣ����", "������Ϣ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
//			//ͨ��ѡ��ť���������ж�ѡ��
//			if(choice == 0){
//				System.out.println("����");
//			}
//			else if(choice == 1){
//				System.out.println("����");
//			}
//			else{
//				System.out.println("����");
//			}
		
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 frm = new Exam1();
		frm.setVisible(true);

	}

}
