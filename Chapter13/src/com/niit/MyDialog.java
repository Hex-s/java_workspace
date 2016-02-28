package com.niit;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * �Զ���Ի���
 * @author Administrator
 *
 */
public class MyDialog extends JDialog {

	private JLabel lblIcon;
	private JLabel lblMsg;
	private JButton[] btns;
	private JPanel pnlTop;
	private JPanel pnlBottom;
	private int index;
	
	public MyDialog(Component parentComponent,Object message,String title,int optionType, int messageType, Icon icon,Object[] options, Object initalValue){
		super(new JFrame(), true);
		this.setLocationRelativeTo(parentComponent);
		this.setSize(400, 140);
		this.setTitle(title);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//��ʼ�����
		initComponent(message, icon, options, initalValue);
		//�󶨰�ť�ļ�����
	}
	/**
	 * ��ʼ��
	 * @param message
	 * @param icon
	 * @param options
	 * @param initalValue
	 */
	private void initComponent(Object message,Icon icon,Object[] options, Object initalValue){
		//��ʼ�����
		pnlTop = new JPanel();
		pnlTop.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		pnlBottom = new JPanel();
		//��ʼ����ǩ
		lblIcon = new JLabel(icon);
		lblMsg = new JLabel(message.toString());
		//����������
		ButtonListener listener = new ButtonListener();
		//��ʼ����ť
		btns = new JButton[options.length];
		for(int i = 0; i < btns.length; i++){
			btns[i] = new JButton(options[i].toString());
			pnlBottom.add(btns[i]);
			//�󶨼�����
			btns[i].addActionListener(listener);
		}
		pnlTop.add(lblIcon);
		pnlTop.add(lblMsg);
		this.add(pnlTop,BorderLayout.NORTH);
		this.add(pnlBottom);
	}
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//��ȡ�¼�Դ��ť����
			JButton btn = (JButton)e.getSource();
			//�жϵ���İ�ť
			for(int i = 0; i < btns.length; i++){
				if(btns[i] == btn){
					//��¼��ǰ�������ť���������е�����
					index = i;
					break;
				}
			}
			//�رնԻ���
			MyDialog.this.dispose();
		}
		
	}
	
	public int getResultOption(){
		return index;
	}
}
